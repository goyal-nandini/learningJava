package com.nandini.oops.enums;

interface DayType{
    void message();
}

enum Week implements DayType {
    MONDAY(8), TUESDAY(6), WEDNESDAY(7), THURSDAY(5),
    FRIDAY(4), SATURDAY(0), SUNDAY(0);
    // Each constant (MONDAY, TUESDAY, etc.) is actually calling the private constructor of the enum.
    //The number in brackets (8, 6, 7) is passed into that constructor.

    private int holidaysHours; // instance veriable

    // constructor with parameter
    Week(int holidaysHours){
        this.holidaysHours = holidaysHours;

        System.out.println("constructor called for: " + this); // this refers to current enum constant object.
    }

    // method
    void displayHours(){
        System.out.println(this + " holiday hours: " + holidaysHours);
    }

    // getter
    public int getHolidaysHours(){
        return holidaysHours;
    }


    @Override
    public void message() {
        System.out.println("message from " + this);
    }
}
//Constructor Automatically Called: You NEVER do:
// new Week() => Java does it internally.
public class Main {
    static void main() {
        System.out.println("Holiday hours for Monday: " + Week.MONDAY.getHolidaysHours());

        for(Week w: Week.values()){
            System.out.println(w +
                    " ordinal = " + w.ordinal() +
                    " holidayHours = " + w.getHolidaysHours());
        }

        Week day = Week.valueOf("FRIDAY");
        System.out.println(day);

        // compare enums
        // accessing enum constant
        Week w1 = Week.MONDAY;
        Week w2 = Week.MONDAY;
        Week w3 = Week.SUNDAY;

        System.out.println(w1);

        System.out.println(w1 == w2); // true
        System.out.println(w1.equals(w2)); // true
        System.out.println(w1 == w3); // false
        System.out.println(w1.equals(w3)); // false

        w1.displayHours();
        w1.message();

        /*remember:  Enum Constants Are Objects
        This is THE biggest realization.
        Week.Monday
        is object of type:
        Week
        NOT just string/int constant 😄*/
    }

    // 4. Illegal things (commented out to show compiler errors)
    // enum SpecialWeek extends Week {} // ERROR: cannot extend enum

    // Week newDay = new Week();        // ERROR: cannot instantiate enum

    // enum BadEnum {
    //     public BadEnum() {}          // ERROR: constructors must be private
    // }
}
