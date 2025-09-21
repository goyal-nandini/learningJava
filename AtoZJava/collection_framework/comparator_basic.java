package collection_framework;

// taking from telusko...its amazing to learn from him...

import java.util.*;

// task is to sort on the basis of last digits only...
// so we use COMPARATORS to customise the sort method
public class comparator_basic {
    public static void main(String[] args) {

        // comparator is an interface which is implemented in two ways:
        // 1️⃣ through classes and 2️⃣ through anonymous class
// u can built your own logic for sorting

        // 1️⃣ here, it is through anonymous class

        // 1.
//        Comparator<Integer> com = new Comparator<Integer>() {
//            public int compare(Integer i, Integer j) { // 🚩🚩
//                if (i % 10 > j % 10) // %10 for getting last digit
//                    return 1; // swap
//                else
//                    return -1;
//            }
//        };

        // ORRR
        Comparator<Integer> com = (i, j) -> (i % 10) - (j % 10);

        List<Integer> nums = new ArrayList<>();


        nums.add(43);
        nums.add(31);
        nums.add(72);
        nums.add(29);

        Collections.sort(nums, com); // 🚩🚩

        System.out.println(nums);

        // 2.
        List<String> list = Arrays.asList("Banana", "Apple", "Cherry");

        Collections.sort(list, new Comparator<String>() {
            public int compare(String s1, String s2) {
                return s2.compareTo(s1); // reverse alphabetical order
            }
        });

        System.out.println(list);

//        👉 Since Java 8, we also use lambdas (shorter form of anonymous class):

        Collections.sort(list, (s1, s2) -> s1.compareTo(s2));
    }
}
