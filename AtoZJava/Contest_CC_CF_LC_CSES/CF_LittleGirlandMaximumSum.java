package Contest_CC_CF_LC_CSES;
// AC :)
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.*;

public class CF_LittleGirlandMaximumSum {
    public static void main(String[] args) {
        FastReader7 fr = new FastReader7();
        PrintWriter out = new PrintWriter(System.out);

        int n = fr.nextInt();
        int q = fr.nextInt();

        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = fr.nextInt();
        }
        int[][] queries = new int[q][2];
        for(int i=0; i<q; i++){
            int l = fr.nextInt();
            int r = fr.nextInt();
            queries[i] = new int[]{l, r};
        }
        long res = solve(arr,queries);
        out.println(res);

        out.flush();
    }

    private static long solve(int[] arr, int[][] queries){
        int n = arr.length;
        int[] diff = new int[n+2];
        for(int[] q: queries){
            int l = q[0]-1;
            int r = q[1]-1;
            diff[l] += 1;
            diff[r+1] -= 1;
        }
        for(int i=1; i<diff.length; i++){
            diff[i] += diff[i-1];
        }

        // have to put max ele in max val of prefix sum of diff arr
        int[] new_diff = Arrays.copyOfRange(diff, 0, n);
        ArrayList<int[]> list = new ArrayList<>();
        for(int i=0; i<new_diff.length; i++){
            list.add(new int[]{new_diff[i], i});
        }
        Collections.sort(list, (a, b) -> b[0]-a[0]);

        // building new array
        Arrays.sort(arr);
        int[] newArr = new int[arr.length];
        int j=n-1;
        for(int i=0; i<list.size(); i++){
            int[] pair = list.get(i);
            int idx = pair[1];
            int ele = arr[j];
            j--;
            newArr[idx] = ele;
        }

        // finding prefix sum for newArr
        long[] prefixSum = new long[newArr.length];
        prefixSum[0] = newArr[0];
        for(int i=1; i<newArr.length; i++){
            prefixSum[i] = prefixSum[i-1]+newArr[i];
        }

        long sum = 0;
        for(int[] q: queries){
            int l = q[0]-1;
            int r = q[1]-1;
            if(l==0) sum += prefixSum[r];
            else sum += prefixSum[r]-prefixSum[l-1];
        }
        return sum;

    }
}
class FastReader7 {
    StreamTokenizer st;
    public FastReader7() {
        st = new StreamTokenizer(new BufferedInputStream(System.in, 1 << 16));
    }
    int nextInt() {
        try {
            st.nextToken();
        } catch (IOException e) {}
        return (int) st.nval;
    }
    long nextLong() {
        try {
            st.nextToken();
        } catch (IOException e) {} return (long) st.nval;
    }
}
