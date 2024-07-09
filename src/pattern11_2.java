//inverted full pyramid
//1_1_1_1
//_2_2_2
//__3_3
//___4
import java.util.*;
public class pattern11_2{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int number = 1;
        for(int i=n; i>=1; i--){
            for(int j=1; j<=n-i; j++){
                System.out.print(" ");
            }
            //for(int j=i; j>=1; j--){ //also correct
                for(int j=1; j<=i; j++){
                System.out.print(number+" ");
            }
            number ++;
            System.out.println();
        }

    }
}