package collection_framework.set.treeset;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Stream;

public class TreeSetDemo {
    public static void main(String[] args) {
        TreeSet<String> treeSetEx = new TreeSet<>();

        System.out.println("Initial Size: " + treeSetEx.size());

        System.out.println(treeSetEx.size());
        treeSetEx.add("cccc");
        treeSetEx.add("cccc");
        treeSetEx.add("cccc");
        treeSetEx.add("cccc");

        Iterator<String> iterator = treeSetEx.iterator();

        while(iterator.hasNext()) {
            String str = iterator.next();
            System.out.println(str);
        }

        System.out.println("-------------subSet, tailSet, headSet----------");

        TreeSet<String> superSet = new TreeSet<>();

        Stream.of("RED", "ORANGE", "GREEN", "WHITE", "BLUE", "BROWN", "YELLOW", "BLACK").forEach(str -> superSet.add(str));

        System.out.println("SuperSet: " + superSet);

        Set<String> subSetRangeExclusive = superSet.subSet("GREEN", "WHITE"); // lower range will be inclusive
        System.out.println("subSet range exclusive: " + subSetRangeExclusive);

        Set<String> subSetRangeInclusive = superSet.subSet("GREEN", true, "WHITE", true);
        System.out.println("subSet range inclusive: " + subSetRangeInclusive);

        Set<String> tailSubSet = superSet.tailSet("GREEN"); // greater than or equals to
        System.out.println("tailSet: " + tailSubSet);

        Set<String> headSubSet = superSet.headSet("GREEN"); // less than, pass ane extra 'true' in args to be inclusive
        System.out.println("headSet: " + headSubSet);
    }
}

//---------------------------------------------------------------------------------------------------

class TreeSetCustomClassUsingComparableDemo {

    public static void main(String[] args) {
        TreeSet<Emp> empTreeSet = new TreeSet<>();

        System.out.println("Initial size: " + empTreeSet.size());

        empTreeSet.add(new Emp(1000));
        empTreeSet.add(new Emp(9000));
        empTreeSet.add(new Emp(5000));
        empTreeSet.add(new Emp(5000));

        Emp smallest = empTreeSet.first();
        Emp largest = empTreeSet.last();

        System.out.println("Least salary Emp: " + smallest.salary);
        System.out.println("Most salary Emp: " + largest.salary);

        System.out.println("Iterating the empTreeSet:");
        Iterator<Emp> iterator = empTreeSet.iterator();
        while(iterator.hasNext()) {
            Emp e = iterator.next();
            System.out.println(e.salary);
        }


    }

}

class Emp implements Comparable<Emp> {
    int salary;
    Emp(int salary) {
        this.salary = salary;
    }

    @Override
    public int compareTo(Emp comparingObject) { // we can change the order by changing compareTo
        return this.salary == comparingObject.salary ? 0 : (this.salary > comparingObject.salary ? 1 : -1);
    }
}

//----------------------------------------------------------------------------------------------------

class TreeSetCustomClassUsingComparatorDemo {
    public static void main(String[] args) {

        /* Use these if you are going to implement these via classes.
        Comparator<Empl> nameComp = new NameComp();
        Comparator<Empl> salaryComp = new SalaryComp();
         */

        /* Anon Class
        TreeSet<Empl> nameCompTreeSet = new TreeSet<>(new Comparator<Empl>() {
            @Override
            public int compare(Empl e1, Empl e2) {
                return e1.name.compareTo(e2.name);
            }
        });
        */
        System.out.println("--------Sorting with name----------");
        TreeSet<Empl> nameCompTreeSet = new TreeSet<>(
                (e1, e2) -> e1.name.compareTo(e2.name)
            );
        add(nameCompTreeSet);
        show(nameCompTreeSet);

        System.out.println("--------Sorting with salary----------");
        TreeSet<Empl> salaryCompTreeSet = new TreeSet<>(
                (e1, e2) -> e1.getSalary() == e2.getSalary() ? 0 : (e1.getSalary() > e2.getSalary() ? 1 : -1)
            );
        add(salaryCompTreeSet);
        show(salaryCompTreeSet);

        
    }

    static void add(TreeSet<Empl> treeSet) {
        treeSet.add(new Empl("Shubham", 101));
        treeSet.add(new Empl("Bhanu", 102));
        treeSet.add(new Empl("Yash", 51));
        treeSet.add(new Empl("Arpit", 21));
    }

    static void show(TreeSet<Empl> treeSet) {
        treeSet.forEach(e -> System.out.println(e.name + " = " + e.salary));
    }
}

class Empl {
    String name;
    int salary;

    Empl(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    int getSalary() {
        return salary;
    }
}

/*
 * NOTE: Don't need to implement Comparator if passing via lambda or anonymous class
 */
class NameComp implements Comparator<Empl> {

    @Override
    public int compare(Empl e1, Empl e2) {
        return e1.name.compareTo(e2.name);
    }
}

class SalaryComp implements Comparator<Empl> {

    @Override
    public int compare(Empl e1, Empl e2) {
        return e1.getSalary() == e2.getSalary() ? 0 : (e1.getSalary() > e2.getSalary() ? 1 : -1);
    }
}