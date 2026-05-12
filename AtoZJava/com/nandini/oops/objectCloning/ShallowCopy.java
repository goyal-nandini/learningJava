package com.nandini.oops.objectCloning;

// case 2. shallow copy, outer object copied

class Address {
    String city;
}

class Client implements Cloneable{
    int reputation;
    Address address;

    Client(int reputation, Address address){
        this.reputation = reputation;
        this.address = address;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
public class ShallowCopy {
    static void main() throws CloneNotSupportedException {
        Address a1 = new Address();
        a1.city = "Delhi";

        Client c1 = new Client(90, a1);
        Client c2 = (Client)c1.clone();

        c2.reputation = 50;
        c2.address.city = "Mumbai";

        System.out.println(c1.reputation); // 90, does not affected, Because primitive copied separately.

        System.out.println(c1.address.city); // Mumbai, does got affected, Because BOTH point to SAME Address object.
        // because inner object shared.
        // Shallow Copy =
        // outer object copied, inner referenced objects shared.

        // Deep Copy Fixes This,
        // Deep copy creates: separate Address object too.
        // Then changes won’t affect original.

        // now, two client objects exist
        // memory after shallow copy
        /*c1 ---> Client object ----┐
                           ▼
                        Address("Delhi")

        c2 ---> Client object ----┘*/

        /*IMPORTANT

        Student object copied.

        BUT:

        Address object NOT copied.
        Both students share SAME address object.

        THAT is shallow copy.

        so what's get copied?
        | Field Type            | What Happens          |
        | --------------------- | --------------------- |
        | primitive (`int`)     | actual value copied   |
        | reference (`Address`) | only reference copied |
*/


    }
}
