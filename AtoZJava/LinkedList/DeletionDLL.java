package LinkedList;

import static LinkedList.ArrayToDLL.printDLL;

public class DeletionDLL {
    public static DLLNode delHead(DLLNode head){
//        DLLNode temp = head;
//        DLLNode front = temp.next;
//        front.back = null;
//        temp.next = null;
//
//        return front;

        // there's no need for two veriable just modify head only...
        DLLNode prev = head;
        head = head.next;
        prev.next = null;
        head.back = null;

        return head;

    }

    public static DLLNode delTail(DLLNode head){
        DLLNode temp = head;

        // goal is to reach temp to the tail-1 then came to next-> works strivers modified (me)
//        while(temp.next.next != null){
//            temp = temp.next;
//        }
//        DLLNode next = temp.next;
//        temp.next = null;
//        next.back = null;

        // instead go and reach tail then came to prev as:
        DLLNode tail = head;
        while(tail.next != null){
            tail = tail.next;
        }
        DLLNode prev = tail.back;
        prev.next = null;
        tail.back = null;

        return head;
    }

    public static DLLNode delKthPos(DLLNode head, int k){

        DLLNode temp = head; // to reach to kth position node
        int cnt = 0;
        while(temp != null){
            cnt++;
            if(cnt == k){
                break;
            }
            temp = temp.next;
        }
        if(temp == null) return head;  // for k > n(length of list)

        DLLNode prev = temp.back;
        DLLNode front = temp.next;

        // edge cases before pushing the references:
        if(prev == null && front == null){
            // its single node
            return null;
        } else if(prev == null){
            // its head
            return delHead(head);
        } else if(front == null){
            // its tail
            return delTail(head);
        } else{
            // its any where in b/w the list
            prev.next = front;
            front.back = prev;

            temp.back = null;
            temp.next = null;
        }
        return head;
    }

    public static DLLNode delNode(DLLNode head, DLLNode node){
        DLLNode prev = node.back;
        DLLNode front = node.next;

        // edge cases before pushing the references:
        if(prev == null && front == null){
            // its single node
            return null;
        } else if(prev == null){
            // its head
            return delHead(head);
        } else if(front == null){
            // its tail
            return delTail(head);
        } else{
            // its any where in b/w the list
            prev.next = front;
            front.back = prev;

            node.back = null;
            node.next = null;
        }
        return head;

    }

    public static void main(String[] args) {
        int[] arr = new int[]{10, 20, 30, 40};

        DLLNode head = new DLLNode(arr[0], null, null);
        DLLNode prev = head;

        for(int i=1; i<arr.length; i++){
            DLLNode newNode = new DLLNode(arr[i], null, prev);
            prev.next = newNode;
            prev = prev.next;
        }
//        DLLNode res = delHead(head);
//        DLLNode res = delTail(head);
//        DLLNode res = delKthPos(head, 5);
        DLLNode res = delNode(head, head.next.next);

        printDLL(res);
    }
}
