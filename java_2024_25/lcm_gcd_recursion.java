// for two numbers only

import java.util.*;
public class lcm_gcd_recursion {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
        System.out.println("Enter the numbers for calculating LCM and HCF: ");
       int a = sc.nextInt();
       int b = sc.nextInt();

        System.out.println("LCM of two numbers " + a + ", " + b + " is: " + findLCM(a, b));
        System.out.println("HCF of two numbers " + a + ", " + b + " is: " + findGCD(a, b));
    }

    public static int findLCM(int p, int q){
        int lcm = (p * q)/findGCD(p, q);
        return lcm;
    }

//    public static int findGCD(int r, int s){
//        if(s == 0){
//            return r;
//        } else return findGCD(s, r % s);  // gives error in program named as lcm_rangeOfNumbers.java
                                             // findGCD(r%s, s) gives correct result
           // above or below(overall same h), any way of finding hcf can be used!!
        public static int findGCD(int r, int s) {
            if (r == 0) {
                return s;
            } else return findGCD(s % r, r);
        }
//public static int findGCD(int u, int v)
//{
//    if (u == 0)
//        return v;
//    return findGCD(v % u, u);
//}

}
