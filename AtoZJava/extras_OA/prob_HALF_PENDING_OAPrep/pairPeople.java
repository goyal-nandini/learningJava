package extras_OA.prob_HALF_PENDING_OAPrep;

/***Properly Framed Problem:**
> You are given an array of `N` people with their weights. Find the **minimum number of shuttles** required to transport all of them.
> **Each shuttle has the following constraints:**
> - Can carry **at most 2 people**
> - The **sum of weights** of the 2 people must be **≤ W**
> - The **absolute difference of weights** of the 2 people must be **≤ D**
> If no valid partner exists for a person, they **ride alone**.
> Return the **minimum number of shuttles** needed.
---
**Example:**
`weights = [1, 2, 5, 6]`, W = 8, D = 4
- Pair (2, 6): sum=8 ✓, diff=4 ✓ → 1 shuttle
- Pair (1, 5): sum=6 ✓, diff=4 ✓ → 1 shuttle
- Total = **2 shuttles** ✓
---
**Approach (Greedy + Two Pointer after sorting):**
Sort the array, then use two pointers — try to pair lightest with heaviest valid partner.

---
 Similar Problems to Practice
 🟢 Direct Match (90–100%)

 These are the ones I would definitely solve.
 1. LeetCode 881 – Boats to Save People ⭐⭐⭐⭐⭐ ✅
 Pattern: Almost identical.
 Difference:
 Only sum <= limit
 No difference constraint
 This is the #1 practice problem for this OA question.

 2. CSES – Ferris Wheel ⭐⭐⭐⭐⭐ ✅
 Exactly:
 Pair at most two people
 Minimize gondolas
 Same greedy idea.

 3. GeeksforGeeks – Minimum Boats to Save People ✅
 Same pattern with different wording.

 🟡 Same Pattern (70–80%)
 4. Assign Cookies (LeetCode 455) ✅
 Pattern:
 Sort
 Greedy matching
 Instead of pairing two people, you're matching children and cookies.

 5. Advantage Shuffle (LeetCode 870) ✅
 Pattern:
 Sorting
 Greedy assignment
 Builds confidence with greedy decisions after sorting.

 6. Match Players and Trainers (LeetCode 2410) ✅ same as lc 455
 Very similar greedy pairing after sorting.

 🔴 Advanced Variants

 These don't look the same but strengthen the same skills.
 7. Rescue Boats with Extra Constraints (Codeforces/AtCoder variants)
 Usually add another restriction (age, color, etc.), just like your |difference| <= D condition.

 8. Task Assignment (AlgoExpert) edit: in premium - not found PS
 Greedy pairing to optimize an objective.

 ⭐ The New Twist
 The standard "Boats to Save People" problem has one condition:
 sum <= limit
 Your OA adds:
 abs(weight1 - weight2) <= D
 This is exactly the kind of modification companies make.
 That's why LeetCode 881 is still the best practice. Once you're comfortable with it, think about how the extra constraint
 changes the greedy check.

 Revision Note 📝
 When you see:
 Pair people
 At most 2 per group
 Minimize groups

 → Think:

 Sort.
 Consider the heaviest remaining person.
 Try to pair them with the lightest feasible person.
 If pairing isn't possible, the heaviest must go alone.


 ---
 Pattern Card – Question 4
 🎯 Pattern Name
 Greedy + Sorting + Two Pointers (Pairing Optimization)
 🧠 Recognition Triggers
 Whenever you see:

 Pair people/items
 Boat / Shuttle / Gondola / Taxi
 At most 2 people/items
 Minimize number of groups
 Weight/capacity constraints
 Pair if possible, otherwise go alone

 👉 Your first thought should be:

 Sort the array + Two Pointers + Greedy pairing

 ---
https://chatgpt.com/s/t_6a66e3d7f748819180608026a1c432cb
 */

import java.util.*;

public class pairPeople {
    public static void main(String[] args) {
        // test cases
        testCases();
    }

    public static void check(int expected, int actual, String testName) {
        if (expected != actual) {
            System.out.println(testName + " FAILED");
            System.out.println("Expected = " + expected);
            System.out.println("Actual   = " + actual);
        } else {
            System.out.println(testName + " Passed");
        }
    }

    public static void testCases() {
        check(2, minShuttles(new int[]{1, 2, 5, 6}, 8, 4), "Test 1");

        check(3, minShuttles(new int[]{5, 5, 5, 5, 5}, 10, 0), "Test 2");

        check(3, minShuttles(new int[]{1, 1, 50, 51}, 100, 0), "Test 3");

        check(2, minShuttles(new int[]{1, 10}, 5, 100), "Test 4");

        check(2, minShuttles(new int[]{6, 5, 1, 2}, 8, 100), "Test 5");

        check(1, minShuttles(new int[]{5}, 10, 10), "Test 6");

        check(0, minShuttles(new int[]{}, 10, 10), "Test 7");

        check(1, minShuttles(new int[]{0, 10}, 10, 10), "Test 8");

        check(2, minShuttles(new int[]{1, 5, 5, 9}, 20, 5), "Test 9");

        check(2, minShuttles(new int[]{1, 2, 3}, 100, 50), "Test 10");

        check(3, minShuttles(new int[]{1, 2, 3, 4, 5, 6}, 1000000000, 1000000000), "Test 11");

        check(2, minShuttles(new int[]{1, 2, 3, 4}, 1000, 1000), "Test 12");

        System.out.println("All test cases passed!");
    }

    // global pairing
    // binary search, TreeSet, custom comparator, greedy-interval problem

    /*interval how? - lets see:
    * 1. diff <= D => |w-x| <= D => -D <= w-x <= D
    * w-x<=D => x>=w-D => lower bound
    * w-x>=D => x<=w-D => upper bound
    * 2. sum <= W => w+x<=W => x <= W-w
    *
    * lo = w-D
    * hi = min(w-D, W-w)
    * okay!! i got it:)
    * */

    /* why treeSet and order in Integer type and why floor used here?
    * --- order: helps in deciding which person's weight to be processed first [sorted acc to hi value] in ascending order
    * means which has narrow window is processed first - as this person has fewest options - so its picked first
    * In short: order[] doesn't change any weights or math — it's purely the schedule that decides who chooses their
    * partner first, and that schedule is what makes the greedy provably optimal instead of accidentally lucky.
    * --- treeSet: ok below few lines
    * --- floor: see the upperbound using binary search will get us the greatest index less than the hiVal, but what if
    * that index is already get partenered with some one other - not available in treeSet so we used floor on it,
    * to get the next greatest index with less then hiVal which is available.
    *
    * ⚙️ What floor does
    In a TreeSet:
    floor(E e) → greatest element ≤ e.

    In a TreeMap:
    floorKey(K key) → greatest key ≤ key.
    floorEntry(K key) → key-value pair with that key.*/

    public static int minShuttles(int[] people, int W, int D) {
        int n = people.length;

        Arrays.sort(people);

        int[] hi = new int[n];
        for(int i=0; i<n; i++){
            int w = people[i];
            hi[i] = Math.min(w+D, W-w);
        }

        Integer[] order = new Integer[n];
        for(int i=0; i<n; i++) order[i] = i;
        Arrays.sort(order, (a, b)->Integer.compare(hi[a], hi[b]));

        TreeSet<Integer> available = new TreeSet<>();
        for(int i=0; i<n; i++) available.add(i);

        int shuttle = 0;
        for(int i: order){
            if(!available.contains(i)) continue;

            available.remove(i);

            int lowVal = people[i]-D;
            int highVal = hi[i];

            // highest index < highVal
            int boundIdx = upperBound(people, highVal);

            if(boundIdx != -1){
                Integer partnerIdx = available.floor(boundIdx);

                if(partnerIdx != null && people[partnerIdx]>=lowVal){
                    // i and partnerIdx are partners in shuttle now
                    available.remove(partnerIdx);
                }
            }

            shuttle++;
        }
        return shuttle;
    }

    // largest index i such that p[i]<val
    private static int upperBound(int[] arr, int val){
        int l=0;
        int h=arr.length-1;
        int ans = -1; // imp: always use an out-of-range sentinel (-1) for "not found," never a valid-looking index like 0.
        while(l<=h){
//            int mid = l+(h-l)/2; kya the ise m...?! - edit: hn yhi shi hai
            int mid = (h+l)/2;

            if(arr[mid]<=val){
                ans=mid;
                l=mid+1;
            } else {
                h = mid - 1;
            }
        }
        return ans;
    }
}
