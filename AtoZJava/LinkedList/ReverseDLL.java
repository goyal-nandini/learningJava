package LinkedList;

import java.util.Stack;

import static LinkedList.ArrayToDLL.printDLL;

public class ReverseDLL {
    public static DLLNode brute_reverseDLL(DLLNode head){
        //using stack
        Stack<Integer> st = new Stack<>();
        DLLNode temp = head;
        while(temp != null){
            st.push(temp.data);
            temp = temp.next;
        }
        // putting back to LL from stack
        temp = head;
        while(temp != null){
            temp.data = st.pop();
            temp = temp.next;
        }
        return head;
    }

    public static DLLNode reverseDLL_byStriver(DLLNode head){
        // okay its 6/9/25 i am touching this after 15 days..no worries
        // i'll make it complete lets rock lets finish this...

        //some little changes like: only swapping the next and back references!! and one variable less
        // lets do it..!!
        DLLNode prev = null;
        DLLNode curr = head;
        while(curr != null){
            prev = curr.back;
            curr.back = curr.next;
            curr.next = prev;
            curr = curr.back;
        }

        return prev.back;

    }
    public static DLLNode reverseDLL_byMe(DLLNode head){
        // wow at one go just this line added and rest is same as reverse singly LL
        // wow i am so thankfullll for my prev rough lessons on dsa topics in dec 24...!!

        DLLNode next = head;
        DLLNode curr = head;
        DLLNode prev = null;

        while(next != null){
            next = next.next;
            curr.next = prev;
            curr.back = next;
            prev = curr;
            curr = next;
        }
        return prev;

    }
    public static void main(String[] args) {
        int[] arr = new int[]{10, 20, 30 , 40};

        DLLNode head = new DLLNode(arr[0], null, null);
        DLLNode prev = head;

        for(int i=1; i<arr.length; i++){
            DLLNode newNode = new DLLNode(arr[i], null, prev);
            prev.next = newNode;
            prev = prev.next;
        }

//        printDLL(brute_reverseDLL(head));
        printDLL(reverseDLL_byStriver(head));
//        printDLL(reverseDLL_byMe(head));

    }
}
