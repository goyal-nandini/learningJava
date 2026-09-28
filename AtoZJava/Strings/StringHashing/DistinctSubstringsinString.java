package Strings.StringHashing;

// https://www.geeksforgeeks.org/dsa/count-number-of-distinct-substring-in-a-string/
// https://cp-algorithms.com/string/string-hashing.html#determine-the-number-of-different-substrings-in-a-string

// Determine the number of different substrings in a string¶
// Problem: Given a string s of length n consisting only of lowercase English letters, find the number of different
// substrings in this string.

// ohh man in GFG it hits collision so have to use double hashing :)

import java.util.HashSet;
import java.util.Set;

public class DistinctSubstringsinString {
    public static void main(String[] args) {
        // simplest to do it now:)

        String s = "ababa";

        System.out.println(count_brute(s));
        System.out.println(count(s));
    }
    // brute: gen all subtring and put in set
    private static int count_brute(String s){
        int n = s.length();
        Set<String> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = i; j < n; j++) {
                sb.append(s.charAt(j));
                set.add(sb.toString());
            }
        }
        return set.size();
    }
    // tc
    // O(n^2) substrings
    // Each insert = O(n)
    // → O(n^3)
    // sc: O(n^3) n^2 substrings and total substrings O(n) => O(n^3)

    // optimal: use rolling hash and put in set
    private static int count(String s){
        int n = s.length();
        int p = 31;
        int mod = 1000000007;
        HashSet<Long> set = new HashSet<>();
        for(int i=0; i<n; i++){ // O(n)
            long hash = 0;
            long power = 1;

            for(int j=i; j<n; j++) { // O(n)
                hash = (hash + ((s.charAt(j) - 'a' + 1) * power) % mod) % mod;
                power = (power * p) % mod;

                set.add(hash); // O(1)
            }
        }
        return set.size();
    }
    // tc:
    // O(n^2)
    // sc: O(n^2) all substrings unique O(n^2) hashes

    // AC with collision handling be using double hashing
    // tc:
    // O(n^2)
    // sc: O(n^2) all substrings unique O(n^2) hashes
    public static int countSubs(String s) {
        // correct code for handling collision, using double hashing

        int n = s.length();

        int p1 = 31;
        long mod1 = 1000000007L;
        int p2 = 37;
        long mod2 = 1000000009L;

        HashSet<Long> set = new HashSet<>();

        for(int i=0; i<n; i++){
            long hash1 = 0, hash2 = 0;
            long power1 = 1, power2 = 1;

            for(int j=i; j<n; j++){
                int val = s.charAt(j)-'a'+1;
                hash1 = (hash1+(val*power1)%mod1) % mod1;
                hash2 = (hash2+(val*power2)%mod2) % mod2;

                power1 = (power1 * p1) % mod1;
                power2 = (power2 * p2) % mod2;

                // String key = hash1 + "#" + hash2; // TLE
//                long key = hash1 * 1000003L + hash2; // Multiplication by a large prime, AC
                 long key = (hash1 << 32) ^ hash2; // combine both hashes, AC => this means hash1*2^32 then xor with hash2


                set.add(key);

            }
        }
        return set.size();
    }

/*A question:
* 🔥 Final question (think deeply)

If I store:
long key = hash1 + hash2;

👉 Will this work?

Don’t guess — reason it out 🚀
*
* No — that won’t work reliably ❌
“Maybe” here means you’ll silently get wrong answers.

🔴 Why hash1 + hash2 is a bad idea

You’re collapsing two values into one like this:

long key = hash1 + hash2;

👉 This is many-to-one mapping

🔥 Collision example (very important)
hash1 = 5, hash2 = 10  → key = 15
hash1 = 6, hash2 = 9   → key = 15  ❌

👉 Different pairs → same key
👉 You just destroyed the benefit of double hashing

🧠 What you actually need

👉 A unique pairing method

🟢 Correct ways
    ✅ Method 1 (best & clean)
    long key = (hash1 << 32) | hash2;

    👉 Why it works:

    hash1 occupies upper 32 bits
    hash2 occupies lower 32 bits
    No overlap → no mixing
*
    ✅ Method 2 (your approach — acceptable)
    long key = hash1 * 1000003L + hash2;

    👉 Works because:
    spreads values
    reduces collisions a lot

    BUT:
    👉 still theoretically unsafe*/
}
