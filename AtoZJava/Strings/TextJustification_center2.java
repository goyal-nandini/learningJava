package Strings;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*PS: here's the modified problem statement:

---

**Text Justification - Center Aligned**

Given an array of strings `words` and a width `maxWidth`, format the text such that each line has exactly `maxWidth`
characters and is **center justified**.

Rules:
- Pack as many words as you can in each line greedily
- Between words, at least one space must exist
- For center alignment, distribute extra spaces **equally on both left and right sides**
- If extra spaces can't be equally distributed, the **left side gets one more space** than the right
- The last line should be **center justified** as well (unlike LC 68)

**Example:**
```
words = ["What","must","be","shall","be"]
maxWidth = 12

Output:
"What must be"   → no extra spaces needed
"  shall be  "   → 2 left, 2 right
```
---
try modifying your LC 68 code for this — only the space distribution part changes!*/

public class TextJustification_center2 {
    public static List<String> fullJustify(String[] words, int maxWidth) {
        // lets do it with center justified variant:

        int n = words.length;
        List<String> res = new ArrayList<>();
        int i=0;
        while(i<n){
            int j = i+1;
            int lineLen = words[i].length();
            while(j<n && lineLen + 1 + words[j].length() <= maxWidth){
                lineLen += words[j].length()+1;
                j++;
            }

            // center alignment has two types of spaces: 1. inter-word spaces and 2. outer padding
            // build the line:

            // int wordCnt = j-i;
            // int gaps = wordCnt - 1;
            // int spaces = maxWidth - (lineLen - gaps);
            // int leftSpaces = spaces/2;
            // int rightSpaces = spaces - leftSpaces;

            int totalChars = lineLen; // words + minimum 1 space between them
            int padding = maxWidth - totalChars; // total outer padding
            int leftSpaces = (padding+1)/2; // left gets more if odd
            int rightSpaces = padding/2;

            StringBuilder sb = new StringBuilder();

            for(int s=0; s<leftSpaces; s++) sb.append(" ");
            for(int k=i; k<j; k++) {
                sb.append(words[k]);
                if(k < j-1) sb.append(" "); // space only between words
            }
            for(int s=0; s<rightSpaces; s++) sb.append(" ");

            res.add(sb.toString());
            i=j;
        }
        return res;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input words
        System.out.println("Enter words separated by spaces:");
        String line = sc.nextLine();
        String[] words = line.split("\\s+");

        // Input maxWidth
        System.out.println("Enter max width:");
        int maxWidth = sc.nextInt();

        List<String> output = fullJustify(words, maxWidth);

        // Print output
        System.out.println("\nJustified Text:");
        for (String justifiedLine : output) {
            System.out.println("\"" + justifiedLine + "\"");
        }

        sc.close();
//
//        String[] words = {
//                "Science","is","what","we","understand",
//                "well","enough","to","explain","to","a",
//                "computer.","Art","is","everything",
//                "else","we","do"
//        };

//        Test 1: ["What","must","be","shall","be"], maxWidth=12
//        Test 2: ["a"], maxWidth=5
//        Test 3: ["ab","cd","ef"], maxWidth=6
//        Test 4: ["this","is","a","long","line"], maxWidth=16
//        Test 5: ["single"], maxWidth=10

//        int maxWidth = 20;
//
//        List<String> output = fullJustify(words, maxWidth);
//
//        // print output
//        for (String line : output) {
//            System.out.println("\"" + line + "\"");
//        }
    }
}
