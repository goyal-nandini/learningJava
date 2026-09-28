//Take an array of numbers as input and check if it is an array sorted in ascending order.
//Eg : { 1, 2, 4, 7 } is sorted in ascending order.
//     {3, 4, 6, 2} is not sorted in ascending order.
// not completed !!
import java.util.*;
public class arrays5{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("enter size : ");
        int size = sc.nextInt();
        int[] numbers = new int[size];
        //input
        System.out.println("enter numbers : ");
        for(int i=0; i<size; i++){
            numbers[i] = sc.nextInt();
        }
        // use of functions
        System.out.println("the result is : ");
        if(isSortedAscendingOrder(numbers)){
            System.out.println("sorted in ascending order");

        } else {
            System.out.println( "not sorted in ascending order");
        }
    }
    public static boolean isSortedAscendingOrder(int numbers[]){
        for(int i=0; i<numbers.length-1; i++){
            if(numbers[i]>numbers[i+1]){
                    return false;
            }
        }
       return true;
    }
}