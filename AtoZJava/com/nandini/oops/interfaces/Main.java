package com.nandini.oops.interfaces;

public class Main {
    public static void main(String[] args) {
        Car car = new Car(); // Reference type is Car → compiler sees everything Car has.

        // way1.
//        car.start();
//        car.applyBrake();
//        car.playMusic("English");
//        car.pauseMusic();
//        car.stop();


        // way2. using interface references
        // Each reference only sees the methods of its own interface

        Engine e = car; //  only sees Engine's methods
        // or we can do like this as well: Engine e = new Car();
        Brake b = car;
        MediaPlayer mp = car;

        e.start();
        b.applyBrake();
        mp.playMusic("Song");
        mp.pauseMusic();
        e.stop();

        // accessing constants directly from interfaces
        System.out.println(Engine.MAX_SPEED);
        System.out.println(Brake.MAX_BRAKE_FORCE);

        // version 2
        // scene was this: we have two same method name under two diff interfaces with both methods of diff behaviour then
        // i implemented it under transformer class check robot and engine interface, both has start method basically
        // resolving this using composition,
        // Composition means: a class USES objects of other classes as its parts, instead of inheriting from them.
        // The class doesn't try to BE those things — it just HOLDS them and delegates work to them.

        // verified version of writing above:
        // VERSION 2 — Composition to resolve same method name conflict
        // Problem: Engine and Robot interfaces both have start()
        //          but with different behaviours
        // Solution: Instead of one class implementing both (conflict!),
        //           create separate classes — CarEngine implements Engine
        //                                  — RobotSystem implements Robot
        //           Then Transformer class CARRIES both as objects (composition)
        //           and delegates to the right one via startAsCar() / startAsRobot()

        // we have here composition over inheritance implementation
        Engine ee = new PetrolEngine();
        MediaPlayer mpp = new CDPlayer();

        NiceeCar niceeCar = new NiceeCar(ee, mpp);
        niceeCar.startCar();
        niceeCar.enjoyMusic();

//        Tomorrow you want an electric engine and bluetooth speaker instead:
//        we added two more classes and NiceeCar didn't change at all.
        NiceeCar tesla = new NiceeCar(new ElectricEngine(), new BluetoothSpeaker());
        tesla.startCar();
        tesla.enjoyMusic();

        // NiceeCar c1 = new NiceeCar(new PetrolEngine(), new CDPlayer());
        // NiceeCar c2 = new NiceeCar(new ElectricEngine(), new BluetoothSpeaker());
        // Same NiceeCar class — infinite combinations. Interface makes composition even more powerful.

/*version 2: So when DO you use inheritance then?
Inheritance is still valid when the relationship is genuinely IS-A:

Dog IS-A Animal          ✅ use inheritance
Car IS-A Engine          ❌ wrong — use composition
ElectricCar IS-A Car     ✅ use inheritance
Car HAS-A Engine         ✅ use composition
The test is simple — ask yourself:

"Is this truly an IS-A relationship, or is it a HAS-A relationship?"

If HAS-A → always go composition.

One Line Why
Inheritance locks you in. Composition keeps you free to swap, extend, and change without breaking everything.*/

    }
}


/*
its diff from composition here i am discussing over way1 and way2 above
Same object, different windows
                    ┌─────────────────────────┐
                    │         CAR             │
                    │  start()    stop()       │
                    │  applyBrake()            │
                    │  playMusic() pauseMusic()│
                    └─────────────────────────┘
                              ▲
              ┌───────────────┼───────────────┐
              │               │               │
         Engine e          Brake b        MediaPlayer mp
         sees only:        sees only:     sees only:
         start()           applyBrake()   playMusic()
         stop()                           pauseMusic()

All three point to the same Car object underneath — but each window is narrow.*/
