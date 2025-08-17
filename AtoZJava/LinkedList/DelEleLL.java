package LinkedList;

// well before insertion, deletion is preferred so let's do this from scratch:
public class DelEleLL {

    public static Node delHead(Node head){
//        head = head.next;

        // or my way but the logic is exactly same!!
        Node temp = null;
        temp = head.next;
        head = temp;
        return head;
    }

    public static Node delTail(Node head){
        Node prev = head;

        while(prev.next.next != null)
            prev = prev.next;

        prev.next = null;

        // 2nd way: i did this way in dec'24 so above is preferred clear and concise!!
        // Deletes the last node of the linked list
//        Node previous = null;  // Will store the node before the last node
//        Node current = head;   // Used to traverse the list
//
//        // Case 1: Empty list
//        if (head == null)
//            return null;
//
//        // Traverse until current reaches the last node
//        while (current.next != null) {
//            previous = current;
//            current = current.next;
//        }
//
//        // Case 2: Only one node in the list
//        if (current == head) {
//            head = null; // Remove the only node
//        }
//        // Case 3: More than one node
//        else {
//            previous.next = null; // Disconnect last node
//        }

        return head;

    }

    // pov: this function consider positions from 0 not 1 be carefull...i thought why not take indexing based...
    // as asked in codestudio!!
    public static Node delPos(Node head, int pos){
        // its logic is amazing: 1. we'll reach pos - 1(curr) location, 2. we'll assign a new variable(NodeToDel)
        // for next node(pos + 1) then with the help of newNode.next we jump from pos - 1 location...to pos + 1:>>
        // curr.next = NodeToDel.next

        if(pos < 0) return head;
        // Edge case: empty list
        if (head == null) return null;

        // Case 1: Deleting the first node (head)
        if (pos == 0) {
            head = head.next;
            return head;
        }

        // Traverse to the (pos - 1)-th node (previous node)
        Node curr = head;
        int i = 0;
        while (i < pos - 1 && curr != null) { // pov: if wondering when pos = 1 then direct jump to core part of the logic:🧠🧠
            curr = curr.next;
            i++;
        }

        // If position is invalid (pos > length of list)
        if (curr == null || curr.next == null) return head;

/*🚩 curr == null → we already fell off the list before reaching pos - 1.
🚩 curr.next == null → we reached the last node but pos is beyond it.
Both checks together cover all invalid positions without crashing. ✅*/

        // 🧠🧠
        // Node to delete
        Node nodeToDel = curr.next;

        // Link previous node to (pos + 1)-th node, skipping the target node
        curr.next = nodeToDel.next;

        return head;
    }

    // this provided by striver works from pos 1 and so on...
    public static Node delPos_Striver(Node head, int pos){
        if(pos == 1){
            head = head.next;
            return head;
        }
        int cnt = 0;
        Node temp = head;
        Node prev = null;

        while(temp != null){
            cnt++;
            if(cnt == pos){ // here doing pos+1 will make the code for pos from 0. 👏👏
                prev.next = prev.next.next;
                break;
            }

            prev = temp;
            temp = temp.next;

        }
        return head;

    }

    public static Node delVal(Node head, int ele){

        if (head == null) return null; // empty list case

        // if head is to be deleted
        if (head.data == ele) return head.next;

        Node curr = head;
        while (curr.next != null && curr.next.data != ele) {
            curr = curr.next;
        }

        // element found
        if (curr.next != null) {
            curr.next = curr.next.next;
        }
        return head;
    }

    public static Node delVal_Striver(Node head, int ele){

        if (head == null) return null; // empty list case

        if(head.data == ele)
            return head.next;

        Node temp = head;
        Node prev = null;

//        while(temp != null && temp.data != ele){
//            prev = temp;
//            temp = temp.next;
//        }
//
//        // If element was not found
//        if (temp == null) return head;
//
//        prev.next = prev.next.next;

        // or
        while(temp != null){

            if(temp.data == ele){ // here doing pos+1 will make the code for pos from 0. 👏👏
                prev.next = prev.next.next;
                break;
            }

            prev = temp;
            temp = temp.next;

        }


        return head;
    }

    public static void printLL(Node head){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40};

        Node head = new Node(arr[0]);
        Node mover = head;

        for(int i=1; i<arr.length; i++){
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover = mover.next;
        }
//        Node res = delHead(head);
//        Node res = delTail(head);
//        Node res = delPos(head, 1);
        Node res = delPos_Striver(head, 5);
//        Node res = delVal(head, 10);
//        Node res = delVal_Striver(head, 50);
       printLL(res);

    }
}
