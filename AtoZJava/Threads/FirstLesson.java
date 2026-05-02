package Threads;

// first time thread implementation from yt vedio of TELUSKO

// threads
// time sharing,
// context switching
// concept of schedular

// using threads both methods are running simultaneously but due to speed first method keep executing at same time
// of calling second method and we are seeing such output many hi then many hello many hi many hello => not strict alt!!

// be setting priority also we are seeing same result as above as we can't control the schedular instead we can only
// suggest our schedular to make it high prior => use of thread priority, setPriority(), getPriority()
// we can only optimise the code to instruct the schedular, can't control it

// want hi and hello print exact alternately only hi hello hi hello - can use sleep method - still not strict
// then go to second lesson i used more to strictly follow strict alt hi hello

class A extends Thread{
    public void run(){
        for(int i=0; i<50; i++){
            System.out.println("hi");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class B extends Thread{
    public void run(){
        for(int i=0; i<50; i++){
            System.out.println("hello");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}

public class FirstLesson {
    static void main(String[] args) {
        A obj1 = new A();
        B obj2 = new B();

        // priority has a value from 1 to 10
        // every thread has by default has normal priority of 5
        System.out.println(obj1.getPriority());
        System.out.println(obj2.getPriority());

        obj1.setPriority(Thread.MAX_PRIORITY); // = 10 max priority
        obj2.setPriority(Thread.MIN_PRIORITY); // = 1

        obj1.start();
        obj2.start();
    }
}

// remember: 🎯 What exception does wait() throw?
//👉 It throws:
//InterruptedException
