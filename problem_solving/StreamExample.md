# Concepts

Integer ArrayList to int[]:-

```java
int[] arr = list.stream().mapToInt(i -> i).toArray();
```

---

Without if else return:-

```java
if(condition) return true;
else return false;

// this can be converted to
return condition;
// or
return !condition;

```

---

Stream of String, to perform various operations on each String

```java
// Get the stream
        Stream<String> stream = Stream.of("Geeks", "For",
                                          "GeeksForGeeks", "A",
                                          "Computer", "Portal");
  
        // Since the stream is not being consumed
        // this will not throw any exception
  
        // Print the stream
        stream.filter(s -> s.startsWith("G"))
            .peek(s -> System.out.println("Filtered value: " + s))
            .map(String::toUpperCase)
            .peek(s -> System.out.println("Uppercase value :" + s))
            .count();
```

---

List to index HashMap:-

```java
IntStream.range(0, alphabet.size())
         .boxed()
         .collect(toMap(alphabet::get, Function.identity()));
```

---

Array to index HashMap:-

```java
Map<Integer, Integer> map = IntStream.range(0, nums2.length)
                                        .boxed()
                                        .collect(Collectors.toMap(i -> nums2[i], i-> i));

//OR

IntStream.range(0, entries.length/2).map(i -> i*2)
        .collect(HashMap::new,
                 (m,i)->m.put(keyType.cast(entries[i]), valueType.cast(entries[i+1])),
                 Map::putAll);
```

---

String to frequency HashMap:-

```java
String s = "Hello"

Map<Character, Integer> = s.chars()
               .mapToObj(c->(char)c)
               .collect(Collectors.toMap());

Map<Character, Long> characterFrequency = string.chars()  // creates an IntStream
    .mapToObj(c -> (char) c) // converts the IntStream to Stream<Character>
    .collect(Collectors.groupingBy(c -> c, Collectors.counting())); // creates a
                                                                    // Map<Character, Long> 
                                                                    // where the Long is

Map<Character, Long> frequency =
            str.chars()
               .mapToObj(c -> (char)c)
               .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

                                                                    // the frequency

Map<Character,Integer> frequencies = new HashMap<>();
for (char ch : input.toCharArray()) 
   frequencies.put(ch, (frequencies.getOrDefault(ch, 0)) + 1);

If you want keys as integers:

Map<Character, Integer> frequency =
            str.chars()
               .mapToObj(c -> (char)c)
               .collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(c -> 1)));

Map<Character, Integer> frequency = 
            str.chars()
               .mapToObj(c -> (char)c)
               .collect(Collectors.toMap(Function.identity(), c -> 1, Math::addExact));
```

---

String to List of characters

```java
List<Character> = s.chars() // gives IntStream which we have to convert to 'char' below
           .mapToObj(c -> (char)c)
           .collect(Collectors.toList()); // converts to List
```

Using sort we get runtime of O(S+T) and space of O(1) ⇒ most interviewers consider sorting doesn’t take extra space

Sorting characters in String:-

```java
String sorted = inputstr
                    .chars()
                    .sorted()
                    .collect(
                      StringBuilder::new,
                      StringBuilder::appendCodePoint,
                      StringBuilder::append
                    )
                    .toString();
```

---

Sorting character array in reverse order:-

```java
Character tempArray[] = new Character[str.length()];
// use charAt(i) and add all string characters
Arrays.sort(tempArray, Collections.reverseOrder()); // `Arrays.sort(tempArray)` for regular sort
    StringBuilder sb = new StringBuilder(tempArray.length);
```

---

Using Comparator(anon class) to reverse the sorting order:-

```java
Character array[] = new Character[str.length()]; // can't use Comparator with primitive types

    for (int i = 0; i < str.length(); i++) {
      array[i] = str.charAt(i);
    }
    Arrays.sort(
      array,
      new Comparator<Character>() {
        // To compare characters
        @Override
        public int compare(Character c1, Character c2) {
          // Comparing characters using the inbuilt Character.compare() function
          return Character.compare(c2, c1);
        }
      }
    );
// Using StringBuilder to convert Character array to a String
    StringBuilder sb = new StringBuilder(array.length);

    // Copy the Character array to the StringBuilder object
    for (Character c : array) sb.append(c.charValue());
```
