//Write a function to print the sum of all odd numbers from 1 to n
// yess !!
import java.util.*;
public class addOddNo{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
         int n = sc.nextInt(); // 1 to n odd numbers eg 1 to 10, odd no- 5 n/2 odd no.
        System.out.println("result = " + addOddNo(n));
    }
    public static int addOddNo(int n){
        int sum = 0;
        for(int i=1; i<=n; i++){
            if(i%2 == 0){
                continue;
            } else {
                sum = sum + i;
            }
        }
        return sum;
    }
}