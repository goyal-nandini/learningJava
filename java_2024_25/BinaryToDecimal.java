//Disclaimer:  has a bug in it, for enteries from user!!
// just refer it for the logic building, not checking whether it is binary or not !!
import java.util.*;
public class BinaryToDecimal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//         int[] binnum = new int[20];
//         for(int i=0; i<20; i++){
//             binnum[i] = sc.nextInt();
//         }
        System.out.println("Enter a binary number: ");
        String binnum = sc.next();
        // checking for correct binary number to be entered by user.
        if (checkBinary(binnum) == true) {
            int result = 0;
            double pow;
            double[] powers = new double[binnum.length()];
            // power 0, 1, 2, 3
            // 2^3*1 + 2^2*0 + 2^1*1 + 2^0*1

            for (int power = binnum.length() - 1; power >= 0; power--) {
                pow = Math.pow(2, power);
                powers[binnum.length() - 1 - power] = pow;
                //int bits = Character.getNumericValue(binnum.charAt(power));
                // here, it would give wrong bits according to given binary number

            }
            for (int i = 0; i < binnum.length(); i++) {
                int bits = Character.getNumericValue(binnum.charAt(i));
                result += bits * powers[i];
            }
            System.out.println("The conversion of binary number to decimal number is: " + result);

            // can done this in one loop only, as:
//            for(int i=0; i<binnum.length(); i++){
//                int power = binnum.length()-i-1;
//                double res = Math.pow(2,power);
//                int bits = Character.getNumericValue(binnum.charAt(i));
//                result += bits * res;
//            }
//            System.out.println(result);
        } else {
            System.out.println("Enter valid binary number to get the conversion!");
        }
    }

    // function to check whether the entered binary number by the user is binary or not.
    public static boolean checkBinary(String binaryNo){
        for(int i = 0; i < binaryNo.length(); i++) {
            char c = binaryNo.charAt(i);
            // this condition fails at 11111... and 0000... entries !! Check for next code
            // at many values
            if (c == '0' || c == '1') {
                return true;
            }
        }
        return false;
    }
}
