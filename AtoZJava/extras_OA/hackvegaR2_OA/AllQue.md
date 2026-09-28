# QUESTION 1

Rakesh is playing a game called **"2048"**. In this game, a **4×4** cell grid is given, where each cell can either be empty (denoted by having the value **0**), or can have a value of **2^k** where **k** is any number between **1 and 11**.

The game aims to win by arriving at a value of **2048** by repeatedly moving in one of four directions: **up (U), down (D), right (R), or left (L)**. When one of these four direction buttons is pressed, all the cells in the grid try to move in that direction. During this movement, if any two adjacent cells (adjacent in the direction of movement) have the same value, then they merge and add up.

For instance,

* if there are two adjacent cells in a row with values **4** and **4**, and the **R** button is pressed, the left cell moves right and gets added to the right cell, and itself becomes empty, so **"4 4" becomes "0 8"**.
* Similarly, **"16 16" becomes "0 32"**.
* However, **"2 4"** remains as **"2 4"** since the values are different and no merging takes place.
* Alternatively, if the adjacent cell is empty, then the value moves in that direction i.e. **"4 0"** on pressing **R** becomes **"0 4"**, as the 4 moves right, and the earlier cell becomes empty.

These operations take place **only row-wise if L or R are pressed** and **only column-wise if U or D are pressed**.

A score is calculated at the press of every button, by adding up all the cells that merged because of the movement in that direction.

---

Given the initial **4×4** static grid and the buttons pressed, write a program that prints the **final state of the grid**. Every operation except the first operation uses the result of the previous operation to perform the current operation.

Read the input from **STDIN** and print the output to **STDOUT**. Do not write arbitrary strings anywhere in the program, as these contribute to the standard output and test cases will fail.

---

## Constraints

1. Grid size is always **4 × 4**.
2. All the cell values are either **0** or **2^k**, where **1 ≤ k ≤ 11**.
3. A key press can be **'U' or 'u'** for up, **'D' or 'd'** for down, **'L' or 'l'** for left, and **'R' or 'r'** for right.

---

## Input Format

* The first **4** lines of input consist of **4 integers each**, separated by a space.
* The fifth line contains an integer **N**, the number of operations to be performed.
* The next **N** lines each contain one key pressed (**U/D/L/R**).

---

## Output Format

Print the **final state of the grid** after performing all the operations.

---

### Sample Input 1

```
16 256 256 512
4 0 0 32
64 0 0 8
2 2 1024 2
2
R
d
```

### Sample Output 1

```
0 0 512 512
0 0 4 32
0 16 64 8
0 4 1024 2
```

---

### Sample Input 2

```
2 4 8 16
2 4 2 2
2 2 4 4
2 64 32 0
3
L
U
U
```

### Sample Output 2

```
8 16 8 16
2 64 4 0
0 0 32 0
0 0 0 0
```


# Question 2

## Problem Statement

A binary tree is represented as a series of relationships between each node and the Root node. The relationships are denoted as combinations of **'L'** and **'R'**, such as **L, R, LL, LR...** and so on, where each node is left (L) to Root or left-left (LL) or right-left (RL) to Root and so on.

In this tree, **if the sum of digits of the left child node is equal to the sum of digits of the right child node, then their parent is called a Super Node.**

Write a program to find all the **Super Nodes** in a given tree, and print the **sum of all those Super Nodes**.

Read the input from STDIN and print the output to STDOUT. Do not print arbitrary strings anywhere in the program, as these contribute to the output and test cases will fail.

---

## Constraints

```
3 <= N <= 100
```

---

## Input Format

* First line contains an integer **N**, the number of nodes.
* Second line contains the **Root** node.
* The next **N−1** lines contain a string **S** and an integer **X**, separated by a space.

    * **S** denotes the relation of X from the Root.
    * **X** is the node value.

---

## Output Format

Print one integer — the sum of all Super Nodes.

---

## Sample Input 1

```
8
21
L 14
R 23
LL 7
LR 70
RR 11
RRL 23
RRR 32
```

## Sample Output 1

```
46
```

### Explanation

```
        21
      /    \
    14      23
   /  \       \
  7   70      11
             /  \
           23    32
```

* 21 → digitSum(14)=5, digitSum(23)=5 ✔
* 14 → digitSum(7)=7, digitSum(70)=7 ✔
* 11 → digitSum(23)=5, digitSum(32)=5 ✔

Answer

```
21 + 14 + 11 = 46
```

---

## Sample Input 2

```
6
11
L 14
R 23
LL 7
LR 8
RR 14
```

## Sample Output 2

```
11
```

### Explanation

```
      11
     /  \
   14    23
  / \      \
 7   8      14
```

* 11 is a Super Node.
* 14 has children 7 and 8 → digit sums 7 and 8 ✘
* 23 has only one child ✘

Answer

```
11
```

---

# Question 3 

## Problem Statement

Consider a binary tree of **N** nodes (1 Root and N−1 descendants).

Each node X is related to the Root by some relations such as **L, R, LL, LR...**, where X is left (L) to Root or left-left (LL) or right-left (RL) to Root and so on.

Two nodes **A** and **B** are given as query.

Write a program to print the **Lowest Common Ancestor (LCA)** of A and B.

Lowest Common Ancestor (LCA) is defined as the **lowest (deepest) node that has both A and B as descendants**, where a node can also be a descendant of itself.

Read the input from STDIN and print the output to STDOUT. Do not print arbitrary strings while reading input or while printing.

---

## Constraints

```
3 <= N <= 100

All node values are unique.
```

---

## Input Format

* First line contains integer **N**.
* Second line contains the **Root**.
* Next **N−1** lines contain relation **S** and node **X**.
* Last line contains two integers **A B**.

---

## Output Format

Print the Lowest Common Ancestor of A and B.

---

## Sample Input 1

```
9
11
L 23
R 44
LL 13
LR 9
RL 4
RR 7
RLL 6
RLR 18
13 18
```

## Sample Output 1

```
11
```

### Explanation

```
          11
        /    \
      23      44
     / \     /  \
   13   9   4    7
            / \
           6  18
```

Ancestors of 13

```
13 → 23 → 11
```

Ancestors of 18

```
18 → 4 → 44 → 11
```

Common ancestor = **11**

---

## Sample Input 2

```
7
12
L 17
R 16
RL 4
RR 9
RLL 2
RLR 3
2 9
```

## Sample Output 2

```
16
```

### Explanation

```
        12
       /  \
     17    16
          /  \
         4    9
        / \
       2   3
```

Ancestors of 2

```
2 → 4 → 16 → 12
```

Ancestors of 9

```
9 → 16 → 12
```

Lowest common ancestor = **16**

---

