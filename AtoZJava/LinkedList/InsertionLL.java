package LinkedList;
// Note: dont get confused with multiple ways to do insertion and deletion, ultimately rely on those adjusting the ref-
//erences in their next part of the node, <<< just focus on the logic, POV: follow Striver's, his has some simplicity and clarity!!

public class InsertionLL {
    public static Node insertInBeg(Node head, int ele){
        Node temp = new Node(ele);
        temp.next = head;
        head = temp;

       return head;
    }

    public static Node insertAtEnd(Node head, int ele){
        if(head == null){ // if empty list
            return new Node(ele);
        }
        Node mover = head; // for reaching to last node
        Node temp = new Node(ele);

        while(mover.next != null){
            mover = mover.next;
        }
        mover.next = temp; // assigning last node to temp node and we're good to go!!

        return head;
    }

    public static Node insertKthPos_Striver(Node head, int val, int pos){
        // pos from 1, but asked from 0 in codestudio problem...changes at @@## gives res
        if(head == null)
            if(pos==1) // @@## pos == 0
                return new Node(val);
            else return head;

        if(pos == 1){ // @@## pos == 0
            Node temp = new Node(val);
            temp.next = head;
            head = temp;
            return head;
        }

        Node mover = head;
        int cnt = 0; // start from 1 because mover is at position 1

        while (mover != null) { // in my pov: this is better to check for null o/w u can see
            // following code for checking null explicitly...this one way check is i think great to
            // get results!!
            cnt++;
            if(cnt == pos - 1){ // @@## cnt == pos
                Node temp = new Node(val);
                temp.next = mover.next;
                mover.next = temp;
                break;
            }
            mover = mover.next;
        }
        return head;
    }

    public static Node insertKthPos(Node head, int val, int pos){
        if(pos == 0){ // 0 based indexing and positioning
            Node temp = new Node(val);
            temp.next = head;
            head = temp;

            return head;
        }

        Node mover = head;
        int cnt = 0; // start from 0 because mover is at position 0

        // Move until the node just before the insertion point
        while (cnt < pos - 1 && mover.next != null) {
            mover = mover.next;
            cnt++;
        }

        // If mover is null, position is invalid
        if (mover == null) {
            System.out.println("Position out of bounds");
            return head;
        }

        Node temp = new Node(val); // temp is newNode
        temp.next = mover.next;
        mover.next = temp;

        return head;
    }

    public static Node insertBeforeVal(Node head, int val, int num){
        // inserting num before val
        if(head.data == val){
            Node temp = new Node(num);
            temp.next = head;
            head = temp;
            return head;
        }

        Node mover = head;
        while (mover.next != null) {
            if(mover.next.data == val) {
                Node temp = new Node(num);
                temp.next = mover.next;
                mover.next = temp;
                break;
            }
            mover = mover.next;
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
        // creating LL from an Array
        int[] arr = {10, 20, 30, 40};

        Node head = new Node(arr[0]);
        Node mover = head;
        for(int i=1; i<arr.length; i++){
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover = mover.next;
        }
//        head = insertInBeg(head, 60);
//        head = insertAtEnd(head, 70);
//        head = insertKthPos(head, 900, 5);
        head = insertKthPos_Striver(head, 900, 3);
//        head = insertBeforeVal(head, 30, 500);
        printLL(head);


    }
}
