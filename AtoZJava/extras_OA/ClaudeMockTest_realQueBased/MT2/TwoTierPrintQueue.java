package extras_OA.ClaudeMockTest_realQueBased.MT2;
import java.util.*;

// took 70 min - only 1 solved - tried 3/4... now time to check and make progress a bit on sliding window

public class TwoTierPrintQueue {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] d = new int[n];
        int[] p = new int[n];

        for(int i=0; i<n; i++){
            d[i] = sc.nextInt();
            p[i] = sc.nextInt();
        }

        long ans = solve(n, d, p);
        System.out.println(ans);
    }

    // shortest job first - brute force se hi lg rha hai - lets do that,
    // else may be constraints beats that...

    // Minimize sum of waiting times → Shortest Processing Time First → ascending duration.

    private static long solve(int n, int[] d, int[] p){
        int cntP = 0, cntStd = 0;
        for(int i=0; i<n; i++){
            if(p[i]==1) cntP++;
            else cntStd++;
        }

        int[] jobP = new int[cntP];
        int[] jobStd = new int[cntStd];

        int k=0, j=0;
        for(int i=0; i<n; i++){
            if(p[i] == 1){
                jobP[k] = d[i];
                k++;
            } else {
                jobStd[j] = d[i];
                j++;
            }
        }

        Arrays.sort(jobP);
        Arrays.sort(jobStd);

        long sum = 0;
        long wait = 0; // wait means current time/accumulated duration of jobs already printed
        // high priority jobs
        for(int i=0; i<cntP; i++){
            sum += wait;
            wait += jobP[i];
        }

        // standard jobs
        for(int i=0; i<cntStd; i++){
            sum += wait;
            wait += jobStd[i];
        }

        return sum;
    }
}
