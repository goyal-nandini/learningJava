package LinkedList;

public class LengthLL {

    // counting length
    public static int countLength(Node head){
        Node temp = head;
        int cnt = 0;
        while(temp != null){
            cnt++;
            temp = temp.next;
        }
        return cnt;
    }

    public static void main(String[] args) {
        // creating ll:
        Node head = new Node(10);
        Node second = new Node(20);
        head.next = second;

        System.out.println(countLength(head));

    }
}
