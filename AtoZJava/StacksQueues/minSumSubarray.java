package StacksQueues;

import java.util.Stack;

public class minSumSubarray {
    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 4};
        System.out.println(sumSubarrayMins(arr));
    }
    public static int sumSubarrayMins(int[] arr) {
        // optimal time:
//        int MOD = (int)10e9+7;
        int MOD = 1000000007;
        int n = arr.length;
        int[] nse = findNSE(arr); // these have indices in them
        int[] psee = findPSEE(arr);
        System.out.println(nse);
        System.out.println(psee);
        int sum = 0;
        for(int i=0; i<n; i++){
            int a = nse[i]-i;
            int b = i-psee[i];
            sum += a*b*arr[i];
        }
        return sum%MOD;
    }
    public static int[] findNSE(int[] arr){
        // here we have to find indices of NSE's of each element
        int n = arr.length;
        int nse[] = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=n-1; i>=0; i--){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i])
                st.pop();

            nse[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return nse;
    }
    public static int[] findPSEE(int[] arr){
        // here we have to find indices of PSEE's of each element
        int n = arr.length;
        int psee[] = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<n; i++){
            while(!st.isEmpty() && arr[st.peek()] > arr[i])
                st.pop();
            psee[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return psee;
    }
}

