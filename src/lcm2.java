//under review still wait --> 1/08/24 19:15 pm
// done at 23:26 pm same day
// one important knowing comes here : 1. Math.max()
// 2. In Java, Integer can be used as a return type for a function because it is a
// wrapper class for the primitive data type int. This allows for more flexibility,
// such as returning null to indicate the absence of a value, which is not possible with
// primitive types.
import java.util.*;
public class lcm2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        //System.out.println("HCF: "+ getHcf(a, b));
        System.out.println("LCM: "+ getLcm2(a, b));
    }

    public static Integer getLcm2(int n1, int n2) {
        // The Math.max() method in Java is used to find the maximum of two numbers.
        int lcm = Math.max(n1, n2);
        // int lcm = (n1 > n2) ? n1 : n2; // can be used
        // Always true
        while (true) {
            if (lcm % n1 == 0 && lcm % n2 == 0) {
                break;
            }
            lcm++;
        }
        return lcm;
    }



}