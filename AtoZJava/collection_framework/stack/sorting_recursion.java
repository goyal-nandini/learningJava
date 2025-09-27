package collection_framework.stack;

import java.util.Stack;

public class sorting_recursion {
    public static void main(String[] args) {

//        will do kl 26/9/2025 friday...ok here i am at 18:30 pm now its 20:49

        // taking stack ds
        Stack<Integer> st = new Stack<>();
        st.push(21);
        st.push(-3);
        st.push(56);
        st.push(30);
        st.push(-7);

        sort(st);
        System.out.println(st); // Java prints the stack from bottom to top.
    }
    public static void sort(Stack<Integer> st){
        //base condition
        if(st.size() == 1) return;

        //hypothesis
        int temp = st.pop();
        sort(st);

        //induction
        insert(st, temp);
    }
    public static void insert(Stack<Integer> st, int temp){
        //base condition
/*For ascending (smallest at bottom, largest at top) -> keep:
if (st.isEmpty() || st.peek() <= temp)

For descending (largest at bottom, smallest at top) -> flip the sign:
if (st.isEmpty() || st.peek() >= temp)*/

        if(st.isEmpty() || st.peek() <= temp){
            st.push(temp);
            return;
        }

        //hypothesis
        int val = st.pop();
        insert(st, temp);

        //induction
        st.push(val);
    }
}
