package com.nandini.oops.interfaces;

// IMP:

// One interface extending MULTIPLE interfaces
// Interface can extend multiple interfaces — this is legal, unlike classes.

public interface PowerCar extends Engine, PowerEngine_extendingInterface {
    void turboBoost();
}

/*Que with ans:
Why would you extend interfaces?
Because sometimes you want to group related interfaces into one bigger contract.

// Instead of forcing every class to implement 3 interfaces separately
class Car implements Engine, Brake, MusicSystem { }

// You create one combined interface
interface FullCar extends Engine, Brake, MusicSystem { }

class Car implements FullCar { }  // cleaner, one word
*/
