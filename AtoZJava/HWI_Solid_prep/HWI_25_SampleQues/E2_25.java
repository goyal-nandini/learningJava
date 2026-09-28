package HWI_Solid_prep.HWI_25_SampleQues;
/*You are given an array A of length N and an
integer k.
It is given that a subarray from l to r is considered
good, if the number of distinct elements in that
subarray doesn’t exceed k. Additionally, an empty
subarray is also a good subarray and its sum is
considered to be zero.
Find the maximum sum of a good subarray.*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class E2_25 {
    public static void main(String[] args) {
        FastReader2 fr = new FastReader2();
        PrintWriter pw = new PrintWriter(System.out);

        int n = fr.nextInt();
        int k = fr.nextInt();
        long[] arr = new long[n];
        for(int i=0; i<n; i++){
            arr[i] = fr.nextLong();
        }

        long res = goodSubarray(arr, k);
        System.out.println(res);
    }

    public static long goodSubarray(long[] arr, int k){
//        Set<Long> set = new HashSet<>();
        Map<Long, Integer> map = new HashMap<>();
        int l=0, r=0;
        long sum = 0;
        long maxSum = 0; // for empty subarray!!

        while(r<arr.length){
            map.put(arr[r], map.getOrDefault(arr[r], 0)+1);
            sum += arr[r];

            while(map.size() > k){
                map.put(arr[l], map.get(arr[l])-1);
                sum -= arr[l];
                if(map.get(arr[l]) == 0){
                    map.remove(arr[l]);
                }
                l++;
            }
            maxSum = Math.max(sum, maxSum); // window is valid
            r++;
        }
        return maxSum;

    }
/*Why not Set?
When you shrink the window from the left, you need to know if arr[l] still appears in the window after removal. A Set has no count — removing arr[l] from the Set would wrongly mark it as "not present" even if duplicates remain.
Example: arr = [1, 1, 2], k = 1

Window [1, 1, 2] → too many distinct → shrink left
Remove first 1, but 1 still exists at index 1 → can't remove it from the distinct count
A Set can't detect this. HashMap with counts handles it correctly (count goes 2→1, not removed).*/
}
class FastReader2{
    BufferedReader reader;
    StringTokenizer tokenizer;

    public FastReader2() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    String next() {
        while (tokenizer == null || !tokenizer.hasMoreElements()) {
            try { tokenizer = new StringTokenizer(reader.readLine()); }
            catch (IOException e) { e.printStackTrace(); }
        }
        return tokenizer.nextToken();
    }

    int nextInt() { return Integer.parseInt(next()); }
    long nextLong() { return Long.parseLong(next()); }
}

