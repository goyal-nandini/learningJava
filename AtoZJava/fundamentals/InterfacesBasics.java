package fundamentals;
import java.lang.invoke.VarHandle;
import java.util.Arrays;

// Interface: a contract/job description
interface Vehicle{
    void start(); // no implementation, just declaration
    void stop();
    void accelerate(int speed);

    // every class implementing Vehicle must provide these methods
}

// Implementation:
class Car implements Vehicle{
    @Override
    public void start() {
        System.out.println("Car: Turn Key, engine starts.");
    }

    @Override
    public void stop() {
        System.out.println("Car: Press break, engine stops.");
    }

    @Override
    public void accelerate(int speed) {
        System.out.println("Car: Accelerating to " + speed + " Km/h");
    }
}

class Bike implements Vehicle{
    @Override
    public void start() {
        System.out.println("Bike: Kick start, engine roars");
    }

    @Override
    public void stop() {
        System.out.println("Bike: Hand brake, stops");
    }

    @Override
    public void accelerate(int speed) {
        System.out.println("Bike: Twisting throttle to " + speed + " km/h");
    }
}

public class InterfacesBasics {
    public static void main(String[] args) {
        Vehicle v1 = new Car(); // v1 is a Vehicle reference pointing to Car object
        Vehicle v2 = new Bike(); // v2 is a Vehicle reference pointing to Bike object
/*What does this mean?

Left side (Vehicle): The TYPE - what operations are allowed
Right side (new Car()): The ACTUAL OBJECT - which implementation is used
v1 can only call methods defined in Vehicle interface
But the BEHAVIOR comes from Car class*/

        v1.start();
        v1.stop();
        v1.accelerate(60);

        System.out.println();

        v2.start();
        v2.stop();
        v2.accelerate(80);

        testVehicle(v1);
        testVehicle(v2);

        demonstratePolymorphism();
        primitivesTest();
    }

    // this method gonna work with any Vehicle Implementation
    public static void testVehicle(Vehicle v){
        System.out.println("Testing:");
        v.start();
        v.stop();
        v.accelerate(100);
        System.out.println();
    }

    public static void demonstratePolymorphism(){
        // approach1: using Interface type
        Vehicle v1 = new Car(); // v1 and v2 are reference pointing to their respective objects
        Vehicle v2 = new Bike();

/*By these above stmts, You're saying:

"I have something that CAN DO vehicle operations"
"I don't care HOW it does them (Car, Bike, Truck, whatever)"
"Just give me something that follows the Vehicle contract"*/

        Vehicle[] vehicles = {v1, v2}; // here, this is an array of references

        System.out.println("v1 reference: " + v1);
        System.out.println("v2 reference: " + v2);

        for(Vehicle v: vehicles) { // what v is?? ans: v is a REFERENCE VARIABLE, not the object itself!
            // Each iteration, `v` points to a different object** in the array
            // When you call `v.start()`, it calls the method on the object `v` is pointing to

            System.out.println("Loop variable v: " + v);  // Same addresses!
            v.start();
            v.stop();
            v.accelerate(50);
            System.out.println("---");
        }

        // approach2: Using concrete types (INFLEXIBLE)
        Car c1 = new Car();
        Bike b1 = new Bike();

        // Can I put them in one array? NO!
        // Vehicle[] mixed = {c1, b1};  // This works
        // Car[] cars = {c1, b1};       // ERROR! Bike is not a Ca

        System.out.println("The power: With interface type, we can treat different objects uniformly!");

        // the ans of using this: Vehicle v1 = new Car();
        //  FLEXIBILITY & POLYMORPHISM:
        // can swap. write generic code, store diff objects/references together

    }

    public static void primitivesTest() {
        int[] numbers = {1, 2, 3};
        for(int num: numbers){
            // num gets a copy of the value
            num = 999; // it does not change the numbers array
        }

        System.out.println(Arrays.toString(numbers)); // [1, 2, 3]
        System.out.println();

        Vehicle car = new Car(); // v1 and v2 are reference pointing to their respective objects
        Vehicle bike = new Bike();
        Vehicle[] vehicles = {car, bike};

        for(Vehicle v: vehicles){
//            v = new Car(); // new Car object,  ❌ Does NOT change vehicles array or v1/v2
//            `v` gets a COPY of the reference, not the reference itself!

            v.accelerate(100);  // ✅ DOES call method on the actual object
            // this alone does change the actual object
            // because v points to same object
        }
        car.start();
        bike.start();
    }
}