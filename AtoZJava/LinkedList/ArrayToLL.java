package LinkedList;

public class ArrayToLL {
    //We want:
//        [10, 20, 30] → 10 → 20 → 30 → null

    // conversion from array to linked list
    public static Node array2LL(int[] arr){
        if(arr.length == 0) return null; // empty list

        // Create the head node from the first array element
        Node head = new Node(arr[0]);
        Node current = head; // "mover" pointer as by striver

        // Loop through the rest of the array
        for(int i=1; i<arr.length; i++){
            Node temp = new Node(arr[i]); // new node created
            current.next = temp;  // links that new node
            current = current.next; // move to the new node
        }
        return head; // this is the address of the first node, head
    }

    // traversing the linked list
    public static void printLL(Node head){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
    public static void main(String[] args) {

        int[] arr = new int[]{10, 20, 30, 40};
        Node head = array2LL(arr);
        printLL(head);
    }
}
