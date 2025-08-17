package LinkedList;

import static LinkedList.ArrayToDLL.printDLL;

public class InsertionDLL {
    public static DLLNode insertBeforeHead(DLLNode head, int val){
        DLLNode temp = new DLLNode(val, head, null);
        head.back = temp;

        return temp;
    }

    public static DLLNode insertBeforeTail(DLLNode head, int val){
        DLLNode newNode = new DLLNode(val);
        DLLNode temp = head;

        while(temp.next != null){
            temp = temp.next;
        }
        DLLNode prev = temp.back;
        prev.next = newNode;
        newNode.back = prev;

        newNode.next = temp;
        temp.back = newNode;

        return head;
    }

    public static DLLNode insertBeforeKthPos(DLLNode head, int val, int k){
        DLLNode temp = head;
        int cnt = 0;
        while(temp != null){ // temp will at kth position
            cnt++;
            if(cnt == k) break;
            temp = temp.next;
        }
        if(temp == null) return head; // k is out of bounds
        DLLNode newNode = new DLLNode(val);
        DLLNode prev = temp.back;

        if(prev == null){ // means insertion before head
            return insertBeforeHead(head, val);
        }
        prev.next = newNode;
        newNode.back = prev;

        newNode.next = temp;
        temp.back = newNode;

        return head;
    }

    public static DLLNode insertBeforeNode(DLLNode head, int val, DLLNode node){
        DLLNode newNode = new DLLNode(val);
        DLLNode prev = node.back;

        if(prev == null) return insertBeforeHead(head, val);

        prev.next = newNode;
        newNode.back = prev;

        newNode.next = node;
        node.back = newNode;

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

//        DLLNode res = insertBeforeHead(head, 900);
//        DLLNode res = insertBeforeTail(head, 900);
//        DLLNode res = insertBeforeKthPos(head, 900, 1);
        DLLNode res = insertBeforeNode(head, 900, head.next.next);

        printDLL(res);

    }
}
