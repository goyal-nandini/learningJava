Here is a complete, simplified guide tailored specifically to your edge-case weaknesses: **guards, overflow, infinity constants, memory/stack limits, and choosing between Memoization vs. Tabulation**.

## 1. Dynamic Programming Choice Matrix

| Constraint Parameter | Typical Value | Can Use Memoization? | Must Use Tabulation? | Notes / Safety Rule |
| --- | --- | --- | --- | --- |
| **Max Recursion Depth** | $N \le 10^3$ | Yes | Optional | Stack depth $\approx 10^3$ is completely safe in Java/C++. |
| **Max Recursion Depth** | $N \ge 10^4$ to $10^5$ | **No** (High Risk) | **Yes** | Standard JVM stack size (~1MB) defaults to ~10,000 frames. Deep 1D DP *will* trigger `StackOverflowError`. |
| **Grid Traversal ($N \times M$)** | $N, M \le 10^3$ | Yes | Optional | Max stack depth is $N + M \approx 2000$ (not $N \times M$), so recursion depth stays safe! |
| **State Table Size** | $N \times M \ge 10^8$ | — | **Space-Optimized Tabulation** | Standard memory limit (256 MB) permits $\approx 3 \times 10^7$ `long` values. Keep only 2 rows or a 1D array. |

---

## 2. Choosing Infinity Constants: `1e9` vs `1e15` vs `1e18`

When taking the `Math.min()` of path costs, setting an uninitialized variable to $0$ breaks your logic. You must initialize cost states to "Infinity."

| Infinity Constant | Value | When to Use | Danger / Overflow Warning |
| --- | --- | --- | --- |
| `(int) 1e9` / `10^9` | $1,000,000,000$ | Use for **32-bit Integer DP** (`int[]`). Fits inside `Integer.MAX_VALUE` ($2.14 \times 10^9$). | Safe to add two positive `1e9` values ($1e9 + 1e9 = 2e9 \le \text{Integer.MAX\_VALUE}$). |
| `Integer.MAX_VALUE` | $2.14 \times 10^9$ | **Avoid in DP!** | If you do `Integer.MAX_VALUE + cost`, it immediately wraps around to negative values! |
| `(long) 1e15` | $1,000,000,000,000,000$ | **Best Default for `long[]` DP** | Big enough to act as infinity, small enough that `1e15 + cost` will **never overflow** 64-bit `Long.MAX_VALUE`. |
| `(long) 1e18` | $1,000,000,000,000,000,000$ | Use when values approach $10^{18}$ | Fits in `long`, but adding numbers directly to it risks reaching `Long.MAX_VALUE` ($9.22 \times 10^{18}$). |
| `Long.MAX_VALUE` | $9.22 \times 10^{18}$ | **Avoid in DP!** | `Long.MAX_VALUE + 1` wraps around to a negative value, breaking `Math.min()`. |

### Golden Rule for Infinity

For any minimization problem, **use `long` and set `INF = (long) 1e15**`. It prevents integer overflow and handles costs cleanly up to $10^{14}$.

---

## 3. TLE (Time) & MLE (Memory) Reference Rules

### 1. Time Limit Exceeded (TLE)

* **Standard Time Limit:** 1.0 second $\approx 10^8$ operations in C++, $\approx 2 \times 10^7$ to $5 \times 10^7$ operations in Java.
* **Calculation:** If $N = 10^5$ and your DP state takes $O(1)$ transitions, $10^5$ operations run in **$< 0.01$ seconds** (Passes).
* If your DP state is $O(N^2)$, $(10^5)^2 = 10^{10}$ operations $\rightarrow$ **TLE**.

### 2. Memory Limit Exceeded (MLE)

* **Standard Memory Limit:** 256 MB.
* **Primitive Byte Sizes:**
* `int`: 4 bytes
* `long`: 8 bytes


* **Array Limit Calculations:**
* `int[10^7]` $\approx 40 \text{ MB}$ (Passes)
* `long[10^7]` $\approx 80 \text{ MB}$ (Passes)
* `long[10^8]` $\approx 800 \text{ MB}$ (**MLE!**)


* **Rule:** If a 2D table `long[N][M]` exceeds $3 \times 10^7$ cells, reduce space to 1D or 2-row rolling arrays.

---

## 4. Cheat Sheet: Boundary Guards & Casting Rules [que2 for MT1 reference :)]

### Guard Formula Rule

Whenever transitioning from state `i` to `i + step` in DP:


$$\text{Guard Condition: } \mathbf{i + \text{step} \le N}$$

* `i + step == N`: End boundary state (corridor fully covered).
* `i + step > N`: Invalid state (overhangs array bounds).

### Type Casting

* `(int) st.nval`: Necessary when using Java `StreamTokenizer` because `nval` reads inputs as `double`.
* `(long) 1e15`: Necessary because `1e15` is a double literal in Java. Double to long conversion requires explicit casting or scientific long formatting: `1_000_000_000_000_000L`.

---