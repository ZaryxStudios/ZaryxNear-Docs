# WorldEdit API Reference

WorldEdit is a powerful in-game map editor for Bukkit/Spigot/Paper. This guide includes common API calls, clipboard operations, selection utilities, and safe edits.

## Setup

Add WorldEdit as a dependency in your plugin `pom.xml` or build.gradle (use shaded/relocated if needed).

```xml
<dependency>
  <groupId>com.sk89q.worldedit</groupId>
  <artifactId>worldedit-bukkit</artifactId>
  <version>7.2.16</version>
  <scope>provided</scope>
</dependency>
```

## Getting WorldEdit instance

```java
import com.sk89q.worldedit.WorldEdit;
import com.sk89q.worldedit.bukkit.BukkitAdapter;
import com.sk89q.worldedit.world.World;

WorldEdit worldEdit = WorldEdit.getInstance();
```

## Selection operations

```java
import com.sk89q.worldedit.entity.Player;
import com.sk89q.worldedit.regions.Region;
import com.sk89q.worldedit.session.Session;

Session session = worldEdit.getSessionManager().get(BukkitAdapter.adapt(player));
Region region = session.getSelection(BukkitAdapter.adapt(player.getWorld()));

if (region != null) {
    int volume = region.getVolume();
    // etc
}
```

## Set blocks safely

```java
import com.sk89q.worldedit.extent.clipboard.io.ClipboardFormats;
import com.sk89q.worldedit.function.operation.Operation;
import com.sk89q.worldedit.function.operation.Operations;

EditSession editSession = WorldEdit.getInstance().newEditSession(BukkitAdapter.adapt(player.getWorld()));
try {
    Operation operation = new ClipboardHolder(clipboard)
        .createPaste(editSession)
        .to(toVector)
        .build();
    Operations.complete(operation);
} finally {
    editSession.close();
}
```

## Common helpers

- `WorldEdit.getInstance().getSessionManager()`
- `BukkitAdapter.adapt(org.bukkit.World)`
- `editSession.setBlock(BlockVector3, BaseBlock)`
- `Operations.complete()`

---

## Notes

- Use `com.sk89q.worldedit` package for 7.x; 8.x may be rebranded as `com.sk89q.worldedit.core`.
- Always close `EditSession`.
- Respect Async limitations: block changes are main-thread in Bukkit.

## 10. WorldEdit advanced utilities

### Async WorldEdit checks
- Para uso sin bloquear el servidor, valida `Bukkit.getServer().isPrimaryThread()` antes del edit.
- Si haces edits grandes, ejecuta en un `BukkitRunnable` con `runTaskAsynchronously` que luego regresa al sync para `EditSession`.

### Clipboard snapshot + history
- Guarda un `Clipboard` listado por usuario y haz rollback con:
  - `clipboard.paste(editSession, toVector, false)`
  - `new Operation[]{...}` + `Operations.complete()`

### Command integration
- Ejemplo: `/zaryxnear-reset` asigna region y usa WorldEdit API para vaciar:

```java
Region region = session.getSelection(world);
EditSession es = worldEdit.newEditSession(wp.getWorld());
Operation op = new EditSessionBuilder(wp.getWorld()).build();
// etc
```

## 11. Best-practices al usar WorldEdit
- Intenta no usar `we.getEditSessionFactory().getEditSession(world, -1)` con límite infinito salvo que sea operación batch garantizada.
- Loguea el usuario y los límites antes de ejecutar: `if (region.getVolume() > 5_000_000) ...`.
- `WorldEdit.getInstance().getConfiguration().getAllowAutoSave()` para condiciones.

## 12. Extensi�n ZaryxNear
- Crea un handler que mapea `Player -> Region` para comandos personalizados.
- Ejemplo: `/zaryxnear-filler` utiliza `BlockArrayClipboard` + `pastBuilder`.

---
