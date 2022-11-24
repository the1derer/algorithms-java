# Map Interface

Used when we add a object with a unique identity. It has a 'key' for each object.

* A map defines a mapping from keys to values.
* The key-value pair is called an entry.
* A Map doesn't allow duplicate keys that means keys are unique.
* Each key maps to one value, which is called single valued map.
* Both the keys & the values must be object.

---

## **A map is not a collecn and map interface doesn't extend the Collecn interface.**

---

## Some methods of map interface

1. `public Object put(Object key, Object value)` -> return the 'value', similar to 'add()'
2. `public Object remove(Object key)` -> removes the key-value pair Object
3. `public int size()` -> returns total no. of elements
4. `public Collection value()` -> returns all values of Map | Values can be duplicate
5. `public Set keySet()` -> returns 'Set' of keys | keys can be duplicate
6. `public Object get(Object key)` -> gives value for 'key'
7. `public boolean isEmpty()`
8. `public void clear()` -> clears whole Map
9. `public boolean containsKey(Object key)` -> checks if key is present or not
10. `public void putAll(Map m)` --> copies content of Map 'm' to 'this' map.
11. `public Set<Map.Entry<K, V>> entrySet()` -> gives a Set of all entries in form 'Entry' class object Set