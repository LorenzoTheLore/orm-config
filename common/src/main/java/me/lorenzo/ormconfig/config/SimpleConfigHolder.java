package me.lorenzo.ormconfig.config;

import me.lorenzo.ormconfig.ConfigHolder;

public class SimpleConfigHolder<T> implements ConfigHolder<T> {
    private final Class<T> configClass;
    private final ConfigHandler configHandler;
    private T cachedInstance;

    public SimpleConfigHolder(Class<T> configClass, ConfigHandler configHandler, T instance) {
        this.configClass = configClass;
        this.configHandler = configHandler;
        this.cachedInstance = instance;
    }

    @Override
    public T getConfig() {
        return cachedInstance;
    }

    @Override
    public void save() {
        configHandler.save(cachedInstance);
    }

    @Override
    public Class<T> getConfigClass() {
        return configClass;
    }
}
