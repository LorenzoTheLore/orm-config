package me.lorenzo.ormconfig.config;

import me.lorenzo.ormconfig.ConfigHolder;
import me.lorenzo.ormconfig.serializer.ConfigSerializer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ConfigHandler {
    private static List<ConfigHolder<?>> configHolders;

    public static <T> ConfigHolder<T> getConfigHolder(Class<T> configClass) {
        Optional<ConfigHolder<?>> configHolderOptional = findConfigHolder(configClass);
        if(configHolderOptional.isEmpty()) {
            return createConfigHolder(configClass);
        }

        return (ConfigHolder<T>) configHolderOptional.get();
    }

    private static Optional<ConfigHolder<?>> findConfigHolder(Class<?> clazz) {
        return configHolders.stream()
                .filter(configHolder -> configHolder.getConfigClass() == clazz)
                .findAny();
    }

    private static <T> ConfigHolder<T> createConfigHolder(Class<T> configClass) {
        SimpleConfigHolder<T> simpleConfigHolder = new SimpleConfigHolder<>(configClass);

        configHolders.add(simpleConfigHolder);
        return simpleConfigHolder;
    }

    static {
        configHolders = new ArrayList<>();
    }
}
