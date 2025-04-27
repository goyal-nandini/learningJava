package collection_framework.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LearnStack {
    public static void main(String[] args) {

        Stack<Integer> num = new Stack<>();

        List<Integer> num1 = new Stack<>(); // works, but we can't use push() pop() peek()
        // only list methods
        num.push(10);
        num.push(11);
        num.push(12);
        num.push(13);

        System.out.println(num);

        System.out.println(num.peek());

        System.out.println("number popped: "+num.pop());

        System.out.println(num.peek());

        System.out.println(num);
    }

}
