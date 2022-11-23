/*
   Union Find or Disjoint Set

   Union Find is a data structure that keeps track of elements which are split into >=1 disjoint sets.
   It has 2 primary operations: 'find' and 'union'

   When and where is UnionFind used?
        Kruskal's minium spanning tree.
        Grid Percolation.
        Network connectivity.
        Least common ancestor in trees.
        Image processing.

  Complexity:
Consturction: O(n)
Union: Ammortised(n) or A(n)
Find: A(n)
Get componednent size: A(n)
Check if connect: A(n)
Count components: O(1)
        A(n) --> Anortized constant time



        Krushkal's Minimum Spanning tree
        1. Sort edges by ascending edge weight
        2. Walk through the sorted edges and look at the two nodes the edge belongs to, if the nodes are already unified we don't include this edge, otherwise we include it and unify the nodes.
        3. The algorithm terminated when every edge has been processed or all the vertices has been unifed.

    * Union and Find operation
    (i) using Union Find, first construct a 'bijection'(a mapping) b/w your obj. and int in rant [0, n). NOTE: this is step is not necessary in general, but it will allow us to construct an array based union find wich is very efficient and easy to work with.

    * Find opration : To find which component a particular elemtn belongs to find the root of that component by following the parent nodes unitl a self loop is reached( a node who's parent is itself.)
    * Union Operation: To unify 2 elements find which are the root nodes of each compnent and if root nodes are differnt make one of the root nodes be the parent of the other.

    * We don't "un-union" elements. In general, this would be very inefficient to do since we would have to update all the children of  a node.
    * The number of components is equal to the number of roots remaining. Also, remark that the number of root nodes never increases.




Path Compression
    
*/
public class UnionFind {

}
