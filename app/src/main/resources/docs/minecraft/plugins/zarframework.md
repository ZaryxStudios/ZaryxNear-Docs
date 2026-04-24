# ZarFramework Reference

ZarFramework is a base framework for Bukkit/Spigot (and partial Bungee support) focused on reducing repetitive code for commands, menus, storage, serialization, and adapters like scoreboard/tablist/nametags.

It is useful when you want a modular plugin architecture without wiring all low-level boilerplate manually.

## Setup

Example Maven dependency:

```xml
<dependency>
    <groupId>com.zaryx.framework</groupId>
    <artifactId>ZarFramework</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>
```

`plugin.yml` (framework plugin side):

```yaml
name: ZarWork
version: 0.0.1
main: com.zaryx.framework.bukkit.FrameworkPlugin
author: Pyeh
```

## Runtime Modules

When Bukkit starts `FrameworkPlugin`, it initializes:

- `CommandManager` (dynamic command register/unregister/enable/disable)
- `MenuManager` + `MenuProviderRegistry` (GUI menu lifecycle)
- `ConfigManager` (class + annotation config mapping)
- `SerializationManager` (Gson-based adapters)

On Bungee, `FrameworkBungee` initializes:

- `BungeeConfigManager`

## Commands API

`CommandAPI` exposes simple static methods:

- `register(Command command)`
- `unregister(Command command)`
- `enable(Command command)`
- `disable(Command command)`

### BaseCommand Pattern

```java
import com.zaryx.framework.bukkit.command.annotation.Info;
import com.zaryx.framework.bukkit.command.core.BaseCommand;
import com.zaryx.framework.bukkit.command.extra.CommandContext;

@Info(
    name = "ping",
    permission = "myplugin.ping",
    playerOnly = false,
    consoleOnly = false
)
public class PingCommand extends BaseCommand {

    @Override
    public void execute(CommandContext context) {
        context.getSender().sendMessage("pong");
    }
}
```

Register at startup:

```java
CommandAPI.register(new PingCommand());
```

### Argument Parsing

Use `CommandArgument<?>` implementations (`StringCommandArgument`, `IntegerCommandArgument`, `PlayerCommandArgument`, etc.). The framework validates and parses before execution.

If parsing fails, sender receives an automatic validation message.

## Menu API

`MenuAPI` supports provider-based menu construction:

```java
MenuAPI.register("main_menu", params -> {
    // Build and return Menu
    // Example: new Menu("Main", 27)
    return buildMainMenu(params);
});
```

Open for player:

```java
MenuAPI.open("main_menu", player, "optional", "params");
```

Important details:

- Menu updates are tick-driven by `MenuManager`
- Each viewer has its own `MenuContext`
- Context/viewers are cleaned up when players close or disconnect

## Storage API

Core abstraction:

```java
public abstract class Storage<T> {
    public T get(String key);
    public void set(String key, T value);
    public void unload(String key);
    public void saveAll();
}
```

Available backends:

- `JsonStorage`
- `MySQLStorage`
- `MongoStorage`

### Example: JSON-backed profile storage

```java
import com.zaryx.framework.bukkit.storage.Storage;
import com.zaryx.framework.bukkit.storage.core.StorageContext;
import com.zaryx.framework.bukkit.storage.extra.JsonStorage;

public class ProfileStorage extends Storage<PlayerProfile> {
    public ProfileStorage() {
        super(new JsonStorage("plugins/MyPlugin/profiles"), PlayerProfile.class);
    }
}
```

Use it:

```java
ProfileStorage storage = new ProfileStorage();
PlayerProfile profile = storage.get(player.getUniqueId().toString());
if (profile == null) {
    profile = new PlayerProfile();
}
profile.setCoins(profile.getCoins() + 100);
storage.set(player.getUniqueId().toString(), profile);
```

## Serialization API

Access framework Gson:

```java
import com.google.gson.Gson;
import com.zaryx.framework.bukkit.serialization.SerializationAPI;

Gson gson = SerializationAPI.getGson();
String json = gson.toJson(myObject);
```

Use this when you need custom type adapters aligned with the framework serializer.

## Placeholder and Text Utilities

`PlaceholderResolver` replaces tags like `<player>` using `PlaceholderContext`.

`Convert` adds helper methods:

- `Convert.text(String)` (color parsing)
- `Convert.text(String, PlaceholderContext)` (placeholder + colors)
- `Convert.itemStackArrayToBase64(ItemStack[])`
- `Convert.itemStackArrayFromBase64(String)`

## Scoreboard / Tablist / Nametag Adapters

ZarFramework provides managers with adapter interfaces:

- `BoardManager` + `BoardAdapter`
- `TabManager` + `TabAdapter`
- `NameTagManager` + `NameTagAdapter`

Pattern:

1. Implement adapter interface with your dynamic data.
2. Initialize manager on plugin enable.
3. Create/destroy contexts on join/quit.

This keeps rendering logic separate from domain services.

## Config API

Use:

- `BukkitConfigAPI.load(Class<?>, Plugin)`
- `BukkitConfigAPI.save(Class<?>)`
- `BukkitConfigAPI.reload(Class<?>, Plugin)`

The framework uses annotation-driven mapping (`@ConfigFile`, `@ConfigPath`) to bind static fields.

## Why Use ZarFramework

- Fast bootstrap for medium/large Minecraft plugins
- Unified way to handle commands, menus, and storage
- Less custom boilerplate for serializer/config integration
- Good base for layered architecture (service + adapter + controller)

## Caveats

- Command registration uses Bukkit `CommandMap` reflection internally
- Runtime behavior is tied to Spigot/Bukkit lifecycle
- Verify your storage backend and connection lifecycle in production (especially MySQL/Mongo)
- Keep menu updates efficient; they are evaluated frequently

## Suggested Architecture with ZarFramework

- `domain/` for business logic (economy, progression, matchmaking, etc.)
- `application/` for use-cases
- `infrastructure/` for storage/menu/commands adapters
- `entrypoints/` for listeners and command registration

This separation makes it easier to test and scale features without mixing Bukkit API details everywhere.
