package fundamentals;

import java.util.*;

public class CollectionsFramework {

    public static void hierarchyOverview() {
        System.out.println("=== COLLECTIONS FRAMEWORK HIERARCHY ===\n");

        System.out.println("Collection (Interface)");
        System.out.println("│");
        System.out.println("├── List (Interface) - Ordered, allows duplicates, indexed");
        System.out.println("│   ├── ArrayList - Fast random access, slow insert/delete");
        System.out.println("│   ├── LinkedList - Slow random access, fast insert/delete");
        System.out.println("│   └── Vector - Thread-safe ArrayList (old, avoid)");
        System.out.println("│");
        System.out.println("├── Set (Interface) - No duplicates, no order (usually)");
        System.out.println("│   ├── HashSet - Fast operations, no order");
        System.out.println("│   ├── LinkedHashSet - Maintains insertion order");
        System.out.println("│   └── TreeSet - Sorted order, slower");
        System.out.println("│");
        System.out.println("└── Queue (Interface) - FIFO ordering");
        System.out.println("    ├── PriorityQueue - Min heap by default");
        System.out.println("    ├── LinkedList - Can be used as Queue");
        System.out.println("    └── ArrayDeque - Double-ended queue");
        System.out.println();
        System.out.println("Map (Interface) - NOT part of Collection! Key-value pairs");
        System.out.println("├── HashMap - Fast, no order");
        System.out.println("├── LinkedHashMap - Maintains insertion order");
        System.out.println("└── TreeMap - Sorted by keys");
        System.out.println();
    }

    // ==========================================
    // ARRAYLIST - When to use
    // ==========================================
    public static void arrayListDeepDive() {
        System.out.println("\n=== ARRAYLIST DEEP DIVE ===\n");

        List<Integer> list = new ArrayList<>();

        // Adding elements - O(1) amortized
        list.add(10);  // Add to end
        list.add(20);
        list.add(30);
        list.add(1, 15);  // Add at index - O(n) - shifts elements!
        System.out.println("After adds: " + list);

        // Accessing - O(1) - VERY FAST!
        int element = list.get(2);  // Random access
        System.out.println("get(2): " + element);

        // Updating - O(1)
        list.set(1, 99);  // Replace element at index
        System.out.println("After set(1, 99): " + list);

        // Removing - O(n) - shifts elements!
        list.remove(1);  // Remove by index
        System.out.println("After remove(1): " + list);

        list.remove(Integer.valueOf(30));  // Remove by value
        System.out.println("After remove(30): " + list);

        // Searching - O(n)
        boolean contains = list.contains(10);
        int index = list.indexOf(10);
        System.out.println("Contains 10: " + contains);
        System.out.println("Index of 10: " + index);

        // Size
        System.out.println("Size: " + list.size());

        // Iterating
        System.out.print("Elements: ");
        for (int num : list) {
            System.out.print(num + " ");
        }
        System.out.println();

        // ==========================================
        // WHEN TO USE ARRAYLIST:
        // ==========================================
        System.out.println("\n✅ USE ArrayList when:");
        System.out.println("  - You need fast random access (get/set by index)");
        System.out.println("  - You mostly add/remove from the END");
        System.out.println("  - You don't frequently insert in the middle");
        System.out.println("  - This is the DEFAULT choice 90% of the time!");
    }

    // ==========================================
    // LINKEDLIST - When to use
    // ==========================================
    public static void linkedListDeepDive() {
        System.out.println("\n=== LINKEDLIST DEEP DIVE ===\n");

        LinkedList<Integer> list = new LinkedList<>();

        // Adding - O(1) at ends, O(n) in middle
        list.add(10);
        list.add(20);
        list.add(30);
        list.addFirst(5);   // Add at beginning - O(1)!
        list.addLast(40);   // Add at end - O(1)
        System.out.println("After adds: " + list);

        // Accessing - O(n) - SLOW! Must traverse
        int element = list.get(2);  // Has to traverse from head
        System.out.println("get(2): " + element);

        // First/Last access - O(1)
        System.out.println("getFirst(): " + list.getFirst());
        System.out.println("getLast(): " + list.getLast());

        // Removing from ends - O(1)
        list.removeFirst();
        list.removeLast();
        System.out.println("After removing first and last: " + list);

        // LinkedList as Queue
        list.offer(50);  // Add to end
        int head = list.poll();  // Remove from front
        System.out.println("Polled: " + head);
        System.out.println("After poll: " + list);

        // ==========================================
        // WHEN TO USE LINKEDLIST:
        // ==========================================
        System.out.println("\n✅ USE LinkedList when:");
        System.out.println("  - You frequently add/remove from BOTH ends");
        System.out.println("  - You need Queue/Deque operations");
        System.out.println("  - You DON'T need random access");
        System.out.println("  - Rarely used in practice - ArrayList is usually better!");
    }

    // ==========================================
    //⭐⭐ ARRAYLIST VS LINKEDLIST - Side by side
    // ==========================================
    public static void arrayListVsLinkedList() {
        System.out.println("\n=== ARRAYLIST VS LINKEDLIST COMPARISON ===\n");

        System.out.println("Operation          | ArrayList | LinkedList");
        System.out.println("-------------------|-----------|------------");
        System.out.println("get(index)         | O(1) ⚡   | O(n) 🐌");
        System.out.println("add(element)       | O(1)* ⚡  | O(1) ⚡");
        System.out.println("add(0, element)    | O(n) 🐌   | O(1) ⚡");
        System.out.println("remove(index)      | O(n) 🐌   | O(n) 🐌");
        System.out.println("removeFirst()      | O(n) 🐌   | O(1) ⚡");
        System.out.println("Memory overhead    | Low       | High (pointers)");
        System.out.println();
        System.out.println("*amortized - occasionally O(n) when resizing");
        System.out.println();
        System.out.println("🎯 DEFAULT CHOICE: ArrayList (unless you need Queue/Deque)");
    }

    // ==========================================
    // HASHSET - Fast, no order
    // ==========================================
    public static void hashSetDeepDive() {
        System.out.println("\n=== HASHSET DEEP DIVE ===\n");

        Set<String> set = new HashSet<>();

        // Adding - O(1) average
        set.add("banana");
        set.add("apple");
        set.add("cherry");
        set.add("apple");  // Duplicate - ignored!
        System.out.println("HashSet: " + set);  // Random order!

        // Contains - O(1) average - VERY FAST!
        System.out.println("Contains 'apple': " + set.contains("apple"));

        // Remove - O(1) average
        set.remove("banana");
        System.out.println("After remove: " + set);

        // Size
        System.out.println("Size: " + set.size());

        // Iterating (order not guaranteed!)
        for (String fruit : set) {
            System.out.println("  " + fruit);
        }

        System.out.println("\n✅ USE HashSet when:");
        System.out.println("  - You need FAST add/remove/contains (O(1))");
        System.out.println("  - You DON'T care about order");
        System.out.println("  - You want to remove duplicates");
        System.out.println("  - This is the DEFAULT Set choice!");
    }

    // ==========================================
    // TREESET - Sorted order
    // ==========================================
    public static void treeSetDeepDive() {
        System.out.println("\n=== TREESET DEEP DIVE ===\n");

        Set<Integer> set = new TreeSet<>();

        // Adding - O(log n)
        set.add(50);
        set.add(20);
        set.add(80);
        set.add(10);
        set.add(20);  // Duplicate - ignored!
        System.out.println("TreeSet: " + set);  // SORTED automatically!

        // Contains - O(log n)
        System.out.println("Contains 20: " + set.contains(20));

        // TreeSet specific methods
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(50);
        treeSet.add(20);
        treeSet.add(80);
        treeSet.add(10);
        treeSet.add(60);

        System.out.println("TreeSet: " + treeSet);
        System.out.println("first(): " + treeSet.first());  // Smallest
        System.out.println("last(): " + treeSet.last());    // Largest
        System.out.println("lower(50): " + treeSet.lower(50));  // Largest < 50
        System.out.println("higher(50): " + treeSet.higher(50));  // Smallest > 50
        System.out.println("floor(55): " + treeSet.floor(55));  // Largest <= 55
        System.out.println("ceiling(55): " + treeSet.ceiling(55));  // Smallest >= 55

        System.out.println("\n✅ USE TreeSet when:");
        System.out.println("  - You need elements in SORTED order");
        System.out.println("  - You need operations like first(), last(), floor(), ceiling()");
        System.out.println("  - You're okay with O(log n) instead of O(1)");
    }

    // ==========================================
    // LINKEDHASHSET - Insertion order
    // ==========================================
    public static void linkedHashSetDeepDive() {
        System.out.println("\n=== LINKEDHASHSET DEEP DIVE ===\n");

        Set<String> set = new LinkedHashSet<>();

        // Maintains insertion order!
        set.add("banana");
        set.add("apple");
        set.add("cherry");
        set.add("apple");  // Duplicate - ignored!
        System.out.println("LinkedHashSet: " + set);  // Same order as inserted!

        System.out.println("\n✅ USE LinkedHashSet when:");
        System.out.println("  - You need to maintain INSERTION ORDER");
        System.out.println("  - You want HashSet performance but predictable iteration");
        System.out.println("  - Rarely used - specific use cases only");
    }

    // ==========================================
    // ⭐⭐ SET COMPARISON
    // ==========================================
    public static void setComparison() {
        System.out.println("\n=== SET COMPARISON ===\n");

        System.out.println("Operation     | HashSet | TreeSet   | LinkedHashSet");
        System.out.println("--------------|---------|-----------|---------------");
        System.out.println("add()         | O(1) ⚡ | O(log n)  | O(1) ⚡");
        System.out.println("contains()    | O(1) ⚡ | O(log n)  | O(1) ⚡");
        System.out.println("remove()      | O(1) ⚡ | O(log n)  | O(1) ⚡");
        System.out.println("Ordering      | None    | Sorted    | Insertion");
        System.out.println("Use case      | Default | Need sort | Need order");
    }

    // ==========================================
    // HASHMAP - Fast, no order
    // ==========================================
    public static void hashMapDeepDive() {
        System.out.println("\n=== HASHMAP DEEP DIVE ===\n");

        Map<String, Integer> map = new HashMap<>();

        // Put - O(1) average
        map.put("Alice", 25);
        map.put("Bob", 30);
        map.put("Charlie", 35);
        map.put("Alice", 26);  // Overwrites old value!
        System.out.println("HashMap: " + map);

        // Get - O(1) average
        int age = map.get("Bob");
        System.out.println("Bob's age: " + age);

        // Get with default
        int unknown = map.getOrDefault("David", 0);
        System.out.println("David's age (default 0): " + unknown);

        // Check if key/value exists
        System.out.println("containsKey('Alice'): " + map.containsKey("Alice"));
        System.out.println("containsValue(30): " + map.containsValue(30));

        // Remove - O(1) average
        map.remove("Charlie");
        System.out.println("After remove: " + map);

        // Iterating over keys
        System.out.println("\nIterating over keys:");
        for (String key : map.keySet()) {
            System.out.println("  " + key + " -> " + map.get(key));
        }

        // Iterating over entries (BETTER!)
        System.out.println("\nIterating over entries:");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("  " + entry.getKey() + " -> " + entry.getValue());
        }

        // putIfAbsent - only puts if key doesn't exist
        map.putIfAbsent("Alice", 100);  // Won't change (Alice exists)
        map.putIfAbsent("David", 40);   // Will add (David doesn't exist)
        System.out.println("After putIfAbsent: " + map);

        // compute - update value based on key
        map.compute("Alice", (k, v) -> v + 1);  // Increment Alice's age
        System.out.println("After compute: " + map);

        // merge - useful for counting
        Map<String, Integer> wordCount = new HashMap<>();
        String[] words = {"apple", "banana", "apple", "cherry", "banana", "apple"};
        for (String word : words) {
            wordCount.merge(word, 1, Integer::sum);  // Add 1, sum if exists
        }
        System.out.println("Word count: " + wordCount);

        System.out.println("\n✅ USE HashMap when:");
        System.out.println("  - You need FAST key-value lookups");
        System.out.println("  - You DON'T care about order");
        System.out.println("  - This is the DEFAULT Map choice! (90% of the time)");
    }

    // ==========================================
    // TREEMAP - Sorted by keys
    // ==========================================
    public static void treeMapDeepDive() {
        System.out.println("\n=== TREEMAP DEEP DIVE ===\n");

        TreeMap<Integer, String> map = new TreeMap<>();

        // Put - O(log n)
        map.put(50, "Fifty");
        map.put(20, "Twenty");
        map.put(80, "Eighty");
        map.put(10, "Ten");
        System.out.println("TreeMap: " + map);  // SORTED by keys!

        // TreeMap specific methods
        System.out.println("firstKey(): " + map.firstKey());
        System.out.println("lastKey(): " + map.lastKey());
        System.out.println("lowerKey(50): " + map.lowerKey(50));
        System.out.println("higherKey(50): " + map.higherKey(50));

        // SubMap views
        System.out.println("headMap(50): " + map.headMap(50));  // Keys < 50
        System.out.println("tailMap(50): " + map.tailMap(50));  // Keys >= 50
        System.out.println("subMap(20, 80): " + map.subMap(20, 80));  // Keys in range

        System.out.println("\n✅ USE TreeMap when:");
        System.out.println("  - You need keys in SORTED order");
        System.out.println("  - You need range queries (headMap, tailMap, subMap)");
        System.out.println("  - You need first/last key operations");
    }

    // ==========================================
    // ⭐⭐ MAP COMPARISON
    // ==========================================
    public static void mapComparison() {
        System.out.println("\n=== MAP COMPARISON ===\n");

        System.out.println("Operation     | HashMap | TreeMap   | LinkedHashMap");
        System.out.println("--------------|---------|-----------|---------------");
        System.out.println("get(key)      | O(1) ⚡ | O(log n)  | O(1) ⚡");
        System.out.println("put(k,v)      | O(1) ⚡ | O(log n)  | O(1) ⚡");
        System.out.println("remove(key)   | O(1) ⚡ | O(log n)  | O(1) ⚡");
        System.out.println("Ordering      | None    | Sorted    | Insertion");
        System.out.println("Use case      | Default | Need sort | LRU cache");
    }

    public static void main(String[] args) {
        hierarchyOverview();

        // List implementations
        arrayListDeepDive();
        linkedListDeepDive();
        arrayListVsLinkedList();

        // Set implementations
        hashSetDeepDive();
        treeSetDeepDive();
        linkedHashSetDeepDive();
        setComparison();

        // Map implementations
        hashMapDeepDive();
        treeMapDeepDive();
        mapComparison();
    }
}
