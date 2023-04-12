package me.lorenzo.ormconfig.config;

import me.lorenzo.ormconfig.ConfigHolder;
import me.lorenzo.ormconfig.annotation.OrmConfig;
import me.lorenzo.ormconfig.persistence.PersistenceHandler;
import me.lorenzo.ormconfig.utils.ReflectionUtils;
import me.lorenzo.ormconfig.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class ConfigHandler {
    private final PersistenceHandler persistenceHandler;
    private final List<ConfigHolder<?>> configHolders;

    public <T> ConfigHolder<T> getConfigHolder(Class<T> configClass) {
        Optional<ConfigHolder<?>> configHolderOptional = findConfigHolder(configClass);
        if(configHolderOptional.isEmpty()) {
            return createConfigHolder(configClass);
        }

        return (ConfigHolder<T>) configHolderOptional.get();
    }

    public abstract <T> void save(T configInstance);

    private Optional<ConfigHolder<?>> findConfigHolder(Class<?> clazz) {
        return configHolders.stream()
                .filter(configHolder -> configHolder.getConfigClass() == clazz)
                .findAny();
    }

    private <T> ConfigHolder<T> createConfigHolder(Class<T> configClass) {
        SimpleConfigHolder<T> simpleConfigHolder = new SimpleConfigHolder<>(configClass, this);

        configHolders.add(simpleConfigHolder);
        return simpleConfigHolder;
    }

    private ConfigHandler() {
        this.persistenceHandler = new PersistenceHandler();
        this.configHolders = new ArrayList<>();
    }
}
