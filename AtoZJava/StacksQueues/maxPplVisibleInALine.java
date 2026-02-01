package StacksQueues;

import java.util.Arrays;
import java.util.Stack;

public class maxPplVisibleInALine {
    public static void main(String[] args) {
        int[] arr = {6, 2, 5, 4, 5, 1, 6};
        int ans = maxPeople(arr);
        System.out.println(ans);
    }

    // JUST CLEVER GREEDY SOLUITON, I DIDN'T GET 👎
    public static int maxPeople_2(int[] arr) {
        // code here
        int max = arr[0];
        int n = arr.length;
        for (int num : arr) max = Math.max(max, num);
        int prev = -1;
        int cur = -1;
        int ans = 1;
        for (int i = 0; i < n; i++) {
            if (cur == -1 && arr[i] == max) {
                cur = i;
            } else if (arr[i] == max) {
                ans = Math.max(ans, ((cur - prev) + (i - cur)) - 1);
                prev = cur;
                cur = i;
            }
        }
        ans = Math.max(ans, ((cur - prev) + (n - cur)) - 1);
        return ans;
    }
//    ADVICE: 📌 Never abandon a solution you understand for a “clever” one you don’t.

    // ⭐⭐I DID THIS BY MONOTONIC STACK ALL BY MYSLEF!!
    public static int maxPeople(int[] arr) {
        // code here
        int n = arr.length;
        int max=0;

        int[] pge = findPGE(arr);
        int[] nge = findNGE(arr);

        for(int i=0; i<n; i++){
            max = Math.max(max, nge[i]-pge[i]-1);
        }
        System.out.println(Arrays.toString(pge));
        System.out.println(Arrays.toString(nge));

//        int[][] nge_pge = findNGE_PGE2(arr);
//        int[] nge = nge_pge[0];
//        int[] pge = nge_pge[1];
//        for(int i=0; i<n; i++){
//            max = Math.max(max, nge[i]-pge[i]-1);
//        }
//        System.out.println(Arrays.toString(nge));
//        System.out.println(Arrays.toString(pge));

        return max;

    }
//    WRONGly computing the answer...next two functions
    public static int[][] findNGE_PGE2(int[] arr) {
        int n = arr.length;
        int[][] res = new int[2][n]; // res[0] = NGE, res[1] = PGE

        Arrays.fill(res[0], n);   // default NGE
        Arrays.fill(res[1], -1);  // default PGE

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {

            // Resolve NGE for elements <= current
            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                int idx = st.pop();
                res[0][idx] = i;   // NGE
            }

            // After popping, stack top is PGE (>= current)
            if (!st.isEmpty()) {
                res[1][i] = st.peek(); // PGE
            }

            st.push(i);
        }

        return res;
    }

    public static int[][] findNGE_PGE(int[] arr){
        // way 2
        int n=arr.length;
        int[][] nge_pge = new int[2][n];
        Arrays.fill(nge_pge[0], n);
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<n; i++){
            while(!st.isEmpty() && arr[st.peek()] <= arr[i]){
                int ind = st.pop();
                nge_pge[0][ind] = i; // for nge
            }
            nge_pge[1][i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return nge_pge;

    }

    public static int[] findPGE(int[] arr){
        int n=arr.length;
        int[] pge = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<n; i++){
            while(!st.isEmpty() && arr[st.peek()] < arr[i]){
                st.pop();
            }
            pge[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return pge;
    }
    public static int[] findNGE(int[] arr){
        int n=arr.length;
        int[] nge = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=n-1; i>=0; i--){
            while(!st.isEmpty() && arr[st.peek()] < arr[i]){
                st.pop();
            }
            nge[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return nge;
    }

    // NOPE NSE and PSE won't work!!
    public static int[] findPSE(int[] arr){
        int n=arr.length;
        int[] pse = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<n; i++){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }
            pse[i] = st.isEmpty() ? 0 : st.peek();
            st.push(i);
        }
        return pse;
    }
    public static int[] findNSE(int[] arr){
        int n=arr.length;
        int[] pse = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=n-1; i>=0; i--){
            if(!st.isEmpty() && arr[st.peek()] <= arr[i]){
                st.pop();
            }
            pse[i] = st.isEmpty() ? 0 : st.peek();
            st.push(i);

        }
        return pse;
    }


}
