package me.lorenzo.ormconfig.reflection;

public class StringUtils {

    /**
     * Method to retrieve an always-valued string based on default value
     *
     * @param string original string
     * @param defaultValue default value to return when string is null
     * @return always-valued string
     */
    public static String getOrDefault(String string, String defaultValue) {
        return (string == null || string.isEmpty()) ? defaultValue : string;
    }

}
