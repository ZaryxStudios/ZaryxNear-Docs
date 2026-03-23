# PlaceholderAPI Reference

PlaceholderAPI provides variable placeholders for chat, scoreboards, bossbars, holograms, and plugin integration.

## Setup

`plugin.yml`:

```yaml
depend:
  - PlaceholderAPI
```

## Register expansion

```java
import me.clip.placeholderapi.expansion.PlaceholderExpansion;

public class MyExpansion extends PlaceholderExpansion {
    @Override
    public boolean canRegister() { return true; }
    @Override
    public String getIdentifier() { return "zaryxnear"; }
    @Override
    public String getAuthor() { return "ZaryxStudio"; }
    @Override
    public String getVersion() { return "1.0.0"; }

    @Override
    public String onPlaceholderRequest(Player player, String identifier) {
        if (player == null) return "";
        if (identifier.equals("online_players")) {
            return String.valueOf(Bukkit.getOnlinePlayers().size());
        }
        return null;
    }
}

// register
new MyExpansion().register();
```

## Use placeholder

`%zaryxnear_online_players%`

## API methods

- `PlaceholderAPI.setPlaceholders(Player, String)`
- `PlaceholderAPI.getPlaceholders(OfflinePlayer, String)`
- `PlaceholderAPI.registerPlaceholderHook(Plugin, String, PlaceholderHook)`

## Common placeholders

- `%player_name%`
- `%server_online_players%`
- `%vault_eco_balance%`

---

## Notes

- Always check `papi` plugin presence.
- Call `PlaceholderAPI.registerPlaceholderHook` in `onEnable`.

## 5. Advanced usage

### Expansions dinámicas
- Usar `%<identifier>_<value>%` junto con `onPlaceholderRequest` para múltiples opciones.

### Caching y rendimiento
- No resuelvas placeholders en cada tick con valores costosos.
- Cachea resultados por player y tiempo en mapas tipo `ConcurrentHashMap<String, CachedValue>`.

### Multiple plugin mappings
- `PlaceholderAPI.registerPlaceholderHook(plugin, "zaryxnear", new PlaceholderHook() { ... })`
- Para placeholders relacionados con Vault, usa `%vault_eco_balance%` y prefija en tu propia expansión: `%zaryxnear_vault_balance%`.

## 6. Debug

- Comprueba `PlaceholderAPI.isRegistered("zaryxnear")`.
- Para logs:
  - `Bukkit.getLogger().info("PAPI value: " + PlaceholderAPI.setPlaceholders(player, "%zaryxnear_online_players%"));`

## 7. Compatibility

- En Paper, las expansiones pueden cargarse automáticamente con `PlaceholderAPI#registerExpansion`.
- Para backwards compat: si `PlaceholderAPI` no está presente, actúa en “modo degradado” y evita llamadas directas.

