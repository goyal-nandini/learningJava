package LinkedList;

//Building the Linked List while linking
//We can use the Node(int data, Node next) constructor to avoid a separate
// current.next = ... step.

//i saw on online compilers like this:

class Node2 {
    int data;
    Node2 next;

    /*🚩🚩👏👏Empty Constructor in Node Class:
Lets you create a Node object without immediately providing data or next.
Defaults: data = 0, next = null.
Useful for:
    @@ Creating placeholder/dummy head nodes.
    @@ Initializing first, then setting values later.
    @@ Supporting frameworks or test code that require a no-arg constructor.
Rarely used in basic LL problems, but kept for flexibility.*/

    Node2() {
        this.data = 0;
        this.next = null;
    }

    Node2(int data) {
        this.data = data;
        this.next = null;
    }

    Node2(int data, Node2 next) {
        this.data = data;
        this.next = next;
    }
}


public class CreatingLL2 {
    public static Node2 constructLL(int[] arr) {
        Node2 head = null;

        // Build from the end to the start
        for (int i = arr.length - 1; i >= 0; i--) {
            head = new Node2(arr[i], head);
        }

        return head;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4};

        Node2 head = constructLL(arr);

        System.out.println(head.data);
    }
}
