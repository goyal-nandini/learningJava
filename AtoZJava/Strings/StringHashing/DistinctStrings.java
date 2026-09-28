package Strings.StringHashing;

// NOTE: COLLISION HANDLING IS NOT DONE YET
// edit: i'd done it now!!
// check this https://chatgpt.com/s/t_69f463ede7e081918845ac678ec6419f

// Q: Search for duplicate strings in an array of strings
// https://cp-algorithms.com/string/string-hashing.html#search-for-duplicate-strings-in-an-array-of-strings
// https://www.youtube.com/watch?v=JEOj8U54Cek&t=2s => get count distinct strings
/*understand the problem first:
*         0       1      2      3     4
* given: ["abc", "xyz", "abc", "pqr", "xyz"]
* goal: [ [0,2], [1,4], [3] ] group duplicate strings
* que can be count distinct strings
* lets implement it and see what's tc is by using hashing on strings
* */

/*tc and sc:
| Approach                  | TC               | SC   | Notes           |
| ------------------------- | ---------------- | ---- | --------------- |
| Hash + collision handling | O(n·m)           | O(n) | Best practical  |
| Hash + sorting            | O(n·m + n log n) | O(n) | Slightly slower |
| Bad hash (your current)   | ❌                | ❌    | Breaks logic    |

* */

import java.util.*;

public class DistinctStrings {
    static int p = 31;
    static int mod = 1000000007;
    public static void main(String[] args) {
//        String[] arr = {"abc", "xyz", "abc", "pqr", "xyz"};

//        String[] arr = {"ab", "cd", "ef", "gh"}; // to test collision handling by modifying hash function
        String[] arr = {"apple", "ant", "banana", "bat"};

//        List<List<Integer>> result = groupIdenticalStrings(arr);
        List<List<Integer>> result = groupIdenticalStrings_handling_collsions(arr);

        for (List<Integer> group : result) {
            System.out.println(group);
        }
    }

    // string compare manually => O(m) m, string length
    // optimized version use of string hash
    // same hash → same group
    // if wanna make it collision safe we have to use hashmap ?! lets do it in two steps, i'll write code with mind in it

    // you first bucket by hash, then resolve collisions by comparing actual strings inside each bucket.

    private static List<List<Integer>> groupIdenticalStrings_handling_collsions(String[] s){
        int n = s.length;

        // step1 hash -> indices
        // same hash jinn ka bhi hoga vo indexes accumulate hongi hash value k saamn
        Map<Long, List<Integer>> map = new HashMap<>();

        for(int i=0; i<n; i++){
            long h = calcHash(s[i]);
            if(!map.containsKey(h)){
                map.put(h, new ArrayList<>());
            }
            map.get(h).add(i);
        }

        List<List<Integer>> resGroups = new ArrayList<>();

        // ism kahin hash value ka use hi ni hua...?! step2 m too hash value nikla ka kya mtlb...???!!!
        // yr ans: https://chatgpt.com/s/t_6a09ae14a554819191e42334916d7d00

        // step2 resolve collisions using actual string
        for(List<Integer> group: map.values()){
            Map<String, List<Integer>> realgrps = new HashMap<>();
            for(int idx: group){
                if(!realgrps.containsKey(s[idx])){
                    realgrps.put(s[idx], new ArrayList<>());
                }
                realgrps.get(s[idx]).add(idx);
            }

//            resGroups.addAll(realgrps.values());
            for (List<Integer> grp : realgrps.values()) {
                resGroups.add(grp);
            }
        }

        return resGroups;
    }
    private static List<List<Integer>> groupIdenticalStrings(String[] s){
        int n = s.length;

        List<long[]> hashes = new ArrayList<>(); // pair (hash, index)

        for(int i=0; i<n; i++){
            long h = calcHash(s[i]);
            hashes.add(new long[]{h, i});
        }

        // sort by hash value
//        hashes.sort(Comparator.comparingLong(a -> a[0]));

        hashes.sort((a, b) -> Long.compare(a[0], b[0]));

        List<List<Integer>> groups = new ArrayList<>();
        groups.add(new ArrayList<>());
        groups.get(0).add((int)hashes.get(0)[1]);  // add first element

        for(int i=1; i<n; i++){
            if(hashes.get(i)[0] != hashes.get(i-1)[0]){
                groups.add(new ArrayList<>());
            }
            groups.get(groups.size()-1).add((int)hashes.get(i)[1]); // storing indexes
        }

        return groups;
    }

    // (FORCED COLLISION ⚠️)
    static long calcHash2(String s) {
        return s.length();  // BAD hash (forces collision)
    }

    // (PARTIAL COLLISION)
    static long calcHash(String s) {
        return s.charAt(0); // hash only first char
    }



    // simple polynomial hash function, simple sober :) don't afraid try try focuss
    private static long calcHash1(String s){
        long hash = 0;
        long power = 1;

        for(int i=0; i<s.length(); i++){
            int val = s.charAt(i)-'a'+1;
            hash = (hash + val * power) % mod;
            power = (power * p) % mod;
        }
        return hash;
    }

    // EXTRAAA IF ANYTIME NEEDEDDD got inspo from doing this Distinct Substring in String problem
    static int p1 = 31;
    static long mod1 = 1000000007L;
    static int p2 = 37;
    static long mod2 = 1000000009L;
    // 🔹 Double hash computation
    private static long[] computeDoubleHash(String s) {
        long hash1 = 0, hash2 = 0;
        long power1 = 1, power2 = 1;

        for (int i = 0; i < s.length(); i++) {
            int val = s.charAt(i) - 'a' + 1;

            hash1 = (hash1 + val * power1 % mod1) % mod1;
            hash2 = (hash2 + val * power2 % mod2) % mod2;

            power1 = (power1 * p1) % mod1;
            power2 = (power2 * p2) % mod2;
        }

        return new long[]{hash1, hash2};
    }

    // 🔹 Combine safely into one key
    private static long combineHash(long h1, long h2) {
        return (h1 << 32) ^ h2;
    }
}
