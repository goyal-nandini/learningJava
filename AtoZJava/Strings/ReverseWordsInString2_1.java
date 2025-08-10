package Strings;

import java.util.Stack;

public class ReverseWordsInString2_1 {
    public static String reverseWords(String s){
        Stack<String> strStack = new Stack<>();

        s += " ";  // ✅ Add a space to handle the last word in the loop

        String str = "";
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ' '){         // ✅ A word ends when space is found
                if(!str.isEmpty())          // ✅ Ignore multiple spaces (important)
                    strStack.push(str);     // ✅ Push complete word into the stack
                str = "";                   // ✅ Reset for next word
            } else {
                str += s.charAt(i);         // ✅ Keep building the current word
            }
        }
        // this above:
        // Skips multiple spaces automatically by checking if the str is not empty before pushing.

        //Keeps building each word character by character.

        // same as striver's
        // ✅ Build final string from stack (reversed order)
        String ans = "";
        while(strStack.size() > 1){         // ✅ Leave last word to avoid trailing space
            ans += strStack.peek() + " ";
            strStack.pop();
        }
        ans += strStack.peek();             // ✅ Add last word (no extra space)

        // this above:
        // Pops one by one and appends to the result with a space.

        //Handles last word separately to avoid trailing space.
        return ans;
    }

    public static void main(String[] args) {
        String s = "a good   example";
        System.out.println("After reversing words: ");
        System.out.println(reverseWords(s));

    }
}
