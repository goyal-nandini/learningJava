// inverted half pyramid amazing logics plus a bonus pattern !!
import java.util.*;

public class pattern4_2_0{
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        for(int i = rows; i >= 1; i--){
            for(int j = 1; j < i; j++){
                System.out.print(" ");
            }
            for(int k = 0; k <= rows - i; k++){
                System.out.print("*");
                //System.out.print("* ");// full pyramid generate only by a space... wow!!!
            }
            System.out.println();
        }

    }
}