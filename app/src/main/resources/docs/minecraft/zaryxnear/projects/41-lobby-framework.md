# Proyecto: Lobby System (ZaryxNear)

Este ejemplo demuestra un proyecto productivo con enfoque en rendimiento y extensión.

## Estructura de carpetas

- `src/main/java/com/zaryxnear/lobby/` - lógica principal
- `src/main/java/com/zaryxnear/lobby/adapters/` - integración externa (WorldGuard, Vault)
- `src/main/java/com/zaryxnear/lobby/service/` - servicios de dominio
- `src/main/java/com/zaryxnear/lobby/controller/` - puntos de entrada e listeners
- `src/main/resources/config.yml` - configuración runtime

## 1) `LobbyService` (core)

```java
public class LobbyService {
    private final TeleportScheduler teleportScheduler;
    private final Map<UUID, LobbyPlayerState> states = new ConcurrentHashMap<>();

    public void applyState(Player player, LobbyState newState) {
        states.compute(player.getUniqueId(), (uuid, current) -> {
            if (current != null && current == newState) return current;
            player.sendMessage("Lobby: " + newState.name());
            return new LobbyPlayerState(newState, System.currentTimeMillis());
        });
    }

    public void scheduleTeleport(Player player, Location target) {
        teleportScheduler.requestTeleport(player, target);
    }
}
```

### 🤔 Por qué importa
Un lobby bien diseñado controla el flujo del jugador, reduce desconexiones y evita validaciones por cada tick.

### ⚠️ Riesgo
No use `Player.teleport()` en `PlayerMoveEvent`; puede generar bucles infinitos y lag.

### 💡 Consejo
Kashege operaciones que requieran cambios globales en un `ServerTickEvent`, con ingeniosas banderas en `PlayerMetadata`.
