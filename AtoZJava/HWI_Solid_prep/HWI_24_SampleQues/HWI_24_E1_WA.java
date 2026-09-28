package HWI_Solid_prep.HWI_24_SampleQues;

// note: this is the same que as in HWI_24_E1
// so in faceprep time, sir thought ki we have to add the values in the range, so he teaches us how to do that using
// prefix sum and difference array, so this is an attempt to do so, but then it was an assignemnt problem, we have to
// assign the value in the range so he later confirmed that this can be done using segment tree only which i also solved
// the same in the respective file :)

import java.io.*;

public class HWI_24_E1_WA {
    private static int MOD = 1000000007;
    public static void main(String[] args) {
        FastReader3 fr = new FastReader3();
        PrintWriter out = new PrintWriter(System.out);

        int n = fr.nextInt();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) arr[i] = fr.nextLong();
        int q = fr.nextInt();
        long[][] queries = new long[q][4];
        for(int i=0; i<q; i++){
            queries[i][0] = fr.nextLong();
            queries[i][1] = fr.nextLong();
            queries[i][2] = fr.nextLong();
            queries[i][3] = fr.nextLong();
        }
        out.println(solve(arr, queries));
        out.close();
    }

    private static long solve(long[] arr, long[][] queries){
        long[] diff1 = new long[arr.length+2];
        long[] diff2 = new long[arr.length+2];
        for(long[] q: queries){
            long l = q[0];
            long r = q[1];
            long x = q[2];
            long y = q[3];
            diff1[(int)l] += (x-l*y)%MOD;
            diff1[(int)r+1] -= (x-l*y)%MOD; // updates with only constant part

            diff2[(int)l] += y;
            diff2[(int)r+1] -= y; // updates with only constant part
        }
        // prefix array of the diff1 and diff2
        for(int i=1; i<diff1.length; i++) {
            diff1[i] = diff1[i] + diff1[i-1];
            diff2[i] = i*(diff2[i]+diff2[i-1]);
        }

        for(int i=0; i<arr.length; i++){
            long val = diff1[i]+diff2[i];
            arr[i] = val;
        }
        long sum=0;
        for(int i=0; i<arr.length; i++){
            sum += arr[i];
        }
        return sum%MOD;
    }
}
//class FastReader3{
//    BufferedReader reader;
//    StringTokenizer tokenizer;
//
//    public FastReader3(){
//        reader = new BufferedReader(new InputStreamReader(System.in));
//    }
//
//    String next(){
//        while(tokenizer == null || !tokenizer.hasMoreElements()){
//            try{
//                String line = reader.readLine();
//                if(line == null) return null;
//                tokenizer = new StringTokenizer(line);
//            } catch (IOException e){
//                return null;
//            }
//        }
//        return tokenizer.nextToken();
//    }
//
//    public int nextInt(){
//        return Integer.parseInt(next());
//    }
//    public Long nextLong(){
//        return Long.parseLong(next());
//    }
//}
