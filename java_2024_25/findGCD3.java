// Bit difficult now, for me
import java.util.*;
public class findGCD3{
    public static void main(String [] args){

      System.out.println("Finding GCD Using Euclid's Algorithm");
      Scanner num = new Scanner(System.in);
      System.out.println("Enter your first (higher) number: ");
      int n1 = num.nextInt();
      System.out.println("Enter your second (lower) number: ");
       int n2 = num.nextInt();
       System.out.println("Numbers for finding GCD are: " + n1 + " " + n2);
       System.out.println("Computing for GCD... ");

        for (int i = 0; i <= n2; i++)
        {
           int g = n1/n2;
           int f = (g * n2);
           int h = n1 - f;
           //System.out.print(n1 + " = " + "(" + n2 + " * " + g + ") + " + h);
           //System.out.println();
            if (h == 0)
            {
                break;
            }
           n1 = n2;
           n2 = h;

        }
        int ans = 0;
        for (int i = 1; i <= n1 && i <= n2; ++i) {

            if (n1 % i == 0 && n2 % i == 0)
           {
             ans = i;
           }

        }
        System.out.println("Your GCD is " + ans);

    }
}