package me.lorenzo.ormconfig.config;

import me.lorenzo.ormconfig.ConfigHolder;

public class SimpleConfigHolder<T> implements ConfigHolder<T> {
    private T cachedInstance;

    @Override
    public T getConfig(Class<? extends T> configClass) {
        if(cachedInstance == null)
            System.out.println("Asd");
            //TODO load instance from serializer
        return cachedInstance;
    }
}
