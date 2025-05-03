//number half pyramid pattern
//1111
//222
//33
//4
import java.util.*;
public class pattern5_1{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int number = 1;
        for(int i=n; i>=1; i--){
            for(int j=1; j<=i; j++){
                System.out.print(number+" ");
            }
            number++;
            System.out.println();
        }

    }
}