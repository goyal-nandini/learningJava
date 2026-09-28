//hollow butterfly (not checked yet) little faulty
import java.util.*;
public class pattern9_5{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // First half of the butterfly pattern
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == n - i - 1 || j == i || j == n - 1) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            for (int j = i + 1; j < n; j++) {
                System.out.print("  ");
            }
            for (int j = i + 1; j < n; j++) {
                System.out.print("  ");
            }
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == n - i - 1 || j == i || j == n - 1) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
        // Second half of the butterfly pattern
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == n - i - 1 || j == i || j == n - 1) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            for (int j = i + 1; j < n; j++) {
                System.out.print("  ");
            }
            for (int j = i + 1; j < n; j++) {
                System.out.print("  ");
            }
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == n - i - 1 || j == i || j == n - 1) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }



//        for(int i=1; i<=n; i++){
//            for(int j=1; j<=i; j++) {
//                if (j == 1 || j == 10 || (i + j) == 11) {
//                    System.out.print("*");
//                }
//                else
//                    System.out.print(" ");
//            }
//            for(int j=1; j<2*i; j++){
//                System.out.print("*");
//            }
//            System.out.println();
//        }

    }
}