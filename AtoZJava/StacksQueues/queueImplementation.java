package StacksQueues;

import java.util.Stack;

class QueuesUsingArrays{
    private int[] queue;   // array for stack
    private int start;
    private int end;
    private int size;   // max size
    private int currSize;   // max size

    // constructor
    public QueuesUsingArrays(int size) {
        this.size = size;
        queue = new int[size];
        start = -1;
        end = -1;
        currSize = 0;
    }
    // queues -> FIFO two pointers -> start and end
    // theres lot of edge cases, so doing along vedio

/* ok tc: O(1) and sc: O(1) for each method
overall sc: O(n) and tc: O(1)

but
using a fixed array queue = new int[size];
🔹 Space = O(size) (this is the main memory used by the queue)
Variables like start, end, currSize use constant space → O(1)*/

    // offer method
    public void offer(int x){
        // think of when we can't push to queue
        if(currSize == size){
            System.out.println("Queue is full");
            return;
        } else if(currSize == 0){
            start = 0; end = 0; // start filling the queue
        } else {
            end = (end+1) % size;
        }
        // put value x in queue
        queue[end] = x;
        currSize++;
    }

    // poll method
    public void poll(){
        // del from start
        if(currSize == 0){ // first case is empty queue
            System.out.println("queue is empty");
            return;
        }
        int ele = queue[start];
        if(currSize == 1){ // second case can be queue has single element
            start = end = -1;
        } else { // third case can be to go and del start and move start ahead
            start = (start+1)%size;
        }

        currSize--;
        System.out.println("popped ele is: " + ele);
    }

    // peek method
    public void peek(){
        if(currSize == 0){
            System.out.println("Queue is empty");
            return;
        }
        System.out.println("top ele is: " + queue[start]);
    }

    // size method
    public void size(){
        System.out.println("Size of queue is: " + currSize);
    }

    // display stack // tc: O(n)
    public void display() {
        if (start == -1 && end == -1) {
            System.out.println("queue is empty!");
            return;
        }

        // took from 2024 dsa edition diary🤨
        int i=start;
        while(i != end){
            System.out.print(queue[i] + " ");
            i=(i+1)%queue.length;
        }
        System.out.println(queue[end]);
    }
}

class QueuesUsingLL{
    private Node start;
    private Node end;
    private int currSize;

    // constructor
    public QueuesUsingLL() {
        this.start = null;
        this.end = null;
        this.currSize = 0;
    }

    public void offer(int x){
        Node temp = new Node(x);

        if(start == null && end == null){ // empty queue
            start = temp;
            end = temp;
        } else{
            end.next = temp;
            end = temp;
        }
        currSize++;
    }
    public void poll(){
        if(start == null && end == null){
            System.out.println("Queue is empty");
            return;
        } else{
            System.out.println("popped ele is: " + start.data);
            Node temp = start;
            start = start.next;
            currSize--;
        }

    }
    public void peek(){
        if(start == null && end == null){
            System.out.println("Queue is empty");
            return;
        } else{
            System.out.println("top ele is: " + start.data);
        }
    }
    public void size(){
        System.out.println("Size is: " + currSize);

    }
    public void display(){
        Node temp = start;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

class QueuesUsingStack{
    // use of two stacks
    Stack<Integer> st1 = new Stack<>();
    Stack<Integer> st2 = new Stack<>();
    // approach1 -> here costly offer operations
    public void offer(int x){
        while (!st1.isEmpty()) {
            st2.push(st1.peek());
            st1.pop();
        }
        st1.push(x);
        while (!st2.isEmpty()) {
            st1.push(st2.peek());
            st2.pop();
        }
    }

    public void poll(){
        System.out.println("popped ele: " + st1.pop());
    }

    public void peek(){
        System.out.println("top ele: " + st1.peek());
    }

    public int size() {
        return st1.size();
    }

    public boolean isEmpty() {
        return st1.isEmpty();
    }

    public void display() {
        System.out.println("Queue elements (front to rear): " + st1);
    }

    // approach2 for higher push operations ->here costly poll operations
    public void offer_2(int x){
        st1.push(x);
    }

    public void poll_2(){
        if(!st2.isEmpty()) {
            st2.pop();
        }
        else{
            while (!st1.isEmpty()) {
                st2.push(st1.peek());
                st1.pop();
            }
        }
        System.out.println("popped ele: " + st2.pop());
    }

    // 👇👇👇 as above
    public int pop__() {
        if (st2.isEmpty()) {
            while (!st1.isEmpty()) {
                st2.push(st1.pop());
            }
        }
        return st2.isEmpty() ? -1 : st2.pop();
    }

    public void peek_2(){
        if(!st2.isEmpty()) {
            st2.peek();
        }
        else{
            while (!st1.isEmpty()) {
                st2.push(st1.peek());
                st1.pop();
            }
        }
        System.out.println("top ele: " + st2.peek());
    }

    // 👇👇👇 as above
    public int peek__() {
        if (st2.isEmpty()) {
            while (!st1.isEmpty()) {
                st2.push(st1.pop());
            }
        }
        return st2.isEmpty() ? -1 : st2.peek();

    }
    public int size_2() {
        return st1.size() + st2.size();
    }

    public boolean isEmpty_2() {
        return st1.isEmpty() && st2.isEmpty();
    }

    public void display_2() {
        Stack<Integer> temp = new Stack<>();
        while (!st2.isEmpty()) temp.push(st2.pop()); // taking reverse of st2
        for (int val : temp) System.out.print("ele from st2: " + val + " ");
        for (int i = 0; i < st1.size(); i++) System.out.print("ele from st1: " + st1.get(i) + " ");
        System.out.println();
        while (!temp.isEmpty()) st2.push(temp.pop()); // putting back to st2 from temp stack
    }
}

public class queueImplementation {
    public static void main(String[] args) {
        // Arrays
        // linkedList
        // stacks
        // offer(), poll(), peek(), size()
        // implementationUsingArrays();
//        implementationUsingLL();
        implementationUsingStacks();
    }
    public static void implementationUsingArrays(){
        QueuesUsingArrays q = new QueuesUsingArrays(5);

        q.offer(20);
        q.offer(50);
        q.offer(70);

        q.display();
        q.poll();

        System.out.print("After popping: ");
        q.display();

        q.peek();
        q.size();

    }
    public static void implementationUsingLL(){
        QueuesUsingLL q = new QueuesUsingLL();

        q.offer(20);
        q.offer(50);
        q.offer(70);
        q.offer(100);

        q.display();
        q.poll();

        System.out.print("After popping: ");
        q.display();

        q.peek();
        q.size();
    }
    public static void implementationUsingStacks(){
        QueuesUsingStack q = new QueuesUsingStack();

        // Approach 1
//        q.offer(20);
//        q.offer(50);
//        q.offer(70);
//        q.offer(100);
//        q.display(); // [20, 50, 70, 100]
//        q.poll();    // Popped ele: 20
//        q.peek();    // Front ele: 50
//        System.out.println("Size: " + q.size());
//        System.out.println("Is empty? " + q.isEmpty());

        // Approach 2
        q.offer_2(200);
        q.offer_2(300);
        q.offer_2(400);
        q.display_2();
        q.poll_2();    // Popped ele: 200
        q.peek_2();    // Front ele: 300
        System.out.println("Size: " + q.size_2());
        System.out.println("Is empty? " + q.isEmpty_2());
        q.display_2();
    }
}
