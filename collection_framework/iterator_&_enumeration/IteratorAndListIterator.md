
# ITERATOR

A collecn provides an iterator which allows sequential access to the elements of a collection.

A collection can be obtained by calling following method of the collection interface.
Iterator itr = collection.iterator()

## Methods of Iterator interface

1. public boolean hasNext()
2. public Object next() :- moves the iterator to the next element and return the current element, throws 'NoSuchElementExcpn' if there is not a next element
3. public Object remove() :- remove the element that was returned by last call to the 'next()' method. Invoking this method results in 'AnIllegalStateException' if the 'next()' method has not yet been called.

Working of iterator() method:
Every class of collecn has nested class that implements Iterator interface

class ArrayList {
     public Iterator iterator() { return new MyIterator();}

     class MyIterator implements Iterator {...}
}

## Iterator only moves in one(forward) direction

-----------------------------------------------------------------------------------------------------

# LISTITERATOR

It is child interface of 'Iterator' interface of 'Iterator' interface, which allows a programmer to traverse a list in either direction and make modification to the underlying list

## Methods

### iterative methods --->

1. public boolean hasNext()
2. public boolean hasPrevious()
3. public Object next()
4. public Object previous()
5. public int nextIndex() :- return index of the next element in the list or size of the list if there are no more elements.
6. public int previousIndex() :- return index of the previous element in the list. If positioned at first element return '-1'

----

### Modification method of ListIterator

1. public boolean add(Object o) :- Insert the new object immediately before the element which would be returned by he next() method.
2. public Object remove()
3. public void set(Object o) :- replaces last element retrieved by next() or previous() method.

Que: Why is 'ListIterator iterator()' not given to 'Set'?
Ans: coz set doesn't have any order
 */
