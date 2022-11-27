# WeakHashMap and IdentityHashMap

## Similarities b/w HashMap and IdentityHashMap
1. Though both HashMap and IdentityHashMap implements Map interface
2. have fail-fast iterator 
3. Are non-synchronised collecn

## Differences b/w HashMap and IdentityHashMap
1. Main differences b/w HashMap v/s IdentityHashMap is that IdentityHashMap uses equality operator "==" for comparing keys and values inside Map while HashMap uses 'equals()' method for comparing keys and values.
2. Unlike HashMap, which uses 'hashcode()' to find bucket location, IdentityHashMap don't uses 'hashcode()' instead it uses 'System.identityHashCode(Object)'
3. Another key difference b/w IdentityHashMap and HashMap in Java is speed. Since, IdentityHashMap doesn't uses 'equals()', its comparatively faster than HashCode for object with expensive equals() and hashcode()
4. One more difference b/w HashMap & IdentityHashMap is immutability of key. One of the basic requirements to safely store objects in HashMap is keys need to be immutable, IdentityHashMap doesn't require keys to be immutable as it is not relied on equals() and hashcode().

There is also a class called IdentityHashTable which is analogous to HashTable in Java but its not part of standard JDK and available in com.sun.... package.

## HashMap and WeakHashMap
WeakHashMap is exactly same as HashMap except the below differences:

* HashMap object is not eligible for garbage collecn. even though it doesn't have any external reference if it associated with HashMap.
* Keys of WeakHashMap have weak reference i.e. the key is garbage collected and then entry in WeakHashMap object will be deleted automaticaly. This is not the case in HashMap.
