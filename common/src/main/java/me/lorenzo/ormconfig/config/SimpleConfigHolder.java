package me.lorenzo.ormconfig.config;

import me.lorenzo.ormconfig.ConfigHolder;

public class SimpleConfigHolder<T> implements ConfigHolder<T> {
    private final Class<T> configClass;
    private T cachedInstance;

    public SimpleConfigHolder(Class<T> configClass) {
        this.configClass = configClass;
    }

    @Override
    public T getConfig(Class<T> configClass) {
        if(cachedInstance == null)
            this.cachedInstance = (T) ConfigHandler.getConfigHolder(configClass);
        return cachedInstance;
    }

    @Override
    public void save() {

    }

    @Override
    public Class<T> getConfigClass() {
        return configClass;
    }
}
