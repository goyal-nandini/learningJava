package LinkedList;


public class DLLDeleAllOccurrances {
    public static void main(String[] args) {
        DLLNode head = new DLLNode(1);
        head.next = new DLLNode(2);
        head.next.back = head;
        head.next.next = new DLLNode(3);
        head.next.next.back = head.next;
        head.next.next.next = new DLLNode(2);
        head.next.next.next.back = head.next.next;
        head.next.next.next.next = new DLLNode(4);
        head.next.next.next.next.back = head.next.next.next;
        head.next.next.next.next.next = new DLLNode(2);
        head.next.next.next.next.next.back = head.next.next.next.next;

        int k = 2;
        DLLNode updatedHead = DLLDeleAllOccurrances.deleteAllOccurrences(head, k);

        DLLNode curr = updatedHead;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }
    // now good to go ive done it here, gfg, cn okay...
    // now time for tcs codevita then w'll do bit manipulation and recursion for the day!!
    // and then do next two dll medium problems then watched their vedios!!
    public static DLLNode deleteAllOccurrences(DLLNode head, int k) {
        // Write your code here.
        DLLNode currNode = head;
        DLLNode prvNode = null;

        while(currNode != null){
            DLLNode nextNode = currNode.next;
            if(currNode.data == k){
                if(currNode == head){
                    head = currNode.next;
                    if(head != null){
                        head.back = null;
                    }
                } else {
                    if(prvNode != null){
                        prvNode.next = nextNode;
                    }
                    if(nextNode != null){
                        nextNode.back = prvNode;
                    }
                }
            } else {
                // when curr node is not deleted
                prvNode = currNode;
            }
            currNode = currNode.next;

        }
        return head;
    }
}
