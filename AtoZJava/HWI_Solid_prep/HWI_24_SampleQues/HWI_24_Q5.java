package HWI_Solid_prep.HWI_24_SampleQues;

// a very interesting problem:

/* 🧠 First understand deeply
You can:
rearrange whole string ✅
then cut into equal substrings

👉 That means:
each piece must have same character frequency

💡 KEY INSIGHT (MOST IMPORTANT)
👉 If you make k pieces
👉 then each character count must be divisible by k

🔥 Example
ababcc
freq:
a = 2, b = 2, c = 2

👉 possible k:
1 → always possible
2 → all divisible by 2 ✅
3 → not possible (2 not divisible by 3)

👉 max = 2
🚀 Final idea

👉 Let frequencies = f1, f2, f3 ...
👉 Answer =
GCD of all frequencies
🧠 Why GCD?
Because:
👉 GCD = largest number dividing all counts
🧪 Example 3
abccdcabacda
freq:
a = 4, b = 2, c = 4, d = 2
GCD:
gcd(4,2,4,2) = 2 ✅
⚡ Edge case
zzzzz
freq:
z = 5
👉 GCD = 5 → answer = 5
🧨 Final formula
Answer = gcd of all character frequencies

WHY GCD: Because:
👉 GCD = largest number dividing all counts

another example:
aaabbbcccdd
freq:
a = 3, b = 3, c = 3, d = 2

👉 GCD:
gcd(3,3,3,2) = 1
💡 Meaning
👉 Only 1 piece possible
You cannot split into equal parts because:
counts don’t divide evenly

⚡ Mental shortcut
If even ONE character breaks divisibility → answer becomes small (often 1)

🔥📌📌✨✨ Pattern locked
You now know:
👉 rearrange + equal pieces
→ frequency + GCD*/

import java.util.HashMap;
import java.util.Scanner;

public class HWI_24_Q5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next(); // len(S) 1 - 2 * 10^5

//        HashMap<Character, Integer> map = new HashMap<>();
        int[] freq = new int[26];
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);

//            map.put(ch, map.getOrDefault(ch, 0)+1);
            freq[ch-'a']++;
        }

        int g = 0;
        for(int i=0; i<26; i++){
            // have to find the gcd of these values
            if(freq[i] > 0){
                g = gcd(g, freq[i]);
            }
        }
        System.out.println(g);
    }
    // euclidean algorithm O(logn) time
    static int gcd(int a, int b){
        if(b==0)
            return a;
        else
            return gcd(b, a%b);

    }
}
