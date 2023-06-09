package me.lorenzo.ormconfig.utils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.Optional;

public class ReflectionUtils {
    private ReflectionUtils() {}

    /**
     * Get an optional containing the annotation instance with updated data for the specified class
     *
     * @param clazz class to get the annotation from
     * @param annotation annotation type to retrieve from clazz
     * @param <T>   the annotation type
     * @return an optional wrapping the annotation instance for the specified class if present
     */
    public static <T extends Annotation> Optional<T> getAnnotationForClass(Class<?> clazz, Class<T> annotation) {
        T annotationInstance = clazz.getAnnotation(annotation);

        return Optional.ofNullable(annotationInstance);
    }

    /**
     * Get an optional containing the annotation instance with updated data for the specified field
     *
     * @param field class to get the annotation from
     * @param annotation annotation type to retrieve from field
     * @param <T>   the annotation type
     * @return an optional wrapping the annotation instance for the specified class if present
     */
    public static <T extends Annotation> Optional<T> getAnnotationForField(Field field, Class<T> annotation) {
        T annotationInstance = field.getDeclaredAnnotation(annotation);

        return Optional.ofNullable(annotationInstance);
    }

    /**
     * Create a new generic instance of a class, using the default empty constructor
     *
     * @param configClass class to use to create the new instance
     * @return new instance of the specified class
     * @param <T> type of the instance
     */
    public static <T> T createInstance(Class<T> configClass) {
        try {
            Constructor<T> constructor = configClass.getDeclaredConstructor();

            return constructor.newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Failed to find empty constructor for class " + configClass.getSimpleName());
        }
    }
}
