package com.nandini.oops.inheritance;

public class Main {
    public static void main(String[] args) {
        Box box = new Box(4.6, 7.9, 9.9);
        Box box2 = new Box(box);

        System.out.println(box.h + " " + box.w);
//        System.out.println(box2.l + " " + box2.h + " " + box2.w);

        BoxWeight box3 = new BoxWeight();
        System.out.println(box3.h + " " + box3.weight);

        BoxWeight box4 = new BoxWeight(2, 5, 6, 80);

        //📌 A NEW CONCEPT follows!!
//        Box box5, -> box5 is a reference type of Box
//        new BoxWeight(), -> object of type boxWeight

        Box box5 = new BoxWeight(2, 3, 4, 8);
        System.out.println(box5.w);
//        System.out.println(box5.weight); //❌ as ERROR why??
//⭐⭐ GOLDEN RULE/REASON: It is the type of reference variable that actually determines
// what members can be accessed Not the type of object!!


//        BoxWeight box6 = new Box(1, 2, 3); //❌ as ERROR why??
/*The  problem:
You're trying to put a parent object into a child reference
This is NOT allowed in Java!

Think about it:
The "Box" object doesn't have a "weight" variable!

If this was allowed, "box6.weight" would try to access something that doesn't exist!
Java prevents this to avoid runtime errors!

-> more on nb :)
*/

        // QUICK test: over copy constructor:
        BoxWeight original = new BoxWeight(1, 2, 3, 50);
        BoxWeight copy = new BoxWeight(original);

        // Are they the same object?
        System.out.println(original == copy);  // false (different objects), yes they are!!

        System.out.println(copy);
        System.out.println(original);

        // Do they have same values?
        System.out.println(original.weight == copy.weight);  // true (same values)

        // New Topic: multilevel inheritance:
        BoxPrice box7 = new BoxPrice(5, 8, 200);
    }

/*THE  Rules 📋
✅ Allowed (Upcasting):
javaParent parent = new Child();  // ✅ Child IS-A Parent
Box box = new BoxWeight();    // ✅ BoxWeight IS-A Box

❌ Not Allowed (Downcasting without checking):
javaChild child = new Parent();   // ❌ Parent might not be a Child
BoxWeight bw = new Box();     // ❌ Box is not necessarily a BoxWeight*/


}
