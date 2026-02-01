package StacksQueues;

import java.util.*;

public class nge_assignement {
    public static void main(String[] args) {

        int[] nums = {6, 0, 8, 1, 3};

        int[] result = nextGreaterElement(nums);

        System.out.println("Next Greater Elements:");
        for(int val : result) {
            System.out.print(val + " ");
        }
    }
    public static int[] nextGreaterElement(int[] nums) {
        // optimal:
        int n = nums.length;
        int[] nge = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i=n-1; i>=0; i--){

            while(!st.isEmpty() && st.peek() <= nums[i])
                st.pop();

            if(st.isEmpty()) nge[i] = -1;
            else nge[i] = st.peek();

            st.push(nums[i]);
        }
        return nge;
    }
}


