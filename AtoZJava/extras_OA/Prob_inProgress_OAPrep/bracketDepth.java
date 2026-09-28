package extras_OA.Prob_inProgress_OAPrep;

/*Bracket Depth with Minimum Swaps

You are given a string S of length N containing only [ and ], and an integer D (maximum allowed depth).

The depth at any point is the number of currently open (unmatched) [ brackets. The string must never exceed
depth D at any position.

If the string violates this condition, find the minimum number of swaps (swap any [ with any ]) to make the
depth never exceed D.
Return the minimum number of swaps required.

Examples:

N=4, D=2, S="[[]]" → depth goes 0,1,2,1,0 → max=2 ✓ → Answer: 0
N=4, D=1, S="[[]]" → depth goes 0,1,2,1,0 → max=2 > 1 → swap to "[][]" → Answer: 1

---
📚 Practice Problems
🎯 Tier 1 (Direct Match)

These are the ones I'd actually ask you to solve.
1. LeetCode 1963 – Minimum Number of Swaps to Make the String Balanced ⭐⭐⭐⭐⭐ ✅
This is the closest problem.
Same theme:

brackets
swaps
greedy

Must solve.

2. Minimum Swaps for Bracket Balancing (GeeksforGeeks) ✅ AMAZING QUE IT IS!!
Classic interview problem.
https://www.geeksforgeeks.org/problems/minimum-swaps-for-bracket-balancing2704/1

3. Maximum Nesting Depth of Parentheses (LeetCode 1614)  ✅
Not about swaps.
But teaches you to think in terms of depth = prefix sum.

Very important.

📈 Tier 2 (Same Pattern) ⁉️⁉️⁉️❓❓❓⁉️⁉️⁉️🙋‍♀️
4. Valid Parentheses (LC20)
Basic.

5. Longest Valid Parentheses (LC32)
Prefix/balance thinking.

6. Minimum Add to Make Parentheses Valid (LC921)
Greedy balance.

7. Minimum Remove to Make Valid Parentheses (LC1249)
Another balance-based greedy.

🚀 Tier 3
8. Remove Invalid Parentheses (LC301)
Hard.

9. Score of Parentheses (LC856)
Uses nesting depth.

⭐ Hidden Insight
The important keyword isn't
swap
The important keyword is
depth
Depth immediately means
running balance

---
Pattern Card – Question 9
🎯 Primary Pattern

Greedy + Prefix Sum (Bracket Sequence)

https://chatgpt.com/s/t_6a66ed2d9dc88191b9f1bab271d4e7cc
*/



public class bracketDepth {
    static void main(String[] args) {
        String s1 = "[[]]";
        System.out.println(s1 + " depth: 1" + "->" + solve(s1, 1));
        System.out.println(s1 + " depth: 2" + "->" + solve(s1, 2));

        String s2 = "[[[]]]";
        System.out.println(s2 + " depth: 1" + "->" + solve(s2, 1));
        System.out.println(s2 + " depth: 2" + "->" + solve(s2, 2));
    }

    private static int solve(String s, int depth){
        int n = s.length();
        int swaps = 0;
        int currDepth = 0;
        for(char ch: s.toCharArray()){
            if(ch == '['){
                if(currDepth < depth) {
                    currDepth++;
                } else {
                    swaps++;
                    currDepth--; // after swap '[' will becomes ']' so currDepth decreases
                }
            } else {
                if(currDepth > 0){
                    currDepth--;
                }
            }
        }
        return swaps;
    }
}
