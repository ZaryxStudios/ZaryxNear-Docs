# Threading Model for Bukkit/Paper Plugins

Understanding the threading model is essential for stable, high-throughput plugins. Minecraft server core is single-threaded for world simulation. Plugin code running on this thread must be minimal.

## 4.1 Thread categories
- Main thread: all world state, event listeners by default.
- Async task threads: `BukkitScheduler.runTaskAsynchronously` uses thread pool.
- Plugin-managed worker pools: advanced systems should use `ExecutorService` or project-managed pool.

## 4.2 Chicago Rule
Never mutate Bukkit objects from non-main threads. Read-only world state has limited exceptions (e.g., `Location#getX`).

### Mental Model
Main thread is the source of truth. Async workers are solvers (I/O, DB, heavy compute). Don’t mix update paths without synchronization.

## 4.3 Safe cross-thread pattern
```java
private final Queue<Runnable> mainQueue = new ConcurrentLinkedQueue<>();

public void scheduleJob(Runnable job) {
    CompletableFuture.runAsync(() -> {
        // heavy compute parallel
        job.run();
    }, workerPool).whenComplete((result, error) -> {
        mainQueue.add(() -> {
            // sync publish to Bukkit
            applyResult(result);
        });
    });
}

@EventHandler
public void onServerTick(ServerTickEndEvent event) {
    Runnable next;
    while ((next = mainQueue.poll()) != null) next.run();
}
```

### Common Mistakes
- using `Player#getInventory` from async code.
- read-modify-write race on mutable `Map<UUID, Integer>` without `ConcurrentHashMap`.

### Performance Warning
`runTaskAsynchronously` is not free; too many short async tasks can overload thread pool and increase context switch costs. Prefer batch work.

### Pro Tips
- Keep worker threads static and bounded (`Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors())`).
- Use `ThreadFactoryBuilder` with uncaught exception handlers.

## 4.4 Why this matters
Threading failures produce data corruption and server crashes, especially in stateful systems with async DB calls.

## 4.5 When to use
- asynchronous I/O, external API calls, serialization.

## 4.6 When not to use
- world state changes & chunk operations. Keep this on main tick.
