// to update bit to either 1 or 0
//updating a specific bit at a given position in an integer involves setting or clearing that bit to either 1 or 0

import java.util.*;
public class updateBit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number in decimal form: ");
        int number = sc.nextInt();
        System.out.println("Enter the position of bit to be updated: ");
        int pos = sc.nextInt();

        int bitMask = 1 << pos;

        System.out.println("Enter the bit to update(0 or 1): ");
        // 1 update krna hai, means 0 ki jagah 1 update krna hai....

        int bit = sc.nextInt();

        if(bit == 1){
            //set
            int newNumber = bitMask | number;
            System.out.println("the number after updating the bit is: ");
            System.out.println(newNumber);
        } else if(bit == 0) {
            //clear
            int notBitMask = ~(bitMask);
            int newNumber = notBitMask & number;
            System.out.println("the number after updating the bit is: ");
            System.out.println(newNumber);
        } else {
            System.out.println("Invalid Bit. Please enter 0 or 1.");
        }
    }
}
