package me.lorenzo.ormconfig.config;

import me.lorenzo.ormconfig.ConfigHolder;

public class SimpleConfigHolder<T> implements ConfigHolder<T> {
    private final Class<T> configClass;
    private final ConfigHandler configHandler;
    private T cachedInstance;

    public SimpleConfigHolder(Class<T> configClass, ConfigHandler configHandler) {
        this.configClass = configClass;
        this.configHandler = configHandler;
    }

    @Override
    public T getConfig() {
        if(cachedInstance == null)
            this.cachedInstance = (T) configHandler.getConfigHolder(configClass);
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
