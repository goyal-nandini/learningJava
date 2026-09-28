package HWI_Solid_prep.HWI_round1_ques;

import java.util.Scanner;

/*## 🧾 Problem: Vault Digit Alignment
In a high-security research facility, a digital vault is protected by **N rotating digits** arranged in a row.
Each digit initially shows a value **A[i]**, where:

```text
0 ≤ A[i] ≤ 9
```
---
### 🔄 Operation Allowed
You are allowed to **rotate any digit forward only (cyclically)**:
```text
0 → 1 → 2 → ... → 8 → 9 → 0 → 1 → ...
```
* Each forward rotation counts as **1 operation**
* You cannot rotate backward
---
### 🎯 Objective
Make the sequence of digits **non-decreasing from left to right** using the **minimum total number of rotations**.
```text
A[0] ≤ A[1] ≤ A[2] ≤ ... ≤ A[N-1]
```
---
### 📥 Input Format
* First line contains an integer **N** — number of digits
* Next **N lines** each contain one integer representing **A[i]**
---
### 📤 Output Format
* Print a single integer — **minimum total rotations required**
---
### 📌 Constraints

```text
1 ≤ N ≤ 10^5
0 ≤ A[i] ≤ 9
```
---
### 🧪 Example
**Input:**
```text
3
3
1
2
```
**Output:**
```text
3
```
---
### 💡 Explanation
* 3 → stays as is
* 1 → rotate to 3 → cost = 2
* 2 → rotate to 3 → cost = 1
Total rotations = **3**
*/
public class VaultDigitAlignment {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];


        int totalRot = 0;
        int prev = arr[0];
        for(int i=1; i<n; i++){
            int curr = arr[i];
            if(curr < prev){
                int cost = (prev - curr + 10)%10;
                totalRot += cost;

                curr = prev; // crucial step, updated the curr with prev!!
            }
            prev = curr;
        }
        System.out.println(totalRot);
    }
}
/*upgrade yrslef ask urself: did i update my variable to reflect that change!
* or just modify the value/cost and left the variable there!!*/
