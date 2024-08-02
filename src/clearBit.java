// to clear bit to 0 at given position
import java.util.*;
public class clearBit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number in decimal form: ");
        int number = sc.nextInt();
        System.out.println("Enter the position of bit to clear: ");
        int pos = sc.nextInt();

        int bitMask = 1 << pos;
        int notBitMask = ~(bitMask);
        int newNumber = notBitMask & number;
        System.out.print("The new number after clearing the bit at given position " + pos + " : ");
        System.out.println(newNumber);
    }
}
