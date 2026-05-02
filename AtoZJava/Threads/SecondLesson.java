package Threads;

/* threads must communicate through a shared resource
 how threads share data, how to pass shared data

 now "turn" is of no use, Declaring shared state ≠ using shared state
 next we first enforce, Only one thread can access shared logic at a time

 now i can see a thread runs then turn flip and only execute that other thread only
 no wait at all, as i am getting => hi hello bsss

 so we'll replace if(condition) to while(condition not met) wait() and use notify()
 one ques: When shared.turn != 0, what does thread A do?
 when A hits this condition, Thread A doesn't stop instead it
    skips the if block
    continues the loop
    goes to next iteration
    checks again
    keeps looping fast

🟢
So actual behavior is:
Thread A is still running — just not printing

It’s basically:
check → skip → check → skip → check → skip

This is called:
Busy waiting (wasting CPU cycles)

🟢
Key correction to your thinking

❌ Threads don’t automatically hand over control
✅ Threads must explicitly wait or yield

🚀 What we actually want

Instead of:
“if not my turn → skip”

We need:
“if not my turn → WAIT (block myself)”

🟢 i used synchronised(), wait(), notify(), try-catch block, busy waiting

🟢
this way we moved from:
❌ random concurrency
❌ busy waiting
❌ wrong assumptions

to:

✅ thread coordination
✅ proper blocking
✅ OS-level synchronization thinking

QUE: why used "shared object" with every "method call" of threads
https://chatgpt.com/s/t_69f4e8740e4481918ae0262bfd045f4f

 */


class Shared{
    int turn = 0; // 0 = A, 1 = B
}
class AA extends Thread{
    Shared shared;

    AA(Shared shared){
        this.shared = shared;
    }

    public void run(){
        for(int i=0; i<50; i++){
            synchronized (shared){
                while(shared.turn != 0){
                    try {
                        shared.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

                System.out.println("hi");
                shared.turn = 1;

                shared.notify();

//                if(shared.turn == 0){
//                    System.out.println("hi");
//                    shared.turn = 1;
//                }
            }
//            System.out.println("hi");
        }
    }
}

class BB extends Thread{
    Shared shared;

    BB(Shared shared){
        this.shared = shared;
    }

    public void run(){
        for(int i=0; i<50; i++){
            synchronized (shared){
                while(shared.turn != 1){
                    try {
                        shared.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

                System.out.println("hello");
                shared.turn = 0;

                shared.notify();

//                if(shared.turn == 1){
//                    System.out.println("hello");
//                    shared.turn = 0;
//                }
            }
//            System.out.println("hello");
        }
    }
}
public class SecondLesson {
    public static void main(String[] args) {
        Shared shared = new Shared();

        AA obj1 = new AA(shared);
        BB obj2 = new BB(shared);

        obj1.start();
        obj2.start();
    }
}
