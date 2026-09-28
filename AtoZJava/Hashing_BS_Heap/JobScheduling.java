package Hashing_BS_Heap;
/*follow up of partI: TODO:
🔵 Pattern 3: Job Scheduling with Deadlines (Classic Greedy + Max Heap)
📌 Problem Statement
You are given N jobs.

Each job i has:
- processing time T[i]
- deadline D[i]

You can process only ONE job at a time.

A job is counted only if it finishes before its deadline.

👉 Find the maximum number of jobs that can be completed.
📥 Input Format
N
T1 T2 T3 ... TN
D1 D2 D3 ... DN
📤 Output
Maximum number of jobs completed
✅ Example (verified, standard)
Input:
4
3 2 1 2
4 3 2 3

Output:
3
🔍 Explanation

Sort by deadline:

Job: (T, D)
(1,2), (2,3), (2,3), (3,4)

Try adding:

1 → OK (time=1)
2 → OK (time=3)
2 → time=5 ❌ → remove largest (2)
3 → OK

👉 Total = 3 jobs

🌐 Same as
Course Schedule III*/

public class JobScheduling {
}
