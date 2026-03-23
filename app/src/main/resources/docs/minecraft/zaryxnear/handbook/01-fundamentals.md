# ZaryxNear Handbook: Core Fundamentals

This chapter defines the ground truths for serious Minecraft plugin engineering. The goal is to build mental models before writing code.

## 1.1 Platform layers (what you can and cannot control)
- Minecraft server is: Server (paper/spigot), plugin loader, plugin runtime.
- Your logic lives inside `JavaPlugin` and `BukkitScheduler`.
- Server tick is the heartbeat; everything sync originates from this.

## 1.2 JavaPlugin lifecycle
1. `onLoad()` - load configuration/metadata (pre-injection, no Bukkit APIs that require world load).
2. `onEnable()` - register listeners/commands/services.
3. `onDisable()` - cleanly unregister and flush state.

### Mental Model
`JavaPlugin` is a service that runs inside the host. Treat it like a scoped microservice that may be reloaded.

### Common Mistakes
- accessing world chunks in `onLoad`; those may not be ready.
- doing heavy I/O in `onEnable` on main thread.

### Performance Warning
`onEnable` is per-server startup. Avoid blocking with >5s work (fail fast with async startup sequencer).

### Pro Tips
- use gradual activation: schedule `runTaskLater` for non-critical work.
- emit a health metric for each phase (enabled, ready, error).

## 1.3 Plugin.yml expected structure
```yaml
ame: my-plugin
author: ZaryxNear
depend:
  - Vault
  - WorldGuard
commands:
  setwarp:
    description: Set a warp
    usage: /setwarp <name>
permissions:
  zaryxnear.warp.use:
    default: op
```

## 1.4 Why this matters
You cannot treat Minecraft plugins as stateless components. Lifecycle mismanagement causes memory leaks and inconsistent state across reloads.

## 1.5 When to use
- Always, for every plugin.

## 1.6 When NOT to use
- N/A (foundational).
