// half pyramid

import java.util.*;

public class pattern2{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        //int columns = sc.nextInt();

        for (int i = 1; i <= rows; i++){
            for(int j = 1; j <= i; j++){
                System.out.print("*");
            }
//            for(int k = 1; k <= rows - i; k ++){ // has to effect on pattern try it !!
//                System.out.print(" ");
//            }
            System.out.println();
        }
    }
}