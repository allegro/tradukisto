package pl.allegro.finance.tradukisto.internal.support;

import java.util.AbstractMap;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapSupport {

    @SafeVarargs
    public static <K, V> Map<K, V> mapOf(Map.Entry<K, V>... entries) {
        return Stream.of(entries)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue
                ));
    }

    @SafeVarargs
    public static <K, V> Map<K, V> unmodifiableMapOf(Map.Entry<K, V>... entries) {
        return Collections.unmodifiableMap(mapOf(entries));
    }

    public static <K, V> Map.Entry<K, V> unmodifiableEntry(K key, V value) {
        return new AbstractMap.SimpleImmutableEntry<>(key, value);
    }

}
