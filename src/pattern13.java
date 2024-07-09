//diamond pattern
import java.util.*;
public class pattern13{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //first half
//        for(int i=1; i<=n; i++){
//            for(int j=1; j<=n-i; j++){
//                System.out.print(" ");
//            }
//            for(int j=1; j<=2*i-1; j++){
//                System.out.print("*");
//            }
//            System.out.println();
//        }
//        //second half
//        for(int i=n; i>0; i--){
//            for(int j=1; j<=n-i; j++){
//                System.out.print(" ");
//            }
//            for(int j=1; j<=2*i-1; j++){
//                System.out.print("*");
//            }
//            System.out.println();
//        }
        // a try ..correct !!
        //first half
        for(int i=0; i<n; i++){
            for(int j=0; j<n-1-i; j++){
                System.out.print(" ");
            }
            for(int j=0; /*j<=2*(i+1)-1(first try)WRONG ?? */ j<=2*i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
        //second half
        for(int i=n-1; i>=0; i--){
            for(int j=0; j<n-1-i; j++){
                System.out.print(" ");
            }
            for(int j=0; /*j<=2*(i+1)-1 WRONG ?? */ j<=2*i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}

