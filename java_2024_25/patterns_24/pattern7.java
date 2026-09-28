//floyd triangle
//1
//2 3
//4 5  6
//7 8 9 10
//11 12 13 14 15
import java.util.*;
public class pattern7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        int number = 1;
        for(int i=0; i < rows; i++){ // for(int i=0; i < rows; i++){ faulty statement rows 4 --> output 4 rows but first blank
//            for(int i=0; i <= rows; i++){  faulty statement one extra line, rows 4 --> output 5 rows
            for(int j=0; j <= i; j++){
                System.out.print(number+" ");
                number++;
            }
            System.out.println();
        }
    }
}