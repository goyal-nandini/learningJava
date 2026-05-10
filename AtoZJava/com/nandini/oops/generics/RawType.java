package com.nandini.oops.generics;

import java.util.ArrayList;

class Box2<T> {

    T value;

    void setValue(T value) {
        this.value = value;
    }

    T getValue() {
        return value;
    }
}

public class RawType {
    static void main() {
        Box2 Box2 = new Box2();

        Box2.setValue("Hello");
        Box2.setValue(10);

        System.out.println(Box2.getValue()); // type safety is gone

/*Why Raw Types Exist?
Backward compatibility.
Old Java (before generics) had:
ArrayList list = new ArrayList();
Java couldn't break old code after introducing generics.*/

        ArrayList list = new ArrayList();

        list.add("Hello");
        list.add(10);

        String s = (String) list.get(1);
        System.out.println(s);

        // See runtime explosion 💥 => ClassCastException
    }
    
}
