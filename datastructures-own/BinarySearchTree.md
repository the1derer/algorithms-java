/*
   A tree is an undirected graph which satisfies any of the following definitions:
   * An acyclic connected graph
   * A connect graph with N nodes and N-1 edges
   * A graph in which any 2 vertices are connected by exactly one path.

   Binary tree:- A tree in which every node has at most 2 child nodes.

   Binary Search Tree: A binary tree that satisfies the BST invariant i.e. let subree has the smaller element and right subtree has larger elements.

   Use of Binary Search trees:
   * Implementation of some maps and set 
   * Red Black Trees
   * AVL Trees
   * Splay Trees
   * etc...

   * Used in the implementation of binary heaps
   * Syntax trees (used by compiler and calculators)
   * Treap - a probabilistic DS (uses a randomised BST )

   Operation    Average   Worse
   Insert       O(log n)    O(n)
   Delete       O(log n)    O(n)
   Remove       O(log n)    O(n)
   Search       O(log n)    O(n)


   Adding elements to BST
    * Elmemts must be 'comparable' so that we can can order them inside tree
    * when inserting compare it value to the value stored in the current node we're considering to decide on one of the following:
    4 case:
        Recurse down left subree (< case)
        Recurse down right subtree (> case)
        Handle finding a duplicate value (= case)
        Create  new node (found a null leaf)
 */
public class BinarySearchTree {

}
