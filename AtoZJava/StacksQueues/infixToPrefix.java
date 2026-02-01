package StacksQueues;

import java.util.Stack;
// jo sir n kia hai vo hi hai same and proven at GFG

public class infixToPrefix {
    public static void main(String[] args) {
            infixToPrefix sol = new infixToPrefix();
            String infix = "a+b*(c^d-e)^(f+g*h)-i";
            String prefix = sol.infixToPrefix(infix);
            System.out.println("Prefix expression: " + prefix);
    }
    public String infixToPrefix(String s) {
         // code here -> okay lets do it...(i didn't found on Coding ninjas
         // so doing here GFG) uff gfg koi tc pass ni ho rha...!!

         // 1. reverse the string
         String str = reverse(s);
         // 2. controlled postfix conversion
         String postfixStr = postfixConversion(str);
         // 3.reverse that above expression
         return reverse(postfixStr);
     }
     public String reverse(String str) {
         char[] arr = str.toCharArray();
         int l = 0, r = arr.length - 1;

         while (l < r) {
             char temp = arr[l];
             arr[l] = arr[r];
             arr[r] = temp;
             l++;
             r--;
         }

         // Now fix brackets
         for (int i = 0; i < arr.length; i++) {
             if (arr[i] == '(') arr[i] = ')';
             else if (arr[i] == ')') arr[i] = '(';
         }
         for(char c: arr){
             System.out.print(c + " ");
         }
         System.out.println();
         return new String(arr);
     }
     public String postfixConversion(String s){
         // go for operand first
         int i=0;
         int n = s.length();
         Stack<Character> st = new Stack<>();
         StringBuilder ans = new StringBuilder();
         while(i < n){
             char curr = s.charAt(i);
             if((curr >= 'A' && curr <= 'Z')
                 || (curr >= 'a' && curr <= 'z')
                 || (curr >= '0' && curr <= '9')){
                     ans.append(curr);
             } else if(curr == '('){
                 st.push(curr);
             } else if(curr == ')'){
                 while(!st.isEmpty() && st.peek() != '('){
                     ans.append(st.pop());
                 }
                 st.pop();
             } else {
                 // time for operators

//                 while (!st.isEmpty() && st.peek() != '(' &&
//                       ((priority(curr) < priority(st.peek())) ||
//                       (priority(curr) == priority(st.peek()) && curr != '^'))) {
//                     ans.append(st.pop());
//                 }
                  if(curr == '^'){
                       while(!st.isEmpty() && priority(curr) <= priority(st.peek())){
                           ans.append(st.pop());
                       }
//                      while (!st.isEmpty() &&
//                            ((priority(curr) < priority(st.peek())) ||
//                            (priority(curr) == priority(st.peek()) && curr != '^'))) {
//                          ans.append(st.pop());
//                      }
                  } else {
                      while(!st.isEmpty() && priority(curr) < priority(st.peek())){
                          ans.append(st.pop());
                      }
                  }
                 st.push(curr);
             }
             i++;
         }
         while(!st.isEmpty()){
             ans.append(st.pop());
         }
         return ans.toString();
     }
     public static int priority(char ch){
         if(ch == '^') return 3;
         else if(ch == '*' || ch == '/') return 2;
         else if(ch == '+' || ch == '-') return 1;
         else return -1;
     }
}
