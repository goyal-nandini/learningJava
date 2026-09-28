package Contest_CC_CF_LC_CSES;

import java.io.*;
import java.util.StringTokenizer;

public class CF_JatayusBalancedBracketSequence {
    public static void main(String[] args) {
        FastReader8 fr = new FastReader8();
        PrintWriter out = new PrintWriter(System.out);

        long t = fr.nextLong();

        while(t-- > 0){
            int n = fr.nextInt();
            String s = fr.next();

            int res = solve(s, n);
            out.println(res);
        }
        out.flush();
    }

    private static int solve(String s, int n) {
        int ans = n;
        //    int[] prefix = new int[2*n];
        //    for(int i=0; i<2*n; i++){
        //        char ch = s.charAt(i);
        //        if(ch == '('){
        //            prefix[i] += 1;
        //        } else {
        //            prefix[i] -= 1;
        //        }
        //    }
        //    for(int i=1; i<prefix.length; i++){
        //        prefix[i] += prefix[i-1];
        //    }
        int curr_depth = 0;
        int running_depth = 0;
        for (int i = 0; i < 2 * n; i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                curr_depth++;
                if (curr_depth <= running_depth) {
                    ans -= 1;
                }
                running_depth = curr_depth;
            } else {
                curr_depth--;
            }
        }
        return ans;

    }
}
class FastReader8{
    BufferedReader reader;
    StringTokenizer tokenizer;

    public FastReader8(){
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
//class FastReader8 {
//    StreamTokenizer st;
//    public FastReader8() {
//        st = new StreamTokenizer(new BufferedInputStream(System.in, 1 << 16));
//    }
//    int nextInt() {
//        try {
//            st.nextToken();
//        } catch (IOException e) {}
//        return (int) st.nval;
//    }
//    long nextLong() {
//        try {
//            st.nextToken();
//        } catch (IOException e) {} return (long) st.nval;
//    }
//}
