package collection_framework.TreeSet;


import java.util.Set;
import java.util.TreeSet;

public class LearnTreeSet {
    public static void main(String[] args) {
        Set<Integer> set = new TreeSet<>();
        set.add(23);
        set.add(30);
        set.add(34);
        set.add(76);
        set.add(0);

        System.out.println(set); // sorted order

        System.out.println(set.contains(100));

        System.out.println(set.isEmpty());

        System.out.println(set.size());

        set.clear();

        System.out.println(set);
    }
}
