/*
   Keys in the HashMap should be of Immutable, eg.--> String, int etc


   Time Compexity HashMap:
   Operation    Average   Worst
   Insertion    O(1)        O(n)
   Removal      O(1)        O(n)
   Search       O(1)        O(n)
 *The constant time behaviour attributed to hash tables is only true if you have a good 'uniform hash function'.


Hash Collision: When two keys have same hashCode()
   Methods to handle hash-colliosion:
   1. Separate chaining: Deals by maintaining a data structure(usually a linked list) to hod all the different values which hashed to a particular value. The data structure doesn't have to be linked-list, it can be one or a mixture of arrays, binary trees, self balancing trees and etc.


   2. Open address: Deals by finding another place within the hash table for the object to go by offsetting it from the position to which it hashed to.


**** Separate Chaining:
Question: How do I maintain O(1) insertion and lookup time complexity once my HT gets really full and I have long linked list chains?
Ans: Once the HT contains a lot of elements you should create a new HT with a larger capacity and rehash all the item inside the old HT and disperse them throughout the new HT at diff. locations.

Question: How do I 'remove' key-value pairs from my HT in separte chaining?
Ans: apply the same procudutre as doing a lookup for a key, but this time instead of returning the value associated with the key remove the node in the linked list data structure.

Que: Can I use another DS to mode the bucket behaviour required for separate chaining?
Ans: Of course! You can use arrays, binary trees, self balancing trees etc. You can even go with a hybrid approach like Java's HashMap. However, note that some of these are much more memory intensive and complex to implement than a simple linked list which is why they may be less popular.


*** Open addressing:
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
Ans: In general the consensus is that we don't handle this issue, instead we avoid it altogether by restricting our domain of probing fn to those which produce a cycle of exactly N. (Ther are a few exceptions with special properties that can produce shorter cycles.)


Linear Probing:
Que: Which value(s) of the constant 'a' in P(x) = ax produce a full cycle modulo N ?
Ans. When 'a' and 'n' are 'relatively prime' i.e. if their Greatest-Coomon-Denominator == 1.
Hence when GCD(a, N) = 1 the probing fn P(x) be able to generate complete cycle & we will always be able to find an empty bucket.

Quadratic Probing: P(x) = ax^2 + bx + c, where a != 0;
No cycle probing fn(most popular):
1) P(x) = x^2, keep table size Prime number > 3 and also keep load-factor > 1/2
2) P(x) = (x^2 + x)/2  and keep the table size a power of 2
3) P(x) = (-1^x) * x^2 and keep the table size a prime N where N is-congruent-to 3 mod 4 (eg. x =23, which is Prime and congruenct to 3 mod 4)

Double Hasing: // TODO: Revise again from William Fiset's lecture: https://www.udemy.com/course/introduction-to-data-structures/learn/lecture/7283740#questions
P(k,x) = x*H2(k), where H2(k) is a seconde hash fn.
NOTE: H2(k) must hash the same type os keys as H1(k)
    Note: Notice that doubling hashing reduce to linear probing(except tat the constant is unknown until runtime).
Since this reduces to linear probing at runtime, we may end up with a linear probing fn
 */
