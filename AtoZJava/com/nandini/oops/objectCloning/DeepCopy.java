package com.nandini.oops.objectCloning;

// case 3: deep copy, REAL fix for shallow copy problem.
// Deep Copy Goal
// We want: completely independent objects
// Meaning:
// separate Client object
// separate Address object

// i'll copy all classes with 1 at their end as duplicates are not allowed in IDE

import Contest_CC_CF_LC_CSES.A;

class Address1 {
    String city;
}

class Client1 implements Cloneable{
    int reputation;
    Address1 address;

    Client1(int reputation, Address1 address){
        this.reputation = reputation;
        this.address = address;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
//        return super.clone(); // here we manually clone nested objects too.

        // creates shallow copy first
        Client1 cloned = (Client1) super.clone();

        // deep copy of nested object
        Address1 newAddress = new Address1();
        newAddress.city = this.address.city;

        cloned.address = newAddress;

        return cloned;
    }
}

public class DeepCopy {
    static void main() throws CloneNotSupportedException{
        Address1 a1 = new Address1();
        a1.city = "Delhi";

        Client1 c1 = new Client1(50, a1);
        Client1 c2 = (Client1) c1.clone();

        c2.address.city = "Mumbai";

        System.out.println(c1.address.city); // delhi
        System.out.println(c2.address.city); // mumbai

        // now changes are independent
        /*FINAL MEMORY DIAGRAM 🧠
        Deep Copy
        c1 --> Client --> Address("Delhi")

        c2 --> Client --> Address("Mumbai")

        Completely separate.*/
    }
}
