package HWI_Solid_prep.HWI_MockQues;

// this passing 4/10 but still concept building is just WOWOWOWOWOW :)

// HWI MT Q1:
/*## Complete Problem Statement
---
# Binary Block Arrangement
**Difficulty:** Easy | **Topic:** Blocks
---
### Problem Description

You are given an integer **N**, an array **A** of length N, and an array **B** of length N.

You have **N blocks of 1 bits** with sizes **A[1...N]**, and **N blocks of 0 bits** with sizes **B[1...N]**.
You must arrange these blocks so that **no two adjacent blocks have the same bit value**.

Among all possible valid arrangements, find the **maximum possible number** obtained by interpreting the
resulting binary string as a **decimal integer**. Print the result modulo **10^9 + 7**.
---
### Notes
- All blocks in A and B must be used **exactly once**
- Blocks must **strictly alternate** between 0 and 1
- The arrangement may **start with either** block type
- The objective is to **maximize the decimal value** of the final binary string

---

### Input Format
```
Line 1: N
Line 2: N space-separated integers (array A)
Line 3: N space-separated integers (array B)
```

### Output Format
```
Single integer — maximum decimal value mod (10^9 + 7)
```

---

### Constraints
- 1 ≤ N ≤ 10^5
- 1 ≤ A[i] ≤ 10^6
- 1 ≤ B[i] ≤ 10^6

---

### Sample Test Cases

**Case 1**
```
Input:        Output:
1             6
2
1
```
**Explanation:**
N=1, A=[2], B=[1]. The best arrangement is A[0] then B[0], giving binary string `110`, which equals **6** in decimal.

---

**Case 2**
```
Input:        Output:
2             20
1 1
1 2
```
**Explanation:**
A desc: [1,1], B asc: [1,2]
String formed: `1` `0` `1` `00` = **10100** = 20 in decimal.

---

**Case 3**
```
Input:        Output:
3             868
2 1 2
1 2 2
```
**Explanation:**
A desc: [2,2,1], B asc: [1,2,2]
String formed: `11` `0` `11` `00` `1` `00` = **1101100100** = 868 in decimal.

---

### Function Signature (Java)
```java
public static int ans(int N, List<Integer> A, List<Integer> B)
```
*/

// My mistakes not using MOD anywhere, rush coding,
import java.util.*;

class BinaryBlockArrangement {
    public static final int MOD = 1000000007;
    // cal powers upto maxK
    private static void power(int base, int maxk, List<Long> lookup){
        // power of 2 upto maxK
//        for(int i=0; i<=maxk; i++){
//            // binary exponentiation, iterative approach
//            int exp = i;
//            int b = base;
//            long ans = 1;
//            while(i>0){
//                if(exp % 2 == 1){
//                    exp -= 1;
//                    ans = ans * b;
//                } else {
//                    exp /= 2;
//                    b = b * b;
//                }
//            }
//            lookup.add(ans);
//        }
        // tbh there is no need of binary exponentiation,
        // must read it: https://chatgpt.com/s/t_69c1052225408191b8748b9ed059ba6a
        // https://chatgpt.com/s/t_69c1056ccf20819181a29a790dc24c09
        // power of 2 we have to calc
        // prevVal * 2 will give us the value and must use MOD
        // NOTE: using ArrayList<Long> is slightly slower
        //👉 Prefer: long[] pow2
        lookup.add(1L);
        for(int i=1; i<=maxk; i++) {
            long val = (lookup.get(i - 1) * 2) % MOD;
            lookup.add(val);
        }
    }
    public static int ans(int N, List<Integer> A, List<Integer> B) {
        // Write your code here, real battle
        int maxA = -1;
        int maxB = -1;
        for(int i=0; i<A.size(); i++){
            maxA = Math.max(A.get(i), maxA);
        }
        for(int i=0; i<B.size(); i++){
            maxB = Math.max(B.get(i), maxB);
        }

        int maxK = Math.max(maxA, maxB);
        List<Long> lookup = new ArrayList<>(); // 🔴🔴🚫🚫
        // AREE array use kroo...🟢🟢📌📌 pls jism size ka pta hoo maxK+1
        power(2, maxK, lookup);

        // actual calc time:
        // sort A in desc and B in asc for getting maximum dec number
        Collections.sort(A, Collections.reverseOrder());
        Collections.sort(B);

        long num = 0;
        for(int i=0; i<N; i++){
            // appending 1s and 0s alternatively, how? -> https://chatgpt.com/s/t_69c105de4728819198717a9e5106f963
            int ones = A.get(i);
            int zeros = B.get(i);

            long powOnes = lookup.get(ones);
            long powZeroes = lookup.get(zeros);

            // append A[i] 1s, like append k 1s or append k 0s:
            num = ((num * powOnes) % MOD + (powOnes-1+MOD) % MOD) % MOD;
            // append B[i] 0s
            num = (num * powZeroes) % MOD;
        }
        return (int)num;
    }
/*
💥 FINAL FORMULA
Append k ones:
num = num * (2^k) + (2^k - 1)
Append k zeros:
num = num * (2^k)

these are formed of shift left and add the block 0s or 1s
rem: a << x means a * 2^x, the same used in above formulas :)
Whenever you see:
👉 “append something to right”
Your brain should go:
SHIFT + ADD

📦 Different cases
Append k zeros:
num = num * 2^k
Append k ones:
num = num * 2^k + (2^k - 1)
Append number a: used in LC 3309
num = num * 2^len(a) + a

GOT CONFUSED WITH USING MOD when and where: GOLDEN RULE: remember forever!! :)
| Operation | Formula               |
| --------- | --------------------- |
| Multiply  | `(a * b) % mod`       |
| Add       | `(a + b) % mod`       |
| Subtract  | `(a - b + mod) % mod` |
*/
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List<Integer> A = new ArrayList<>();
        List<Integer> B = new ArrayList<>();
        for (int i = 0; i < N; i++) A.add(sc.nextInt());
        for (int i = 0; i < N; i++) B.add(sc.nextInt());
        System.out.println(ans(N, A, B));
    }
}
