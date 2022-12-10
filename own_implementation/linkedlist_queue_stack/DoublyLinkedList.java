package own_implementation.linkedlist_queue_stack;
public class DoublyLinkedList<T>  implements Iterable<T> {
    
    private int size = 0;
    private Node<T> head = null;
    private Node<T> tail = null;

    // Internal Node class to represent data
    private static class Node<T> {
        private T data;
        private Node<T> prev, next;

        public Node(T data, Node<T> prev, Node<T> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

    // Empty this linked list, O(n)
    public void clear() {
        Node<T> trav = head;
        while(trav.next == null) {
            Node<T> next = trav.next;
            trav.next = trav.prev = null;
            trav.data = null;
            trav = next;
        }
        head = tail = trav = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void add(T elem) {
        addLast(elem);
    }

    public void addLast(T elem) {
        if(isEmpty()) {
            head = tail = new Node<T>(elem, null, null);
        } else {
            tail.next = new Node<T>(elem, tail, null);
            tail = tail.next;
        }
        size++;
    }

    public void addFirst(T data) {
        if(isEmpty()) {
            head = tail = new Node<T>(data, null, null);
        } else {
            head.prev = new Node<>(data,null, head);
            head = head.prev;
        }
        size++;
    }

    public void addAt(int index, T data) throws Exception {
        if(index < 0 || index > size) {
            throw new Exception("Illegal Index");
        }
        if(index == 0) {
            addFirst(data);
            return;
        }

        if(index == size) {
            addLast(data);
            return;
        }

        Node<T> temp = head;
        for(int i=0; i<index-1; i++) {
            temp = temp.next;
        }
        Node<T> newNode = new Node<T>(data, temp, temp.next);
        temp.next.prev = newNode;
        temp.next = newNode; // TODO: understand

        size++;
    }

    public T peekFirst() {
        if(isEmpty()) throw new RuntimeException("Empty list");
        return head.data;
    }

    public T peekLast() {
        if(isEmpty()) throw new RuntimeException("Empty list");
        return tail.data;
    }

    public T removeFirst() {
        if(isEmpty()) throw new RuntimeException("Empty list");

        T data = head.data;
        head = head.next;
        --size;

        if(isEmpty()) tail = null;

        // memory cleanup of the previous node
        else head.prev = null;

        return data;
    }

    public T removeLast() {
        if(isEmpty()) throw new RuntimeException("Empty list");

        T data = tail.data;
        tail = tail.prev;
        --size;
        
        if(isEmpty()) head = null;

        else tail.next = null;

        return data;
    }

    private T remove(Node<T> node) {
        if(node.prev == null) return removeFirst();
        if(node.next == null) return removeLast();


        node.next.prev = node.prev;
        node.prev.next = node.next;

        T data = node.data;

        node.data = null;
        node = node.prev = node.next = null;

        --size;

        return data;
    }

    // TODO: implement this
    public T removeAt(int index) {
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Index out of bounds");

        int i;
        Node<T> trav;

        if (index < size/2) {
        }

        return remove(trav);
    }

    public boolean remove(Object obj) {
        Node<T> trav = head;

        // Support searching for null
        if(obj == null) {
            for(trav = head; trav != null ; trav = trav.next) {
                if(trav.data == null) {
                    remove(trav);
                    return true;
                }
            }
            // search for non null object
        } else {
            for(trav = head; trav != null; trav = trav.next) {
                if(obj.equals(trav.data)) {
                    remove(trav);
                    return true;
                }
            }
        }
        return false;
    }

    public int indexOf(Object obj) {
        int index = 0;
        Node<T> trav = head;

        if(obj == null) {
            for(; trav != null; trav = trav.next, index++) {
                if(trav.data == null) {
                    return index;
                }
            }
        } else {

            for(; trav != null; trav = trav.next, index++) {
                if(obj.equals(trav.data)) {
                    return index;
                }
            }
        } 
        return -1;
    }

    @Override
    public java.util.Iterator<T> iterator() {
        return new java.util.Iterator<T>() {
            private Node<T> trav = head;

            @Override
            public boolean hasNext() {
                return trav != null;
            }

            @Override
            public T next() {
                T data = trav.data;
                trav = trav.next;
                return data;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<T> trav = head;

        while(trav!=null) {
            sb.append(trav.data);
            if(trav.next!=null) {
                sb.append(", ");
            }
            trav = trav.next;
        }
        sb.append("]");
        return sb.toString();
    }
}
