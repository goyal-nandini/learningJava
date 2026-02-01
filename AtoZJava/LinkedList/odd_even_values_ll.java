package LinkedList;

public class odd_even_values_ll {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 1, 4, 3, 6, 5};
        ListNode head = array2LL(arr);

        System.out.print("Original List: ");
        printList(head);

        head = oddEvenList_1(head);

        System.out.print("After Odd-Even Grouping (by value): ");
        printList(head);
    }

    // bubble-sort–style grouping: odds before evens
    public static ListNode oddEvenList_1(ListNode head) {
        if (head == null) return null;

        ListNode temp;
        int cnt = 0;

        // count ListNodes
        temp = head;
        while (temp != null) {
            cnt++;
            temp = temp.next;
        }

        // bubble passes
        for (int i = 0; i < cnt; i++) {
            temp = head; // reset each pass
            while (temp != null && temp.next != null) {
                if (temp.data % 2 == 0 && temp.next.data % 2 == 1) {
                    // swap values
                    int tmp = temp.data;
                    temp.data = temp.next.data;
                    temp.next.data = tmp;
                }
                temp = temp.next;
            }
        }

        return head;
    }

    // convert array to linked list
    public static ListNode array2LL(int[] arr) {
        if (arr.length == 0) return null;

        ListNode head = new ListNode(arr[0]);
        ListNode curr = head;
        for (int i = 1; i < arr.length; i++) {
            curr.next = new ListNode(arr[i]);
            curr = curr.next;
        }
        return head;
    }

    // print the linked list
    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}

// ListNode definition
class ListNode {
    int data;
    ListNode next;

    ListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

