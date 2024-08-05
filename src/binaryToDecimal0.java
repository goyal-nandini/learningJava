// different approach to it but same logic
import java.util.*;
public class binaryToDecimal0 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a positive binary number: ");
        String binStr = sc.next();
        // checking the binary number
        //The negation (!) inside the condition bracket can be confusing at first,
        // but it's essential for understanding how the code logic works.
        if(!isValidBinary(binStr)){  //c=1 isValidBinary return true, !true=false --> if condition false
                                     // block m not entry!!
            //The if condition checks if the negated result is true.(think simply!!)
            System.out.println("Error! Invalid Input, Enter valid Binary number!");
            return;
        }
        int binnum = Integer.parseInt(binStr);
        int decnum = 0;
        int i = 1;
        int rem;
        while(binnum != 0){
            rem = binnum%10;
            decnum = decnum + (rem * i);
            i *= 2; // can use pow function in this
            binnum = binnum/10;
        }
        System.out.println("The conversion of Binary Number to decimal Number:");
        System.out.println(decnum);
    }
    public static boolean isValidBinary(String binStrg){
        for(int i=0; i<binStrg.length(); i++){
            char c = binStrg.charAt(i);
            if(c != '0' && c != '1'){ // say, c=1 condition: if condition false, not enterred in block!
                                      // c=2 if condition true, block entered!!
                return false;
            }
        }
        return true;

    }
}
