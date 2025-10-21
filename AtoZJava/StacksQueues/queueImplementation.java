package StacksQueues;

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
        if(currSize == queue.length){
            System.out.println("Queue is full");
            return;
        } else if(currSize == 0){
            start = 0; end = 0; // start filling the queue
        } else {
            end = (end+1) % queue.length;
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
            start = (start+1)%queue.length;
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

public class queueImplementation {
    public static void main(String[] args) {
        // Arrays
        // linkedList
        // stacks
        // offer(), poll(), peek(), size()
        ImplementationUsingArrays();
    }
    public static void ImplementationUsingArrays(){
        QueuesUsingArrays q = new QueuesUsingArrays(5);

        q.offer(20);
        q.offer(50);

        q.display();
        q.poll();

        System.out.print("After popping: ");
        q.display();

        q.peek();
        q.size();

    }


}
