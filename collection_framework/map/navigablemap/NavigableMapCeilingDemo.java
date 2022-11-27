package collection_framework.map.navigablemap;

import java.util.Calendar;
import java.util.Locale;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class NavigableMapCeilingDemo {
    
    public static void main(String[] args) {
        NavigableMap<Integer, String> navigableMap = new TreeMap<>();

        navigableMap.put(2, "two");
        navigableMap.put(1, "one");
        navigableMap.put(3, "three");

        System.out.println("Original map: " + navigableMap + "\n");

        System.out.println("----------------Descending/Reverse NavigableMap-----------------");
        NavigableMap<Integer, String> descendingNavigableMap = navigableMap.descendingMap();
        System.out.println("Descending map: " + descendingNavigableMap + "\n");


        System.out.println("----------------Ceiling key-----------------");
        Calendar now = Calendar.getInstance();

        Locale locale = Locale.getDefault();
        // Locale locale = new Locale("fr", "FR");

        
        Map<String, Integer> mapOfDayNamesAndNumber = now.getDisplayNames(Calendar.DAY_OF_WEEK, Calendar.LONG, locale);
        System.out.println(mapOfDayNamesAndNumber);

        NavigableMap<String, Integer> navigableMapOfDaysOfWeek = new TreeMap<>(mapOfDayNamesAndNumber); // will sort by key i.e String i.e. alphabetically

        System.out.printf("navigableMapOfDaysOfWeek: %n%s%n", navigableMapOfDaysOfWeek);

        System.out.printf("Key ceiling after Sunday: %s%n", navigableMapOfDaysOfWeek.ceilingKey("Sunday"));
        System.out.printf("Key ceiling after Tunday: %s%n", navigableMapOfDaysOfWeek.ceilingKey("Tunday"));

        navigableMapOfDaysOfWeek.remove("Sunday");
        System.out.printf("Key ceiling after Sunday after remove(): %s%n", navigableMapOfDaysOfWeek.ceilingKey("Sunday"));

        System.out.println("----------------Ceiling key-----------------");

        NavigableMap<String, String> ceilingDemoNavigableMap = new TreeMap<>();

        ceilingDemoNavigableMap.put("C++", "Good Programming language");
        ceilingDemoNavigableMap.put("Java", "Best programming language");
        ceilingDemoNavigableMap.put("Scala", "Another JVM language");
        ceilingDemoNavigableMap.put("Python", "Dynamic programming language");

        System.out.println("SortedMap: " + ceilingDemoNavigableMap);

        System.out.println("ceilingKey from Java: " + ceilingDemoNavigableMap.ceilingKey("Java"));
        System.out.println("ceilingKey from Kava: " + ceilingDemoNavigableMap.ceilingKey("Kava"));
    }
}
