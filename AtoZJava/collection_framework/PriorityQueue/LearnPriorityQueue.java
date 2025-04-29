package collection_framework.PriorityQueue;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class LearnPriorityQueue {
    public static void main(String[] args) {
        Queue<Integer> pq = new PriorityQueue<>();

        // PriorityQueue<Integer> behaves like a "Min-Heap"
        pq.offer(34);
        pq.offer(04);
        pq.offer(76);
        pq.offer(-12);
        pq.offer(98);


        System.out.println(pq);

        // The smallest element (-12) is always at the top (peek()).
        //The rest of the elements are arranged to maintain the "heap
        // property", not sorted.
        System.out.println(pq.poll()); // poll() will always return the smallest one first (in a min-heap)
        System.out.println(pq.peek()); // it will show the element which has highest priority here, the min
        // element has highest priority. smaller number = higher priority.

        // for sorted order (don't u rem we did min heap and max heap insertion,
        // deletion black page rough nb sem 3 when dsa, a subject) ya i do rem properly!!
        while (!pq.isEmpty()){
            System.out.print(pq.poll()+" ");
        }

        System.out.println();

        // changing the default MIN HEAP to MAX HEAP:
        Queue<Integer> pq_max = new PriorityQueue<>(Comparator.reverseOrder());
        // This creates a PriorityQueue with a custom comparator that reverses the natural ordering.
        pq_max.offer(56);
        pq_max.offer(15);
        pq_max.offer(20);
        pq_max.offer(02);

        System.out.println(pq_max);
        System.out.println(pq_max.poll());
        System.out.println(pq_max.peek()); // it will show the max out of left elements in the queue


    }

}
