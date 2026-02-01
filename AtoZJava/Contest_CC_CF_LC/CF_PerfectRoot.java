package Contest_CC_CF_LC;

import java.util.Scanner;

public class CF_PerfectRoot {
    final static long k = 1000000000;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0) {
            int n = sc.nextInt();

            // we have to tell n perfect roots between 1 to 10^9
            // sqrt(y) = x, we have to tell x, and alike n no. of times
           for(long i: perfectRoot(n)){
               System.out.print(i + " ");
           }
        }
    }
    public static long[] perfectRoot(int n){
        int cnt=n;
        int j=0;
        long[] ans = new long[n];
        for(int i=1; i<k; i++){
            long sq = (long)Math.sqrt(i);

            if(sq * sq == i){
                ans[j] = sq;
                j++;
                cnt--;
            }
            if(cnt == 0) break;
        }
        return ans;
    }
}
