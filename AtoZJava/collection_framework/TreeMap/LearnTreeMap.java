package collection_framework.TreeMap;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class LearnTreeMap {
    // same as hashmap but the keys are in sorted order
    /* time complexity: important:
    | Feature      | `HashMap` (Average) | `HashMap` (Worst) | `TreeMap`     |
    | ------------ | ------------------- | ----------------- | ------------- |
    | Insert       | O(1)                | O(n)              | O(log n)      |
    | Search/Get   | O(1)                | O(n)              | O(log n)      |
    | Delete       | O(1)                | O(n)              | O(log n)      |
    | Sorted Order | ❌ No                | ❌ No              | ✅ Yes         |
    | Null Keys    | ✅ 1 allowed         |                   | ❌ Not allowed |

🔍 Which one should I use?
    | Use case                                                  | Choose      |
| ------------------------------------------                    | ----------- |
| Need fast access (insert, get, delete)                     | ✅ `HashMap` |
| Need sorted keys or range queries(means                 | ✅ `TreeMap` |
 Give me all keys (or entries) between a certain range)

*/
    public static void main(String[] args) {
        TreeMap<Integer, String> scores = new TreeMap<>();

        scores.put(50, "Fail");
        scores.put(60, "Pass");
        scores.put(70, "Good");
        scores.put(80, "Very Good");
        scores.put(90, "Excellent");

        // Get entries between 60 and 80
        SortedMap<Integer, String> range = scores.subMap(60, 90);  // 60 <= key < 90

/*The method subMap(...) returns a SortedMap, not a TreeMap directly.
It’s still backed by the original TreeMap, just represents a portion of it (a view).
So, range here is a SortedMap view of the original TreeMap within that range.*/

        System.out.println("Scores between 60 and 90:");
        for (Map.Entry<Integer, String> entry : range.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        /* TreeMap is built for range-based access, because it keeps keys sorted.
        You can use built-in methods like:
        | Method             | Description                                    |
        | ------------------ | ---------------------------------------------- |
        | `subMap(from, to)` | Get map entries **between two keys**           |
        | `headMap(to)`      | Get entries **less than** a key                |
        | `tailMap(from)`    | Get entries **greater than or equal to** a key |

        SortedMap is an interface in Java. It extends Map, and it guarantees that the keys are always sorted.
        TreeMap implements SortedMap
        TreeMap is a class.
        SortedMap is an interface.
        Both are related to sorted order of keys.
*/

    }
}
