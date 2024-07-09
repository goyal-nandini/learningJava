//solid rhombus logic by me only !! during extracting for pattern 13 by myself
// nothing special !! only one row m no. of stars extra hai 2 se
import java.util.*;
public class pattern10_0{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n-i; j++){
                System.out.print(" ");
            }
            for(int k=1; k<=n+2; k++){
                System.out.print("*");
            }
            System.out.println();
        }
        for(int i=n; i>0; i--){
            for(int j=1; j<=n-i; j++){
                System.out.print(" ");
            }
            for(int k=1; k<=n+2; k++){
                System.out.print("*");
            }
            System.out.println();
        }

    }
}

