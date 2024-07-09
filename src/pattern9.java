//butterfly pattern
import java.util.*;
public class pattern9{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //first half
        for (int i = 1; i <= n; i++){
            //first part
            for(int j = 1; j <= i; j++){
                System.out.print("* ");
            }
            //spaces
            for(int j = 1; j <= 2*(n-i); j++){
                System.out.print("  ");
            }
            //second part
            for(int j = 1; j <= i; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
        //second half --> flipping the row number
        for (int i = n; i >= 1; i--){
            //first part
            for(int j = 1; j <= i; j++){
                System.out.print("* ");
            }
            //spaces
            for(int j = 1; j <= 2*(n-i); j++){
                System.out.print("  ");
            }
            //second part
            for(int j = 1; j <= i; j++){
                System.out.print("* ");
            }
            System.out.println();
        }

    }

}