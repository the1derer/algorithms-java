package collection_framework.map.treemap;

import java.util.*;
import java.util.Map.Entry;

public class TreeMapComparatorDemo {

    public static void main(String[] args) {
        // Comparator salaryComparator = new MySalaryComp(); //have to implement
        // Comparator interface
        // Comparator nameComparator = new MyNameComp();

        /*
         * AnonClass + Lambda implementation is below
         */
        Comparator<Empl> salaryComparator = new Comparator<Empl>() {

            @Override
            public int compare(Empl e1, Empl e2) {
                return e1.getSalary() > e2.getSalary() ? 1 : -1;
            }
        };

        Comparator<Empl> nameComparator = (e1, e2) -> e1.name.compareTo(e2.name);

        System.out.println("----------------sorting with salary------------------");
        TreeMap<Empl, String> salarySortedTreeMap = new TreeMap<>(salaryComparator);
        add(salarySortedTreeMap);
        show(salarySortedTreeMap);

        Empl em = salarySortedTreeMap.firstKey();
        System.out.println("Lowest salary emp: " + em.salary);
        Entry<Empl, String> entry = salarySortedTreeMap.firstEntry();

        System.out.println("----------------sorting with name------------------");
        TreeMap<Empl, String> nameSortedTreeMap = new TreeMap<>(nameComparator);
        add(nameSortedTreeMap);
        show(nameSortedTreeMap);

    }

    static void add(TreeMap<Empl, String> tMap) {
        tMap.put(new Empl("llll", 101), "String1");
        tMap.put(new Empl("bbbb", 102), "String2");
        tMap.put(new Empl("rrrr", 51), "String3");
        tMap.put(new Empl("mmmm", 21), "String4");
    }

    static void show(TreeMap<Empl, String> tMap) {
        tMap.entrySet().forEach(entry -> {
            Empl emplTemp = entry.getKey();
            System.out.println("Empl name: " + emplTemp.name);
            System.out.println("Empl name: " + emplTemp.salary);
            System.out.println("Value: " + entry.getValue());
        });
    }
}

class Empl {
    String name;
    int salary;

    Empl(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }
}
