package Threads;

// must read this: https://www.w3schools.com/java/java_threads.asp

// 2 ways to create threads in java
// 1. extending Thread
// 2. implementing Runnable

class sampleA extends Thread{
    public void run(){
        System.out.println("hi");
    }
}

class sampleB implements Runnable{
    public void run(){
        System.out.println("hello");
    }
}

public class ThirdLesson {
    public static void main(String[] args) {
        // 1.
        sampleA obj1 = new sampleA();
        obj1.start();

        // 2.
        Runnable obj2 = new sampleB();
        Thread t2 = new Thread(obj2);
        t2.start();
    }
}

/*Que: why do we even have two ways?
Extending Thread looks easier, but:

❌ You are mixing task + thread
❌ You lose ability to extend another class (Java doesn’t allow multiple inheritance)

🧠 Runnable = Better design

With Runnable:

✔ You define task separately
✔ Thread just executes it
✔ More flexible
✔ Used in real-world (Executors, thread pools, etc.)
*
| Approach              | Meaning                             |
| --------------------- | ----------------------------------- |
| `extends Thread`      | “I am a thread”                     |
| `implements Runnable` | “I am a task to be run by a thread” |


Thread executes the Runnable
thread class hai aur runnable ek interface*/

/*📝📝from yt description:
* #1
Multiple Inheritance is not supported by Java. So, extending a thread is not a good practice to follow.
Thread is a class that implements Runnable and Runnable contains a method known as the run() method.
Instead of extending a thread, we can also implement it through an interface called Runnable.
 class A implements Runnable
 {
  public void run()
  {
   statements;
  }
 }

#2
In the Runnable method, the start() method is not present so we can not use it by implementing Runnable simply.
Thread has multiple constructors and one of the constructors takes a runnable object.
We cannot create an object of a thread by using a class name.
Objects for a thread will be created by using a Runnable keyword. So, we create a reference of an interface and an object of a class
e.g., Runnable obj= new A();
We have to pass a reference to an object in the thread class.
After creating a reference of the Runnable class, we can use the start() method with the thread.

#3
We can create a thread by using two methods:
 1. Extend a thread class
 2. Implement a Runnable interface
The runnable interface does not have thread methods, in that case, we need to create a separate thread object to use features.

#4
We can also instantiate a runnable interface by using an anonymous class.
Runnable is a functional interface so we also use lambda expression with it.*/
