package com.devport.gaebang;

import io.papermc.paper.plugin.lifecycle.event.handler.LifecycleEventHandler;
import io.papermc.paper.registry.data.EnchantmentRegistryEntry;
import io.papermc.paper.registry.event.RegistryComposeEvent;
import io.papermc.paper.registry.keys.EnchantmentKeys;
import io.papermc.paper.registry.keys.tags.ItemTypeTagKeys;
import net.kyori.adventure.key.Key;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.EquipmentSlotGroup;

@SuppressWarnings("UnstableApiUsage")
public class EnchantmentRegistry
        implements LifecycleEventHandler<RegistryComposeEvent<Enchantment, EnchantmentRegistryEntry.Builder>> {

    @Override
    public void run(RegistryComposeEvent<Enchantment, EnchantmentRegistryEntry.Builder> event) {
        // 진동 부여 (검, 도끼)
        event.registry().register(
                EnchantmentKeys.create(Key.key("gaebang", "vibration_apply")),
                builder -> builder
                        .description(Component.text("진동 부여").color(NamedTextColor.YELLOW))
                        .supportedItems(event.getOrCreateTag(ItemTypeTagKeys.ENCHANTABLE_SHARP_WEAPON))
                        .anvilCost(3)
                        .maxLevel(3)
                        .weight(15)
                        .minimumCost(EnchantmentRegistryEntry.EnchantmentCost.of(1, 1))
                        .maximumCost(EnchantmentRegistryEntry.EnchantmentCost.of(3, 1))
                        .activeSlots(EquipmentSlotGroup.ANY)
        );

        // 진동 폭발 (활, 쇠뇌)
        event.registry().register(
                EnchantmentKeys.create(Key.key("gaebang", "vibration_explosion")),
                builder -> builder
                        .description(Component.text("진동 폭발").color(NamedTextColor.YELLOW))
                        .supportedItems(event.getOrCreateTag(ItemTypeTagKeys.ENCHANTABLE_BOW))
                        .anvilCost(3)
                        .maxLevel(1)
                        .weight(15)
                        .minimumCost(EnchantmentRegistryEntry.EnchantmentCost.of(1, 1))
                        .maximumCost(EnchantmentRegistryEntry.EnchantmentCost.of(1, 1))
                        .activeSlots(EquipmentSlotGroup.ANY)
        );

        // 침잠 부여 (검, 도끼)
        event.registry().register(
                EnchantmentKeys.create(Key.key("gaebang", "submersion_apply")),
                builder -> builder
                        .description(Component.text("침잠 부여").color(NamedTextColor.DARK_AQUA))
                        .supportedItems(event.getOrCreateTag(ItemTypeTagKeys.ENCHANTABLE_SHARP_WEAPON))
                        .anvilCost(3)
                        .maxLevel(3)
                        .weight(15)
                        .minimumCost(EnchantmentRegistryEntry.EnchantmentCost.of(1, 1))
                        .maximumCost(EnchantmentRegistryEntry.EnchantmentCost.of(3, 1))
                        .activeSlots(EquipmentSlotGroup.ANY)
        );

        // 침잠 쇄도 (괭이)
        event.registry().register(
                EnchantmentKeys.create(Key.key("gaebang", "submersion_rush")),
                builder -> builder
                        .description(Component.text("침잠 쇄도").color(NamedTextColor.DARK_AQUA))
                        .supportedItems(event.getOrCreateTag(ItemTypeTagKeys.HOES))
                        .anvilCost(3)
                        .maxLevel(1)
                        .weight(15)
                        .minimumCost(EnchantmentRegistryEntry.EnchantmentCost.of(1, 1))
                        .maximumCost(EnchantmentRegistryEntry.EnchantmentCost.of(1, 1))
                        .activeSlots(EquipmentSlotGroup.ANY)
        );

        // 파열 부여 (도끼)
        event.registry().register(
                EnchantmentKeys.create(Key.key("gaebang", "rupture_apply")),
                builder -> builder
                        .description(Component.text("파열 부여").color(NamedTextColor.DARK_GREEN))
                        .supportedItems(event.getOrCreateTag(ItemTypeTagKeys.AXES))
                        .anvilCost(3)
                        .maxLevel(3)
                        .weight(15)
                        .minimumCost(EnchantmentRegistryEntry.EnchantmentCost.of(1, 1))
                        .maximumCost(EnchantmentRegistryEntry.EnchantmentCost.of(3, 1))
                        .activeSlots(EquipmentSlotGroup.ANY)
        );

        // 출혈 부여 (검)
        event.registry().register(
                EnchantmentKeys.create(Key.key("gaebang", "bleeding_apply")),
                builder -> builder
                        .description(Component.text("출혈 부여").color(NamedTextColor.DARK_RED))
                        .supportedItems(event.getOrCreateTag(ItemTypeTagKeys.SWORDS))
                        .anvilCost(3)
                        .maxLevel(3)
                        .weight(15)
                        .minimumCost(EnchantmentRegistryEntry.EnchantmentCost.of(1, 1))
                        .maximumCost(EnchantmentRegistryEntry.EnchantmentCost.of(3, 1))
                        .activeSlots(EquipmentSlotGroup.ANY)
        );

        // 실드 브레이커 (도끼)
        event.registry().register(
                EnchantmentKeys.create(Key.key("gaebang", "shield_breaker")),
                builder -> builder
                        .description(Component.text("실드 브레이커").color(NamedTextColor.GRAY))
                        .supportedItems(event.getOrCreateTag(ItemTypeTagKeys.AXES))
                        .anvilCost(3)
                        .maxLevel(3)
                        .weight(15)
                        .minimumCost(EnchantmentRegistryEntry.EnchantmentCost.of(1, 1))
                        .maximumCost(EnchantmentRegistryEntry.EnchantmentCost.of(3, 1))
                        .activeSlots(EquipmentSlotGroup.ANY)
        );
    }
}
