package extras_OA.infosys_OA_Prep;

/*Sum of Substring Scores (Unique Character Index Sum)

You are given a string S. For every substring, its score is the sum of indices (1-based or 0-based, as per problem) of
characters that appear exactly once in that substring.

Find the sum of scores of all substrings of S.

Example:
S = "abc"
Substrings:
"a"   → unique: a(idx 0) → score = 0
"b"   → unique: b(idx 1) → score = 1
"c"   → unique: c(idx 2) → score = 2
"ab"  → unique: a(0),b(1) → score = 1
"bc"  → unique: b(1),c(2) → score = 3
"abc" → unique: a(0),b(1),c(2) → score = 3
Total = 0+1+2+1+3+3 = 10

Approach: For each character at index i, calculate its contribution across all substrings where it appears exactly once.
Use last/next occurrence tracking per character.

---
Similar Problems
🟢 Direct Match
Count Unique Characters of All Substrings (LC 828)

This is almost identical.

🟡 Same Pattern
Sum of Beauty of All Substrings
Total Appeal of A String (LC 2262)
Count Vowels of All Substrings
Number of Wonderful Substrings
🔴 Advanced Variant
Distinct Subsequences II
Palindromic Subsequences
Suffix Automaton Contribution Problems
String Contribution DP

---
Pattern

⭐⭐⭐⭐ Character Contribution Technique

https://chatgpt.com/s/t_6a66fdf807bc81919ea085539beb8324
*/

//public class substringScores {
//}
