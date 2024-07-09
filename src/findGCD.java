// A NEW WAY
//Euclid's method for computing the greatest common divisor of two positive integers consists of
// replacing the larger number with the difference of the numbers, and repeating this until the two numbers are equal:
// that is their greatest common divisor.(USED IN THE FOLLOWING CODE)

//The method introduced by Euclid for computing greatest common divisors is based on the fact that,
// given two positive integers a and b such that a > b, the common divisors of a and b are the same as the
// common divisors of a – b and b.

import java.util.*;


public class findGCD{
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();


        while(n1 != n2) {
            if(n1>n2) {
                n1 = n1 - n2;
            } else {
                n2 = n2 - n1;
            }
        }
        System.out.println("GCD is : "+ n2);
    }
}
