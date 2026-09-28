package Trees.SegmentTree;
// PENDING: code part, idea/journey for function calculation is left
// HWI MT Q2:
/*## Complete Problem Statement

**You are given an array A of N integers and Q queries. Each query is either:**

- **Update(i, x):** Set A[i] = x.
- **Query(L, R):** Find **maximum value M** in [L, R]. Compute the **Recamán distance**: starting from M, how many
steps until the Recamán sequence revisits a value or exceeds 10^6? (Recamán: R(0)=0, R(n)=R(n-1)−n if positive and
unvisited, else R(n-1)+n). Return **steps × multiplier**, where multiplier = **17** if M is a **fortunate number**
(smallest m>1 where p#+m is prime, for some primorial p#), else **1**.


**Find the sum of all query results.**

---

### Notes:
- If neither a repeat nor a value exceeding **10^6** occurs within **5000** steps, terminate at **5000**.
- Only Fortunate numbers ≤ 10000 (predefined list) are considered.
- **Recamán Sequence (in simple words):** Start from 0. At step n: Try to subtract n from the previous number. If the
result is **positive** and has **never appeared before**, accept it. Otherwise, **add** n instead. You keep generating
numbers this way.
- **Recamán Distance:** For a number M: Start the Recamán process from M. Count how many steps it takes until a number
repeats, **or** the value becomes greater than **1,000,000**, **or** you reach **5000 steps** (stop even if nothing
happened). That step count is called the **Recamán distance**.
- **Fortunate Number:** A Fortunate number is a special number m > 1 such that when you add it to a product of the first
few prime numbers (a primorial p#), the result is **prime**. Only Fortunate numbers ≤ 10000 are considered.

---

### Input Format:
- The first line contains an integer **N**.
- Each of the next N lines contains an integer describing **A[i]**.
- The next line contains an integer **Q**, denoting the number of queries.
- Each of the next Q lines contains **3 space-separated integers** describing a query:
  - **[0, i, x]** → Update query
  - **[1, L, R]** → Range query

---

### Constraints:
- 1 ≤ N ≤ 10^5
- 1 ≤ A[i] ≤ 10^4
- 1 ≤ Q ≤ 50,000
- 1 ≤ Queries[i][j] ≤ 10^5

---

### Function Signatures (given):
```java
public static int getSum(/** segment tree params **)  // to be implemented

public static int getSumOfAllQuery(int N, List<Integer> A, int Q,
                                   List<List<Integer>> Queries)  // to be implemented
```

        ---

        ### Sample Test Cases:

        **Test 1:**
        - N=10, array: [7373, 5968, 3638, 47, 8385, 8219, 59, 8319, 9100, 9750]
        - Q=6, queries: 0 6 8951, 1 1 7, 1 2 5, 1 6 8, 0 4 2190, 1 2 6
        - **Expected Output: 1233**

        **Test 2:**
        - N=10, array: [1308, 398, 8265, 5321, 9564, 4620, 9238, 3740, 1550, 8924]
        - Q=10, queries: `1 0 0`, `0 1 3988`, `1 6 8`, `1 8 9`, `1 5 9`, `1 0 7`, `1 7 8`, `1 3 4`, `1 4 6`, `0 7 8327`
        - **Expected Output: 847**

        **Test 3:**
        - N=6, array: [9999, 8888, 7777, 6666, 5555, 4444]
        - Q=4, queries: `1 0 5`, `1 2 4`, `0 1 3`, `1 1 5`
        - **Expected Output: 847*
*/
import java.io.*;
import java.util.*;
import java.lang.Math;
import static java.util.stream.Collectors.toList;

// pattern recognition + implementation speed

class SegmentTree {
    // build your seg tree here
    private int[] tree;
    private int n;

    public SegmentTree(int[] arr){
        n = arr.length;
        tree = new int[4 * n];
        buildTree(arr, 0, 0, n-1); // arr, idx, start, end
    }

    private void buildTree(int[] arr, int idx, int start, int end){
        if(start == end){
            tree[idx] = arr[start];
        } else {
            int mid = (start+end)/2;
            // left
            buildTree(arr, 2*idx+1, start, mid);
            // right
            buildTree(arr, 2*idx+2, mid+1, end);
            // merge
            tree[idx] = Math.max(tree[2*idx+1], tree[2*idx+2]);
        }
    }
    public int query(int l, int r){
        return query(0, 0, n-1, l, r);
    }

    private int query(int idx, int start, int end, int qsi, int qei){
        // 3 cases

        // completely inside
        if(start >= qsi && end <= qei){
            return tree[idx];
        }
        // completely outside
        else if(end < qsi || start > qei) {
            return 0;
        }
        // overlapping
        else {
            int mid = (start+end)/2;

            int left = query(2*idx+1, start, mid, qsi, qei);
            int right = query(2*idx+2, mid+1, end, qsi, qei);

            return Math.max(left, right);
        }
    }

    public void update(int index, int val){
        update(0, 0, n-1, index, val);
    }

    private void update(int idx, int start, int end, int i, int val){
        if(start == end){
            tree[i] = val;
            return;
        }

        int mid = (start+end)/2;

        if(idx <= mid){
            update(2*idx+1, start, mid, i, val);
        } else {
            update(2*idx+1, mid+1, end, i, val);
        }

        tree[idx] = Math.max(tree[2*idx+1], tree[2*idx+2]);
    }
}

public class RecamannDistance {

    public static long getSumOfAllQuery(int N, List<Integer> A, int Q,
                                        List<List<Integer>> Queries) {
        // Write your code here


        return 0L;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = Integer.parseInt(scan.nextLine().trim());

        List<Integer> A = new ArrayList<>(N);
        for (int j = 0; j < N; j++) {
            A.add(Integer.parseInt(scan.nextLine().trim()));
        }

        int Q = Integer.parseInt(scan.nextLine().trim());

        List<List<Integer>> Queries = new ArrayList<>();
        for (int i = 0; i < Q; i++) {
            Queries.add(
                    Arrays.asList(scan.nextLine().trim().split(" "))
                            .stream()
                            .map(s -> Integer.parseInt(s))
                            .collect(toList())
            );
        }

        long result = getSumOfAllQuery(N, A, Q, Queries);
        System.out.println(result);
    }
}