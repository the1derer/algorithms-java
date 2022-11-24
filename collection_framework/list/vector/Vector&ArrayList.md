# Difference b/w ArrayList and Vector

## Synchronization :-
ArrayList is non-synced which means multiple threads can work on ArrayList at the same time. For eg. -> if one thread is performing an add opertn on 
ArrayList, there can be another thread performing remove operation on ArrayList at the same time in a multithreaded environment.
CopyOnWriteArrayList is thread-safe variant of ArrayList

While Vector is synced. This means if 1 thread is working on vector, no other thread can get hold of it. 
Unlike ArrayList only one thread can perform an opertn on Vector at a time.

## Resize:-
Array grow half of its size.
Vector grow double of its size and you can also define how much you want to grow.

## Performance:-
ArrayList gives better performance as it is non-synced.
Vector operations give poor performance as they are thread-safe, the thread which works on vector gets lock on it which make other threads wait till lock is released.

## Fail-Fast
If the collecn(ArrayList, vector etc) gets structurally modified by any means except the add() or remove() methods of iterator after creation of
Iterator, then, the Iterator will throw 'ConcurrentModificationException'. Structural modification refers to the addition or deletion of elements from the collection.
As per the Vector javadoc the 'Enumeration' returned by Vector is **not** fail-fast.
OTOH, the Iterator and ListIterator returned by ArrayList are fail-fast.

## Vector and Collecn-Framework
Vector was not part of Collecn Framework, it has been included later. It can be considered Legacy code.
There is nothing about vector which 'List' collecn can't do. Therefore Vector should be avoided. If there is need of thread-safe operatn
make ArrayList synchronised(using Collection.synchronizedList()) or use CopyOnWriteArrayList.


# Similarities b/w ArrayList and Vector

* Both are growable array Data structure.
* Iterator and ListIterator returned by both are fail-fast.
* They both are ordered collectn classes as they maintain the insertion order.
* Bth allow duplicates and null values.
* Both grow and shrink automatically when overflow and deletion happens.


# When to use ArrayList and when to use Vector

It totally depends on the requirements. If there is a need to perform thread-safe opertn the vector is your best bet. As it ensure that only one thread access the collecn at a time.
Performance :- Synced operation consume more time compared to non-synced ones. So, if there is no need for the thread-safe operatn, ArrayList is a better choice as performance will be improved becoz of concurrent processes.