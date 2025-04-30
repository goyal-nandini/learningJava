package collection_framework.HashSet;

import java.util.HashSet;
import java.util.Set;

public class LearnHashSet {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.add(23);
        set.add(30);
        set.add(34);
        set.add(76);
        set.add(0);

        System.out.println(set);
        // In a HashSet, the order in which elements are added is not preserved when
        // you retrieve or print them. This is because HashSet is backed by a hash
        // table, and the hashing mechanism stores elements based on their "hash codes",
        // not on their insertion order.

        System.out.println(set.contains(100));

        System.out.println(set.isEmpty());

        System.out.println(set.size());

        set.clear();
        // the clear() method is often used in test cases, especially when you want
        // to reset a HashSet (or any collection) to an empty state before the next
        // part of the test.
        System.out.println(set);
    }
}
// ✅ If You Need Ordered Output:
//Use:
//
//LinkedHashSet – maintains insertion order.
//
//TreeSet – maintains elements in sorted (natural) order.
