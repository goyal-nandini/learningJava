package HWI_Solid_prep.HWI_MockQues;

// seems passing 10/10 acc to a peer from the community

import java.util.*;

class BinaryBlockII {
    static final long MOD = 1_000_000_007L;

    static long power(long b, long e, long mod) {
        long r = 1;
        b %= mod;
        for (; e > 0; e >>= 1, b = b * b % mod)
            if ((e & 1) == 1) r = r * b % mod;
        return r;
    }

    static long solve(int n, List<Long> A, List<Long> B) {
        // Max-heap for A → largest 1-blocks first (more significant positions)
        PriorityQueue<Long> maxA = new PriorityQueue<>(Collections.reverseOrder());
        maxA.addAll(A);

        // Min-heap for B → smallest 0-blocks first (minimize wasted positions)
        PriorityQueue<Long> minB = new PriorityQueue<>(B);

        long result = 0;

        for (int i = 0; i < n; i++) {
            // Append block of 'a' ones: shift left by a, then add (2^a - 1)
            long a = maxA.poll();
            long p2a = power(2, a, MOD);
            result = (result * p2a % MOD + (p2a - 1 + MOD)) % MOD;

            // Append block of 'b' zeros: just shift left by b
            long b = minB.poll();
            long p2b = power(2, b, MOD);
            result = result * p2b % MOD;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<Long> A = new ArrayList<>();
        for (int i = 0; i < n; i++)
            A.add(sc.nextLong());

        List<Long> B = new ArrayList<>();
        for (int i = 0; i < n; i++)
            B.add(sc.nextLong());

        System.out.println(solve(n, A, B));
    }
}