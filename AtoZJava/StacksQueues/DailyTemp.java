package StacksQueues;

import java.util.*;

public class DailyTemp {
    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>(); // stores indices

        for (int i = 0; i < n; i++) {
            // while current temp is warmer than the temp at stack top
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                answer[prevIndex] = i - prevIndex; // days waited
            }
            stack.push(i); // push current index
        }

        // remaining indices in stack have no warmer future day → answer[i] stays 0
        return answer;
    }

    public static void main(String[] args) {
        int[] t1 = {73,74,75,71,69,72,76,73};
        System.out.println(Arrays.toString(dailyTemperatures(t1)));
//        // Output: [1,1,4,2,1,1,0,0]
//
//        int[] t2 = {30,40,50,60};
//        System.out.println(Arrays.toString(dailyTemperatures(t2)));
//        // Output: [1,1,1,0]
//
//        int[] t3 = {30,60,90};
//        System.out.println(Arrays.toString(dailyTemperatures(t3)));
//        // Output: [1,1,0]
    }
}

