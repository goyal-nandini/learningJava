// brute force method
// This method is straightforward but not very efficient, especially for large numbers,
// as it may require a lot of iterations.
// For a more efficient solution, using the relationship between LCM and GCD is recommended
//The brute-force method for finding the LCM involves generating multiples of the two numbers
// and comparing them to find the first common multiple.
//By incrementing s and t in multiples of a and b respectively, the method ensures that
// every possible multiple is checked until the first common one is found.
import java.util.*;
public class lcm1{
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       System.out.println("Enter the numbers a and b: ");
       int a = sc.nextInt();
       int b = sc.nextInt();
       int s, t = 0;
       for(int i = 1; ; i++){  //The outer loop runs indefinitely (i.e., it does not have
                               // a condition to stop; it uses a break statement to exit).
           s = a * i;         // multiples of a, storing in s
           for(int j = 1; t < s; j++){
               t = j * b;    // multiples of b, storing in t
           }
           if(s == t){      //Once a common multiple is found (i.e., s == t), break out of the
                            // loops and print the result.
               break;
           }
       }
        System.out.println("lcm of numbers is " + s);
    }
}
