package StacksQueues;
//teacher told to implement Stack properly — inside a class (object-oriented way),
// not just static functions.

class StackUsingArray {
    private int[] st;   // array for stack
    private int top;    // top pointer
    private int size;   // max size

    // constructor
    public StackUsingArray(int size) {
        this.size = size;
        st = new int[size];
        top = -1;
    }
/*Time Complexity (TC): O(1)
Space Complexity (SC): O(1) → no extra space is used

SC (overall): O(n) — because of the array of size n (fixed).
TC (overall): O(1)

The stack object uses O(n) memory for the array (n = max size).
Each method itself uses only constant extra space O(1).

dis with arrays they are not dynamic in size so there might some extra space left in the array with stack*/

    // push method
    public void push(int x) {
        if (top < size - 1) {
            st[++top] = x;
        } else {
            System.out.println("Stack is full!");
        }
    }

    // pop method
    public void pop() {
        if (top == -1) {
            System.out.println("Stack is empty!");
        } else {
            System.out.println("Popped element: " + st[top--]);
        }
    }

    // peek method
    public void peek() {
        if (top == -1) {
            System.out.println("Stack is empty!");
            return;
        }
        System.out.println("top ele is: " + st[top]);
    }

    public void size(){
        System.out.println("Size is: " + top+1);
    }

    // display stack
    public void display() {
        if (top == -1) {
            System.out.println("Stack is empty!");
            return;
        }
        for (int i = 0; i <= top; i++) {
            System.out.print(st[i] + " ");
        }
        System.out.println();
    }
}

public class stackImplementation {
    static int top = -1; // shared top for all methods

    public static void main(String[] args) {
        // Arrays
        // linkedList
        // queues
        // push(), pop(), peek(), size()

        ImplementationUsingArrays();
    }
    public static void ImplementationUsingArrays(){
        int[] st = new int[10];
        StackUsingArray s = new StackUsingArray(5);

        s.push(10);
        s.push(20);

        s.display();
        s.pop();

        s.peek();
        s.size();
    }

}
