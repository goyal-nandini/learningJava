// inverted of inverted half pyramid rotated 180 degrees.
//****
//_***
//__**
//___*
import java.util.*;
public class pattern6{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        for(int i = 0; i < rows; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < rows - i; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}