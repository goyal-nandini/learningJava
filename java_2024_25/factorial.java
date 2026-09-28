import java.util.*;

public class factorial{

    public static int factorialOfANumber(int a){
        if(a<0){
            System.out.println("Invalid Number");
            return 0;
        }
        else {
            int factorial = 1;
            for (int i = a; i >= 1; i--) {
                factorial = factorial * i;
            }
            return factorial;
        }
    }
    public static void main(String[] args){
       Scanner sc = new Scanner(System.in);
       int a = sc.nextInt();
       System.out.println("Factorial of given numbers :" + factorialOfANumber(a));
    }
}