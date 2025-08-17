package LinkedList;

import static LinkedList.ArrayToLL.printLL;

public class ReverseLL {
    public static Node reverseLL(Node head){
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

        printLL(reverseLL(head));


    }
}
