/*
   Object that go into priority queue have to implement comparable.
   Priority Queue is Abstract Data Structure i.e. can be implemented by various Data-Structures, but because of time complexity PrioriyQueues are generally implemented using Heaps. (Max heaps or Min heaps)
   
   Library provided by programming languages generally provide Min-heap.
   To get Max-heap we can negate the compartor().
   If the items are number we can multiply them by '-1' when inserting and removing them from Min-heap, thus achiving a psudomaxheap.


   Types to Heaps:
        Binary Heap
        Fibonacci Heap
        Binomial Heap
        Pairing Heap

    For simplicity we are only going to learn Binary Heap(Binary heap is a binary ree that supports the heap invariant. In a binary tree every node has exactly two childern, children can be null.)
    A complete binary tree tree, is a tree in which every level, except possibly the last is completely filled and all the nodes are as far left as possible.
    
    Heaps are generally represented using arrays.
        Let i be the parent node index(zero based index)
        Left child index:  2i + 1
        Right child index: 2i + 2
-----------------------------------------------------------------------

    Adding Elements to Binary Heap

    using bubbling up technique --> insert at the last, and bubble up to the position until we meet heap invaiant.

    --------------------------------------------------------------------
    Removing elements from Binary Heap --> we generally want to remove from the leaf nodes of the heap

    poll() => removing the element at top
        We do this by sawapping with the 
Time: O(log(n))

    remove(element) => (i) perform the linear search to locate the node and (ii) swap with the last node to remove.
    Time compexity: O(n + log n) -> O(n)

> in remove(element) the complexity increases because of linear search to find the index of element.

    We can improve complexity of 'remove(element)' using HashTables --> get the complexity O(log n)
    * map every node to the index it is found at. when we want to remove a particular element just look up its index in HashTable using constant time.
Caveat: What if there are 2 or more nodes with the same value?
instead of mapping one value to one position, we will map one value to multiple positions. We can maintain a 'Set' or 'TreeSet' of indexes for which a perticular node value (key) maps to. 

 */
