package me.lorenzo.ormconfig.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface OrmConfig {
    /**
     * Specifies the path in which the configuration's file should be saved
     * Note: If empty, it will be the path of most eligible data folder
     *
     * @return parent file path for the configuration
     */
    String path() default "";

    /**
     * Specifies the name of the configuration file
     * Note: If empty, it will be the name of the class in lower-case
     *
     * @return parent file path for the configuration
     */
    String name() default "";
}
