package collection_framework.ArrayDeque;

import java.util.ArrayDeque;

public class ArrayDequeWithStack {
    public static void main(String[] args) {
        ArrayDeque<Integer> aqds = new ArrayDeque<>();
        // it says ArrayDeque implements stack but ques how?
        // where push() pop() comes here in queue inteface!?

        // ✅ They are from the Deque interface, not Queue!
        //Deque = double-ended queue
        //It extends Queue, so ArrayDeque implements both.

        // ArrayDeque supports both queue and stack operations!

        // 👇
        // Queue interface: FIFO (offer, poll, peek)

        //Deque interface: adds LIFO support too (push, pop)

        //ArrayDeque: supports both because it implements Deque

        // 👇 ⭐
//        Stack Operation	        Method Used
//        Push (add to top)	        offerLast() or push()
//        Pop (remove from top)	    pollLast() or pop()
//        Peek (top element)	    peekLast()

    }
}
