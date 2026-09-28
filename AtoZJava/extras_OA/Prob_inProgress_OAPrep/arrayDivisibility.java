package extras_OA.Prob_inProgress_OAPrep;

/*Make Array Ascending with Divisibility

You are given an array of integers. Rearrange it to make it strictly ascending such that for every index i
(1-based), arr[i] % i == 0.

Determine if such an arrangement is possible, or find the arrangement.

Example: arr = [2, 6, 3]
Valid: [2, 6, 3] → 2%1=0✓, 6%2=0✓, 3%3=0✓

*/

/*
---
📚 Tier 1 (Must Solve)
LeetCode 526 – Beautiful Arrangement ⭐⭐⭐⭐⭐ ✅
This is almost the same problem!
Condition:
num % position == 0
OR
position % num == 0

This is the first problem you should solve.

LeetCode 996 – Number of Squareful Arrays ✅
Another permutation + constraint problem.

Tier 2
Matchsticks to Square (LC473)
Partition to K Equal Sum Subsets (LC698)

These strengthen backtracking with assignment.

---
🎯 Pattern

Sorting + Backtracking / Bipartite Matching (Assignment Problem)

https://chatgpt.com/s/t_6a66f8c311cc819180c57bbcaa0aa798
*/

import java.util.*;

public class arrayDivisibility {
    static void main(String[] args) {

    }
    private static void solution(int[] nums){
        int n = nums.length;
        Arrays.sort(nums);
        int[] visited = new int[n];
        ArrayList<Integer> list = new ArrayList<>();
        if(solve(nums, visited, list)) System.out.println(list);

    }
    private static boolean solve(int[] nums, int[] visited, ArrayList<Integer> list){
        if(list.size() == nums.length){
            return true;
        }
        for(int i=0; i<nums.length; i++){
            if(visited[i] == 0){
                // skip i if i-1 is same as i and has not visited yet ie visited[i-1] == 0 <- be careful
                if(i>0 && visited[i-1] == 0 && nums[i] == nums[i-1]) continue;

//                if(nums[i] % (i+1) != 0) continue; // BUG:
                // i is simply the index of the element in the nums array. It does not represent the position
                // where nums[i] is being placed in list!

                if(nums[i] % list.size()+1 != 0) continue; // 1-based index

                // if the problem wants the final arrangement of numbers in ascending order...
                // or strcitly ascending order - get idea how what is compared...
                if(list.size()>0 && nums[i] < list.get(list.size())-1) continue;

                list.add(nums[i]);
                visited[i] = 1;
                if(solve(nums, visited, list)) return true;
                list.remove(list.size()-1);
                visited[i] = 0;
            }


        }
        return false;
    }
}
/*
* https://share.gemini.google/pk3tIxDMMZVX
* The **permutation logic** comes into play because you are given an array of numbers in an arbitrary order,
* and you need to find an **ordering (rearrangement)** of those exact same elements that satisfies two specific
* constraints at the same time:

1. **Divisibility Constraint:** The element at 1-based index `pos` must satisfy `arr[pos - 1] % pos == 0`.
2. **Ascending Constraint:** Each placed element must be strictly greater than the previously placed element
* (`arr[pos - 1] > arr[pos - 2]`).

---

### Why is this a Permutation Problem?

When a problem asks you to *"rearrange an array of $N$ elements"*, mathematically you are picking a **permutation**
* of those $N$ elements.

* For an array of size $N$, there are $N!$ possible ways to order (permute) the numbers.
* You are searching through the space of permutations to find **at least one valid permutation** where every element
* fits both conditions.

---

### How Backtracking Explores Permutations Step-by-Step

Instead of generating all $N!$ permutations and checking them at the end, backtracking builds the permutation **one
* slot at a time** (from position $1$ to $N$):

```
Slot 1 (pos = 1): Pick a number X from `nums` that is unused.
                  Check: Is X % 1 == 0? (Always true)

Slot 2 (pos = 2): Pick an unused number Y from `nums`.
                  Check 1: Is Y % 2 == 0?
                  Check 2: Is Y > X? (Strictly ascending)
                  If valid -> move to Slot 3.
                  If invalid -> prune this branch, backtrack, try another Y!

Slot 3 (pos = 3): Pick an unused number Z from `nums`.
                  Check 1: Is Z % 3 == 0?
                  Check 2: Is Z > Y?
                  ...

```

---

### Visualizing the Decision Tree for `arr = [2, 6, 3]`

After sorting `nums = [2, 3, 6]`:

```
                    Root (pos = 1)
                /         |         \
           Pick 2       Pick 3      Pick 6
          (2%1==0)     (3%1==0)    (6%1==0)
            /             |            \
       (pos = 2)      (pos = 2)     (pos = 2)
       /       \       /     \       /     \
    Pick 3   Pick 6  Pick 2  Pick 6 Pick 2  Pick 3
    3%2!=0   6%2==0  2<3(X)  6>3✓   2<6(X)  3<6(X)
     (X)     6>2✓             (✓)
              |                |
          (pos = 3)        (pos = 3)
              |                |
           Pick 3           Pick 2
           3%3==0           2%3!=0
            3>6(X)           (X)

```

In this tree:

1. When you pick `2` at `pos=1`, then `6` at `pos=2` (since $6 \% 2 == 0$ and $6 > 2$), the only remaining element
* for `pos=3` is `3`. But `3` is NOT $> 6$, so it fails the ascending check!
2. If you try the permutation `[2, 3, 6]`:
* `pos = 1`: `2 % 1 == 0` $\checkmark$
* `pos = 2`: `3 % 2 != 0` $\times$ (Fails divisibility!)


3. If you try `[3, 6, ...]` or other permutations, you keep testing until you either find a valid ordering or exhaust all choices.

---

### Summary

The permutation logic is simply **a systematic way of placing every number into every slot**, using visited tracking
* (`visited[i]`) so no number is reused, and **pruning early** as soon as a slot violates the divisibility or ascending rule.*/
