package StacksQueues;

import java.util.Stack;
// jo sir n kia hai vo hi hai same except 🚨👁️ and proven at GFG
public class infixToPostfix {
    public static void main(String[] args) {
        infixToPostfix sol = new infixToPostfix();
        String infix = "a+b*(c^d-e)^(f+g*h)-i";
        String prefix = sol.infixToPostfix(infix);
        System.out.println("Prefix expression: " + prefix);
    }
    public static String infixToPostfix(String exp) {
        // Write your code here -> okay lets do this

        int i=0;
        StringBuilder ans = new StringBuilder();
        char ch = exp.charAt(i);
        Stack<Character> st = new Stack<>();
        int n = exp.length();

        while(i < n){
            if((exp.charAt(i) >= 'A' && exp.charAt(i) <= 'Z') ||
                    (exp.charAt(i) >= 'a' && exp.charAt(i) <= 'z') ||
                    (exp.charAt(i) >= '0' && exp.charAt(i) <= '9')){
                // st.push(exp.charAt(i)); -> HUGE MISTAKE
                ans.append(ch);
            } else if(exp.charAt(i) == '('){
                st.push(ch);
            } else if(exp.charAt(i) == ')'){
                // we have to pop till we encounter '(' and add them to ans
                while(!st.isEmpty() && st.peek() != '('){
                    // ans += st.pop();
                    ans.append(st.pop());
                }
                st.pop(); // to pop '(' now
            } else{
                // now all operators come and we have to add them to ans acc to
                // their priority 🚨👁️
                while (!st.isEmpty() && st.peek() != '(' &&
                    ((priority(ch) < priority(st.peek())) ||
                    (priority(ch) == priority(st.peek()) && ch != '^'))) {
                    ans.append(st.pop());
                }
                st.push(ch);
            }
            i++;
        }
        // adding any left ones in stack to ans
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
