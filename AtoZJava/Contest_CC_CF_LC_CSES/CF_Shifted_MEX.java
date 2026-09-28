package Contest_CC_CF_LC_CSES;

// ERROR WA 🔴🔴🔴

import java.util.Scanner;
import java.util.Arrays;

public class CF_Shifted_MEX {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0) {
            int n = sc.nextInt();
            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            Arrays.sort(a);
            System.out.println(shiftedMEX(a));
        }
    }
    public static long shiftedMEX(long[] a){
        int n = a.length;
        long want = 0;
        long x = want - a[0];
        for(int i=0; i<n; i++){
            if(a[i] + x == want){
                want += 1;
            }
        }
        return want;
    }
}
