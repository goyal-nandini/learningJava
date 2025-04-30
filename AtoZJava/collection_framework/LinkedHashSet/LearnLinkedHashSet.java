package collection_framework.LinkedHashSet;


import java.util.LinkedHashSet;
import java.util.Set;

public class LearnLinkedHashSet {
    public static void main(String[] args) {
        Set<Integer> set = new LinkedHashSet<>();
//        LinkedHashSet is a class in Java’s Collection Framework that:

//        Extends HashSet (more in imp_info)

//        Implements the Set interface

//        Preserves insertion order(means prints numbers in order as they are added)

        set.add(23);
        set.add(30);
        set.add(34);
        set.add(76);
        set.add(0);

        System.out.println(set);

        System.out.println(set.contains(100));

        System.out.println(set.isEmpty());

        System.out.println(set.size());

        set.clear();

        System.out.println(set);
    }
}
