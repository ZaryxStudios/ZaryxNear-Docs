# TPS and Tick Budget (Performance Engineering)

High-performance plugin systems begin with a clear understanding of the tick budget.

## 2.1 Server tick anatomy
- The server aims for 20 TPS (every 50ms).
- Tick phases: world update, entity AI, player movement, scheduled tasks, event emission.
- Your plugin runs in this loop; cost is additive.

## 2.2 Measuring and profiling
- Use Spark / WarmRoast / Java Flight Recorder.
- `timings paste` is a starting signal, not an ROI profile.

## 2.3 Rule of 5ms
- Keep plugin work under `5ms` per tick across all hooks.
- Large servers require `<=1ms`.

### Mental Model
Imagine execution as a pipeline; each listener is an insertion point. If one stage exceeds 50ms, you drop ticks.

### Common Mistakes
- using `PlayerMoveEvent` at `MONITOR` with expensive pathfinding every movement.
- iterating over `world.getEntities()` every tick.

### Performance Warning
`Bukkit.getScheduler().runTaskTimer` with 1 tick on 1000 entities is a direct ticket to tick lag.

### Pro Tips
- batch operations: collect 100 updates and apply every 5 ticks.
- use aggregated counters and guard thresholds to avoid runaway loops.

## 2.4 Tactical actions
- convert frequent listeners to region-based conditions.
- maintain in-memory spatial index for entity lookups (Quadtree/k-d tree).

## 2.5 Why this matters
Low TPS impacts every player and can kill server reputation. Plugins that ignore budget are unmaintainable.

## 2.6 When to use
- always in performance-sensitive plugins.

## 2.7 When not to use
- not applicable (conceptual foundation).
