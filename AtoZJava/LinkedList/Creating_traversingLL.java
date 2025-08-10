package LinkedList;

// creating and traversing linked list:
// see this Node class will be used in entire package: so lets keep it same...
class Node{
    int data;
    Node next;

    Node(int data){
        this.data = data;
        this.next = null;
    }
}

public class Creating_traversingLL {
    public static void main(String[] args) {
        Node head = new Node(10);

        Node second = new Node(20);
        head.next = second;

        Node third = new Node(30);
        second.next = third;

        // traversing and printing the list:
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}