package collection_framework;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

// i'll come back to this part in which we use comparator with priority queue
public class custom_comparator {
    public static class Pair {
        double first;
        int second;

        Pair(double first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static void MinimiseMaxDistance(int[] arr, int K) {
        // better:
        // use of priority queue and max heap
//        Queue<Pair> pq_max = new PriorityQueue<>(Comparator.reverseOrder());
//        why not this?? 🚩🚩 https://share.evernote.com/note/5c5fbe8b-336d-8e2a-a3fa-8b0be61512c2


        // 🚩🚩🚨🚨 evergreen notes https://share.evernote.com/note/e7ca81bb-dd43-c65a-3275-e1951267bcc9
        Queue<Pair> pq_max = new PriorityQueue<>((a, b) -> Double.compare(b.first, a.first));

    /* A PriorityQueue in Java by default is a min-heap. That means the smallest element comes out first.
    But you want a max-heap based on first (the double value in your Pair).

    (a, b) -> Double.compare(b.first, a.first)
🔹 This tells Java: compare b.first with a.first instead of a.first with b.first.
🔹 This reverses the order, making it a max-heap.

    Pair objects in this queue will now be ordered by first in descending order.*/
    }
}
