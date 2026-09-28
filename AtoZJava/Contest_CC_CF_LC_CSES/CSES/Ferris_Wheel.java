package Contest_CC_CF_LC_CSES.CSES;

import java.io.*;
import java.util.*;

public class Ferris_Wheel {
    static void main(String[] args) {
        FastReader51 fr = new FastReader51();
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int n = fr.nextInt();
        long x = fr.nextLong();

        long[] p = new long[n];
        for(int i=0; i<n; i++){
            p[i] = fr.nextLong();
        }

        Arrays.sort(p);
        int i=0;
        int j=n-1;
        int cnt = 0;
        while(i<=j){
            if(p[i]+p[j]<=x){
                cnt++;
                i++;
                j--;
            } else {
                cnt++;
                j--;
            }
        }
        out.println(cnt);
        out.flush();
    }
}

class FastReader51{
    BufferedReader reader;
    StringTokenizer tokenizer;

    public FastReader51(){
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    String next(){
     while(tokenizer == null || !tokenizer.hasMoreElements()) {
         try{
             String line = reader.readLine();
             if(line == null) return null;
             tokenizer = new StringTokenizer(line);
         } catch(IOException e){
             return null;
         }
     }
     return tokenizer.nextToken();
    }
    int nextInt(){
        return Integer.parseInt(next());
    }
    long nextLong(){
        return Long.parseLong(next());
    }
    double nextDouble(){
        return Double.parseDouble(next());
    }
    String nextLine(){
        try{
            return reader.readLine();
        } catch(IOException e){
            return null;
        }
    }
}
