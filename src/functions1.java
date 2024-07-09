// an introduction to functions
// product of two numbers
import java.util.*;
public class functions1{

    public static int calculateProduct(int a, int b){
    return a*b;
    }
    public static void main(String[] args){
       Scanner sc = new Scanner(System.in);
       int a = sc.nextInt();
       int b = sc.nextInt();

       System.out.println("Product of numbers is :" + calculateProduct(a, b));
       return;
    }
}
