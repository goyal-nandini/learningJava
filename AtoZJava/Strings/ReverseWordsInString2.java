package Strings;

import java.util.Stack;

public class ReverseWordsInString2 {
    // trying using Stacks
    public static String reverseWords(String s){
        Stack<String> strStack = new Stack<>();

//        Step 1: Normalize the string (optional, handled cleverly here)
//        Add a space at the end of the string → s += " ";
//
//        This ensures even the last word gets processed, since loop breaks words at space.

        s += " ";

        // step: 2 from stiver
        String str = "";
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == ' '){ // for any trailing and leading spaces and multiple spaces.
                strStack.push(str);  // pushing "str" to stack strStack
                str = ""; // starting a new word
            } else{
               str += s.charAt(i); // add words to "str" String
            }
        }

        // this above:
        //it pushes even empty strings ("") when there are multiple spaces in a row.

        //That’s why in real implementations, people often check if str is not empty before pushing:

        // step: 3 from gpt as striver doesn't fit in!!(gives wrong as per step 2)
        // filling stack to "ans" String

//        String ans = "";
//        while(!strStack.isEmpty()){
//            if(!strStack.peek().isEmpty()){
//                ans += strStack.peek() + " ";
//            }
//            strStack.pop();
//        }
//        return ans.trim();  // remove the trailing space as above will add it after the last word

        // or can use stringbuilder (more efficient)
        StringBuilder ans2 = new StringBuilder();
        while (!strStack.isEmpty()) {
            String word = strStack.pop();
            if (!word.isEmpty()) {
                ans2.append(word).append(" ");
            }
        }
        return ans2.toString().trim();
    }

    public static void main(String[] args) {
        String s = "a good   example";
        System.out.println("After reversing words: ");
        System.out.println(reverseWords(s));

    }
}
