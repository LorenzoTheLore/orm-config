package me.lorenzo.ormconfig.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
public @interface OrmField {
    /**
     * Specifies the path of the field inside the YAML file
     *
     * @return yaml field path
     */
    String path() default "";
}
