package myPack1;

public class ClassA {
    public void displayA(){
        System.out.println("ClassA");
    }
}

class ClassB{ // this is hidden class, as it is not public also we can't make it public
    // as java source file can have only one class declared as public becasue the file name is
    // same as the public class name
    public void displayB(){
        System.out.println("CLassB");
    }
}
