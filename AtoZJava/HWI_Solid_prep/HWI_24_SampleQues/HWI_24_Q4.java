package HWI_Solid_prep.HWI_24_SampleQues;

// TODO:
// building mountain: mathy mathy very much...!!
// observation formula prepared, relations, dependence and all!!

import java.util.Scanner;

public class HWI_24_Q4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] height = new int[n];
        for(int i=0; i<n; i++){
            height[i] = sc.nextInt();
        }

        int ans = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            int base = height[i] - Math.min(i, n-1-i);
            int mismatch = 0;
            for(int j=0; j<n; j++){
                int expected = base + Math.min(j, n-1-j);
                if(height[j] != expected){
                    mismatch++;
                }
            }
            ans = Math.min(ans, mismatch);
//            if(height[i+1] == height[i]+1){
//
//            }
        }

    }
}
