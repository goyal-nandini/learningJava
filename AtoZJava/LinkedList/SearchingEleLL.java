package LinkedList;

public class SearchingEleLL {

    public static boolean isPresent(Node head, int ele){
        Node temp = head;
        while(temp != null){
            if(temp.data == ele) return true;
            temp = temp.next;
        }
        return false;
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
