package Contest_CC_CF_LC_CSES.CSES.gcd_pairs;

import Contest_CC_CF_LC_CSES.A;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class gcdExactlyK_generalised {
    static void main() {
        int[] arr = {2, 3, 4};
        int k = 1;
        int M = 4; // max value in array

        System.out.println(countPairsExactlyK(arr, k, M));
    }

    static long countPairsExactlyK(int[] arr, int k, int M){
        List<Integer> reduced = new ArrayList<>();
        for(int x: arr){
            if(x%k==0) reduced.add(x/k);
        }

        if(reduced.size()<2) return 0; // can't form any pairs

        // run exactly the same steps co-prime pairs count
        int newM = M/k; // max possible val after div by k

        int[] freq = new int[newM+1];
        for(int x: reduced){
            freq[x]++;
        }

        int[] cnt = new int[newM+1];
        for(int d=1; d<=newM; d++){
            for(int mult=d; mult<=newM; mult+=d){
                cnt[d] += freq[mult];
            }
        }

        int[] mu = computeMobius(newM);

        int[] g = new int[newM+1];
        long cntPairs = 0;
        for(int i=1; i<=newM; i++){
            g[i] = cnt[i]*(cnt[i]-1)/2;
            cntPairs += ((long)g[i]*mu[i]);
        }
        return cntPairs;
    }

    static int[] computeMobius(int n){
        int[] mu = new int[n+1];
        mu[1] = 1; // base case
        boolean[] isComposite = new boolean[n+1];
        ArrayList<Integer> primes = new ArrayList<>();

        for(int i=2; i<=n; i++){
            if(!isComposite[i]){
                primes.add(i);
                mu[i] = -1; // primes has exactly one distinct prime factor, so -1^1=-1
            }

            for(int p: primes) {
                if ((long)i * p > n) break;
                isComposite[i * p] = true;

                if (i % p == 0) { // does p already divide i?
                    mu[i * p] = 0; // squared appear and it becomes 0 as per rule or mobius function
                    break; // because smallest prime factor has repeated then every later product also contain repeated
                    // prime, no need to continue
                } else {
                    mu[i * p] = -mu[i];
                }
            }
        }
        return mu;
    }
    /*The key insight 🌟

The algorithm doesn't factor every number separately.
Instead, it builds larger numbers from smaller ones:

    If you're multiplying by a new prime, flip the sign.
    If you're multiplying by a prime already present, set the value to 0.

This is why the linear sieve runs in O(n) time instead of factoring each number individually.*/
}
