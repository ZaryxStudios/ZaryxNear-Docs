# Command API Mechanics (Brigadier Integration)

CommandAPI is the de facto wrapper for Brigadier command graphs in Paper/Spigot. It provides type-safe definitions, tab completion, and command dispatch integration.

## 3.1 Core architecture
- `CommandAPI.onLoad(CommandAPIPaperConfig)` initializes a Brigadier dispatcher.
- `CommandAPICommand` is an immutable command tree builder.
- `withSubcommand`, `withArguments`, and `withOptionalArguments` create branches.
- `register()` publishes to server command map.

## 3.2 Command lifecycle and execution context
- `executes`, `executesPlayer`, `executesConsole`: synchronous by default.
- `executesAsync`: background; cannot touch Bukkit world objects.

### Mental Model
`CommandAPICommand` is a declarative DSL. Think of it as a directed graph where nodes validate arguments and leaves are handlers.

### API example
```java
new CommandAPICommand("warp")
    .withPermission("zaryxnear.warp")
    .withArguments(new StringArgument("name"), new LocationArgument("destination"))
    .executesPlayer((player, args) -> {
        String warpName = (String) args.get("name");
        Location dest = (Location) args.get("destination");
        WarpService.instance().teleport(player, warpName, dest);
    })
    .register();
```

## 3.3 Deep internals
- `withOptionalArguments` causes the dispatcher to register an alternative path with missing arguments.
- `ArgumentSuggestions` will be invoked per tab-complete; avoid full-scan closures.
- `CommandAPIMain` integrates with `CommandMap` in `SimpleCommandMap`.

### Common Mistakes
- Using `GreedyStringArgument` in the middle of argument list.
- Caching `Location` from async context (not thread-safe).
- Ignoring `args.getOptional("name").orElse(...)` semantics.

### Performance Warning
Dynamic suggestions that compute on the fly for every key-stroke can spawn CPU spikes. Cache or precompute large datasets.

### Pro Tips
- Use `CommandAPICommand` builder methods in registration class with ID-based test coverage.
- Prepare a `CommandRegistration` helper to unify permissions and multi-locale display text.

## 3.4 Why this matters
Correct command design reduces exploit surface and improves player experience with predictable tab-complete behavior.

## 3.5 When to use
- complex command sets, multi-argument branches, plugin-level schemata.

## 3.6 When NOT to use
- very small single-command plugin with simple `CommandExecutor` and no subcommands.
