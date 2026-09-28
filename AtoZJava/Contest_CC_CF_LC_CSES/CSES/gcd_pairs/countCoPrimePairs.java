package Contest_CC_CF_LC_CSES.CSES.gcd_pairs;

// que: Problem: Given an array of N integers (values up to M), count the number of pairs (i,j) with gcd(a[i], a[j]) = 1 (coprime pairs).
// Brute force is O(N²) — too slow for N=10^5. Here's the O(M log M) approach using everything you just learned.

// with inclusion-exclusion and mobius function: lets do it:

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class countCoPrimePairs {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;

        int[] arr = new int[n];
        int M = 0;
        for(int i=0; i<n; i++){
            in.nextToken();
            arr[i] = (int)in.nval;
            M = Math.max(M, arr[i]);
        }

//        int[] arr = {1,2,3,4,5,6,7,8,9,10};
//        int M = 10; // max value in array
//        int n = arr.length;

        // flow: freq -> cnt -> g -> mu
        // 1. freq[v] = how many times value v appears in arr
        int[] freq = new int[M+1];
        for(int i=0; i<n; i++){
            freq[arr[i]]++;
        }

        // 2. cnt[d] = how many ele divible by d
        int[] cnt = new int[M+1];
        for(int d = 1; d<= M; d++){
            for(int mult = d; mult <= M; mult += d){
                cnt[d] += freq[mult];
            }
        }

        // 3. mu[d] = mobius function - precomputed
        int[] mu = computeMobius(M);

        long coPrimePairs = 0;
        for(int d=1; d<=M; d++){
            long pairsDivisibleByD = (long) cnt[d]*(cnt[d]-1)/2;
            coPrimePairs += mu[d]*pairsDivisibleByD;
        }

        System.out.println("freq:(1-based)");
        for (int i = 1; i <= M; i++)
            System.out.print(freq[i] + " ");

        System.out.println();
        System.out.println("cnt:(1-based)");
        for (int i = 1; i <= M; i++)
            System.out.print(cnt[i] + " ");

        System.out.println();
        System.out.println("mu:(1-based)");
        for (int i = 1; i <= M; i++)
            System.out.print(mu[i] + " ");

        System.out.println(coPrimePairs);
    }
/*What this function needs to doFill an array mu[1..n] where each mu[i] follows the rules you already know:
mu[1] = 1
mu[i] = -1 if i is prime
mu[i] = 0 if i has a squared prime factor
otherwise, mu[i] = -mu[i/p] where p is i's smallest prime factor (flips the sign, one more prime multiplied in)*/

    // Standard sieve to compute mu[1..n]
    public static int[] computeMobius(int n){
        int[] mu = new int[n+1];
        mu[1] = 1; // base case
        boolean[] isComposite = new boolean[n+1];
        List<Integer> primes = new ArrayList<>();

        for(int i=2; i<=n; i++){
            if(!isComposite[i]){ // i is prime
                primes.add(i);
                mu[i] = -1; // a prime itself k=1 distinct prime => (-1)^1=-1
            }

            for(int p: primes){
                if((long) i*p > n) break; // break is product exceed the array size
                isComposite[i*p] = true; // marked as composite
                // This inner loop builds up composite numbers by multiplying i by every prime found so far —
                // this is how the sieve marks non-primes efficiently.

                if(i%p==0){
                    mu[i*p]=0; // p divides i already => i*p has p squared => mu=0
                    break;
                } else {
                    mu[i * p] = -mu[i]; // p is a new prime factor - flips the sign
                }
                /*This last part is the key decision:
                If p already divides i, then i*p contains p twice — so by definition mu(i*p)=0. Example:
                i=2, p=2 → i*p=4=2² → mu[4]=0.
                Otherwise, p is a brand new prime being multiplied in, so it flips the sign relative to mu[i].
                Example: i=2 (mu[2]=-1),
                p=3 (new prime) → i*p=6 → mu[6] = -mu[2] = -(-1) = 1. Matches your earlier answer μ(6)=+1!*/
            }
        }

        return mu;

    }
}
