package utilities.readers;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {
    String configFile;
    Properties properties;

    public PropertiesReader(String configFile){
        this.configFile = configFile;
        properties = new Properties();
    }

    public String getPropertyUsingKey(String key) {
        // load a properties file
        InputStream stream = getClass().getClassLoader().getResourceAsStream(configFile);
        try {
            properties.load(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // get value by key
        return properties.getProperty(key).trim();
    }
}
