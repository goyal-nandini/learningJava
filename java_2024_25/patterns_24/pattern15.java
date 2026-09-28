//pascal's triangle (has a great logic behind it)  wonderful logic waiting below check it out with
// wonderful visual alignment
//____1
//___1_1
//__1_2_1
//_1_3_3_1
//1_4_6_4_1
import java.util.*;
public class pattern15 {
    public static void main(String[] args) {
        // i've written this code after understanding original logic(below it)
         Scanner sc = new Scanner(System.in);
         int n = sc.nextInt();
         for(int i=0; i<n; i++){
             for(int j=n-i; j>=1; j--){
                 System.out.print(" ");
             }
             int bin = 1;
             for(int k=0; k<=i; k++){
                 if(k==0 || i==0){
                     bin = 1;
                 } else {
                     bin = (bin * (i-k+1))/k;
                 }
                 //System.out.printf("%6d",bin);
                 System.out.print(bin+" ");
             }
             System.out.println();

         }


//                copy paste below
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Enter the number of rows: ");
//        int r = scanner.nextInt();
//        System.out.println("\nPascal's Triangle:");
//
//        for (int q = 0; q < r; q++) {
//            System.out.print("ROW " + q);
//            for (int p = 40 - 3 * q; p > 0; p--) { // r = 14 tkk workable hai
//                System.out.print(" ");
//            }
//            int bin = 1;
//            for (int x = 0; x <= q; x++) {
//                if (x == 0 || q == 0) {
//                    bin = 1;
//                } else {
//                    bin = bin * (q - x + 1) / x;
//                }
//                System.out.printf("%6d", bin);
//            }
//            System.out.println();
//        }

    }
}
