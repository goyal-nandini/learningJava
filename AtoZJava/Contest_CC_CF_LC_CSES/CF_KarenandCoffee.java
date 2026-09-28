package Contest_CC_CF_LC_CSES;
// AC :)
/*recipes → diffArray() → mark valid positions → prefCount[]
                                                   ↓
                              each query answered in O(1)
 Sure! Let's build up from what you already have.
---
**Step 1: After `diffArray()`, you have this:**
Say N=5, k=2, recipes cover positions such that:
```
position:  1  2  3  4  5
diffArr:   1  2  3  2  1
```
This tells you how many recipes cover each position. ✅ You already have this. [check diffArray function!!]
---
**Step 2: Now mark which positions are "valid" (count >= k):**
```
position:  1  2  3  4  5
diffArr:   1  2  3  2  1
valid?:    0  1  1  1  0     ← diffArr[i] >= k (k=2)
```
---
**Step 3: Build a prefix sum over the valid array:**
```
position:   1  2  3  4  5
valid?:     0  1  1  1  0
prefCount:  0  1  2  3  3    ← running sum of valid positions
```
This tells you: *"how many valid positions exist from position 1 to i?"*
---
**Step 4: Now any query [l, r] is O(1):**
Query: how many valid positions in [2, 4]?
```
prefCount[4] - prefCount[2-1]
= prefCount[4] - prefCount[1]
= 3 - 0
= 3  ✅
```
No loop needed at all!
---
**So the flow is:**
```
recipes → diffArray() → mark valid positions → prefCount[]
                                                    ↓
                              each query answered in O(1)
```
Your code only does the first arrow. The TLE is because the last part (counting valid positions
in a range) still has a loop inside `solve()`. Does this make sense?*/

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StreamTokenizer;

public class CF_KarenandCoffee {
    public static void main(String[] args) {
        FastReader6 fr = new FastReader6();
        PrintWriter out = new PrintWriter(System.out);

        long n = fr.nextLong();
        long k = fr.nextLong();
        long q = fr.nextLong();

        long[][] recipes = new long[(int)n][2];
        long[][] questions = new long[(int)q][2];

        for(int i=0; i<n; i++){
            long l = fr.nextLong();
            long r = fr.nextLong();

            recipes[i] = new long[]{l, r};
        }
        long[] diffArr = diffArray(recipes);
        long[] prefixSum = prefixSumOfvalidTemp(diffArr, k);
        for(int i=0; i<q; i++){
            long a = fr.nextLong();
            long b = fr.nextLong();
            questions[i] = new long[]{a, b};
            long res = solve(questions[i], prefixSum);
            out.println(res);
        }
        out.flush();

    }
    private static long[] diffArray(long[][] recipes){ // buildRecipeCoverageArray
        long n = 200000;
        long[] diff = new long[(int)n+2];
        for(long[] rec: recipes){
            long l=rec[0];
            long r=rec[1];
            diff[(int)l]+=1;
            diff[(int)r+1]-=1;
        }

        for(int i=1; i<diff.length; i++){
            diff[i] = diff[i]+diff[i-1];
        }
        return diff;
    }
    private static long[] prefixSumOfvalidTemp(long[] diffArr, long k){ // buildValidPositionPrefixSum
        long[] prefixSum = new long[diffArr.length];
        for(int i=0; i<prefixSum.length; i++){
            if(diffArr[i]>=k){
                prefixSum[i] = 1;
            } else {
                prefixSum[i] = 0;
            }
        }
        for(int i=1; i<prefixSum.length; i++){
            prefixSum[i] = prefixSum[i]+prefixSum[i-1];
        }
        return prefixSum;
    }
    private static long solve(long[] question, long[] prefixSum){ // countValidInRange
        long l = question[0];
        long r = question[1];
        long res = prefixSum[(int)r]-prefixSum[(int)l-1];
        return res;
    }
}
class FastReader6 {
    StreamTokenizer st;
    public FastReader6() {
        st = new StreamTokenizer(new BufferedInputStream(System.in, 1 << 16));
    }
    int nextInt() {
        try {
            st.nextToken();
        } catch (IOException e) {}
        return (int) st.nval;
    }
    long nextLong() {
        try {
            st.nextToken();
        } catch (IOException e) {} return (long) st.nval;
    }
}
