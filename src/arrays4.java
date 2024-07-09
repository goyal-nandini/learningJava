//Find the maximum & minimum number in an array of integers
import java.util.*;
public class arrays4{
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       int size = sc.nextInt();
       int[] ar = new int[size];
        // input
       for(int i=0; i<ar.length; i++){
           ar[i]=sc.nextInt();
       }
       int max = Integer.MIN_VALUE; // min negative value stored
       int min = Integer.MAX_VALUE;// max positive value stored
       for(int i=0; i<ar.length; i++) {
           if (ar[i] < min) {
               min = ar[i];
           }
           if(ar[i] > max){
               max = ar[i];
           }
       }
        System.out.println("min value "+min);
        System.out.println("max value "+max);

    }
}