package org.mandm.helpers.loaders;

import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Map;

public class YAMLLoader {
    public static Map<String, Object> load(String path) {
        InputStream inputStream;
        try {
            inputStream = new FileInputStream(path);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        var yaml = new Yaml();
        return yaml.load(inputStream);

    }
}
