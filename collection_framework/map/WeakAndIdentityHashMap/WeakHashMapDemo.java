package collection_framework.map.WeakAndIdentityHashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

public class WeakHashMapDemo {
    public static void main(String[] args) {
        Map<Temporary, String> hashMap = new HashMap<>();

        Map<Temporary, String> weakHashMap = new WeakHashMap<>();

        Temporary t1 = new Temporary();
        Temporary t2 = new Temporary();

        hashMap.put(t1, "sai");
        System.out.println("Before HashMap gets garbage collected: " + hashMap);

        t1 = null;
        System.gc();
        System.out.println("After HashMap key gets garbage collected: " + hashMap);

        weakHashMap.put(t2, "sai");
        System.out.println("Before WeakHashMap gets garbage collected: " + weakHashMap);

        t2 = null;
        System.gc();
        System.out.println("After weakHashMap key gets garbage collected: " + weakHashMap);

    }
}

class Temporary {

    @Override
    public String toString() {
        return "Temporary";
    }

    @Override
    public void finalize() {
        System.out.println("Finalize method called on : " + this.getClass().getName());
    }
}