package me.lorenzo.ormconfig;

public interface ConfigHolder<T> {

    /**
     * Returns the configuration instance defined by the specified class.
     *
     * @return configuration instance initialized with updated data
     */
    T getConfig();

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
