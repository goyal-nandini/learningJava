package StacksQueues;

import java.util.Arrays;

public class countNGE_brute {
    public static void main(String[] args) {
        int[] nums = {3, 4, 2, 7, 5, 8, 10, 6};   // You can change input here
        int[] indices = {0, 5};
        int[] res = count_NGE(nums, indices);

        System.out.println("Input array: " + Arrays.toString(nums));
        System.out.println("Next Greater Elements: " + Arrays.toString(res));
    }
    public static int[] count_NGE(int arr[], int indices[]) {
        // code here -> BRUTE 🟢📸
// Time: O(n*m)
//  worst case (for each query, scan the rest of the array).
// Space: O(m) for the answer.

        int n = arr.length;
        int m = indices.length;
        int[] ans = new int[m];
        for(int i=0; i<m; i++){
            int cnt = 0;
            for(int j=indices[i]+1; j<n; j++){
                if(arr[j] > arr[indices[i]]) cnt++;
            }
            ans[i] = cnt;
        }
        return ans;
    }
}
