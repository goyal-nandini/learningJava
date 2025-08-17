package LinkedList;

import static LinkedList.ArrayToDLL.printDLL;

public class ReverseDLL {
    public static DLLNode reverseDLL(DLLNode head){
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

        printDLL(reverseDLL(head));

    }
}
