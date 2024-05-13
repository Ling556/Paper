package org.bukkit.inventory.meta.trim;

import org.bukkit.Keyed;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Registry;
import org.bukkit.Translatable;

/**
 * Represents a pattern that may be used in an {@link ArmorTrim}.
 */
public interface TrimPattern extends Keyed, Translatable {

    // Paper start - Generated/TrimPattern
    // @GeneratedFrom 1.20.6
    @org.bukkit.MinecraftExperimental(org.bukkit.MinecraftExperimental.Requires.UPDATE_1_21)
    @org.jetbrains.annotations.ApiStatus.Experimental
    TrimPattern BOLT = Registry.TRIM_PATTERN.get(NamespacedKey.minecraft("bolt"));

    TrimPattern COAST = Registry.TRIM_PATTERN.get(NamespacedKey.minecraft("coast"));

    TrimPattern DUNE = Registry.TRIM_PATTERN.get(NamespacedKey.minecraft("dune"));

    TrimPattern EYE = Registry.TRIM_PATTERN.get(NamespacedKey.minecraft("eye"));

    @org.bukkit.MinecraftExperimental(org.bukkit.MinecraftExperimental.Requires.UPDATE_1_21)
    @org.jetbrains.annotations.ApiStatus.Experimental
    TrimPattern FLOW = Registry.TRIM_PATTERN.get(NamespacedKey.minecraft("flow"));

    TrimPattern HOST = Registry.TRIM_PATTERN.get(NamespacedKey.minecraft("host"));

    TrimPattern RAISER = Registry.TRIM_PATTERN.get(NamespacedKey.minecraft("raiser"));

    TrimPattern RIB = Registry.TRIM_PATTERN.get(NamespacedKey.minecraft("rib"));

    TrimPattern SENTRY = Registry.TRIM_PATTERN.get(NamespacedKey.minecraft("sentry"));

    TrimPattern SHAPER = Registry.TRIM_PATTERN.get(NamespacedKey.minecraft("shaper"));

    TrimPattern SILENCE = Registry.TRIM_PATTERN.get(NamespacedKey.minecraft("silence"));

    TrimPattern SNOUT = Registry.TRIM_PATTERN.get(NamespacedKey.minecraft("snout"));

    TrimPattern SPIRE = Registry.TRIM_PATTERN.get(NamespacedKey.minecraft("spire"));

    TrimPattern TIDE = Registry.TRIM_PATTERN.get(NamespacedKey.minecraft("tide"));

    TrimPattern VEX = Registry.TRIM_PATTERN.get(NamespacedKey.minecraft("vex"));

    TrimPattern WARD = Registry.TRIM_PATTERN.get(NamespacedKey.minecraft("ward"));

    TrimPattern WAYFINDER = Registry.TRIM_PATTERN.get(NamespacedKey.minecraft("wayfinder"));

    TrimPattern WILD = Registry.TRIM_PATTERN.get(NamespacedKey.minecraft("wild"));
    // Paper end - Generated/TrimPattern

    // Paper start - adventure
    /**
     * Get the description of this {@link TrimPattern}.
     *
     * @return the description
     */
    net.kyori.adventure.text.@org.jetbrains.annotations.NotNull Component description();

    /**
     * @deprecated this method assumes that {@link #description()} will
     * always be a translatable component which is not guaranteed.
     */
    @Override
    @Deprecated(forRemoval = true)
    @org.jetbrains.annotations.NotNull String getTranslationKey();
    // Paper end - adventure

    // Paper start - Registry#getKey
    /**
     * @deprecated use {@link Registry#getKey(Keyed)} and {@link Registry#TRIM_PATTERN}. TrimPatterns
     * can exist without a key.
     */
    @Deprecated(forRemoval = true, since = "1.20.4")
    @Override
    org.bukkit.@org.jetbrains.annotations.NotNull NamespacedKey getKey();
    // Paper end - Registry#getKey
}
