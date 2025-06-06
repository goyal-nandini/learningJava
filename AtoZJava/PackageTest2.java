import myPack2.ClassB;
import myPack1.ClassA;
public class PackageTest2 {
    public static void main(String[] args) {
        ClassB objectB = new ClassB();
        ClassA objectA = new ClassA();
        objectB.displayB();
        objectA.displayA();
    }
}
