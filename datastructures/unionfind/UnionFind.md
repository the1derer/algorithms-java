# Union Find or Disjoint Set

Union Find is a data structure that keeps track of elements which are split into >=1 disjoint sets.
It has 2 primary operations: **find** and **union**.

## When and where is UnionFind used?

* Kruskal's minimum spanning tree.
* Grid Percolation.
* Network connectivity.
* Least common ancestor in trees.
* Image processing.

## Complexity

```
Construction            ---> O(n)
Union:                  ---> ⍺(n)
Find:                   ---> ⍺(n)
Get component size:     ---> ⍺(n)
Check if connect        ---> ⍺(n)
Count components        ---> O(1)
```

⍺(n) ==> Amortized constant time

## Kruskal's Minimum Spanning tree Algorithm(MST)

### What is a minimum spanning tree

Given a graph G = (V,E) we want to find a Minimum Spanning Tree in the graph (it may not be unique).

* A minimum spanning tree is a subset of the edges which connect all vertices in the graph with minimum total edge cost.

### How to find MST

1. Sort edges by ascending edge weight
2. Walk through the sorted edges and look at the two nodes the edge belongs to, if the nodes are already unified we don't include this edge, otherwise we include it and unify the nodes.
3. The algorithm terminated when every edge has been processed or all the vertices has been unified.

## How Union Find works internally

(i) First construct a 'bijection'(a mapping) b/w your obj. and integers in range [0, n).

> We are going to maintain a HashMap for the mapping.

**NOTE:** this is step is not necessary in general, but it will allow us to construct an array based union find which is very efficient and easy to work with

(ii) Next we are going to construct an array to store Union Find info. Each index has an associated object we can lookup through our mapping.

### Find operation

To find which component a particular elements belongs to find the root of that component by following the parent nodes until a self loop is reached( a node who's parent is itself.)

### Union operation

To unify 2 elements find which are the root nodes of each component and if root nodes are different make one of the root nodes be the parent of the other

### Remarks

* We don't "un-union" elements. In general, this would be very inefficient to do since we would have to update all the children of  a node.
* The number of components is equal to the number of roots remaining. Also, remark that the number of root nodes never increases.

### Remarks (time complexity)

<!-- TODO: Find time complexity of the Union Find above version -->
Our current version of Union Find doesn't support the nice ⍺(n) time complexity we want.

## Path Compression ( To get time ⍺(n) complexity)
