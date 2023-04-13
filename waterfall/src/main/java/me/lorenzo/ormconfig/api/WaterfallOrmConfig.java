package me.lorenzo.ormconfig.api;

import me.lorenzo.ormconfig.ConfigHolder;
import me.lorenzo.ormconfig.IOrmConfig;

public class WaterfallOrmConfig implements IOrmConfig {
    @Override
    public void initialize(Class<?> mainClass) {

    }

    @Override
    public <T> ConfigHolder<T> getConfigHolder(Class<T> configClass) {
        return null;
    }
}
