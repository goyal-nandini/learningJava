package LinkedList;


public class LLDemo {
    public static void main(String[] args) {
        // Step 1: Create two nodes
        Node head = new Node(10);
        Node second = new Node(20);

        // Step 2: Link them
        head.next = second;  // head → second

        // Step 3: Print details
        System.out.println("Head Node: " + head + " data = " + head.data);
        System.out.println("Second Node: " + second + " data = " + second.data);

        // Step 4: Show what 'next' holds
        System.out.println("head.next: " + head.next);
        System.out.println("second.next: " + second.next); // null
    }
}
