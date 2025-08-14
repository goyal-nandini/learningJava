package LinkedList;

public class SearchingEleLL {

    public static boolean isPresent(Node head, int ele){

        // iterative approach: 🙌🙌📍📍🚩🚩👏👏
//        Node temp = head;
//        while(temp != null){
//            if(temp.data == ele) return true;
//            temp = temp.next;
//        }
//        return false;

        // recusive approach:🙌🙌
        // Check if we reach the end of the Linked List.
        if (head == null) {
            return false;
        }
        // Value found so will end our search.
        if (head.data == ele) {
            return true;
        }
        // Recurring for the next node.
        return isPresent(head.next, ele);
    }

    public static void main(String[] args) {
        Node head = new Node(10);

        Node second = new Node(20);
        head.next = second;

        Node third = new Node(30);
        second.next = third;

        System.out.println(isPresent(head, 40));
    }
}
