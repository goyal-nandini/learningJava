package StacksQueues;
//teacher told to implement Stack properly — inside a class (object-oriented way),
// not just static functions.

import java.util.LinkedList;
import java.util.Queue;

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

class Node{
    int data;
    Node next;

    Node(int data){
        this.data = data;
        this.next = null;
    }
}

class StackUsingLL{
    private Node top;    // top pointer
    private int currSize;

    // constructor
    public StackUsingLL() {
        this.top = null;
        this.currSize = 0;
    }

    public void push(int x){
        Node temp = new Node(x);
        if(top == null){ // empty stack
            top = temp;
        } else {
            temp.next = top;
            top = temp;
        }
        currSize++;
    }

    public void pop(){
        if(top == null){
            System.out.println("Stack is empty");
            return;
        } else{
            System.out.println("popped ele is: " + top.data);
            Node temp = top;
            top = top.next;
            currSize--;
        }
    }

    public void peek(){
        if(top == null){
            System.out.println("Stack is empty");
            return;
        } else{
            System.out.println("top ele is: " + top.data);
        }
    }

    public void size(){
        System.out.println("Size is: " + currSize);
    }

    public void display(){
        Node temp = top;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

class StackUsingQueues{
    Queue<Integer> q = new LinkedList<>();

/*trying to simulate LIFO (Last-In-First-Out) behavior using a FIFO
(First-In-First-Out) queue. The idea is to rotate the queue after each push
so that the newly added element comes to the front.*/
    public void push(int x){
        int size = q.size();

        q.offer(x);

        for(int i=1; i<=size; i++){
            q.offer(q.peek());
            q.poll();
        }
    }

    public void pop() {
        if (q.isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }
        System.out.println("Popped ele: " + q.poll());
    }

    public void peek() {
        if (q.isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }
        System.out.println("Top ele: " + q.peek());
    }

    public int size() {
        return q.size();
    }

    public void display() {
        System.out.println("Stack elements: " + q);
    }
}

public class stackImplementation {
    static int top = -1; // shared top for all methods

    public static void main(String[] args) {
        // Arrays
        // linkedList
        // queues
        // push(), pop(), peek(), size()

//        implementationUsingArrays();
//        implementationUsingLL();
        implementationUsingQueues();
    }
    public static void implementationUsingArrays(){
        int[] st = new int[10];
        StackUsingArray s = new StackUsingArray(5);

        s.push(10);
        s.push(20);

        s.display();
        s.pop();

        s.peek();
        s.size();
    }
    public static void implementationUsingLL(){
        StackUsingLL s = new StackUsingLL();

        s.push(10);
        s.push(20);
        s.push(30);

        s.display();
        s.pop();

        s.peek();
        s.size();

    }
    public static void implementationUsingQueues(){
        StackUsingQueues s = new StackUsingQueues();

        s.push(10);
        s.push(20);
        s.push(30);

        s.display();
        s.pop();

        s.peek();
        s.size();
    }

}
