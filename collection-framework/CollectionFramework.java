/*
 * Collection is a group of of object, to be treated as a single unit.
 * 
 * Importance of Collections
 * 1. Common task on multiple objects.
 * 2. Detached RecordSet(link in JDBC where we bring lot of objects from DB and then change them & send then send them to DB in one go).
 * 3. Returning any number of values from single fn.
 * 4. Passing any number of arguments in one fm.
 * 5. Pooling: like ThreadPool and Collection Pool.
 * 6. Duplicate removing.
 * 7. Sorting.
 * 8. Searching.
 * 9. Updating.
 * 10. Serialization.
 * 11. Cloning.
 * 
 * 
 * Collection is based on abstraction i.e. interfaces
 * 
 * # Collection Framework:-
 * 
 *            |--> List
 * Collection |--> Map -> SortedMap -> NavigableMap
 *            |--> Set -> SortedSet -> NavigableSet
 *            |--> Queue -> Deque
 * 
 * Iterable(in 'lang' package, not part of collection framework)
 * 
 * 
 * 
 * -----------------------------------------------------------------------------------
 * Abstract Classes in Collection:      |        Concrete Classes
 * - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
 * 1. AbstractSequentialList            |        LinkedList
 * 2. Abstract List                     |        ArrayList | Vector -> Stack
 * 3. Abstract Set                      |        HashSet -> LinkedSet | TreeSet
 * 
 * 
 * 
 * 
 * ------------------------------------------------------------------------------------
 * java.util.Collection |-> HashSet, LinkedHashSet, SortedSet -> TreeSet
 *                      |-> ArrayList, Vector, LinkedList
 *                      |-> HashMap, LinkedHashMap, HashTable, SortedMap, TreeMap
 * 
 * -----------------------------------
 * Extra Interfaces:
 * 1. NavigableMap
 * 2. NavigableSet
 * 3. Iterator
 * 4. ListIterator
 * 5. Enumeration
 * 6. Comparator
 * 7. Comparable
 * - - - - - - - - - - - - - - - - - - - - - 
 * Extra Concrete Classes.
 * 1. Properties
 * 2. Collection
 * 3. Arrays
 * 4. ConcurrentHashMap
 * 5. CopyOnWriteArrayList
 * 6. CopyOnWriteArraySet
 * 7. WeakHashMap
 * 8. IdentityHashMap
 * 
 * 
 * ------------------------------------------------------------------------------------------------
 * 
 * A collection allows a group of objects to be treated as single unit. These objects can be stored,
 * retrieved and manipulated as elements of collections.
 * Some collections allow duplicates, others don't.
 * Some are ordered and others are unordered.
 * 
 * All general purpose collection implementing classes should proved 2 std. constructors-
 * (i) Default Constructor(no argument constructor):- Creates an empty collection.
 * (ii) A constructor with a single argument of type 'Collection' which creates a new collection with the same elements as its argument.
 * 
 * 
 * Collection Framework is provided in 'java.util' package & compromises of 2 main parts:- 
 * 
 * 1. The core interfaces that allow collectn to be manipulated independently of their implementation.
 * 2. A small number of implement that is concrete classes tat are specific implementation of core interfaces.
 * 
 * -----------------------------------------------------------------------------------------------------------
 * 
 * When to to which class
 * 
 * Interface                        Description                                                 Concrete Classes
 * - - - - - - - - - -          - - - - - - - - - - - - - - - - - - - - - - - -                 - - - - - - - -  - -
 * Collection                   A basic interface that defines                              | No concrete classes
 *                              normal operation                                                                                          |
 * 
 * 
 * Set                          Unique elements. no order. No duplicates                    | HashSet, LinkedHashSet
 *                              allowed                                                     |
 * 
 * 
 * SortedSet                    Unique elements and in sorted order                         | TreeSet
 * 
 * 
 * 
 * List                         Duplicate elements but in insertion order.                  | ArrayList, LinkedList, Vector
 * 
 * Map                          Unique keys, key to value mapping, every entry with         | HashMap, LinkedHashMap, HashTable
 *                              with unique identity                                        |
 * 
 * SortedMap                    Unique keys but in sorted order                             | TreeMap
 * 
 * 
 * 
 * -------------------------------------------------------------------------------------------------------------------
 * 
 * COLLECTION INTERFACE
 * Methods of Collection interface
 * 
 * 1. public boolean add(Object o)
 * 2. public boolean addAll(Collection c)
 * 3. public void clear() --> clear all elements
 * 4. public boolean contains(Object o) --> tells if object 'o' is in collection or not
 * 5. public boolean isEmpty() --> checks if collection is empty or not
 * 6. public Iterator iterator()
 * 7. public boolean remove(Object o) --> removes the object o 
 * 8. public boolean removeAll(Collection c) --> removes all elements in common with  collection 'c' passed in argument
 * 9. public int size() --> gives total number of elements
 * 10. public Object[] toArray() --> return elements of collection in object type array
 */         