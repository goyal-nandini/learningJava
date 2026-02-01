package fundamentals;


import java.util.*;

/* ⭐⭐Remember this pattern?
List<Integer> list = new ArrayList<>();

Now you know WHY! List is an interface, ArrayList is the implementation - same as Vehicle and Car!
 List is an INTERFACE (the contract)
 ArrayList is a CLASS (the implementation)
*/
public class RealJavaInterfaces {
    public static void main(String[] args) {
        // 1. list interface:

        List<Integer> list1 = new ArrayList<>(); // using arraylist
        List<Integer> list2 = new LinkedList<>(); // using linkedlist

        // Both implement List interface, so both have same methods:
        list1.add(10);
        list1.add(20);
        list1.add(30);

        list2.add(100);
        list2.add(200);
        list2.add(300);

        System.out.println("ArrayList: " + list1);
        System.out.println("LinkedList: " + list2);

        // I can pass BOTH to same method!
        printList(list1);
        printList(list2);

        // 2. Set interface

        Set<String> set1 = new HashSet<>();    // Unordered, fast
        Set<String> set2 = new TreeSet<>();    // Sorted, slower

        // Add same elements to both
        set1.add("banana");
        set1.add("apple");
        set1.add("cherry");

        set2.add("banana");
        set2.add("apple");
        set2.add("cherry");

        System.out.println("HashSet (unordered): " + set1);
        System.out.println("TreeSet (sorted): " + set2);

        // Same method works for both!
        printSet(set1);
        printSet(set2);

        // 3. Map interface

        Map<String, Integer> map1 = new HashMap<>();     // Unordered
        Map<String, Integer> map2 = new TreeMap<>();     // Sorted by keys

        map1.put("Alice", 25);
        map1.put("Bob", 30);
        map1.put("Charlie", 35);

        map2.put("Alice", 25);
        map2.put("Bob", 30);
        map2.put("Charlie", 35);

        System.out.println("HashMap: " + map1);
        System.out.println("TreeMap: " + map2);

        printMap(map1);
        printMap(map2);
    }
    // Works with ANY List implementation!
    public static void printList(List<Integer> list) {
        System.out.println("Printing list: " + list);
    }

    // Works with ANY Set implementation!
    public static void printSet(Set<String> set) {
        System.out.println("Printing set: " + set);
    }

    // Works with ANY Map implementation!
    public static void printMap(Map<String, Integer> map) {
        System.out.println("Printing map: " + map);
    }
/*
## **Type this code and run it!**

 ---

 ## **What you'll observe:**

 1. **HashSet vs TreeSet:**
 - HashSet: Elements in random order
 - TreeSet: Elements sorted alphabetically

 2. **HashMap vs TreeMap:**
 - HashMap: Keys in random order
 - TreeMap: Keys sorted alphabetically

 3. **Same methods work for different implementations!**

 ---

 ## **The Interface Hierarchy (IMPORTANT!):**
```
Collection (interface)
    ├── List (interface)
    │   ├── ArrayList (class)
    │   ├── LinkedList (class)
    │   └── Vector (class - old, don't use)
    │
    ├── Set (interface)
    │   ├── HashSet (class)
    │   ├── TreeSet (class)
    │   └── LinkedHashSet (class)
    │
    └── Queue (interface)
        ├── PriorityQueue (class)
        └── LinkedList (class) - yes, it implements both List and Queue!

Map (interface) - NOT part of Collection! **REASON::!!??
    ├── HashMap (class)
    ├── TreeMap (class)
    └── LinkedHashMap (class)

**THE  Reason:
Collection interface is for SINGLE elements.
Map stores KEY-VALUE PAIRS, not single elements!

WHY separate?

Collection has methods like add(element) - for single elements
Map has methods like put(key, value) - for pairs
Fundamentally different structures!
 */
}
