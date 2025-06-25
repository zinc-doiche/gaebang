package com.devport.gaebang;

import io.papermc.paper.plugin.bootstrap.BootstrapContext;
import io.papermc.paper.plugin.bootstrap.PluginBootstrap;
import io.papermc.paper.plugin.lifecycle.event.LifecycleEventManager;
import io.papermc.paper.registry.event.RegistryEvents;

@SuppressWarnings("UnstableApiUsage")
public class GaebangBootstrapper implements PluginBootstrap {

    @Override
    public void bootstrap(BootstrapContext context) {
        LifecycleEventManager<BootstrapContext> lifecycleManager = context.getLifecycleManager();

        lifecycleManager.registerEventHandler(
                RegistryEvents.ENCHANTMENT
                        .compose()
                        .newHandler(new EnchantmentRegistry())
        );
        lifecycleManager.registerEventHandler(
                RegistryEvents.DAMAGE_TYPE
                        .compose()
                        .newHandler(new DamageTypeRegistry())
        );
    }
}