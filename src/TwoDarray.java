import java.util.*;
public class TwoDarray{
    public static void main(String[] args){
     Scanner sc = new Scanner(System.in);
     int rows = sc.nextInt();
     int cols = sc.nextInt();
     //declaration
     int[][] ar = new int[rows][cols];
      // input
     for(int i=0; i<rows; i++){
         for(int j=0; j<cols; j++){
             ar[i][j] = sc.nextInt();
         }
     }
     //output
        System.out.println("entered matrix is :");
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                System.out.print(ar[i][j]+" ");
            }
            System.out.println();
        }
        // checking the number
     int x = sc.nextInt();

     for(int i=0; i<rows; i++){
         for(int j=0; j<cols; j++){
             if(ar[i][j]==x){
                 System.out.println("number" + x + "has found at location :("+i+","+j+")");
             }
         }
     }


    }
}