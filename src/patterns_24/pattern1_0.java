package patterns_24;
//two hollow rectangles side by side i was just trying !!

// 🔴🔴try it make it a box with partition in b/w something like this!!
import java.util.*;

public class pattern1_0{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        int columns = sc.nextInt();

        for (int i = 1; i <= rows; i++){
            for(int j = 1; j <= columns; j++){
                if(i == 1 || i == rows || j == 1 || j == columns){
                    System.out.print("*") ;
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}