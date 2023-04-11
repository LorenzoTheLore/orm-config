package me.lorenzo.ormconfig.config;

import me.lorenzo.ormconfig.ConfigHolder;

public class SimpleConfigHolder<T> implements ConfigHolder<T> {
    private T cachedInstance;

    @Override
    public T getConfig(Class<T> configClass) {
        if(cachedInstance == null)
            this.cachedInstance = (T) ConfigFactory.getConfigHolder(configClass);
        return cachedInstance;
    }
}
