package me.lorenzo.ormconfig;

import me.lorenzo.ormconfig.annotation.OrmApplication;

public interface IOrmConfig {

    /**
     * Initialize the orm-config library, which should be annotated with {@link OrmApplication @OrmApplication}.
     *
     * @param mainClass the main class
     */
    void initialize(Class<?> mainClass);

    /**
     * Returns the configuration handler for a specific configuration's model
     *
     * @param configClass Class defining configuration model
     * @return instance of the ConfigHolder handling instances of specified configuration model
     * @param <T> type of the configuration
     */
    <T> ConfigHolder<T> getConfigHolder(Class<T> configClass);

}
