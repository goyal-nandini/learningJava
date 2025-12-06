package StacksQueues;

import java.util.Arrays;
import java.util.Stack;

class Pair {
    int val, indx;

    Pair(int v, int i) {
        val = v;
        indx = i;
    }
}
public class NGEII_2 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 1};   // You can change input here
        int[] res = ngeII(nums);

        System.out.println("Input array: " + Arrays.toString(nums));
        System.out.println("Next Greater Elements: " + Arrays.toString(res));
    }

    public static int[] ngeII(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        Pair[] arr = new Pair[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Pair(nums[i], i);
        }

        int maxi = Integer.MIN_VALUE;
        for (int x : nums) {
            maxi = Math.max(maxi, x);
        }

        while (arr[n - 1].val != maxi) {
//          rotateByOne(arr);
            rotateBynMinus1(arr, n-1);
        }


        Stack<Pair> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek().val <= arr[i].val) {
                st.pop();
            }

            int next = st.isEmpty() ? -1 : st.peek().val;
            ans[arr[i].indx] = next;
            st.push(arr[i]);
        }
        return ans;
    }

    public static void rotateByOne(Pair[] arr) {
        int n = arr.length;
        Pair temp = arr[0];
        for (int i = 1; i < n; i++) {
            arr[i - 1] = arr[i];
        }
        arr[n - 1] = temp;
    }

    public static void rotateBynMinus1(Pair[]  arr, int d){
        // 1. say we have [1 2 3 4 5 6 7] and d=3
        // rotating a pair now :)
        int n=arr.length;
        Pair temp[] = new Pair[d];
        for(int i=0; i<d; i++)
            temp[i] = arr[i];

        for(int i=d; i<n; i++) // shifting
            arr[i-d] = arr[i];

        int j=0;
        for(int i=n-d; i<n; i++) {
            arr[i] = temp[j];
            j++;
        }
    }
}
