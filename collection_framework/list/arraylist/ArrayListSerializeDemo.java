package collection_framework.list.arraylist;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

// using String ArrayList
class ArrayListSerializeStringDemo {

    public static void main(String[] args) {
        ArrayList<String> writeStringList = new ArrayList<>();
        writeStringList.addAll(Arrays.asList("Hello", "Hi!", "Howdy!!"));

        try {

            FileOutputStream fos = new FileOutputStream("myfile");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(writeStringList);
            fos.close();

            System.out.println("After Deserialization");
            
            FileInputStream fin = new FileInputStream("myfile");
            ObjectInputStream oin = new ObjectInputStream(fin);

            // TODO: See how to define and cast to generic based ArrayList while reading below
            ArrayList readStringList = (ArrayList)oin.readObject();

            System.out.println(readStringList);

        } catch(Exception ioe) {
            ioe.printStackTrace();
        }

    }
    
}

/*
 * This example uses custom class Emp for demo. We can use any class that implements Serializable
 */

class ArrayListSerializeCustomClassDemo {

    public static void main(String[] args) {
        ArrayList<SerializableEmp> empList = new ArrayList<SerializableEmp>();
        // empList.addAll(Arrays.asList(new Emp(10), new Emp(20), new Emp(30)));
        empList.add(new SerializableEmp(10));

        try {

            FileOutputStream fos = new FileOutputStream("myfile");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(empList);
            fos.close();

            System.out.println("After Deserialization");
            
            FileInputStream fin = new FileInputStream("myfile");
            ObjectInputStream oin = new ObjectInputStream(fin);

            // ArrayList<Emp> readList1 = (ArrayList<Emp>)oin.readObject(); // will give "Unchecked cast from Object to ArrayList<Emp>" warning
            ArrayList readList1 = (ArrayList)oin.readObject();

            Iterator<SerializableEmp> iterator = readList1.iterator();

            while(iterator.hasNext()) {
                // Emp e = iterator.next();
                // System.out.println(e.x);
                System.out.println(iterator.next().x);
            }
        } catch(Exception ioe) {
            ioe.printStackTrace();
        }

    }
    
}

class SerializableEmp implements Serializable {
    int x;
    SerializableEmp(int x) {
        this.x = x;
    }
}
