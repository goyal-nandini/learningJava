package com.nandini.oops.interfaces;

// CONSTANT INTERFACE is an Anti-pattern
// ❌ Bad practice
/*A constant interface is a design pattern in Java where an interface is used solely to define constants,
but it is generally considered an anti-pattern due to its drawbacks.
What is a Constant Interface?
In Java, a constant interface is an interface that contains only constant values (typically public static final fields).*/

public interface CarConstants {
    int MAX_SPEED = 200;
    int MAX_BRAKE_FORCE = 100;
}

/*
And Car implements CarConstants just to access those — that pollutes Car's public API with constants
it doesn't "behave" like. Use a final class instead:

// ✅ Good practice
final class CarConstants {
    private CarConstants() {}  // not instantiable
    public static final int MAX_SPEED = 200;
}
*/
