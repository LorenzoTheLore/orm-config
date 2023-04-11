package me.lorenzo.ormconfig.file;

import java.io.File;
import java.io.IOException;

public class FileUtils {

    private FileUtils() {}

    /**
     * Returns the file with specified fileName in the specified filePath,
     * creating new one if not existent
     *
     * @param path where to look for the file
     * @param fileName the file name
     * @return File instance representing the location of the file
     */
    public static File getFile(String path, String fileName) {
        File file = new File(path, fileName);

        if(!file.exists()) {
            try {
                createFile(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return file;
    }

    /**
     * Create a new file based on {@link File file}
     *
     * @param file reference to the instance of file to create
     * @throws IOException thrown when file cannot be created
     */
    private static void createFile(File file) throws IOException {
        if(!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }

        file.createNewFile();
    }

}
