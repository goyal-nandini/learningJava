// error error check check in comment out part so applied previously used logic .You should remember.
// rest part is okay yes dry run okay uncommented part
// rest check carefully

import java.util.*;

public class pattern15_1 {
    public static void main(String[] args) {
         Scanner sc  = new Scanner(System.in);
        System.out.print("Height: ");
        int n = sc.nextInt();


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < i + 1; k++) {
                if (i!= 1 || i!= 0) {
                    comb(i, k);
                }
                else {
                    System.out.print("1");
                    break;
                }
            }
            System.out.println();
        }

    }
//    int num = 1;
//    public static void comb(int a, int b) {
//        System.out.print(fact(a) / (fact(a - b) / fact(b)));
//    }
    public static void comb(int a, int b) {
      int num = 1;
        for (int i = 1; i <= b; i++) {
         num *= (a - i + 1);
         num /= i;
        }
        System.out.print(num+" ");
   }



//    public static int fact(int num) {
//        if(num == 0){
//           return 1;
//        } else {
//           return num * fact(num - 1);
//        }
//    }
}
