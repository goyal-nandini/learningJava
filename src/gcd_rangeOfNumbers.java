// works well throughout, keep it up!!
   // also another way to find hcf just minor modification!! acc to me
// one important concept: Method Overloading.
// in Java, it is allowed to have two methods with the same name but different parameters.
// This concept is called method overloading.Method overloading allows a class to have more than
// one method with the same name, as long as their parameter lists are different.
//The Java compiler differentiates the overloaded methods by their method signatures.
// A method signature includes the method's name and the parameter list. The return type is not considered
// part of the method signature for method overloading.
import java.util.*;
public class gcd_rangeOfNumbers {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hcf of 12, 16, 24 is: ");
        long[] arr1 = {12, 16, 24};
        System.out.println(gcd(arr1));

        System.out.println("enter size of an array: ");

        int size = sc.nextInt();
        long[] arr2 = new long[size];

        System.out.println("Enter the numbers for which you want to calculate hcf: ");

        for(int i = 0; i < arr2.length; i++){
             arr2[i] = sc.nextInt();
        }

        System.out.println("hcf of the given range of numbers is: " + gcd(arr2));

    }
    public static long gcd(long a, long b) {
        // another great way of finding hcf of two numbers
        while (b > 0) {
            long temp = b;
            b = a % b; // % is remainder
            a = temp;
        }
        return a;
    }

    public static long gcd(long[] input){
        long result = input[0];
        for(int i = 1; i < input.length; i++){
            result = gcd(result, input[i]);
        }
        return result;
    }
}