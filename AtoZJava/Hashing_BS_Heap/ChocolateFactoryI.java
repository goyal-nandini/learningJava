package Hashing_BS_Heap;
/*🍫 Chocolate Factory with Deadlines
Problem
A factory produces chocolates through 3 sequential stages:
Melting → Molding → Packaging
There are P Melting machines, each takes T1 time
There are Q Molding machines, each takes T2 time
There are R Packaging machines, each takes T3 time
Each machine can process only one chocolate at a time.

Each chocolate i has a deadline D[i]
👉 If a chocolate finishes after its deadline, it is discarded.
A chocolate is counted only if it completes all 3 stages before its deadline.

Goal 📌
👉 Find the maximum number of chocolates that are completed on time.

Input Format
N
P Q R T1 T2 T3
D1 D2 D3 ... DN

Constraints
1 ≤ N ≤ 10000
1 ≤ P, Q, R ≤ 1000
1 ≤ T1, T2, T3 ≤ 1000
1 ≤ D[i] ≤ 10^6

Example
Input:
5
2 2 1 3 2 4
10 12 15 20 25

Output:
4*/

/*✅ Pipeline + Greedy Scheduling with Deadlines
PATTERN:
Use min heaps (machine availability)
Sort by deadlines
Simulate pipeline
SKIP jobs that miss deadline

⚡ Why skipping is mandatory

Think like this:
👉 If you process a bad job:
It blocks machines
Delays all future jobs
Reduces total count

👉 If you skip it:
Machines stay free
Future jobs can succeed

🔥 Simple Example

Imagine:

1 machine each stage
t1 = t2 = t3 = 5

Deadlines:
[8, 20]
If you DON'T skip:
First job finishes at 15 ❌ (missed)
But still used machines
Second job starts late → might fail
If you SKIP first:
Second job starts at 0 → finishes at 15 ✅

👉 Count = 1 vs possibly 0*/

/*honestly just perfume wali code lines ko manage krna hai their order, polling, adding!! + sorting here
*
* see i did same as perfume wala with just one added condition of sorting and finish3 <= deadline cnt++;
* then the realization:
❌ The REAL PROBLEM (Important ⚠️)

You are processing every chocolate even if it already failed.

👉 Even if a chocolate misses deadline, you still:

occupy machines
push times forward
ruin future scheduling
🔥 Why this is wrong?

Imagine:

Chocolate A misses deadline badly
But you still let it go through all 3 stages
Now machines are delayed for next chocolates

👉 That reduces total count

💡 Key Insight (Core Greedy Idea)

If a chocolate cannot be completed before deadline,
👉 DO NOT process it at all*/


import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Arrays;

public class ChocolateFactoryI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p = sc.nextInt();
        int q = sc.nextInt();
        int r = sc.nextInt();
        int t1 = sc.nextInt();
        int t2 = sc.nextInt();
        int t3 = sc.nextInt();

        int[] deadlines = new int[n];
        for(int i=0; i<n; i++) deadlines[i] = sc.nextInt();

        System.out.println(solve(n, p, q, r, t1, t2, t3, deadlines));
        System.out.println(solve2(n, p, q, r, t1, t2, t3, deadlines));
    }

    private static int solve(int n, int p, int q, int r, int t1, int t2, int t3, int[] deadline){
        // this problem is extension of perfume factory with deadline given for all chocolates, we are tend to process
        // those whose deadline is closer so sort is required then we will process each chocolate till stage3 but then
        // is deadline reach we skip that and save time for next chocolate by carefully managing the heap!! only update
        // heap if the chocolate is valid

        // attention: don't get confused both are same idea: 1. Revert machines when deadline missed
        // 2. Before pushing into machines[updating heaps], check: Can this chocolate finish before deadline
        // if we start now?

        // a refined version to say:
//        These are actually two different approaches:
//        Approach 1 → Compute finish3, then revert if missed (your code)
//        Approach 2 → Check BEFORE assigning machines (predictive)
        // oRRR
        // Two valid approaches — both correct:
        // 1. Simulate fully, then revert heaps if deadline missed (what we do here)
        // 2. Predict finish time before polling, skip if guaranteed to miss

        // idea1:
        int cnt=0;
        Arrays.sort(deadline);
        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        PriorityQueue<Integer> pq2 = new PriorityQueue<>();
        PriorityQueue<Integer> pq3 = new PriorityQueue<>();

        for(int i=0; i<p; i++) pq1.add(0);
        for(int i=0; i<q; i++) pq2.add(0);
        for(int i=0; i<r; i++) pq3.add(0);

        for(int i=0; i<n; i++){
            int m1 = pq1.poll();
            int finish1 = m1+t1;

            int m2 = pq2.poll();
            int start2 = Math.max(m2, finish1);
            int finish2 = start2+t2;

            int m3 = pq3.poll();
            int start3 = Math.max(m3, finish2);
            int finish3 = start3+t3;

            if(finish3 <= deadline[i]){
                cnt++;

                // if deadline meet then and only we consider the chocolate and update the heap with this updated machine
                // time/finish time for each machine
                // else we will revert back with what we poll for calc the finish time for all chocolates

                pq1.add(finish1);
                pq2.add(finish2);
                pq3.add(finish3);
            } else {
                pq1.add(m1);
                pq2.add(m2);
                pq3.add(m3);
            }
        }
        return cnt;
    }
    private static int solve2(int n, int p, int q, int r, int t1, int t2, int t3, int[] deadline){
        // idea2:
        int cnt=0;
        Arrays.sort(deadline);
        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        PriorityQueue<Integer> pq2 = new PriorityQueue<>();
        PriorityQueue<Integer> pq3 = new PriorityQueue<>();

        for(int i=0; i<p; i++) pq1.add(0);
        for(int i=0; i<q; i++) pq2.add(0);
        for(int i=0; i<r; i++) pq3.add(0);

        for(int i=0; i<n; i++){
            int m1 = pq1.peek();
            int finish1 = m1+t1;

            int m2 = pq2.peek();
            int start2 = Math.max(m2, finish1);
            int finish2 = start2+t2;

            int m3 = pq3.peek();
            int start3 = Math.max(m3, finish2);
            int finish3 = start3+t3;

            if(finish3 <= deadline[i]){
                cnt++;
                pq1.poll();
                pq2.poll();
                pq3.poll();
                pq1.add(finish1);
                pq2.add(finish2);
                pq3.add(finish3);
            }
        }
        return cnt;
    }
    /*🚀 Why this works
Greedy + earliest deadline first
Only feasible jobs enter pipeline
Machines are not wasted on bad jobs

👉 This is similar to job scheduling with deadlines + resources*/
}
