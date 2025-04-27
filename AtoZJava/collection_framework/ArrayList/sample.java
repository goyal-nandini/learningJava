package collection_framework;

public class sample {
    public static void main(String[] args) {
//        All arrays (whether int[], String[], double[]) inherit from the Object class.
        Object obj = new int[10];
        System.out.println(obj.getClass());  // class [I
        // [ means → it’s an array
       //  I means → it’s an array of int (primitive int)
        System.out.println(obj.getClass().getSuperclass()); //class java.lang.Object


//        Arrays are objects in Java created by special array classes, and they all
//        ultimately inherit from "java.lang.Object".
    }



}


