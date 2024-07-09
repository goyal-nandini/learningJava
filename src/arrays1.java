// intro to ARRAYS
// ques linear search. search any element x from an array take input by user.
import java.util.*;
public class arrays1{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        int[] numbers = new int[size];// array declare
         for(int i=0; i<size; i++){   // array element input
             numbers[i] = sc.nextInt();
         }
         int x = sc.nextInt();

         for(int j=0; j<size; j++){   // array element search output
             if(numbers[j]==x){
                 System.out.println("x is at index "+j);
             }
         }
    }
}