package LinkedList;

class DLLNode{
    int data;
    DLLNode next;
    DLLNode back;

    DLLNode(int data1){
        this.data = data1;
        next = null;
        back = null;
    }
    DLLNode(int data1, DLLNode next1, DLLNode back1){
        this.data = data1;
        this.next = next1;
        this.back = back1;
    }
}

public class ArrayToDLL {
    public static void printDLL(DLLNode head){
        DLLNode temp = head;
        while (temp != null){
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.print("null");
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 4, 1};

        DLLNode head = new DLLNode(arr[0], null, null);
        DLLNode prev = head;

        for(int i=1; i<arr.length; i++){
            DLLNode newNode = new DLLNode(arr[i], null, prev);
            prev.next = newNode;
            prev = prev.next;
        }
        printDLL(head);

    }
}
