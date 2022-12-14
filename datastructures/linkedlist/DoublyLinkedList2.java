package datastructures.linkedlist;

import java.util.Iterator;

public class DoublyLinkedList2<T> implements Iterable<T> {
    private int size = 0;
    private Node<T> head;
    private Node<T> tail;

    private class Node<T> {
        T data;
        Node<T> next;
        Node<T> prev;

        Node(T data, Node<T> prev, Node<T> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }

    DoublyLinkedList2() {}

    DoublyLinkedList2(T value) {
        Node<T> newNode = new Node<>(value, null, null);
        head = tail = newNode;
        size++;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(T value) {
        if (isEmpty()) {
            head = tail = new Node<>(value, null, null);
        } else {
            head.prev = new Node<>(value, null, head);
            head = head.prev;
        }
        ++size;
    }

    public void addLast(T value) {
        if (isEmpty()) {
            head = tail = new Node<>(value, null, null);
        } else {
            tail.next = new Node<>(value, tail, null);
            tail = tail.next;
        }
        ++size;
    }

    public void add(T value) {
        addLast(value);
    }

    public void addAt(int index, T value) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException();
        Node<T> trav = head;
        int i = 0;
        while (i < index - 1) { // TODO: Pay important attention how to do this
            System.out.println("Trav is currently at: " + trav.data);
            trav = trav.next;
            i++;
        }
        // for (int i = 0; i < index - 1; i++) {
        // trav = trav.next;
        // }
        System.out.println("Trav before inserting: " + trav.data);
        Node<T> newNode = new Node<>(value, trav, trav.next);
        trav.next.prev = newNode; // missed this
        trav.next = newNode;

        ++size;
    }

    public T getFirst() {
        return head.data;
    }

    public T getLast() {
        return tail.data;
    }

    public T get(int index) { // not able to understand this
        Node<T> trav = head;
        for (int i = 0; i < index; i++) {
            trav = trav.next;
        }
        return trav.data;
    }

    // public T peekFirst() {
    // return last.value;
    // }

    // public T peekLast() {

    // }

    // public T pop() {
    // return removeFirst();
    // }

    // public void push(T value) {
    // addFirst(value);
    // }

    // public T remove() {}

    public T removeFirst() {
        T returnData = head.data;
        head.next.prev = null;
        head.next = null;

    }

    // public T removeLast() {

    // }

    // public boolean remove(Object obj) {

    // }

    // public void clear() {

    // }

    // public Iterator<T> iterator() {
    // return new Iterator<T>() {
    // @Override
    // public boolean hasNext() {

    // }

    // @Override
    // public T next() {

    // }
    // };
    // }

    @Override
    public String toString() {
        Node<T> trav = head;
        StringBuilder string = new StringBuilder();
        while (trav != null) {
            string.append(trav.data).append(", ");
            trav = trav.next;
        }
        return string.toString();

    }

    public static void main(String[] args) {

        DoublyLinkedList2<String> list = new DoublyLinkedList2<>();
        list.add("Hello0");
        list.add("Hello1");
        list.add("Hello2");
        list.add("Hello3");
        list.add("Hello4");

        System.out.println(list);

        list.addAt(2, "NewHello");

        System.out.println(list);
        System.out.println(list.get(3));

    }
}
