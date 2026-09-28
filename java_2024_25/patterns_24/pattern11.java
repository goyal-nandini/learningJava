//number pyramid
//____1
//___2_2
//__3_3_3
//_4_4_4_4
//5_5_5_5_5
import java.util.*;
public class pattern11{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
//        for(int i=1; i<=n; i++){ // correct both, try any !!
        //spaces
//            for(int j=1; j<=n-i; j++){
//                System.out.print(" ");
//            }
        // numbers --> row no.,row no. times
//            for(int j=1; j<=i; j++){
//                System.out.print(i+" "); // extra space for perfect pattern
//            }
//            System.out.println();
//        }
        for(int i=0; i<n; i++){
            //spaces
            for(int j=0; j<n-1-i; j++){
                System.out.print(" ");
            }
            //numbers --> row no.,row no, times + 1
            for(int j=0; j<=i; j++){
                System.out.print(i+1+" ");
            }
            System.out.println();
        }

    }
}