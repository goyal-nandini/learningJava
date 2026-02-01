package DPandGreedy;

// alike finding all subsequence with additional property of non-adjacents only
//and also taking max sum as part 2

import java.util.ArrayList;

public class maxSum_nonAdjacent {
    public static void main(String[] args) {
        int[] arr = {2, 1, 4, 9};
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>(); // list of list
        ArrayList<Integer> list = new ArrayList<>();
//        allSubsequences(0, arr, list, ans);
        allSubsequencesWithNonAdj(0, arr, list, ans);
        System.out.println(ans);
        System.out.println(maxSumWithNonAdj(0, arr));

        // memoisation ho jaega...
        // ek baar tabulation try krt hai
        System.out.println(maxSumWithNonAdj_tabulation(arr));

    }
    // part 2 for max sum of those subsequences
// ⭐⭐   🔵 View 1: Forward recursion -> “What is the best answer starting from index i?”
    public static int maxSumWithNonAdj_tabulation(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n + 2]; // padding avoids bounds checks

        for (int i = n - 1; i >= 0; i--) {
            int pick = arr[i] + dp[i + 2];
            int notPick = dp[i + 1];
            dp[i] = Math.max(pick, notPick);
        }

        return dp[0];
    }

    public static int maxSumWithNonAdj(int i, int[] arr){
        if(i>=arr.length) return 0;

        int pick = arr[i] + maxSumWithNonAdj(i+2, arr);  // if i is picked so pick i+2 now
        int notPick = maxSumWithNonAdj(i+1, arr); // if i is not picked then pick i+1 now
        return Math.max(pick, notPick);
    }
//    🔴 If you PICK arr[i]
//    You cannot pick i+1
//    So you move to i+2
//    🔵 If you NOT PICK arr[i]
//    No restriction
//    Move to i+1

    // part 1 only all subsequences with non adj ele
    public static void allSubsequencesWithNonAdj(int i, int[] arr, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> ans){
        if(i>=arr.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        list.add(arr[i]);
        allSubsequencesWithNonAdj(i+2, arr, list, ans);  // if i is picked so pick i+2 now

        list.remove(list.size()-1);
        allSubsequencesWithNonAdj(i+1, arr, list, ans); // if i is not picked then pick i+1 now
    }
    public static void allSubsequences(int i, int[] arr, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> ans){
        if(i==arr.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        list.add(arr[i]);
        allSubsequences(i+1, arr, list, ans); // pick

        list.remove(list.size()-1);
        allSubsequences(i+1, arr, list, ans); // not pick
    }
}
