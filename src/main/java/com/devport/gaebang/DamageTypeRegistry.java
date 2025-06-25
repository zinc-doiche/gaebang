package com.devport.gaebang;

import io.papermc.paper.plugin.lifecycle.event.handler.LifecycleEventHandler;
import io.papermc.paper.registry.data.DamageTypeRegistryEntry;
import io.papermc.paper.registry.event.RegistryComposeEvent;
import io.papermc.paper.registry.keys.DamageTypeKeys;
import net.kyori.adventure.key.Key;
import org.bukkit.damage.DamageEffect;
import org.bukkit.damage.DamageScaling;
import org.bukkit.damage.DamageType;
import org.bukkit.damage.DeathMessageType;

@SuppressWarnings("UnstableApiUsage")
public class DamageTypeRegistry
        implements LifecycleEventHandler<RegistryComposeEvent<DamageType, DamageTypeRegistryEntry.Builder>> {

    @Override
    public void run(RegistryComposeEvent<DamageType, DamageTypeRegistryEntry.Builder> event) {
        event.registry().register(
                DamageTypeKeys.create(Key.key("gaebang", "vibration")),
                builder -> builder
                        .exhaustion(0.1f)
                        .messageId("gaebang.death.vibration")
                        .damageEffect(DamageEffect.HURT)
                        .damageScaling(DamageScaling.NEVER)
                        .deathMessageType(DeathMessageType.DEFAULT)
        );
        event.registry().register(
                DamageTypeKeys.create(Key.key("gaebang", "submersion")), 
                builder -> builder
                        .exhaustion(0.1f)
                        .messageId("gaebang.death.submersion")
                        .damageEffect(DamageEffect.DROWNING)
                        .damageScaling(DamageScaling.NEVER)
                        .deathMessageType(DeathMessageType.DEFAULT)
        );
        event.registry().register(
                DamageTypeKeys.create(Key.key("gaebang", "bleeding")),
                builder -> builder
                        .exhaustion(0.1f)
                        .messageId("gaebang.death.bleeding")
                        .damageEffect(DamageEffect.HURT)
                        .damageScaling(DamageScaling.NEVER)
                        .deathMessageType(DeathMessageType.DEFAULT)
        );
        event.registry().register(
                DamageTypeKeys.create(Key.key("gaebang", "rupture")),
                builder -> builder
                        .exhaustion(0.1f)
                        .messageId("gaebang.death.rupture")
                        .damageEffect(DamageEffect.HURT)
                        .damageScaling(DamageScaling.NEVER)
                        .deathMessageType(DeathMessageType.DEFAULT)
        );
    }
}
