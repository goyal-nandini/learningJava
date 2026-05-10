package com.nandini.oops.generics;

/*Generic CLASS
class Box<T>
Entire class can use T.
All methods inside class know about T.*/

class Box<T>{ // this class works for many types, T is like a datatype
    // T is datatype placeholder
    T value;

    void setValue(T value){
        this.value = value;
    }

    T getValue(){
        return value;
    }
}
public class genericClass {
    static void main() {
        Box<String> box = new Box<>();
        box.setValue("Hello");
        System.out.println("String: " + box.getValue());

        Box<Integer> box2 = new Box<>();
        box2.setValue(23);
        System.out.println("Integer: " + box2.getValue());

        Box<int[]> box3 = new Box<>();
        box3.setValue(new int[]{2, 3, 4});
        for(int i: box3.getValue()){
            System.out.print(i + " ");
        }
    }
}
