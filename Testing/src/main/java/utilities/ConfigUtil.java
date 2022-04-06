package utilities;

import org.apache.commons.configuration.PropertiesConfiguration;
import utilities.readers.PropertiesReader;

public class ConfigUtil {
    public static String BROWSER;
    public static String Web_URL;

    public static void loadTestConfigurations() {
       PropertiesReader reader = new PropertiesReader("config.properties");
        BROWSER = reader.getPropertyUsingKey("Browser");
        Web_URL = reader.getPropertyUsingKey("Web_URL");
    }
}
