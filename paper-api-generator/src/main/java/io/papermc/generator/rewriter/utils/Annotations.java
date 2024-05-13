package io.papermc.generator.rewriter.utils;

import io.papermc.generator.rewriter.replace.SearchMetadata;
import io.papermc.generator.rewriter.context.ImportCollector;
import io.papermc.generator.utils.ClassHelper;
import io.papermc.generator.utils.experimental.ExperimentalHelper;
import net.minecraft.world.flag.FeatureFlag;
import net.minecraft.world.flag.FeatureFlagSet;
import org.bukkit.MinecraftExperimental;
import org.jetbrains.annotations.ApiStatus;
import java.lang.annotation.Annotation;

public final class Annotations {

    public static String annotation(Class<? extends Annotation> clazz, ImportCollector collector) {
        return "@%s".formatted(collector.getShortName(clazz));
    }

    public static String annotationStyle(Class<? extends Annotation> clazz) {
        return "@%s".formatted(ClassHelper.retrieveFullNestedName(clazz));
    }

    public static String annotation(Class<? extends Annotation> clazz, ImportCollector collector, String param, String value) {
        String annotation = annotation(clazz, collector);
        if (value.isEmpty()) {
            return annotation;
        }
        return "%s(%s = %s)".formatted(annotation, param, value);
    }

    public static String annotation(Class<? extends Annotation> clazz, ImportCollector collector, String value) {
        String annotation = annotation(clazz, collector);
        if (value.isEmpty()) {
            return annotation;
        }
        return "%s(%s)".formatted(annotation, value);
    }

    public static void experimentalAnnotations(final StringBuilder builder, final SearchMetadata metadata, final FeatureFlagSet featureFlags) {
        experimentalAnnotations(builder, metadata, ExperimentalHelper.onlyOneFlag(featureFlags));
    }

    public static void experimentalAnnotations(final StringBuilder builder, final SearchMetadata metadata, final FeatureFlag featureFlag) {
        builder.append(metadata.indent()).append(annotation(MinecraftExperimental.class, metadata.importCollector(), "%s.%s".formatted(
            metadata.importCollector().getShortName(MinecraftExperimental.Requires.class), ExperimentalHelper.toBukkitAnnotationMember(featureFlag).name()
        ))).append('\n');

        builder.append(metadata.indent()).append(annotation(ApiStatus.Experimental.class, metadata.importCollector())).append('\n');
    }

    private Annotations() {
    }
}
