package me.lorenzo.ormconfig.config;

import me.lorenzo.ormconfig.ConfigHolder;

import java.util.ArrayList;
import java.util.List;

public class ConfigFactory {
    private static List<ConfigHolder<?>> configHolders;

    public static <T> ConfigHolder<T> getConfigHolder(Class<T> configClass) {
        return new SimpleConfigHolder<>();
    }

    static {
        configHolders = new ArrayList<>();
    }
}
