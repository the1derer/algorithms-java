package collection_framework.properties_class;

import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class ListSystemProperties {
    public static void main(String[] args) {
        
        String classPath = System.getProperty("java.class.path");
        System.out.println(classPath);

        Properties systemProperties = System.getProperties();

        // TODO: can't think how to find generics for sortedSystemProperties
        SortedMap sortedSystemProperties = new TreeMap(systemProperties);

        Set<String> keySet = sortedSystemProperties.keySet();

        Iterator<String> iterator = keySet.iterator();

        while(iterator.hasNext()) {
            String propertyName = iterator.next();
            String propertyValue = systemProperties.getProperty(propertyName);
            System.out.println(propertyName + " : " + propertyValue);
        }
    }
}
