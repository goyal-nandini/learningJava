package StacksQueues;

import java.util.*;

public class assignment_que2 {
    public static String firstNonRepeatingPrefix(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        Queue<Character> q = new LinkedList<>();
        StringBuilder result = new StringBuilder();

        for (char c : s.toCharArray()) {
            // update frequency
            freq.put(c, freq.getOrDefault(c, 0) + 1);
            // add to queue
            q.add(c);

            // remove from front while not unique
            while (!q.isEmpty() && freq.get(q.peek()) > 1) {
                q.poll();
            }

            // append answer for this prefix
            if (!q.isEmpty()) {
                result.append(q.peek());
            } else {
                result.append('#');
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(firstNonRepeatingPrefix("aabc"));   // Output: a#bb
        System.out.println(firstNonRepeatingPrefix("bb"));     // Output: b#
        System.out.println(firstNonRepeatingPrefix("abcabc")); // Output: aabc#
    }
}

