# TreeMap

* Implements 'NavigableMap' interface.
* Maintains a Red-Black Tree(a type of self-balancing BST).
* This implementation provides guaranteed log(n) time cost for the containsKey, get, put and remove operations.
* Algorithms are adaptations of those in Cormen, Leiserson, and Rivest's `Introduction to Algorithms`.


## Internal implementation

```java
class TreeMap {
    Entry root;
            |-> key, value, LEFT, RIGHT

    class Entry implements Map.Entry {
        Object k;
        Object v;
        Entry LEFT;
        Entry RIGHT;
    }

    public void put(k, v) {
        Entry e = new Entry(k, v);
        root = e;
    }
}
```

## NOTE:
* 'NavigableMap' extends 'SortedMap' interface.
* Class whose Object has to kept in 'Key' has to implement `Comparable` interface. Otherwise `ClassCastException`

---

# Entry class of TreeMap

```java
class TreeMap implement NavigableMap {
    private transient Entry<K, V> root;

    static final class Entry<K, V> implements Map.Entry<K, V> {
        K key;
        V value;
        Entry<K, V> left;
        Entry<K, V> right;
        Entry<K, V> parent;
    }
}

interface NavigableMap extends SortedMap {...}

interface SortedMap {
    SortedMap headMap(Object start);
    SortedMap subMap(Object start);
    SortedMap subMap(Object end);
    SortedMap tailMap(Object start);
}
```

## Constructor of TreeMap

1. TreeMap()
2. TreeMap(Comparator c)
3. TreeMap(Map m)
4. TreeMap(SortedMap sm)
