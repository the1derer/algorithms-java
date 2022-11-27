# Navigable Map

The `java.util.NavigableMap` interface inherits `SortedMap` to add navigation methods that allow for key-value searching.

The `java.util.TreeMap` class implements `NavigableMap`.

* `ceilingKey()` Returns the least key greater than or equal to the given key

* The `pollFirstEntry()` method return and removes the "first" entry(key + value) in the `NavigableMap` or `null` if Map is empty.
  * "first" means smallest element according to the sort order of the keys.
* The `pollLastEntry()` method return and removes the "last" entry(key + value) in the `NavigableMap` or `null` if Map is empty.
  * "last" means largest key according to the sort order of the map.

* `firstEntry()` returns first entry without removing.
* `lastEntry()` returns last entry without removing.

* `firstKey()` returns first key without removing.
* `lastKey()` returns last key without removing.


TODO: Demo these methods
* `floorKey()`

* `higherEntry()`
* `lowerEntry()`