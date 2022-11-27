package collection_framework.properties_class;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

public class PropertiesXML {
    
    public static void main(String[] args) throws IOException {

        Properties properties = new Properties();
        properties.put("today", new Date().toString());
        properties.put("user", "A");

        FileOutputStream output = new FileOutputStream("./properties_class/user.props");

        properties.storeToXML(output, "updates");

        FileInputStream input = new FileInputStream("./properties_class/user.props");

        properties.loadFromXML(input);

        properties.list(System.out);

        System.out.println(properties.getProperty("user"));
        System.out.println(properties.getProperty("today"));

        System.out.println("via get() Method"); // will work as Properties class extends Map
        System.out.println(properties.get("user"));
        System.out.println(properties.get("today"));
    }
}
