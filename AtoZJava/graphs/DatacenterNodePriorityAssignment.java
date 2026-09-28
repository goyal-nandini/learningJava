package graphs;
 /*THE BIG CODE CHALLENGE Q3
 Problem:
 ## Datacenter Node Priority Assignment
---
### Problem Statement
You are managing a distributed datacenter network consisting of **N server nodes** (0-indexed) connected by **M
bidirectional fiber-optic links**. The network may have multiple connected components — nodes within the same component
can communicate with each other, while nodes in different components cannot.
You are given **N capacity values**. You must assign these values to the N nodes — each node receives exactly one value
and each value is used exactly once — to **maximize the total network efficiency**.

---

### Scoring

For each node `i`, define:

- `degree[i]` — the number of fiber-optic links directly connected to node `i`
- `component_size[i]` — the number of nodes in the connected component containing node `i` (including itself)

The **score** of node `i` is:

```
score[i] = component_size[i] + degree[i]
```

> **Special case:** If the graph has no edges (M = 0), every node forms its own component of size 1 with degree 0, so
every node has score = 1.
---
### Objective
Find an assignment of capacity values to nodes that **maximizes**:
```
total_efficiency = Σ (assigned_capacity[i] × score[i])   for all i in [0, N-1]
```
---
### Function Signature
```java
static long solve(int N, int M, int[] A, int[][] edges)
```
**Parameters:**

| Parameter | Type | Description |
|-----------|------|-------------|
| `N` | int | Number of server nodes |
| `M` | int | Number of bidirectional fiber-optic links |
| `A` | int[] | Array of N capacity values to be assigned |
| `edges` | int[][] | Array of M pairs `[u, v]` — a bidirectional link between nodes u and v (0-indexed internally) |

**Returns:** A single `long` — the maximum possible total efficiency.
---
### Input Format
```
Line 1:   N
Line 2:   M
Line 3:   N space-separated integers — the capacity values A[0], A[1], ..., A[N-1]
Next M lines: two space-separated integers u v (1-indexed) — a fiber-optic link between u and v
```

### Output Format

```
Print a single integer: the maximum total efficiency
```

---

### Constraints

```
1 ≤ N ≤ 10^5
0 ≤ M ≤ min(10^5, N*(N-1)/2)
1 ≤ A[i] ≤ 10^9
1 ≤ u, v ≤ N
u ≠ v
No duplicate edges
```

---

### Sample

**Input:**
```
5
4
10 20 30 40 50
1 2
2 3
3 4
4 5
```

**Output:**
```
1020
```

**Explanation:**

The graph is a path: `1 — 2 — 3 — 4 — 5` (all 5 nodes in one component, `component_size = 5` for all).

| Node | degree | component\_size | score |
|------|--------|-----------------|-------|
| 1    | 1      | 5               | **6** |
| 2    | 2      | 5               | **7** |
| 3    | 2      | 5               | **7** |
| 4    | 2      | 5               | **7** |
| 5    | 1      | 5               | **6** |

Sorted scores: `[6, 6, 7, 7, 7]`
Sorted capacities: `[10, 20, 30, 40, 50]`

Optimal assignment (pair largest capacity with largest score):

```
10×6 + 20×6 + 30×7 + 40×7 + 50×7
= 60 + 120 + 210 + 280 + 350
= 1020
```

---

### Key Insight (Hint)

> By the **Rearrangement Inequality**, the sum `Σ (a[i] × b[i])` is maximized when both arrays are sorted in the **same order**. So: compute all scores, sort scores and capacity values independently, then pair them in ascending order and sum the products.

**Time complexity:** O(N log N + M) — dominated by sorting.
 */

import java.util.*;
import java.io.*;
import java.util.List;

public class DatacenterNodePriorityAssignment {

    public static void main(String[] args) throws IOException {
        StreamTokenizer st = new StreamTokenizer(new BufferedInputStream(System.in, 1 << 16));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        st.nextToken(); int N = (int) st.nval;
        st.nextToken(); int M = (int) st.nval;

        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            st.nextToken();
            A[i] = (int) st.nval;
        }

        int[][] edges = new int[M][2];
        for (int i = 0; i < M; i++) {
            st.nextToken(); edges[i][0] = (int) st.nval;
            st.nextToken(); edges[i][1] = (int) st.nval;
        }

        pw.println(solve(N, M, A, edges));
        pw.flush();
        pw.close();
    }
/*program flow:
1. build adj list, 2. find degree, 3. find comp size, 4. cal scores
5. sort the arrays, 6. cal the max efficiency <- that's it...
🟢🟢🟢 📌📌
what i learnt: u have less time bare 20-25 min as a whole
get the ps, write the code, debug it, run it, submit it
comes through rigorous practice in contests.*/

    static long solve_WA(int N, int M, int[] A, int[][] edges) {
        // write your code here, it was a easy problem really it is!! so much
        // only implementation carefully and u'll get scores very easily :)

        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<=N; i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0; i<edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        // build components for each node
        int[] visited = new int[N+1];
        int[] comp_size = new int[N+1];
        int[] degree = new int[N+1]; // !!🔴 simple it was!! -> size of adj list!!
        for(int i=0; i<=N; i++){
            if(visited[i]!=1){ // not visited
                Queue<Integer> q = new LinkedList<>();

                q.add(i);
                visited[i]=1;
                int comp = 0;
                int deg = 1;
                while(!q.isEmpty()){
                    int node = q.poll();
                    for(int neigh: adj.get(node)){ // NOT handles carefully,
                        // careless mistakes 🔴🔴
                        comp++;
                        deg++;
                        q.add(neigh);
                    }
                }
                comp_size[i] = comp;
                degree[i] = deg;
            }
        }

        // cal scores:
        int[] scores = new int[N+1];
        for(int i=0; i<=N; i++){
            scores[i] = comp_size[i]+degree[i];
        }

        // cal efficiency
        Arrays.sort(scores);
        Arrays.sort(A);

        long ans = 0;
        for(int i=0; i<N; i++){
            ans = ans + (long)scores[i]*A[i];
        }

       return ans;
    }

    // correction: BUG is in 0-based and 1-based -> very common trap, don't fall, instead try to do
    // reduce 1-based to 1-based and start working on it :)
    static long solve_BUG(int N, int M, int[] A, int[][] edges) {
        // write your code here, it was a easy problem really it is!! so much
        // only implementation carefully and u'll get scores very easily :)

        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<=N; i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0; i<edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] degree = new int[N+1];
        for(int i=0; i<=N; i++){
            degree[i] = adj.get(i).size();
        }

        // build components for each node
        int[] visited = new int[N+1];
        int[] comp_size = new int[N+1];
        for(int i=0; i<=N; i++){
            if(visited[i]!=1){ // not visited
                Queue<Integer> q = new LinkedList<>();
                List<Integer> comp = new ArrayList<>();

                q.add(i);
                visited[i]=1;
                while(!q.isEmpty()){
                    int node = q.poll();
                    comp.add(node);
                    for(int neigh: adj.get(node)){ // NOT handles carefully,
                        if(visited[neigh]!=1){
                            visited[neigh]=1;
                            q.add(neigh);
                        }
                    }
                }
                int size = comp.size();
                for(int node: comp){
                    comp_size[node] = size;
                }
            }
        }

        // cal scores:
        int[] scores = new int[N+1];
        for(int i=1; i<=N; i++){
            scores[i] = comp_size[i]+degree[i];
        }

        // cal efficiency
        int[] realScores = Arrays.copyOfRange(scores, 1, N + 1); // indices 1..N only
        Arrays.sort(realScores);
        Arrays.sort(A);

        long ans = 0;
        for(int i=0; i<N; i++){
            ans = ans + (long)scores[i]*A[i];
        }

        return ans;
    }
/*From your code:

👉 You:

understand logic well ✅
rush implementation ❌
skip verification ❌

After coding:
👉 Pause for 20 seconds
👉 Ask ONLY these 3:
Indexing correct?
Sorted array used?
Overflow handled?*/
    // CORRECT:
    static long solve(int N, int M, int[] A, int[][] edges) {

        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<=N; i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0; i<edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] degree = new int[N+1];
        for(int i=1; i<=N; i++){
            degree[i] = adj.get(i).size();
        }

        int[] visited = new int[N+1];
        int[] comp_size = new int[N+1];

        for(int i=1; i<=N; i++){   // ✅ FIXED
            if(visited[i]!=1){
                Queue<Integer> q = new LinkedList<>();
                List<Integer> comp = new ArrayList<>();

                q.add(i);
                visited[i]=1;

                while(!q.isEmpty()){
                    int node = q.poll();
                    comp.add(node);

                    for(int neigh: adj.get(node)){
                        if(visited[neigh]!=1){
                            visited[neigh]=1;
                            q.add(neigh);
                        }
                    }
                }

                int size = comp.size();
                for(int node: comp){
                    comp_size[node] = size;
                }
            }
        }

        int[] scores = new int[N];
        for(int i=1; i<=N; i++){
            scores[i-1] = comp_size[i] + degree[i];
        }

        Arrays.sort(scores);
        Arrays.sort(A);

        long ans = 0;
        for(int i=0; i<N; i++){
            ans += (long)scores[i] * A[i];
        }

        return ans;
    }
}
