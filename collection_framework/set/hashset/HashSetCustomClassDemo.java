package collection_framework.set.hashset;

import java.util.HashSet;

public class HashSetCustomClassDemo {
    public static void main(String[] args) {
        HashSet<Emp> customClassHashSet = new HashSet<>();

        System.out.println("Initial Size: " + customClassHashSet.size());

        customClassHashSet.add(new Emp(1002));
        customClassHashSet.add(new Emp(1003));
        customClassHashSet.add(new Emp(1002));
        customClassHashSet.add(new Emp(1004));
        customClassHashSet.add(new Emp(1001));

        System.out.println("Size after insertion: " + customClassHashSet.size());

        Emp removeKey = new Emp(1002);
        System.out.println("Does set contains key? " + customClassHashSet.contains(removeKey)); // no need to check in IRL as remove() already does this.
        customClassHashSet.remove(removeKey);

        System.out.println("--------after removing element---------");
        for(Emp e : customClassHashSet) {
            System.out.println(e.id); // or should @Override `toString() method in Emp class
        }

    }
}

class Emp {
    int id;
    Emp(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        System.out.println("executing equals");

        Emp e = (Emp)obj;
        return this.id == e.id;

    }

    @Override
    public int hashCode() {
        System.out.println("executing hashCode");
        return id * 10;
    }

    @Override
    public String toString() {
        return String.valueOf(this.id);
    }
}

//---------------------------------------------------------

class DistinctElementEx {
    public static void main(String[] args) {
        HashSet<Price> priceHashSet = new HashSet<>();
        priceHashSet.add(new Price("Banana", 20));
        priceHashSet.add(new Price("Apple", 20));
        priceHashSet.add(new Price("Orange", 30));

        priceHashSet.forEach(System.out::println);

        Price testKey = new Price("Banana", 20);

        System.out.println("Does set containsKey? " + priceHashSet.contains(testKey)); // you can see it calls hashCode and then Equals method

        System.out.println("Inserting duplicate object: " + priceHashSet.add(testKey)); // returns false if key is already there

        System.out.println("Deleting key from set: " + priceHashSet.remove(testKey));

        System.out.println("After all the changes: ---> ");
        priceHashSet.forEach(System.out::println);
    }
}

class Price {
    private String item;
    private int price;

    public Price(String item, int price) {
        this.item = item;
        this.price = price;
    }

    @Override
    public int hashCode() {
        System.out.println("Executing hashCode()");
        int hashCode = price * 20 + item.hashCode();
        return hashCode;
    }

    @Override
    public boolean equals(Object obj) {
        System.out.println("Executing equals()");
        if(obj == this)
            return true;
        
        if(obj instanceof Price) {
            Price compareObj = (Price) obj;
            return (compareObj.item.equals(this.item) && compareObj.price == this.price);
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Item: " + item + " ,Price: " + price;
    }
}
