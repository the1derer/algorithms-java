# Set Interface

'Set' don't follow any data structure coz internally it makes the instance(object) of corresponding 'Map' class.

Eg.

```java
public HashSet() {
    Map map = new HashMap<>();
    ...
}
```


## HashSet

* HashSet creates an instance of HashMap when HashSet is instantiated. TreeSet creates an instance of TreeMap when TreeSet is instance of TreeMap when TreeSet is instantiated and so on. The
* The keys in the map are the elements you add to the set.
* **Then what are the values?**
  * Values are dummy objects.
  * When you add an element to the set, the element will be added as key and `new Object()`(dummy object instance) will be added as value, which is dummy value.
* **What will happen if you add duplicate object to Set?**
    If the set already contains the element, the call to add method leaves the set unchanged and returns `false`.
    If the set doesn't contain the element, the call to add method adds the element adn returns `true`.

HashSet is backed by a HashMap instance and hence it **allows the null element**. It makes no guarantee to the iteration order of the set; in particular, it doesn't guarantee the order will remain same over time.

### When to use HashSet

* Looking for performance. Since this class uses hash fn when retrieving the element, it allows O(1) time for add, remove, contains and size. Assuming the hash fn disperses the elements properly among the buckets.
* Iterating over this set requires time proportional to the sum of HashSet instance's size(the number of elements) + the 'capacity' of 'backing' HashMap instance(the number of buckets).
* Thus it is very important, **not to set the initial capacity too high (or the load-factor too low)** if iteration performance is important.



## LinkedHashSet:-

* LinkedHashSet is backed by LinkedHashMap.
* Internal workings:
  * So, all the elements in LinkedHashSet are actually the keys in the LinkedHashMap. It maintains a doubly linkedlist running through all of its entries
  * This linked list defines the iteration ordering, which is the order in which elements were inserted into the set(insertion-order).
  * This class provides the all the options.
* LinkedHashSet **allows null** elements.

## TreeSet

* TreeSet is backed by TreeMap instance and TreeSet **won't permit `null`** elements.
* As opposed to HashSet, TreeSet provides a total ordering of its elements and especially when you need a sorted order.
* The elements are ordered either by using their plain `Comparable` natural ordering(if you don't pass any parameter for the TreeSet constructor) or by a `Comparator` typically provided at SortedSet creation time as a parameter to constructor.
* All the elements inserted into this set must either implement the Comparable interface or atleast be accepted by the specified Comparator.
* So all such elements must be mutually comparable i.e. `e1.compareTo(e2)` (or `Comparator.compare(e1, e2)`) must not throw a `ClassCastException`.

* class TreeSet implements NavigableSet interface

* NavigableSet interface extends SortedSet interface

Methods of SortedSet interface:-

```java
public SortedSet headSet(Object start)
public SortedSet headSet(Object start, Object end)
public SortedSet headSet(Object end)
```
