//0-1 triangle
//1
//01
//101
//0101
//10101
import java.util.*;
public class pattern8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();

        for(int i=0; i<rows; i++){
            for(int j=0; j<=i; j++){ //for(int j=0; j<i; j++){ prints pattern but one row blank and total 4 rows.
                if((i+j)%2 == 0)
                    System.out.print("1 ");
                else System.out.print("0 ");
            }
            System.out.println();
        }
    }
}