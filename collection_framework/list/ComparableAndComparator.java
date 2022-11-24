package list;
/*
 * Only those objects whose class has implemented 'Comparable' can be sorted. Sorting without implmenting 'Comparable' will result in 'ClassCastException'
 * 
 * Comparable Interface(`compareTo()` to method): via comparable interface, you can have sorting only on 1 field of the object.
 * 
 * Comparator (Overcome the problem of repeatedly making changes to our class): via comparator interface, you can have a sorting on multiple feilds of an object.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class ComparableDemo {

    public static void main(String[] args) {
        ArrayList<Empl1> list1 = new ArrayList<>();
        list1.add(new Empl1("Ram", 3000));
        list1.add(new Empl1("John", 6000));
        list1.add(new Empl1("Krish", 7000));
        list1.add(new Empl1("Tron", 2400));

        Collections.sort(list1);

        list1.stream().forEach(e -> System.out.println(e.getSalary()));

        Empl1 e1 = Collections.max(list1);
        Empl1 e2 = Collections.min(list1);
        System.out.println(e1.salary);
        System.out.println(e2.salary);

    }
        
}

class Empl1 implements Comparable<Empl1> {
    String name;
    int salary;

    Empl1(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    int getSalary() {
        return salary;
    }

    public int compareTo(Empl1 e) {
        System.out.println("compareTo method called");
        if(this.salary > e.salary)
            return 1;
        else if(this.salary < e.salary)
            return -1;
        else
            return 0;
    }
}

/*----------------------------------------------------------------
 * COMPARATOR
 */

class ComparatorDemo {

    public static void main(String[] args) {
        ArrayList<Empl2> list1 = new ArrayList<>();
        list1.add(new Empl2("Ram", 3000));
        list1.add(new Empl2("John", 6000));
        list1.add(new Empl2("Krish", 7000));
        list1.add(new Empl2("Tron", 2400));

        // Collections.sort(list1, new MySalaryComp()); // use this and implement Comparator interface
        Collections.sort(list1, new Comparator<Empl2>() { // anonymous class
            public int compare(Empl2 e1, Empl2 e2) {
                int e1Salary = e1.getSalary();
                int e2Salary = e2.getSalary();

                if(e1Salary > e2Salary) return 1;
                else if (e1Salary == e2Salary) return 0;
                else return -1;
            } 
        });
        list1.stream().forEach(e -> System.out.println(e.getSalary()));

        Collections.sort(list1, new MyNameComp());
        Collections.sort(list1, (e1, e2) -> {
            System.out.println("hello");
            return e1.name.compareTo(e2.name);
        });
        list1.stream().forEach(e -> System.out.println(e.name));
    }
        
}

class MySalaryComp implements Comparator<Empl2> {

    public int compare(Empl2 e1, Empl2 e2) {
        int e1Salary = e1.getSalary();
        int e2Salary = e2.getSalary();

        if(e1Salary > e2Salary) return 1;
        else if (e1Salary == e2Salary) return 0;
        else return -1;
    }

    
}

class MyNameComp implements Comparator<Empl2> {

    public int compare(Empl2 e1, Empl2 e2) {
        return e1.name.compareTo(e2.name);
    }
}

class Empl2 {
    String name;
    int salary;

    Empl2(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    int getSalary() {
        return salary;
    }
}