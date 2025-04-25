import java.util.Scanner;
class ScannerClass {
    void printNumber() {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println(num);
    }
    public static void main(String[] args){
//        printNumber(); --> wrong
        ScannerClass obj = new ScannerClass();  // Create an instance of the class
        obj.printNumber();  // Call the non-static method using the object
    }
}