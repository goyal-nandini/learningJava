package collection_framework.stack;

import java.util.Stack;

public class Reverse_recursion {
    public static void main(String[] args) {

        // taking stack ds
        Stack<Integer> st = new Stack<>();
        st.push(21);
        st.push(-3);
        st.push(56);
        st.push(30);
        st.push(-7);

        System.out.println(st); // before
        reverse(st);
        System.out.println(st); // after
    }
    public static void reverse(Stack<Integer> st){
        // just same as we did for sorting...believe me just same steps...

        if(st.size() == 1) return;

        int temp = st.pop();
        reverse(st);

        insert(st, temp);
    }
    public static void insert(Stack<Integer> st, int temp){
        if(st.isEmpty()){
            st.push(temp);
            return;
        }

        int val = st.pop();
        insert(st, temp);

        st.push(val);
    }
}
