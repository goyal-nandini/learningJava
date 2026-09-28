package HWI_Solid_prep.HWI_25_SampleQues;

import java.util.Scanner;
import java.util.Arrays;

// OPTIMIZATION REQUIRED 🔴🔴🔴

/*You’re given an array A of n integers and q queries.
Each query can be one of the following two types:

• Type 1 Query: (1, l, r) - Replace A[i] with
(i-l+1)*A[l] for each index i, where l <= i <= r.

• Type 2 Query: (2, l, r) - Calculate the sum of the
elements in A from index l to index r.

Find the sum of answers to all type 2 queries. Since
answer can be large, return it modulo 109+7.
*/
class Pair{
    int type;
    int l;
    int r;
    Pair(int type, int l, int r){
        this.type = type;
        this.l = l;
        this.r = r;
    }
}
public class E1_HWI_25_TLE {
    final static int MOD = 1000000007;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] A = new int[n];
        for(int i=0; i<n; i++){
            A[i] = sc.nextInt();
        }

        int nq = sc.nextInt();
        Pair[] queries = new Pair[nq];
        for(int i=0; i<nq; i++){
            int x = sc.nextInt();
            int l = sc.nextInt();
            int r = sc.nextInt();
            Pair p = new Pair(x, l, r);
            queries[i] = p;
        }

        // we have to get to each query and cal for type 2 query only
        int ans = 0;
        for(int i=0; i<nq; i++){
            // to do
            int l = queries[i].l;
            int r = queries[i].r;
            int type = queries[i].type;

            int sum = 0;
            // for type 1 queries only
            if(type == 1){
                int base = A[l];
                for(int j=l-1; j<r; j++){
                    A[j] = (int)(((long)(j-l+1) * base) % MOD);
                }
                System.out.println(Arrays.toString(A));
            } else if(type == 2){ // for type 2 queries
                for(int j=l-1; j<r; j++){
                    sum = (sum + A[j]) % MOD;
                }
                System.out.println(sum);
            }
            ans = (ans + sum) % MOD;
        }
        System.out.println("Final ans:" + ans);
    }
}
