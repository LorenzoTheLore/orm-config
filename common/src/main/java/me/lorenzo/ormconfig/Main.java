package me.lorenzo.ormconfig;

import me.lorenzo.ormconfig.persistence.PersistenceHandler;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        PersistenceHandler persistenceHandler = new PersistenceHandler();
        TestConfig testConfig = new TestConfig("Test", 15);

        try {
            persistenceHandler.write(testConfig, new File("test.yml"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
