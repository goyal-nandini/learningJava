package Contest_CC_CF_LC_CSES;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SPOJ_NAJPF_PatternFind {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            String text = sc.next();
            String pattern = sc.next();
            int n = pattern.length();
            List<Integer> res = new ArrayList<>();

            StringBuilder sb = new StringBuilder(pattern);
            sb.append("$").append(text);

            int[] zVal = calcZArray(sb.toString());
            for(int i=0; i<sb.length(); i++){
                if(zVal[i] == n){
                    res.add(i - n);
                }
            }
            if(res.size() == 0){
                System.out.println("Not Found");
                System.out.println();
                continue;
            }
            System.out.println(res.size());
            for(int idx: res){
                System.out.print(idx + " ");
            }
            System.out.println();
        }

    }
    private static int[] calcZArray(String input){
        int n = input.length();
        int[] z = new int[n]; // Z[i] = length of substring starting at i which matches prefix

        int r = 0, l = 0;
        for(int i=1; i<n; i++){

            // case 1. outside the box
            if(i>r){
                r = l = i;
                while(r<n && input.charAt(r) == input.charAt(r-l)){
                    r++;
                }

                z[i] = r-l; // gives number of matched chars
                r--; // we've to do this as in the loop 'r' gets one index more the valid length so we have to
                // move back one index to restore the last valid index
            }
            // case 2. inside the box
            else {
                int mirror = i - l; // exact prefix matched char with the box
                int remaining = r - i + 1; // how much safe area/length remains inside current box
                // z[mirror] means how long did the match go when we are at pos mirror


                // case 2a.
                if(z[mirror] < remaining){
                    z[i] = z[mirror]; // copy safely || mirror result completely safe → direct copy
                }
                // case 2b.
                else {
                    // start from right and expand || mirror result may continue beyond known boundary → must extend
                    l = i;
                    while(r<n && input.charAt(r) == input.charAt(r-l)){
                        r++;
                    }
                    z[i] = r-l;
                    r--;
                }
            }
        }

        return z;
    }
}