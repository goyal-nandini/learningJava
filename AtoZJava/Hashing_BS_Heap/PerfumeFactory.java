package Hashing_BS_Heap;
// found on Twitter from a company OA
/*## 01. Perfume Factory
### Problem Statement
At a perfume factory, every perfume bottle goes through three processes after each other, i.e. **Distillation →
Enfleurage → Extraction**. There are **P Distillation**, **Q Enfleurage**, and **R Extraction** machines.
Each machine can process only a single product at any time, and it takes **T1** hours for Distillation, **T2**
hours for Enfleurage, and **T3** hours for Extraction. Your task is to print the minimum hours required to produce
**N** perfume bottles.

---

### Input Format
The input consists of two lines:
- The first line contains an integer **N**, representing the number of perfume bottles.
- The second line contains six space-separated integers **P, Q, R, T1, T2, T3**.
The input will be read from the STDIN by the candidate.

---
### Output Format
Print the minimum hours required to prepare **N** perfume bottles.
The output will be matched to the candidate's output printed on the STDOUT.
---
### Constraints
- 1 ≤ N ≤ 10000
- 1 ≤ P, Q, R, T1, T2, T3 ≤ 1000
---
### Example
**Input:**
```
8
4 3 2 10 5 2
```
**Output:**
```
32
```
---
### Explanation
There are 4 Distillation, 3 Enfleurage, and 2 Extraction machines. Taking the waiting time into account, the start time
for making each of the eight bottles is **15** and **15** hours consecutively. The last perfume bottles will be ready
after **15 + 10 + 5 + 2 = 32** hours.
---

Want me to walk through the logic and code a solution in Java?*/
import java.util.PriorityQueue;
import java.util.Scanner;

// tc: O(p+q+r + nlogp + nlogq + nlogr) -> O(nlog(max(p, q, r))) dominant term
// sc: O(p+q+r)

public class PerfumeFactory {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p = sc.nextInt();
        int q = sc.nextInt();
        int r = sc.nextInt();
        int t1 = sc.nextInt();
        int t2 = sc.nextInt();
        int t3 = sc.nextInt();

        System.out.println(solve(n, p, q, r, t1, t2, t3));
    }

    private static int solve(int n, int p, int q, int r, int t1, int t2, int t3){
        // min-heap stores the availability time, when each machine becomes free.
        // heap stores the timeline of machine availability
        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(); // stores when stage2 machines become free
        PriorityQueue<Integer> pq3 = new PriorityQueue<>();

//        You must add P, Q, R zeros as available time of all machines
        for(int i=0; i<p; i++) pq1.add(0);
        for(int i=0; i<q; i++) pq2.add(0);
        for(int i=0; i<r; i++) pq3.add(0);

        int finish3 = 0;

        for(int i=0; i<n; i++){
            // for a bottle i, all stage processing

            // stage1
            int m1 = pq1.poll(); // take available time of m1
            int finish1 = m1 + t1; // compute the finish time of m1
            pq1.add(finish1); // add the finish time means available time of m1

            // stage2
//          Math.max(/*machine2 available time, bottle arrival time*/)
            int m2 = pq2.poll();
            int start2 = Math.max(m2, finish1);
            int finish2 = start2 + t2;
            pq2.add(finish2);

            // stage3
            int m3 = pq3.poll();
            int start3 = Math.max(m3, finish2); // machine3 available time vs bottle i arrival time
            finish3 = start3 + t3;
            pq3.add(finish3);
        }
        return finish3;
    }
}
