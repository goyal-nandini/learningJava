package LinkedList;

import java.util.Stack;

import static LinkedList.ArrayToLL.printLL;

public class ReverseLL {
    public static Node brute_reverseLL(Node head){
        //using stack
        Stack<Integer> st = new Stack<>();
        Node temp = head;
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

    public static Node recursive_reverseLL(Node head){
        // okay its 6/9/25 i am touching this after 15 days..no worries i'll make
        // it complete lets rock lets finish this...
        if(head == null || head.next == null) return head;

        Node newHead = recursive_reverseLL(head.next);
        Node front = head.next;
        front.next = head;
        head.next = null;
        return newHead;
    }

    public static Node iterative_reverseLL(Node head){
        Node next = head;
        Node curr = head;
        Node prev = null;

        while(next != null){
            next = next.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    public static void main(String[] args) {
        // creating LL from an Array
        int[] arr = {10, 20, 30, 40};

        Node head = new Node(arr[0]);
        Node mover = head;
        for(int i=1; i<arr.length; i++){
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover = mover.next;
        }

//        printLL(brute_reverseLL(head));
        printLL(recursive_reverseLL(head));
//        printLL(iterative_reverseLL(head));


    }
}
