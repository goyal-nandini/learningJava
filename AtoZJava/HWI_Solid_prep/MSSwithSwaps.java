package HWI_Solid_prep;

//optimization LEFT !!

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MSSwithSwaps {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n];
        for(int i=0; i<n; i++){
            a[i] = sc.nextInt();
        }
        int ans = solve(a, k);
        System.out.println(ans);
    }

    // posOutside = allPos - PosInside
    // for optimization LEFT !!
    static int solve(int[] a, int k){
        int n = a.length;
        int ans = 0;

        for(int l=0; l<n; l++){
            int sum = 0;

            for(int r=l; r<n; r++){
                sum += a[r];

                List<Integer> posOutside = new ArrayList<>();
                List<Integer> negInside = new ArrayList<>();

                // collect posOutside and negInside
                for(int i=0; i<n; i++){
                    if(i>=l && i<=r){
                        if(a[i]<0){
                            negInside.add(a[i]);
                        }
                    } else {
                        if(a[i]>0){
                            posOutside.add(a[i]);
                        }
                    }
                }

                // sorting time because we have to replace the worst neg with best pos
                Collections.sort(negInside);
                Collections.sort(posOutside, Collections.reverseOrder());

                int currSum = sum; // took this extra because this sum will be reused for the next subarray!! so we can't
                // take the modifies max sum we get in this subarray for next subarray !!

                // now swapping starts as a calc whole gain and deciding the max sum
                // but before this we have decide the no of swaps?
                // as k swaps possible and decided by negIns and PosOut, do min of both with min with k also will be the
                // total swaps can be made with gain and addition of gain to currSum

                int operations = Math.min(k, Math.min(negInside.size(), posOutside.size()));

                for(int i=0; i<operations; i++) {
                    int gain = posOutside.get(i) - negInside.get(i);
                    if (gain > 0) currSum += gain;
                    else break;
                }
                ans = Math.max(ans, currSum);
            }
        }
        return ans;
    }
}
