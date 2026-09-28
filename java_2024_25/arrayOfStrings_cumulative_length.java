//Take an array of Strings input from the user & find the cumulative (combined) length of all those strings.
import java.util.*;
public class arrayOfStrings_cumulative_length {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        sc.nextLine();
        String[] ar = new String[size];
        //input
        for(int i=0; i<ar.length; i++){
           ar[i] = sc.nextLine();
        }


        int sum=0;
        for(int i=0; i<ar.length; i++){
            sum += ar[i].length();
        }
        System.out.print("cumulative length : "+sum);

//        int totLength = 0;
//        for(int i=0; i<size; i++) {
//            array[i] = sc.next();
//            totLength += array[i].length();
//        }

    }
}
