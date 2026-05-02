package Threads;

// race condition IMPORTANT
// threads and mutation are not good at same time
// mutability and immutability
// thread safe
// synchronized and join keyword

class Counter{
    int count;
    public synchronized void increment(){
        count++;
    }
}

class Sample1 implements Runnable{
    Counter c;
    Sample1(Counter c){
        this.c = c;
    }
    public void run(){
        for(int i=0; i<1000; i++){
            c.increment();
        }
    }
}

class Sample2 implements Runnable{
    Counter c;
    Sample2(Counter c){
        this.c = c;
    }
    public void run(){
        for(int i=0; i<1000; i++){
            c.increment();
        }

    }
}

public class FourthLesson {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Runnable obj1 = new Sample1(counter);
        Runnable obj2 = new Sample2(counter);

        Thread t1 = new Thread(obj1);
        Thread t2 = new Thread(obj2);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(counter.count);


    }

}
/*Alright, let’s break synchronized and join keywords down in **simple words**:

- **`synchronized`**:
  Imagine two people trying to add coins into the same jar at the same time. If they both reach in together, coins might get lost or counted wrong.
  `synchronized` is like saying: *“Only one person can touch the jar at a time.”*
  In your code, it makes sure that when one thread is incrementing `count`, no other thread can do it until the first one finishes. This prevents race conditions.

- **`join`**:
  Think of it like waiting for your friends before leaving.
  When you call `t1.join()`, the main program says: *“I’ll wait here until thread t1 finishes its work.”*
  Same for `t2.join()`.
  Without `join`, the main program might print the result before the threads are done, so you’d get an incomplete count.

### Together:
- `synchronized` → keeps the **counting safe** (no clashes).
- `join` → makes sure the **main program waits** until both threads finish before showing the final answer.

That’s why with both in place, you consistently see `Final count: 2000`.

🟢
With synchronized: one thread at a time → safe, consistent result.
Without synchronized: both threads race → unsafe, unpredictable result.

Without join → main thread races ahead, prints too early → incomplete result.
With join → main thread patiently waits → correct, complete result.
*/
/* 📝📝from yt description:
#1
Threads and Mutations:
Threads are useful when you want to execute multiple things at the same time.
Most of the time, threads are created by the framework itself.
Threads are used when you want to make things faster.

Mutations simply mean that you can change something.
Primitive type variables and primitive type objects are mutations as their value can be changed.
Strings are immutable as we cannot change their value of it.
Use of threads and mutations at the same time is not good, as it creates instability in the code.


#2
Thread Safe:
Thread safe means that only one thread will work at one point.
When a thread is already working on an object and preventing another thread from working on the same object, this process is called Thread-Safety.
If we have two threads and each thread is calling increment thousand times, then increment will be called two thousand times.
For the above case, every time you run the code you will get a different output for this.
This happens because the main method prints the value of the count at any moment of time, it does not wait for threads to execute completely and come back to the main method.
If the main method waits for threads to execute and to come back after completion, then it gives nearby correct output.

#3
join method and synchronized keyword:
join() is a method that allows the main method to wait for the other threads to come back and join.
join through an exception so we have to handle it by using throws Interruption.
If both threads go to the method at the same time then it might be possible that they will be lost some of the values in between.
The above problem will be resolved by using the synchronized keyword.
By using the synchronized, java ensures that the method will be called by only one method at a time to handle instability in code.
So, if a thread is working with the synchronized method, then the other thread has to wait to work with that method until the first thread gets completed.
Synchronization in java is the capability to control the access of multiple threads to any shared resource.

#4
Race condition:
Synchronization helps to prevent the race condition.
Race condition is a condition in which the critical section (a part of the program where shared memory is accessed) is concurrently executed by two or more threads. It leads to incorrect behaviour of a program.*/
