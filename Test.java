public class Test {
    public void show() {
        show2();
    }

    public void show2() {
        System.out.println("hello");
    }

    public static void main(String[] args) {
        Test t = new Test();
        t.show();
    }
}

class Demo {
    public static void main(String[] args) {
        Test t = new Test();
        t.show();
    }
}
