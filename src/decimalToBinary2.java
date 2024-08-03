// without using modular operator

import java.util.*;
public class decimalToBinary2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int decnum = sc.nextInt();
        int temp, chk, i=0;
        int[] binnum = new int[20];

        while(decnum != 0){
            temp = decnum/2; // divisor
            chk = temp*2;    // checking that number under divident after division, imagine dividing positions of numbers
            if(chk == decnum){   // if chk(that number under divident) is equal to divident ie decnum, then remainder is 0, and assigned to binnum[] array
                binnum[i] = 0;
            } else {
                binnum[i] = 1;
            }
            i++;
            decnum = temp;   // assigning divisor as next decnum, imagine prime factorisation calculation pattern
        }
        for(i=(i-1); i>=0; i--){
            System.out.print(binnum[i]);
        }
    }
}
