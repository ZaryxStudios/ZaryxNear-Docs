# MythicMobs API Reference

MythicMobs lets you create custom mobs, skills, drops, and mobs behavior via config. This reference shows how to summon mobs, listen to events, and query MythicMobs objects.

## API dependency

```xml
<dependency>
  <groupId>io.lumine</groupId>
  <artifactId>mythicmobs</artifactId>
  <version>5.0.7</version>
  <scope>provided</scope>
</dependency>
```

## Get MythicMobs instance

```java
import io.lumine.xikage.mythicmobs.MythicMobs;

MythicMobs mythicMobs = MythicMobs.inst();
```

## Spawn custom mob

```java
import io.lumine.xikage.mythicmobs.mobs.MythicMob;
import io.lumine.xikage.mythicmobs.mobs.ActiveMob;
import org.bukkit.Location;

MythicMob mymob = MythicMobs.inst().getMobManager().getMythicMob("ZombieKing");
if (mymob != null) {
    ActiveMob active = mythicMobs.getMobManager().spawnMob("ZombieKing", location);
}
```

## Skill casting

```java
import io.lumine.xikage.mythicmobs.skills.SkillManager;
import io.lumine.xikage.mythicmobs.skills.SkillMetadata;
import io.lumine.xikage.mythicmobs.skills.Targeter;

SkillManager skillManager = MythicMobs.inst().getSkillManager();
SkillMetadata metadata = SkillMetadata.newSkillMetadata(...); // build via API
skillManager.getSkill("Fireball").execute(metadata);
```

## Events

- `MythicMobSpawnEvent`
- `MythicMobDeathEvent`
- `MythicMobDespawnEvent`
- `MythicMobSkillActivateEvent`

```java
@EventHandler
public void onMobDeath(MythicMobDeathEvent event) {
    ActiveMob mob = event.getMob();
    // custom logic
}
```

## Utility

- `MythicMobs.inst().getMobManager().getActiveMobs()`
- `MythicMobs.inst().getEntityManager().isActiveMob(entity)`
- `MythicMobs.inst().getSkillManager().getSkill(String)`

---

## Tips

- Keep config valid and reload with `/mythicmobs reload`.
- Use `mythicmobs` plugin dependency in `plugin.yml`.
- Prevent plugin crash by checking `null` for mob definitions.

## 8. Custom goals y conditions

### Condiciones personalizadas
- Define tus condiciones en `MythicMobs/Conditions.yml`.
- Registrar a través de `ConditionManager.registerCondition("custom", MyCondition.class)`.

### Meta en mobs
- Uso: `AI:` secciones y `TargetLocation{distance=10}`.
- Hacer un objetivo que persiga al jugador y active un skill.

## 9. Eventos de combate y hook al daño

- `MythicMobDamageEvent` permite cancelar daño y modificar causa.
- `MythicMobSpawnEvent` para añadir tags de UUID / metadata.

```java
@EventHandler
public void onDamage(MythicMobDamageEvent event) {
    event.setDamage(event.getDamage() * 0.8); // reducción 20%
}
```

## 10. Integración de pathfinder y NPCs (Citizens)

- `MythicMobs` ofrece `Skill` base para Citizens.
- Para mob personalizado en NPC:
  - `npc.setTrait(new MythicMobsTrait(...))` (ejemplo en docs oficial).

## 11. Debug y comando util

- Usa `MythicMobs.inst().getMobManager().getLoadedMobs()` para listado.
- `MythicMobs.inst().getVars().setVar("key", "value")` para variables globales.
- Comprueba que tus archivos YAML sean `UTF-8` y no tengan tabs.

