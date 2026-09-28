package com.nandini.oops.interfaces;

public class RobotSystem implements Robot{
    @Override
    public void start() {
        System.out.println("Robot mode activated - BEEP BOOP");
    }
}
