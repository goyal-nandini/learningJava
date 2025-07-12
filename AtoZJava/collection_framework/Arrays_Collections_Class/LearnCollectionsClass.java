package collection_framework.Arrays_Collections_Class;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LearnCollectionsClass {
    public static void main(String[] args) {
                /*🔶 2. Collections Class
                ✅ What is it?
                A utility class in java.util package.
                Provides static methods to operate on Collection objects like List, Set, etc.
                Works with Collection Framework, not arrays.
                Common Methods:
                | Method                           | Description                |
                | -------------------------------- | -------------------------- |
                | `Collections.sort(list)`         | Sorts a `List`             |
                | `Collections.reverse(list)`      | Reverses the order of list |
                | `Collections.max(list)`          | Finds max element          |
                | `Collections.min(list)`          | Finds min element          |
                | `Collections.shuffle(list)`      | Randomly shuffles elements |
                | `Collections.frequency(list, x)` | Counts occurrences of `x`  |*/


        List<Integer> list = new ArrayList<>();
        list.add(34);
        list.add(12);
        list.add(9);
        list.add(9);
        list.add(9);
        list.add(76);
        list.add(29);
        list.add(75);

        System.out.println("min element " + Collections.min(list));
        System.out.println("max element " + Collections.max(list));
        System.out.println(Collections.frequency(list, 9));

        Collections.sort(list, Comparator.reverseOrder());

        System.out.println(list);

    }
}
