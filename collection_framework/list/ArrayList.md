package collection_framework.list;

/*
 * ---------------------------------------------------
 * How ArrayList(or any other collecn) store object
 * 
 * class ArrayList {
 *      Object o[];
 * }
 * 
 * ArrayList() { 
 *      o = new Object[10]; // 10 is the default size
 * ...}
 * 
 * ArrayList(int capacity)
 * 
 * ArrayList(Collection c)
 * ----------------------------------------------------
 * 
 * Since all entries in ArrayList buffer has to be instance DM.
 * So here too when we 'add(Object o)' any element to arrayList, these entries are insert to 'Object o[]' array at class level.
 * Here this 'Object o[]' grows dynamically similar to StringBuffer.
 * 
 * Growing formula: NewCapacity = initialCapacity + (initialCapacity/2)
 * 
 * -----------------------------------------------------
 * ArrayList and Vector classes are implemented via a dynamically resizeable arrays.
 * ArrayLists are created with an initial size. When this size increases the collection is auto enlarged.
 * 
 * ------------------------------------------------------------------------------------------
 * IMPORTANT POINTS: ArrayList in MultiThreaded Environment
 * 
 * ## List l = Collections.synchronizedList(new ArrayList())
 *      |--> Thread t1
 *      |--> Thread t2
 *      |--> Thread t3
 * Here only one of the threads can access 'List l' at a time.
 * 
 * ## You can also use 'CopyOnWriteArrayList' class which wil prevent ConcurrentModificationExcepn by Iterator.
 * 
 * 
 * Theory:-
 * 1. ArrayList is not synchronized.
 * 2. ArrayList size can be dynamically increased or decreased.
 * 3. ArrayList are created with initial size of 10.
 * 4. Can contain duplicate elements.
 * 5. Maintains insertion order of the elements.
 * 6. When array gets full it creates another array and uses `System.arrCopy()` to copy elements from one array to another.
 * 
 * 
 * 7. 
 *    (i) ArrayList is synchronised collecn hence it is not suitable to be used b/w multiple threads concurrently.
 *    (ii) If you want to use ArrayList like a data-structure in multi-threaded environment, then you need to either use CopyOnWriteArrayList,
 *          or use Collections.synchronisedList() to create synced list.
 * 8. CopyOnWriteArrayList -> Part of Concurrent Collection pkg and much more scalable then Collections.sync..List(). But only useful when
 *                            there are many reader and only few writers. Since a new copy of ArrayList is created every time a write, happens
 *                            it can be overkill if used in write heavy environment.
 *    Second Option is a strictly synced collecn, much like Vector or HashTable, but its not scalable coz once the number  of thread increases drastically, contention becomes a real issue.
 * 
 * 9. CopyOnWriteArrayList is recommend for concurrent multi-threaded environment as it is optimized for multiple concurrent read and create copy for 
 * write operatns. Part of 'java.util.concurrent' pkgs along with ConcurrentHashMap.
 * 
 *
 * 
 * 
 * 10. Iterator and ListIterator of java ArrayList are fail-fat, it means if ArrayList is structurally modified at anytime after the Iterator is created in anyway except through the Iterator's own remove or add method, the iterator will throw a 'ConcurrentModificationExcpn'. This in face of concurrent modificatn , Iterator fails quickly and cleanly that's why it is called fail-fast.
 * 11. ConcurrentModificationExcptn is not guaranteed and is only thrown at best effort.
 * 12. If you are creating SynchronizedList(Map/Set) it is recommended to create while creating instance of underlying ArrayList(HashMap/HashSet) to prevent non-synced access to the list.
 * 
 * 13. An applicatn can increase the capacity of an ArrayList instance explicitly before adding a large no. of elements using the 'ensureCapacity()' operation. This may reduce the amt of incremental fillings of ArrayList.
 * 
 * 14. The size(), isEmpty(), get(), set(), iterator() and lisIterator() has runtime complexity of O(1) as ArrayList is based on Array. But adding or removing an element is costly as compared to LinkedList
 * 
 * 15. Always try to use ArrayList with generics to avoid ClassCastException.
 * 
 * 16. If we set ArrayList reference to null in Java, all the elements inside ArrayList becomes eligible to Garbage Collection in java, provided there is no strong ref exists for those objects.
 * 
 * 17. Always use isEmpty() method to check if List is empty or not, instead of using 'size==0' check.
 * 
 */