# java.util.LinkedList

LinkedList class provides uniformly named methods to get, remove and insert element at the beginning and end of the list.
These operations allow linked-list to be used as a Stack, Queue or Doubly-Ended Queue

## Two Constructors

* LinkedList()
* LinkedList(Collecn c)

## How 'LinkedList' class is defined

```java
class LinkedList {

    Node first;

    class Node {
        Object value;
        Node next;

        Node(Object value) {
            this.value = value;
        }

        public boolean add(Object value) {
            Node n = new Node(value);
            n.next = first;
            first = n;
        }


    }
}
```

## Why use LinkedList?
To implement Data Structures like Stack, queues etc.