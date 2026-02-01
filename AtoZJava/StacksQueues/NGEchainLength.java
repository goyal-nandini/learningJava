package StacksQueues;

import java.util.*;

public class NGEchainLength {
    public static void main(String[] args) {
        int[] nums = {3, 4, 2, 7, 5, 8, 10, 6};   // You can change input here
        int[] indices = {0, 5};
        int[] res = count_NGE(nums, indices);

        System.out.println("Input array: " + Arrays.toString(nums));
        System.out.println("Next Greater Elements: " + Arrays.toString(res));
    }
    public static int[] count_NGE(int arr[], int indices[]) {
        // optimal time: 🔴📸
// 🚨 Your solution does NOT solve this problem.
// It solves NGE chain length, not count of greater elements to the right.
// We need:
// 📌 count of all values to the right which are greater than arr[i]

// This cannot be solved by normal NGE stack chaining.
// Correct approach options:

// A) Fenwick Tree (Binary Indexed Tree)
// B) Merge sort + count (like inversion count reversed) 🔎🖊️📝👆🧗
// C) Coordinate compression + BIT
// D) Segment Tree

// Time complexity target: O((n + q) log n)

        int n = arr.length;
        int m = indices.length;
        int[] ans = new int[m];
        Stack<Integer> st = new Stack<>(); // will be storing indexes
        int[] countNGE = new int[n]; // array to store count of NGE of all ele

        for(int i=n-1; i>=0; i--){
            // we are finding count of NGE for all ele in arr array
            while(!st.isEmpty() && arr[st.peek()] <= arr[i]){
                st.pop();
            }

            if(!st.isEmpty()){
                countNGE[i] = 1+countNGE[st.peek()];
            } else {
                countNGE[i] = 0;
            }
            st.push(i);
        }

        for(int i=0; i<n; i++){
            System.out.print(countNGE[i] + " ");
        }

        for(int i=0; i<m; i++){
            ans[i] = countNGE[indices[i]];
        }

        // for(int i=m-1; i>=0; i--){
        //     Stack<Integer> st = new Stack<>();
        //     for(int j=n-1; j>=indices[i]; j--){

        //         while(!st.isEmpty() && st.peek() <= arr[j]){
        //             st.pop();
        //         }
        //         ans[i] = st.size();

        //         // Try to build a monotonic decreasing stack from
        //         // right to left, but instead of storing only values,
        //         // store how many greater elements are reachable from each position.
        //         st.push(arr[j]);
        //     }
        //     // ans[i] = st.peek();

        // }
        return ans;
    }
}
