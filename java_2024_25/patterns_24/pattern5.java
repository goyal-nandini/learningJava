//number half pyramid pattern
//12345
//1234
//123
//12
//1

import java.util.*;

public class pattern5{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        for (int i = 1; i <= rows; i++){
            for(int j = 1; j <= i; j++){
                System.out.print(j+" ");
            }
            System.out.println();
        }

    }
}