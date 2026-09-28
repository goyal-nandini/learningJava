package Contest_CC_CF_LC_CSES.CSES;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ArrayDivision {
    public static void main(String[] args) {
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out);

        long n = fr.nextLong();
        int k = fr.nextInt();

        long[] arr = new long[(int)n];
        for(int i=0; i<n; i++){
            arr[i] = fr.nextLong();
        }

        long res = solve(arr, k);
        out.println(res);

        out.close();
    }
    private static long solve(long[] arr, int k){
        long sum = 0;
        long max = 0;
        for(long x: arr) {
            sum += x;
            max = Math.max(x, max);
        }
        long l=max;
        long h=sum;
        long ans=sum;

        while(l<=h){
            long mid = l + (h - l) / 2;
            if(isValid(arr, mid, k)){
                ans = mid;
                h=mid-1; // want min possible
            } else {
                l=mid+1;
            }
        }
        return ans;
    }
    private static boolean isValid(long[] arr, long maxSum, int maxDiv){
        // divide the array into k parts/subarrays and checking for max sum of each subarray
        // maxsum is for one subarray from the array
        long sum=0;
        int grp=1;
        for(int i=0; i<arr.length; i++){
            sum += arr[i];
            if(sum > maxSum){
                grp++;
                sum=arr[i]; // reset to curr ele as because of this ele, arr[i], then sum exceeds,
               // so we have to start from there only || for checking each subarray to be of maxSum only
            }
        }
        if(grp <= maxDiv){
            return true;
        }
        return false;
    }
}
class FastReader{
    BufferedReader reader;
    StringTokenizer tokenizer;

    public FastReader(){
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    String next(){
        while(tokenizer == null || !tokenizer.hasMoreElements()){
            try{
                String line = reader.readLine();
                if(line == null) return null;
                tokenizer = new StringTokenizer(line);
            } catch (IOException e){
                return null;
            }
        }
        return tokenizer.nextToken();
    }

    public int nextInt(){
        return Integer.parseInt(next());
    }
    public Long nextLong(){
        return Long.parseLong(next());
    }
}
