package Trees.BIT_FenwickTree;
/* 🟢🟢🟢
🧠 Mental Model (Final Fix)
Think:
update → go UP the tree
query  → go DOWN the tree

Direction depends on:
i += LSB(i)   → upward
i -= LSB(i)   → downward

That’s the entire data structure.
⚠️ Common Beginner Mistakes (you WILL hit these)

1️⃣ Forgetting index + 1 shift
2️⃣ Using int instead of long (CSES → overflow)
3️⃣ Updating wrong direction
4️⃣ Mixing 0-based and 1-based logic

🟢🟢🟢
👉 Fenwick Tree is intentionally 1-based.
Not tradition. Not laziness. Mathematics + bit manipulation require it.
Let’s prove it instead of saying “competitive programmers do this”.
1️⃣ The REAL reason: i & -i breaks with 0-index

Fenwick relies on: i & -i

which extracts the lowest set bit.
This only works cleanly when indices start from 1.
Look at index = 0

Binary:
0 = 00000

Now:
0 & -0 = 0

So update loop becomes:

while(i <= n){
    i += i & -i;   // adds 0
}

💀 Infinite loop.

That alone already kills 0-based Fenwick.

🟢🟢🟢
I love that you’re digging into the **logn** part — that’s the heart of why Fenwick Trees are so efficient.
Let’s break it down clearly:

---

### 🔹 Why updates/queries are O(logn)
- In a Fenwick Tree, each index `i` is responsible for a block of elements whose size is the
lowest set bit of `i` (the `i & -i` trick).
- When you **update**, you climb upward:
  `i += (i & -i)`
  → each step jumps to the next node that covers a larger block.
  → the number of jumps is proportional to the number of bits in `n` → **logn**.
- When you **query (prefix sum)**, you climb downward:
  `i -= (i & -i)`
  → each step jumps to the parent node covering a smaller block.
  → again, at most logn steps.

---

### 🔹 Intuition
Think of `n` in binary:
- Each update/query touches at most one node per bit in `n`.
- For `n = 200000`, binary length ≈ 18 bits.
- So each operation takes ≤ 18 steps.

---

### 🔹 Example
Suppose `n = 8` (binary `1000`):
- Update at index 3 (`011`):
  - Step 1: update node 3
  - Step 2: jump to 4 (`100`)
  - Step 3: jump to 8 (`1000`)
  → 3 steps = log₂(8).
- Query at index 7 (`111`):
  - Step 1: add node 7
  - Step 2: jump to 6 (`110`)
  - Step 3: jump to 4 (`100`)
  → 3 steps = log₂(8).

---

### 🔹 Formal Complexity
- **Update:** O(logn)
- **Prefix sum query:** O(logn)
- **Range update (two updates):** O(logn) // in CSES problem "range update queries"
- **Point query (arr[k] + prefixSum(k)):** O(logn) // in CSES problem "range update queries"

---

✨ So the “logn” comes directly from the binary representation of indices — each step clears one set bit, and there are at most log₂(n) bits.

---
*/
public class BIT {
    private int[] tree;
    private int n;

    BIT(int[] arr){
        n = arr.length;
        tree = new int[n+1]; // 0-based arr with 1-based tree
        buildBIT(arr);
    }

    public void buildBIT(int[] arr){
        for(int i=0; i<arr.length; i++){
            update(i, arr[i]);
        }
    }
    
    public void update(int idx, int val){
        int i= idx+1; // shift to 1-based
        while(i<=n) {
            tree[i] += val;
            // those 3 steps 
            i += (i & -i);
        }
    }
    
    // sum from index 0 to idx in array
    public int prefixSum(int idx){
        int i = idx+1; // shift to 1-based acc to tree[as it has cal acc to 1-based values of arr]
        int sum = 0;
        while(i>0){
            sum += tree[i];
            i -= (i & -i); // remember, we jumped to get parent node in the tree
        }
        return sum;
    }
    
    // range sum query, still this BIT mainly for prefix sum as video told, 
    // but here chatgpt telling to get range sum too
    public int rangeSum(int left, int right){
        if(left == 0) return prefixSum(right); // just sum from 0 to right
        return prefixSum(right) - prefixSum(left-1);
        // arreee we did it na... prefix sum precomputation :)
    }

    public void printBIT() {
        for(int i = 0; i <= n; i++) {
            System.out.print(tree[i] + " ");
        }
        System.out.println();
    }
}