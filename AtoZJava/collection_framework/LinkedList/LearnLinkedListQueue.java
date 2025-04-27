package collection_framework.LinkedList;

import java.util.LinkedList;
import java.util.Queue;


public class LearnLinkedListQueue {
//Since Queue is an interface,
//➡️ we need a class that implements Queue to actually create an object.
//
//Common classes:
//1. LinkedList
//2. PriorityQueue

    public static void main(String[] args) {
        Queue<Integer> que = new LinkedList<>();
//        you are saying:
//
//"Hey Java, I only care about the Queue behavior."
//
//Even though LinkedList is inside, you use it like a Queue.
//
//You can do:
//
//offer(), poll(), peek(), etc

        LinkedList<Integer> que1 = new LinkedList<>();
//        You can use both List and Queue behaviors because LinkedList implements both List and Queue interfaces.
//
//                You can do:
//
//        add(), remove(), get(index), etc. (List behavior)

//        offer(), poll(), peek(), etc. (Queue behavior)

        que.offer(12);
        que.offer(13);
        que.offer(14);
        que.offer(15);
        System.out.println(que); //[12, 13, 14, 15]

        System.out.println("popped element is: "+que.poll());
        System.out.println("Element to be popped next: "+que.peek());

    }
}
