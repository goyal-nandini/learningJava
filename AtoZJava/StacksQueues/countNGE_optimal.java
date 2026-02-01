package StacksQueues;

import java.util.*;

public class countNGE_optimal {
    public static void main(String[] args) {
        int[] nums = {3, 4, 2, 7, 5, 8, 10, 6};   // You can change input here
        int[] indices = {0, 5};
        int[] res = count_NGE(nums, indices);

        System.out.println("Input array: " + Arrays.toString(nums));
        System.out.println("Next Greater Elements: " + Arrays.toString(res));
    }
    // A small class to keep both value and original index together
    static class Pair {
        int val;
        int idx;
        Pair(int v, int i) {
            val = v;
            idx = i;
        }
    }

    public static int[] count_NGE(int arr[], int indices[]) {
        int n = arr.length;
        int m = indices.length;

        // -> This will store the final answer: count of greater elements to the right for each index
        int[] countGreater = new int[n];

        // -> Convert arr[] into Pair[] so we don't lose original indexes after sorting
        Pair[] pairs = new Pair[n];
        for (int i = 0; i < n; i++) pairs[i] = new Pair(arr[i], i);

        // -> Use modified merge sort to fill countGreater[]
        mergeSort(pairs, 0, n - 1, countGreater);

        // -> Now answer queries based on computed results
        int ans[] = new int[m];
        for (int i = 0; i < m; i++) ans[i] = countGreater[indices[i]];

        return ans;
    }

    private static void mergeSort(Pair[] arr, int left, int right, int[] countGreater) {
        if (left >= right) return;
        int mid = left + (right - left) / 2;

        // Sort left and right halves
        mergeSort(arr, left, mid, countGreater);
        mergeSort(arr, mid + 1, right, countGreater);

        // Merge them and count
        merge(arr, left, mid, right, countGreater);
    }

    private static void merge(Pair[] arr, int left, int mid, int right, int[] countGreater) {
        List<Pair> temp = new ArrayList<>();

        int i = left;       // pointer for left half
        int j = mid + 1;    // pointer for right half

        // ------------------------------------------
        // Merging with counting
        // ------------------------------------------

        while (i <= mid && j <= right) {
            // If right value > left value,
            // then ALL remaining values in right half are also >= this (since sorted)
            if (arr[j].val > arr[i].val) {
                // Increase count of elements greater to the right for arr[i]
                countGreater[arr[i].idx] += (right - j + 1); // 🖊️📝
                temp.add(arr[i]);
                i++;
            } else {
                // normal merge
                temp.add(arr[j]);
                j++;
            }
        }

        // Copy remaining elements
        while (i <= mid) temp.add(arr[i++]);
        while (j <= right) temp.add(arr[j++]);

        // Put temp back into arr
        for (int k = left; k <= right; k++) {
            arr[k] = temp.get(k - left);
        }
    }
}
