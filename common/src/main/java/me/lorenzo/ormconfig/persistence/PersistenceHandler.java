package me.lorenzo.ormconfig.persistence;

import me.lorenzo.ormconfig.annotation.OrmField;
import me.lorenzo.ormconfig.utils.FileUtils;
import me.lorenzo.ormconfig.utils.ReflectionUtils;
import me.lorenzo.ormconfig.utils.StringUtils;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class PersistenceHandler {
    private final Yaml yaml;

    public PersistenceHandler() {
        DumperOptions dumperOptions = new DumperOptions();
        dumperOptions.setIndent(2);
        dumperOptions.setPrettyFlow(true);
        dumperOptions.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);

        this.yaml = new Yaml(dumperOptions);
    }

    /**
     * Writes current configuration instance to file.
     * Note: Only fields annotated with {@link OrmField @OrmField} will be written in file
     *
     * @param configInstance configuration instance containing updated configuration data
     * @param file file used to store data
     * @throws Exception generic exception thrown when writing fails
     */
    public void write(Object configInstance, File file) throws Exception {
        Class<?> configClass = configInstance.getClass();
        Map<String, Object> values = new HashMap<>();

        for(Field field : configClass.getDeclaredFields()) {
            Optional<OrmField> ormFieldOptional = ReflectionUtils.getAnnotationForField(field, OrmField.class);
            if(ormFieldOptional.isEmpty()) {
                continue;
            }

            field.setAccessible(true);
            OrmField ormField = ormFieldOptional.get();
            String path = StringUtils.getOrDefault(ormField.path(), field.getName());

            values.put(path, field.get(configInstance));
        }

        FileWriter fileWriter = FileUtils.getFileWriter(file);
        yaml.dump(values, fileWriter);
        fileWriter.close();
    }
}
