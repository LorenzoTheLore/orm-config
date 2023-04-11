package me.lorenzo.ormconfig;

public interface ConfigHolder<T> {

    /**
     * Returns the configuration instance defined by the specified class.
     *
     * @param configClass configuration model that holds the structure of the configuration
     * @return configuration instance initialized with updated data
     */
    T getConfig(Class<T> configClass);

    /**
     * Save (serialize) current instance data to file
     */
    void save();

    /**
     * Get the class of the model contained in this holder
     *
     * @return type of config
     */
    Class<T> getConfigClass();
}
