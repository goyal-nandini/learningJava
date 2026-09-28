package BitManipulation;

/*Question 26:
Maximum XOR Subarray Partition
You are given an array A of size N. You can partition A into multiple subarrays such that each  element belongs to
exactly one subarray and each subarray has a length of at least K. The beauty  of a subarray is the maximum bitwise
XOR of the values of a subset in that subarray. The  amazingness of a partitioned array is the sum of beauties of its
subarrays. Find the maximum  possible amazingness of A.
Note
• A subarray is a contiguous part of the array.
Input Format
1. The first line contains an integer, N, denoting the number of elements in A. 2. The next line contains an integer,
K, denoting the given integer.
3. Each line i of the N subsequent lines (where 0 ≤ i < N) contains an integer describing  A[i].
Constraints
• 1 <= N <= 10^5
• 1 <= K <= 10^5
• 1 <= A[i] <= 10^5
Example 1
Sample Input 1
2
2
2
1
Sample Output 1
3
Explanation
Given N = 2, K = 2, A = [2, 1].
We take the entire A as one subarray as [2, 1] with maximum amazingness equal to 3. Hence, the answer for this case is equal to 3.
Example 2
Sample Input 2
4
1
1
5
3
3
Sample Output 2
12
Explanation
Given N = 4, K = 1, A = [1, 5, 3, 3].
We can take 4 subarrays from A as [1], [5], [3], [3] whose maximum amazingness is equal to 1 +  5 + 3 + 3 = 12.
Hence, the answer for this case is equal to 12.
Example 3
Sample Input 3
7
1
16
3
3
5
19
19
5
Sample Output 3
70
Explanation
Given N = 7, K = 1, A = [16, 3, 3, 5, 19, 19, 5].
The maximum possible amazingness for this case is equal to 70*/

// will give tle with these constraint

import java.io.*;
import java.util.*;

public class maxXorSubarrayPartition {
    final static int HIGH = 17;

    void main() throws IOException {
        FastReader sc = new FastReader();
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] A = new int[N + 1]; // 1-indexed
        for (int i = 1; i <= N; i++) A[i] = sc.nextInt();

        System.out.println(solve(A, K));
    }

    // Build a fresh basis over A[l..r] and return max subset XOR
    private long beautyOf(int[] arr, int l, int r){
        // task is to ge the beauty of arr from l to r - get max xor of the subset of arr[l...r]
        // Assume arr to be from arr[l] to arr[r] as a new arr - 'narr' -
        // now aur task is to find xor basis of this 'narr'

        // insert and queryMax methods to write now
        long[] basis = new long[HIGH];
        for(int i=l; i<=r; i++){
            insert(basis, arr[i]);
        }
        return queryMax(basis);
    }
    void insert(long[] basis, long num){
        for(int i=HIGH-1; i>=0; i--){
            long bit = (num >> i) & 1; // get the bit
            if(bit == 0) continue;

            if(basis[i] == 0){
                basis[i] = num;
                return;
            }
            num = num ^ basis[i];
        }
    }
    long queryMax(long[] basis){
        long result = 0;
        for(int i=HIGH-1; i>=0; i--){
            result = Math.max(result, result ^ basis[i]);
        }
        return result;
    }

    // this also makes the same tc as n^2*17 not do any optimization over solve_tle
    // One important point:
    // You asked "How to optimize this code?"
    // The honest answer is:
    // You can't optimize it into an acceptable solution just by tweaking the loops.
    // The bottleneck isn't an inefficient implementation—it's that the algorithm fundamentally considers all O(n^2)
    // subarrays. To go faster, you need a different data structure or a different DP formulation, not just micro-optimizations.
    private void solveFOrFixedIdx(int idx, int[] arr, int k, long[] dp, int n){
        long[] basis = new long[HIGH];
        long maxSum = Long.MIN_VALUE;

        for(int i=idx; i<n; i++){
            insert(basis, arr[i]);
            if(i-idx+1>=k){
                // once the len exceeds k means just add that ele only in basis,
                // not starting from start to insert
                long beauty = queryMax(basis);
                long sum = beauty + dp[i+1];
                maxSum = Math.max(maxSum, sum);
            }
        }
        dp[idx] = maxSum;
    }
    private long solve(int[] arr, int k){
        int n = arr.length;
        long[] dp = new long[n+1];

        for(int idx=n-1; idx>0; idx--){
            solveFOrFixedIdx(idx, arr, k, dp, n);
        }
        return dp[1];
    }


    // this brute-force version rebuilds a fresh basis from scratch for every (idx, i) pair — for N=10^5
    // that's way too slow (roughly O(N² × 17)).
    // FIX: Here's the real question to sit with: for a fixed idx, as i increases by 1 (chunk grows by one element
    // to the right), you're currently throwing away the whole basis and rebuilding it from idx to the new i.
    // But do you actually need to rebuild it? If you already had the basis for A[idx..i-1], and now you just want to
    // add A[i] — what's the minimum work needed?
    // Think about your own insert() function — if you call it once more with just the new element, what does it do to
    // the existing basis?

    private long solve_tle(int[] arr, int k){
        int n = arr.length;
        long[] dp = new long[n+1];

        for(int idx=n-1; idx>0; idx--){
            long maxSum = Long.MIN_VALUE;

            for(int i=idx+k-1; i<n; i++){
                long beauty = beautyOf(arr, idx, i);
                long sum = beauty + dp[i+1];
                maxSum = Math.max(maxSum, sum);
            }
            dp[idx] = maxSum;
        }
        return dp[1];
    }

    // starting with recursion lets do tabulation of this, see above
    private long solve_recursion(int idx, int[] arr, int k){
        if(idx == arr.length) return 0;
        long maxSum = Long.MIN_VALUE;
        for(int i=idx+k-1; i<arr.length; i++){
            long beauty = beautyOf(arr, idx, i);
            long sum = beauty + solve_recursion(i+1, arr, k);
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }

    // Fast I/O to prevent timeout on reading 10^5 elements
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    String line = br.readLine();
                    if (line == null) return null;
                    st = new StringTokenizer(line);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

}
