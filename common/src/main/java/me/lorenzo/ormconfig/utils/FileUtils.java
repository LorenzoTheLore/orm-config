package me.lorenzo.ormconfig.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
     * Get an instance of filereader for the specified file
     *
     * @param file file to create filereader on
     * @return filereader instance
     */
    public static FileReader getFileReader(File file) {
        File theFile = getFile(file.getPath(), file.getName());
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(theFile);
        } catch (FileNotFoundException e) {
            //We can ignore this case, it is handled by the getFile method
        }

        return fileReader;
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
