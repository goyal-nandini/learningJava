//Two numbers are entered by the user, x and n.
// Write a function to find the value of one number raised to the power of another i.e. x^n.
// while doing c ques was --> make your pow function
import java.util.*;
public class XraisedToPowerN {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int n = sc.nextInt(); //Please see that n is not too large or else result will exceed the size of int.

        System.out.println("result = "+ powFunction(x, n));
    }
    public static float powFunction(int base, int exp){
        float ans = 1;
        for(int i=1; i<=exp; i++){
            ans = ans * base;
        }
        return ans;
    }
}