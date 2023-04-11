package me.lorenzo.ormconfig.annotation;

public @interface OrmApplication {
    /**
     * Specifies package name(s) containing configuration {@link OrmConfig models}
     * Note: Not specifying it will result in searching from the main class package
     *
     * @return list of packages containing configurations
     */
    String[] modelPackages() default {};

}
