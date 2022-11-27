package collection_framework.properties_class;

import java.io.FileInputStream;
import java.util.Enumeration;
import java.util.Properties;

/*
 * Used when we have to read '.properties' file.
 * Properties extend HashTable, so there can't be two properties with same key
 */

public class PropertiesDemo {

    public static void loadProperties() {
        Properties loadProps = new Properties();

        FileInputStream fileInputStream = null;

        try {
            fileInputStream = new FileInputStream("properties_class/application.properties");
            loadProps.load(fileInputStream);

            Enumeration<?> names = loadProps.propertyNames();

            while(names.hasMoreElements()) {
                String key = (String)names.nextElement();
                String value = loadProps.getProperty(key);

                System.out.println(key + " = " + value);
            }
        } catch(Exception exception) {
            System.out.println(exception);
        }
    }

    public static void main(String[] args) {
        loadProperties();
    }
    
}
