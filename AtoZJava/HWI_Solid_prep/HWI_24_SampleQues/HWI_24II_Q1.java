package HWI_Solid_prep.HWI_24_SampleQues;

import java.util.*;
public class HWI_24II_Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int E = sc.nextInt();
        int n = sc.nextInt();
        int[] A = new int[n];
        for(int i=0; i<n; i++){
            A[i] = sc.nextInt();
        }
        int res = solve(A, E);
        System.out.println(res);
    }
    // on 27.3.2026
    private static int solve(int[] exercises, int E){
        int n = exercises.length;
        Arrays.sort(exercises);
        int ans=0;
        int i=n-1; // will go from end of the sorted array as i have to perform min exercise and in this must drain more
        // energy by performing tough exercises!
        while(E>0 && i>=0){
            // first time
            E -= exercises[i];
            ans++; // counted
            if(E<=0) break;

            // second time
            E -= exercises[i];
            ans++; // counted
        }
        if(E>0) return -1;
        return ans;
    }

    // this i did on 16.3.2026
    private static int solve_1(int[] exercises, int E){
        int n = exercises.length;
        Arrays.sort(exercises);
//        if(E < exercises[n-1]) return -1;
        int cnt=0;
        int ans=0;
        int i=n-1; // will go from end of the sorted array as i have to perform min exercise and in this must drain more
        // energy by performing tough exercises!
        while(E>0 && i>=0){
            E -= exercises[i];
            if(E<=0) break;
            cnt++;
            ans++;
            if(cnt == 2){
                cnt = 0;
                i--;
            }
        }
        if(E>0) return -1;
        return ans;
    }
}
