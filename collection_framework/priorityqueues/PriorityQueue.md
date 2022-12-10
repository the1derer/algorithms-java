# Priority Queue

**Object that go into priority queue have to implement comparable.**

* Priority Queue is Abstract Data Structure i.e. can be implemented by various Data-Structures.
* But because of time complexity Priority Queues are generally implemented using Heaps. (Max heaps or Min heaps)

---

## Heaps

A heap is a tree based DS that satisfies **heap invariant**(also called heap property) i.e. If 'A' is a parent node of 'B' then 'A' is ordered with respect to 'B' for all nodes A, B in the heap.

### Turning Min PQ to Max PQ

* Library provided by programming languages generally provide Min-heap.
  * To get Max-heap we can negate the comparator().
  * If the items are number we can multiply them by '-1' when inserting and removing them from Min-heap, thus achieving a pseudo-max-heap.

## Types to Heaps

* Binary Heap
* Fibonacci Heap
* Binomial Heap
* Pairing Heap
 ....

**NOTE:** For simplicity we are only going to use Binary Heap to implement PQ.

## Binary Heap

Binary heap is a binary tree that supports the heap invariant. In a binary tree every node has exactly two children, children can be null.

A **complete binary tree**, is a tree in which every level, except possibly the last is completely filled and all the nodes are as far left as possible.

Maintaining the complete binary tree is VVImp as it gives us an insertion point no matter what the heap looks likes or what values are in it.

## How to represent binary heaps

* Binary Heaps are generally represented using arrays
* Let `i` be the parent node index(zero based index)
  * Left child index:  `2i + 1`
  * Right child index: `2i + 2`

This is not the only way to represent heaps, we can also use objects and pointers and then recursively add and remove nodes as needed. But Array construction is very efficient.

---

## Adding Elements to Binary Heap

Using **bubbling(or swimming or shifting) up technique** -->
  i. Insert at the last(insertion) position
  ii. Then bubble up to the position until we meet heap invariant.

---

## Removing elements from Binary Heap

We generally want to remove from the leaf nodes of the heap

### Polling

* Removing element with lowest priority or root node.
* For Max-heap this will be largest element and in Min-heap this will be smallest element.
We do this by swapping with the last element and then **bubbling down**
Time: **O(log(n))**

### remove(element)

(i) perform the linear search to locate the node
(ii) swap with the last node to remove.
Time complexity: **O(n + log n) -> O(n)**

> in remove(element) the complexity increases because of linear search to find the index of element.

#### improving complexity of searching elements

We can improve complexity of 'remove(element)' using **HashTables** --> get the complexity O(log n)

* Map every node to the index it is found at. when we want to remove a particular element just look up its index in HashTable using constant time.

**Caveat:** What if there are 2 or more nodes with the same value?

Instead of mapping one value to one position, we will map one value to multiple positions. We can maintain a `Set` or `TreeSet` of indexes for which a particular node value (key) maps to.

Does it matter which node we remove in case of repeated value node?
Ans -> No.

## When and where is a PQ used?

* Certain implementations of Dijkstra's Shortest Path algorithm.
* Anytime you need the dynamically fetch the 'next best' or 'next worst' element.
* Huffman coding(which is often used for lossless data compression).
* **Best** First Search(BFS) algorithms such as A* use PQs to continuously grab the next most promising node.
* Minimum Spanning Tree(MST) algorithms.

## Complexity PQ with binary heap

* Binary Heap Construction   --> O(n)
* Polling                    --> O(log n)
* Peeking                    --> O(1)
* Adding                     --> O(log n)

* Naive Removing                              --> O(n)
* Advanced removing with help from hash table --> O(n) {adds a linear space complexity and also adds some overhead to binary heap implementation.}
* Naive Contains                              --> O(n)
* Contains check with help of a hash table    --> O(1)

**Note:** Don't use Iterators in PriorityQueues(in Java) to get sorted data as iterator won't maintain order.
