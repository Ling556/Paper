package io.papermc.generator.rewriter.types;

import com.google.common.collect.Multimap;
import io.papermc.generator.rewriter.ClassNamed;
import io.papermc.generator.rewriter.replace.SearchMetadata;
import io.papermc.generator.rewriter.replace.SearchReplaceRewriter;
import org.checkerframework.checker.nullness.qual.MonotonicNonNull;

import java.util.Collection;

public abstract class SwitchRewriter<T> extends SearchReplaceRewriter {

    protected @MonotonicNonNull Return<T> defaultValue;

    protected SwitchRewriter(final Class<?> rewriteClass, final String pattern, final boolean exactReplacement) {
        super(rewriteClass, pattern, exactReplacement);
    }

    protected SwitchRewriter(final ClassNamed rewriteClass, final String pattern, final boolean exactReplacement) {
        super(rewriteClass, pattern, exactReplacement);
    }

    protected record Return<T>(T object, String code) {}

    protected Return<T> returnOf(T object, String code) {
        return new Return<>(object, code);
    }

    protected abstract Multimap<Return<T>, String> getContent(); // <return:cases>

    @Override
    protected void insert(final SearchMetadata metadata, final StringBuilder builder) {
        Multimap<Return<T>, String> content = this.getContent();
        for (Return<T> key : content.keySet()) {
            Collection<String> conditions = content.get(key);
            for (String cond : conditions) {
                builder.append(metadata.indent()).append("case ").append(cond).append(':');
                builder.append('\n');
            }
            builder.append(metadata.indent()).append(INDENT_UNIT).append("return ").append(key.code()).append(';');
            builder.append('\n');
        }

        if (this.defaultValue != null) {
            builder.append(metadata.indent()).append("default:");
            builder.append('\n');
            builder.append(metadata.indent()).append(INDENT_UNIT).append("return ").append(this.defaultValue.code()).append(';');
            builder.append('\n');
        }
    }
}
