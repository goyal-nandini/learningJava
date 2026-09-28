package extras_OA.ClaudeMockTest_realQueBased.MT2;

import java.util.Scanner;

/*Yes. **For your current level, the full version is hard.** Don't attack it directly. You need to build the exact chain of patterns behind it.

The important thing is that this question is **not primarily about sign flipping**. It's:
> **Transform operation → gain array → choose up to K non-overlapping subarrays with maximum total gain.**
So practice these LeetCode problems in this order 👇
### 🟢 Level 1 — Build the "flip → gain" intuition

**1. LC 53 — Maximum Subarray** ⭐⭐⭐ ✅
This is the most important prerequisite.
You should be able to immediately think:
```text
Original contribution = a[i]
After flip            = -a[i]
gain = -a[i] - a[i]
     = -2*a[i]
```
Then:
```text
maximum gain = maximum subarray of gain[]
```
If LC 53 isn't automatic for you, do this first.

---

**2. LC 1749 — Maximum Absolute Sum of Any Subarray** ⭐⭐⭐ ✅
This is particularly useful because it trains you to think:
> "What transformation of the subarray gives me the best improvement?"
It is much closer in **thinking style** to this question than many ordinary Kadane problems.
---

### 🟡 Level 2 — Multiple subarrays
**3. LC 1186 — Maximum Subarray Sum with One Deletion** ⭐⭐⭐ ✅
Not the same problem, but excellent for learning:
> "I have an array + one special operation. How does that operation change my DP state?"
Don't worry if the connection isn't obvious initially.

---

**4. LC 1031 — Maximum Sum of Two Non-Overlapping Subarrays** ⭐⭐⭐⭐
🔥 **Very important for your target problem.**
This teaches:
```text
choose subarray 1
+
choose subarray 2
```
while maintaining the **non-overlapping constraint**.
You should definitely solve this before moving on.

---

**5. LC 689 — Maximum Sum of 3 Non-Overlapping Subarrays** ⭐⭐⭐⭐
This is even closer.
You go from:
```text
2 non-overlapping subarrays
```
to:
```text
3 non-overlapping subarrays
```

The important mental transition is:

```text
K = 1
K = 2
K = 3
...
K = arbitrary
```

That's exactly the direction your Signal Polarity problem takes.

---

### 🔴 Level 3 — The actual pattern

**6. LC 3077 — Maximum Strength of K Disjoint Subarrays** ⭐⭐⭐⭐⭐
🚨 **This is the one I want you to eventually solve.**
It is VERY close conceptually to your question.
The problem asks you to select **K disjoint subarrays** and optimize their contribution.
You'll encounter states like:
```text
not currently inside a subarray
currently inside a subarray
```
and transitions for starting/continuing/ending a segment.
This is the DP pattern you need.

---

### Your exact practice ladder

Don't randomly solve 20 questions. Do this:

```text
LC 53
   ↓
LC 1749
   ↓
LC 1031
   ↓
LC 689
   ↓
LC 3077
   ↓
Signal Polarity Amplifier
```

### And here's the important part

**Don't start LC 3077 immediately.**

Given the things you've been struggling with recently, I would expect:

```text
53       → should become comfortable
1749     → should be manageable
1031     → slight struggle
689      → significant struggle
3077     → hard
Signal   → then becomes recognizable
```

That's actually a **good progression**.

Your goal isn't to magically solve the Signal Polarity problem today. Your goal is to train your brain to see:

> **"Ah, we're selecting profitable non-overlapping intervals."**

Once you recognize that transformation, the problem stops looking like a weird "signal flipping" question and starts looking like a familiar DP problem. 🧠

If you want, I can also give you a **10-question LeetCode ladder specifically for "maximum K non-overlapping subarrays"**, from very easy → OA-medium → hard, without dumping solutions on you.
*/

public class SignalPolarityAmplifier {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] a = new int[n];
        for(int i=0; i<n; i++){
            a[i] = sc.nextInt();
        }

        // subarray choose karoo, sliding window se krte hai
        // dp?! states: idx, prevELe, k flips, sum maximum,
    }
    private static int solve(int idx, int prev, int k, int[] arr){

        if(prev < 0 && arr[idx] < 0){
            return -arr[prev]-arr[idx]+solve(idx+1, idx, k--, arr);
        }

        return -1;


    }
}
