# HashMap class

* uses 16-17 Hashing techniques to store key-value pair.

## Points of HashMap:-

---

* The class whose objects you want to add in HashMap as key, that class must override two methods of Object class.
  * `public int hashCode()`
  * `public boolean equals()`

---

1. HashMap class has one nested class with name 'Node'(changed from 'Entry' before JDK 1.8) which implemented a one interface 'Map.Entry' interface.
2. Map interface is also having one nested interface called Entry and this interface has got 3 methods:-
    * `public object getKey()`
    * `public Object getValue()`
    * `public int hashCode()`
3. Whenever we create the object of HashMap using default constructor than 1 Node class array will be created of size 16, which is known as capacity of HashMap
4. Each index of this array is called a bucket.
5. And each bucket is a LinkedList.
6. Whenever we add any key value pair in a HashMap class using the put method, the put method first converts this key value pair into the single object of an Node class and this 'Node' class object is going to be stored into the array of this class, which is defined in a HashMap class

## How an Entry class object is stored in a array?

Step-1: The HashCode of the key class Object Object is first calculator.
Step-2: Calculating the reminder of this hashcode by dividing it via total number of bucket or capacity.
Step-3:- This reminder is created as a index of bucket.
Step-4: Once the bucket is decided then the equals method is called on a key class object and then passes existing key class object into this method one by one.

If the key match is found than the 'Node' class object is not added into the bucket but value of the key will be replaced by new value, otherwise this Entry class object is added in a bucket as a first node of a linked list which is maintained by the bucket.

## Some important points on HashMap

1. The default size of an array is 16(always power of 2) and the load-factor is 0.75. Load FActor means whenever the size of the HashMap reaches to 75% of its current size i.e. 12, it will double its size by recomputing the hashcodes of existing elements.

2. Hence to avoid rehashing of the elements(as it degrades performance), it is the best practice to explicitly give the size of the HashMap while creating it. Never give the capacity too high and load-factor too low.

3. Since Java is multi-threaded it is very possible that >1 thread might be using the same HashMap and then they moth realize they need to resize the HashMap at the same time which leads to race condition.

**4. What is race condition w.r.t. HashMaps:-**
(a) When >=2 threads see the need for resizing the same HashMap, they might end up adding the elements of old bucket to the new bucket simultaneously.
    And hence, might lead to infinite loop.
    In case of Collision, i.e. when there are different keys with same HashCode, internally we use singly linked to store the elements.
    And we store every new element at the head of the linked list to avoid tail traversing and hence at time of resizing the entire sequece of object in linked list gets reversed, during which there are chances of infinite loop.
For example:
    lets assume there are 3 keys with same hashcode and hence stored in linkedlist inside a bucket[format is in : Object_Value(current_address , next_address)]:
    initial structure: 1(100, 200) -> 2(200, 300) -> (300, null)
    After resizing by thread-1
    3(300, 200) -> 2(200, 100) -> (100, null)
    When thread-2 starts resizing, it again starts with the 1st element by placing at the head:
    1(100, 300) -> 3(300, 200) -> 2(200, 100) ==> Which become a infinite loop for next insertion and thread hags there.

---

## Node (or Entry) class

HashMap has a static class named Node(Entry till JDK 1.7) tat implements Map.Entry interface.
This Node class looks like following:

```java
static class Node implements Map.Entry {
    final Object key;
    Object value;
    final int hash;
    Node next;

    Node(int i, Object key, Object value, Node entry) {
        this.key = key;
        this.value = value;
        this.next = entry;
        this.hash = i;

        .
        ..
    }
}
```

Every time we insert into HashMap using put() method, a new 'Node' object is created(not true in some cases. If key already exists, then it just replace the value). Map internally uses 2 data structures to manage/store data.

---

The HashMap class uses a HashTable to implement the Map interface. The HashMap is not threadsafe and permits one null key and null value. The Hashmap class is roughly equivalent to the HashTable except that it is unsynchronized and permits null. This class makes no guarantee as to the order of the map.

HashMap can be synchronized by using a method:

```java
Map m = Collecn.synchronizedMap(new HashMap())
```

### Constructors of HashMap:-

There are 4 types of constructors in HashMap as shown below:-

1. HashMap():
2. HashMap(Map m): It initialized the HashMap by using the elements of 'm'
3. HashMap(int capacity): It initializes the capacity of the HashMap to capacity. The default initial capacity of HashMap will be 16 and load-factor
will be 0.75. Load factor represents at what level HashMap should be doubled.
4. HashMap(int capacity, float loadFactor): Initialized both capacity and load factor by using its argument.

---

## Will Fiset Lecture Notes

Keys in the HashMap should be of Immutable, eg.--> String, int etc

### Time Complexity HashMap

   Operation    Average   Worst
   Insertion    O(1)        O(n)
   Removal      O(1)        O(n)
   Search       O(1)        O(n)

* The constant time behaviour attributed to hash tables is only true if you have a good 'uniform hash function'.

Hash Collision: When two keys have same hashCode()
   Methods to handle hash-collision:

   1. Separate chaining: Deals by maintaining a data structure(usually a linked list) to hod all the different values which hashed to a particular value. The data structure doesn't have to be linked-list, it can be one or a mixture of arrays, binary trees, self balancing trees and etc.

   2. Open address: Deals by finding another place within the hash table for the object to go by offsetting it from the position to which it hashed to.

**** Separate Chaining:
Question: How do I maintain O(1) insertion and lookup time complexity once my HT gets really full and I have long linked list chains?
Ans: Once the HT contains a lot of elements you should create a new HT with a larger capacity and rehash all the item inside the old HT and disperse them throughout the new HT at diff. locations.

Question: How do I 'remove' key-value pairs from my HT in separate chaining?
Ans: apply the same procedure as doing a lookup for a key, but this time instead of returning the value associated with the key remove the node in the linked list data structure.

Que: Can I use another DS to mode the bucket behaviour required for separate chaining?
Ans: Of course! You can use arrays, binary trees, self balancing trees etc. You can even go with a hybrid approach like Java's HashMap. However, note that some of these are much more memory intensive and complex to implement than a simple linked list which is why they may be less popular.

### Open addressing

Since we are not going to use separate DS like linked-list etc in separate-chaining, instead we store in the HashTable itself, we care a great deal about size of HashTable.
Load factor = (items in table) / (size of table)

For best result i.e. to have O(1) time keep load-factor < 0.8
For finding where to keep the data in case of hash-collision we use Probing fn P(x):
There are infinite amount of Probing sequence to choose from, below are some examples:
Linear Probing => P(x) = ax + b
Quadratic Probing => P(x) = ax^2 + bx + c
Double Hashing => P(k, x) = x*H2(k), where H2(k0) is a secondary hash fun.
Pseudo random number generator => P(k, x) = x*RNG(H(k), x), where 'RNG' is random number generator fn seeded with H(k).

General insertion method for open addressing on a table of side N goes as follows:
x := 1
keyHash := H(k)
index := keyHash
while table[index] != null : // means table index is occupied
    index = (keyHash + P(k, x)) mod N
    x = x+1
insert (k, v) at table[index]

Where H(k) is the hash for the key k and P(k, x) is the probing fn.

There is a danger of going into a circle even when using probing fn. This means our probing fn is not viable.
Que: So that's concerning, how do we handle probing fn which produce cycles shorter than the table size?
Ans: In general the consensus is that we don't handle this issue, instead we avoid it altogether by restricting our domain of probing fn to those which produce a cycle of exactly N. (There are a few exceptions with special properties that can produce shorter cycles.)

Linear Probing:
Que: Which value(s) of the constant 'a' in P(x) = ax produce a full cycle modulo N ?
Ans. When 'a' and 'n' are 'relatively prime' i.e. if their Greatest-Common-Denominator == 1.
Hence when GCD(a, N) = 1 the probing fn P(x) be able to generate complete cycle & we will always be able to find an empty bucket.

Quadratic Probing: P(x) = ax^2 + bx + c, where a != 0;
No cycle probing fn(most popular):

1) P(x) = x^2, keep table size Prime number > 3 and also keep load-factor > 1/2
2) P(x) = (x^2 + x)/2  and keep the table size a power of 2
3) P(x) = (-1^x) * x^2 and keep the table size a prime N where N is-congruent-to 3 mod 4 (eg. x =23, which is Prime and congruenct to 3 mod 4)

Double Hashing: // TODO: Revise again from William Fiset's lecture: <https://www.udemy.com/course/introduction-to-data-structures/learn/lecture/7283740#questions>
P(k,x) = x*H2(k), where H2(k) is a second hash fn.
NOTE: H2(k) must hash the same type os keys as H1(k)
    Note: Notice that doubling hashing reduce to linear probing(except tat the constant is unknown until runtime).
Since this reduces to linear probing at runtime, we may end up with a linear probing fn
