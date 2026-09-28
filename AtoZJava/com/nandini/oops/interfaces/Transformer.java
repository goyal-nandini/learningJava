package com.nandini.oops.interfaces;

public class Transformer {
    private Engine engine = new Car();
    private Robot robot = new RobotSystem();

    void startAsCar(){
        engine.start(); // Car engine started - VROOM
    }

    void startAsRobot(){
        robot.start(); // Robot mode activated - BEEP BOOP
    }

//    Composition solves the conflict — each behavior lives in its own class, no clash.
}
