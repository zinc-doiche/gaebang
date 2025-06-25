package com.devport.gaebang;

import io.papermc.paper.plugin.lifecycle.event.handler.LifecycleEventHandler;
import io.papermc.paper.registry.data.DamageTypeRegistryEntry;
import io.papermc.paper.registry.event.RegistryComposeEvent;
import io.papermc.paper.registry.keys.DamageTypeKeys;
import net.kyori.adventure.key.Key;
import org.bukkit.damage.DamageEffect;
import org.bukkit.damage.DamageType;

@SuppressWarnings("UnstableApiUsage")
public class DamageTypeRegistry
        implements LifecycleEventHandler<RegistryComposeEvent<DamageType, DamageTypeRegistryEntry.Builder>> {

    @Override
    public void run(RegistryComposeEvent<DamageType, DamageTypeRegistryEntry.Builder> event) {
        event.registry().register(
                DamageTypeKeys.create(Key.key("gaebang", "vibration")),
                builder -> builder.messageId("gaebang.death.vibration")
        );
        event.registry().register(
                DamageTypeKeys.create(Key.key("gaebang", "submersion")), 
                builder -> builder
                        .messageId("gaebang.death.submersion")
                        .damageEffect(DamageEffect.DROWNING)
        );
        event.registry().register(
                DamageTypeKeys.create(Key.key("gaebang", "bleeding")),
                builder -> builder.messageId("gaebang.death.bleeding")
        );
        event.registry().register(
                DamageTypeKeys.create(Key.key("gaebang", "rupture")),
                builder -> builder.messageId("gaebang.death.rupture")
        );
    }
}
