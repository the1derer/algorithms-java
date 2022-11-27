package collection_framework.list.arraylist;

import java.util.ArrayList;

public class ArrayListContainsMethod {
    public static void main(String[] args) {
        ArrayList<Emp> list = new ArrayList<>();

        Emp e2 = new Emp(1001);
        // list.add(new Emp(1001));

        list.add(new Emp(1002));
        list.add(new Emp(1003));
        list.add(new Emp(1004));
        list.add(new Emp(1005));
        list.add(new Emp(1001));

        System.out.println(list);

        for(Emp e : list) {
            System.out.println(e.id);
        }

        System.out.println("ArrayList contains the 1001: "+list.contains(e2));
    }
}

class Emp {
    int id;

    Emp(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        System.out.println("Check"); // will indicate how many time equals has been run
        Emp e = (Emp) o;
        
        return this.id == e.id;
    }
}
