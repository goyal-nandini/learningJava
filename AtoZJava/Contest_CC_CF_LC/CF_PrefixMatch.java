package Contest_CC_CF_LC;

import java.util.Scanner;

public class CF_PrefixMatch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0) {
            int n = sc.nextInt();
            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            System.out.println(prefixMatch(a));
        }
    }
    public static long prefixMatch(long[] a){
        int n=a.length;
        long max=Long.MIN_VALUE;
//        int maxPrefix = Integer.MIN_VALUE;
        int sum=0;
//        int ind = 0;
        for(int i=0; i<n; i++){
            if(a[i] > max){
                max = a[i];
//                ind = i;
            }
        }

//        if(a[0] != max){
//            int temp = a[0];
//            a[0] = a[ind];
//            a[ind] = temp;
//        }
//        for(int i=0; i<n; i++){
//            maxPrefix = Math.max(a[i], maxPrefix);
//            sum += maxPrefix;
//        }
        sum += max*n;
        return sum;
    }
}
