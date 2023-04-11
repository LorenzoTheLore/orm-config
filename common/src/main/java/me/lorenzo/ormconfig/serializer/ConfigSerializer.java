package me.lorenzo.ormconfig.serializer;

import me.lorenzo.ormconfig.annotation.OrmConfig;
import me.lorenzo.ormconfig.utils.FileUtils;
import me.lorenzo.ormconfig.utils.ReflectionUtils;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Optional;

public class ConfigSerializer {
    private static ConfigSerializer instance;

    private final Yaml yaml;

    public static ConfigSerializer getInstance() {
        if(instance == null)
            instance = new ConfigSerializer();
        return instance;
    }

    public <T> T deserializeConfig(File file, Class<T> clazz) {
        Optional<OrmConfig> ormConfigOptional = ReflectionUtils.getAnnotationForClass(clazz, OrmConfig.class);
        if(ormConfigOptional.isEmpty()) {
            throw new UnsupportedOperationException("Unable to deserialize " + file.getName() + " to class " + clazz.getSimpleName());
        }

        FileReader fileReader = FileUtils.getFileReader(file);
        T t = yaml.loadAs(fileReader, clazz);
        try {
            fileReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return t;
    }

    private ConfigSerializer() {
        DumperOptions dumperOptions = new DumperOptions();
        dumperOptions.setIndent(2);
        dumperOptions.setPrettyFlow(true);

        this.yaml = new Yaml(dumperOptions);
    }
}
