//inverted half pyramid with 180 degree rotated.

import java.util.*;

public class pattern4_1{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();

        for(int i = 1; i <= rows; i++){
//            for(int j = 1; j <= rows-i; j++) {
//                System.out.print(" ");
//            }
            for(int k = 1; k <= rows; k++) {
                if (i + k >= rows+1) {
                    System.out.print("*");
                } else System.out.print(" ");
            }

//            for(k = 1; k <= i; k++) {
//                System.out.print("*");
//            }
            System.out.println();
        }
    }
}
