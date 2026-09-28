package HWI_Solid_prep.HWI_round1_ques;

/*## Spice Blend Sequencing (Hard)
### Problem Statement
A chef is creating a signature spice blend by combining spices from 2 different regional collections:
- **Collection A** has **N** spices
- **Collection B** has **M** spices

The chef must select **exactly K** spices in total to create the blend. At each step, the chef picks the next available
 spice from the **front of either Collection A or Collection B**. The original relative order of spices within each
 collection **must be preserved**.

Each spice has a **flavor profile** (an integer category) and an **intensity value**:
- **Intensity**: The intensity of every selected spice adds to the **score**
- **Harmony**: When two consecutive spices in the blend share the same flavor profile, a **Harmony Bonus of H** points
is added

**Find the maximum total score** (sum of intensities + harmony bonuses) achievable by selecting exactly K spices.

---

### Input Format
```
N
M
K
H
flavor1 intensity1   ← N lines for Collection A
...
flavor1 intensity1   ← M lines for Collection B
...
```

### Constraints
```
1 <= N <= 1000
1 <= M <= 1000
1 <= K <= N + M
1 <= H <= 10^5
1 <= A[i][flavor], A[i][intensity] <= 10^5
1 <= B[i][flavor], B[i][intensity] <= 10^5
```

---

### Sample Test Case

**Input:**
```
2
1
3
50
1 10
2 20
1 15
```

**Output:** `95`

**Explanation:** Select all 3 spices. Take B[0] (flavor 1, intensity 15) → A[0] (flavor 1, intensity 10) → A[1]
(flavor 2, intensity 20). B[0] and A[0] share flavor 1 → harmony bonus of 50.
Total = 15 + 10 + 20 + 50 = **95**
*/

public class SpiceBlendSequencing {
    public static void main(String[] args) {

    }
}
