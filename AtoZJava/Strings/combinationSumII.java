package Strings;

import java.util.*;

public class combinationSumII {
    public static void main(String[] args) {
        int[] candidates = {1, 2, 7, 6, 1, 5};
        int target = 8;

        combinationSumII sol = new combinationSumII();

//        // voilating combination sum II -> duplicate combo are there...which is prohibited!!
//        List<List<Integer>> result = sol.combinationSum2_Wrong(candidates, target);

//        List<List<Integer>> result = sol.combinationSum2_1(candidates, target);
        List<List<Integer>> result = sol.combinationSum2_2(candidates, target);

//        List<List<Integer>> result = sol.combinationSum2_Optimal(candidates, target);
        for (List<Integer> subset : result) {
            System.out.println(subset);
        }
    }

    // optimal 😃🫣😃
    public static List<List<Integer>> combinationSum2_Optimal(int[] candidates, int target){
        // ok so its next day lets do optimal one (i did covered it yesterday) but now lets code it up!!
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates, 0, target, list, ans);
        return ans;
    }
    public static void helper(int[] arr, int ind, int targetSum, List<Integer> list, List<List<Integer>> ans){
        // ok so lets boom

        // base case:
        if(targetSum == 0){
            ans.add(new ArrayList<>(list));
            return;
        }

        // to go from ind to n-1 (index) -> Iterate through the array starting from the current index
        for(int i=ind; i<arr.length; i++){
            // have to select whether this index applicable or not (to check for duplicate ele)
            // Skip duplicates to avoid repeated combinations
            if (i > ind && arr[i] == arr[i - 1]) continue;

            // to break out immediately when target seems not reachable
            // Early termination: if current element exceeds remaining target, no need to proceed further
            if (arr[i] > targetSum) break;

            // Include current element and recurse with updated target and index
            list.add(arr[i]);
            helper(arr, i+1, targetSum-arr[i], list, ans);

            // Backtrack: remove the last added element to explore other possibilities
            list.remove(list.size()-1); // backtrack
        }
    }

    // correct brute two: 2️⃣
    public static List<List<Integer>> combinationSum2_2(int[] candidates, int target) {
        Arrays.sort(candidates); // sort to bring duplicates together
        List<List<Integer>> result = new ArrayList<>();
        helper_2(candidates, 0, target, new ArrayList<>(), result);
        return result;
    }
    public static void helper_2(int[] arr, int ind, int targetSum, List<Integer> list, List<List<Integer>> result) {
        // Base case
        if (ind == arr.length) {
            if (targetSum == 0)
                result.add(new ArrayList<>(list));
            return;
        }

        // pick (only if value fits)
        if (arr[ind] <= targetSum) {
            list.add(arr[ind]);
            helper_2(arr, ind + 1, targetSum - arr[ind], list, result);
            list.remove(list.size() - 1);
        }

        // skip duplicates while not picking
        int next = ind + 1;
        while (next < arr.length && arr[next] == arr[ind]) {
            next++; // move to the next different number
        }

        // not pick
        helper_2(arr, next, targetSum, list, result);
    }

    // correct brute one: 1️⃣
    public List<List<Integer>> combinationSum2_1(int[] candidates, int target){
        // correct one but brute hai...!!
        Arrays.sort(candidates); // sorting helps create unique sorted lists

        // 😃🫣 sorting k baad duplicate mismatched order
        // wale bhi same ho jate hai that's why hashset use krna is benifitted🫣😱

        Set<List<Integer>> set = new HashSet<>();
        helper_2(candidates, 0, target, new ArrayList<>(), set);

        // Convert set to list
        return new ArrayList<>(set);

    }
    public static void helper_2(int[] arr, int ind, int target, List<Integer> temp, Set<List<Integer>> set) {
        // Base case
        if (ind == arr.length) {
            if (target == 0) {
                set.add(new ArrayList<>(temp)); // add directly, already sorted due to sorted array
            }
            return;
        }

        // pick (if possible)
        if (arr[ind] <= target) {
            temp.add(arr[ind]);
            helper_2(arr, ind + 1, target - arr[ind], temp, set);
            temp.remove(temp.size() - 1); // backtrack
        }

        // not pick
        helper_2(arr, ind + 1, target, temp, set);
    }

    // voilating 👁️ combination sum II -> duplicate combo are there...which is prohibited!!
    public List<List<Integer>> combinationSum2_Wrong(int[] candidates, int target) {

        // this doesn't work as it returns all combo not unique like [1,2] and [2,1] both but we don't want them!!
        // BRUTE: follow up from combination sum I so here repetition of ele is not allowed so don't stick on same index to reach target!! ✋

        Arrays.sort(candidates); // sorting k baad duplicate mismatched order
        // wale bhi same ho jate hai that's why hashset use krna is benifitted🫣😱

        List<Integer> list = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        helper_func(candidates, 0, target, list, result);

        return result;
    }
    public static void helper_func(int[] arr, int ind, int targetSum, List<Integer> list, List<List<Integer>> result){
        // Base Case:
        if(arr.length == ind){
            if(targetSum == 0){
                result.add(new ArrayList<>(list));
            }
            return;
        }
        // Recursive part:
        if(targetSum >= arr[ind]){ // pick (only if it doesn't overshoot)
            // pick
            list.add(arr[ind]);
            helper_func(arr, ind+1, targetSum - arr[ind], list, result); // here inde+1 is used ✋
            list.remove(list.size() - 1); // backtrack
        }
        // not pick
        helper_func(arr, ind+1, targetSum, list, result);
    }
}

/* tc: O(nlogn) [for sorting]+ O(2^t * k) + O(logn) -> hashset wala
* sc: O(2^n * k) + O(n) 2^n for subsets yet they get filtered acc to targets
*
* then while loop k through duplicates htana
* tc: O(nlogn)[for sorting] + O(2^t * k)
* O(2^n * k) + O(n) 2^n for subsets yet they get filtered acc to targets
* */