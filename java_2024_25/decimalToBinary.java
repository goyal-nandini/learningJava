// for loop
import java.util.*;
public class decimalToBinary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int decnum = sc.nextInt();
        int[] binnum = new int[20];
        // every code is correct make sure to stay at commented code once at a time for major understanding (me)
        int i = 0;
        for(; decnum != 0; i++){
            binnum[i] = decnum % 2;
            decnum /= 2;
        }
//        int i;
//        for(i = 0; decnum != 0; decnum /= 2){
//            binnum[i++] = decnum % 2;
//        }
        // i++ 1. value used, 2. value change

        for(i=(i-1); i>=0; i--){
            System.out.print(binnum[i]);
        }




    }
}
