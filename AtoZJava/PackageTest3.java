// subclassing an imported class
import myPack2.*;

class ClassC extends ClassB{
    int n = 10;
    void display(){
        System.out.println("ClassC");
        System.out.println("m: " + m);
        System.out.println("n: " + n);
    }
}
public class PackageTest3 {
    public static void main(String[] args) {
        ClassC objectC = new ClassC();
        objectC.display();
        objectC.displayB();

        ClassD ObjectD = new ClassD();
        ObjectD.display();
    }
}


