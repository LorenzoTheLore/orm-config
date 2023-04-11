package me.lorenzo.ormconfig;

public interface ConfigHolder<T> {

    /**
     * Returns the configuration instance defined by the specified class.
     *
     * @param configClass configuration model that holds the structure of the configuration
     * @return configuration instance initialized with updated data
     */
    T getConfig(Class<T> configClass);

}
