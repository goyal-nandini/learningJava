package LinkedList;

public class getNthNodeFromEnd {
    public static void main(String[] args) {
            // get a ll first
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);

        // Traverse and print
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }
        System.out.println("null");

        System.out.println(getNthNodeFromBackOfLL(head, 1).data);
        System.out.println(getNthFromback(head, 1).data);
    }
    public static Node getNthFromback(Node head, int n){
//        3️⃣ Two-Pointer with Dummy Node (Safe Version)
//        Idea:
//        Introduce a dummy node pointing to head to simplify edge cases.
//
//                Move fast N steps from dummy, then move slow and fast together until fast.next == null.
//                slow.next is the answer.

            if (head == null || n <= 0) return null;

            Node dummy = new Node(0);
            dummy.next = head;
            Node slow = dummy, fast = dummy;

            // Move fast n steps
            for (int i = 0; i < n; i++) {
                if (fast.next == null) return null; // list size < n
                fast = fast.next;
            }

            // Move both until fast reaches last node
            while (fast.next != null) {
                slow = slow.next;
                fast = fast.next;
            }

            return slow.next;
//✅ Advantage:
//        Handles n == length automatically
//        Cleaner and safer for edge cases
    }
    public static Node getNthNodeFromBackOfLL(Node head, int n){
        //1️⃣brute:
        //Time: O(2L) → O(L)
        //Space: O(1)

//        Node temp = head;
//        int cnt = 0;
//        while(temp != null){
//            cnt++;
//            temp = temp.next;
//        }
//
//        //for n is cnt
//        if(cnt == n) return head;
//
//        // we have to look for (cnt - n + 1)th node from front
//        int res = cnt - n + 1;
//        temp = head;
//        while(res != 1){
//            temp = temp.next;
//            res--;
//        }
//        return temp;

        //2️⃣optimal:two pointer approach
        //Time: O(L) → single traversal
        //Space: O(1)

        //Edge Case:
        //N == length → return head
        //N > length → return null

        Node fast = head;
        Node slow = head;

        for(int i=0; i<n; i++) fast = fast.next;
        if(fast == null) return head;

        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        return slow.next;

    }
}
