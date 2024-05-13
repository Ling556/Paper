package io.papermc.generator;

import io.papermc.generator.types.registry.AttributeGenerator;
import io.papermc.generator.types.registry.GeneratedKeyType;
import io.papermc.generator.types.SourceGenerator;
import io.papermc.generator.types.registry.BiomeGenerator;
import io.papermc.generator.types.registry.SoundGenerator;
import io.papermc.generator.types.goal.MobGoalGenerator;
import io.papermc.generator.types.registry.StructureGenerator;
import io.papermc.generator.types.registry.StructureTypeGenerator;
import io.papermc.generator.types.registry.TagGenerator;
import io.papermc.generator.types.registry.LegacyKeyedRegistryGenerator;
import io.papermc.paper.registry.RegistryKey;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import org.bukkit.GameEvent;
import org.bukkit.MusicInstrument;
import org.bukkit.block.Biome;
import org.bukkit.damage.DamageType;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Wolf;
import org.bukkit.generator.structure.Structure;
import org.bukkit.generator.structure.StructureType;
import org.bukkit.inventory.meta.trim.TrimMaterial;
import org.bukkit.inventory.meta.trim.TrimPattern;
import org.bukkit.potion.PotionEffectType;

public interface Generators {

    SourceGenerator[] API = {
        simpleKey("GameEventKeys", GameEvent.class, Registries.GAME_EVENT, RegistryKey.GAME_EVENT, false),
        simpleKey("BiomeKeys", Biome.class, Registries.BIOME, RegistryKey.BIOME, true),
        simpleKey("TrimMaterialKeys", TrimMaterial.class, Registries.TRIM_MATERIAL, RegistryKey.TRIM_MATERIAL, true),
        simpleKey("TrimPatternKeys", TrimPattern.class, Registries.TRIM_PATTERN, RegistryKey.TRIM_PATTERN, true),
        simpleKey("StructureKeys", Structure.class, Registries.STRUCTURE, RegistryKey.STRUCTURE, true),
        simpleKey("StructureTypeKeys", StructureType.class, Registries.STRUCTURE_TYPE, RegistryKey.STRUCTURE_TYPE, false),
        simpleKey("InstrumentKeys", MusicInstrument.class, Registries.INSTRUMENT, RegistryKey.INSTRUMENT, false),
        simpleKey("EnchantmentKeys", Enchantment.class, Registries.ENCHANTMENT, RegistryKey.ENCHANTMENT, false),
        simpleKey("MobEffectKeys", PotionEffectType.class, Registries.MOB_EFFECT, RegistryKey.MOB_EFFECT, false),
        simpleKey("DamageTypeKeys", DamageType.class, Registries.DAMAGE_TYPE, RegistryKey.DAMAGE_TYPE, true),
        simpleKey("WolfVariantKeys", Wolf.Variant.class, Registries.WOLF_VARIANT, RegistryKey.WOLF_VARIANT, true),
        new MobGoalGenerator("VanillaGoal", "com.destroystokyo.paper.entity.ai"),
        new SoundGenerator("Sound", "org.bukkit"),
        new BiomeGenerator("Biome", "org.bukkit.block"),
        new AttributeGenerator("Attribute", "org.bukkit.attribute"),
        new StructureTypeGenerator("StructureType", "org.bukkit.generator.structure"),
        new StructureGenerator("Structure", "org.bukkit.generator.structure"),
        new LegacyKeyedRegistryGenerator<>("TrimPattern", TrimPattern.class, "org.bukkit.inventory.meta.trim", Registries.TRIM_PATTERN, RegistryKey.TRIM_PATTERN),
        new LegacyKeyedRegistryGenerator<>("TrimMaterial", TrimMaterial.class, "org.bukkit.inventory.meta.trim", Registries.TRIM_MATERIAL, RegistryKey.TRIM_MATERIAL),
        new TagGenerator("Tag", "org.bukkit")
    };

    private static <T, A> SourceGenerator simpleKey(final String className, final Class<A> apiType, final ResourceKey<? extends Registry<T>> registryKey, final RegistryKey<A> apiRegistryKey, final boolean publicCreateKeyMethod) {
        return new GeneratedKeyType<>(className, apiType, "io.papermc.paper.registry.keys", registryKey, apiRegistryKey, publicCreateKeyMethod);
    }
}
