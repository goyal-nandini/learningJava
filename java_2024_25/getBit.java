// to get the bit at the given position, position is counted from right to left from 0,
import java.util.*;
public class getBit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number in decimal form: ");
        int number = sc.nextInt();
        System.out.println("Enter the position of bit to get: ");
        int pos = sc.nextInt();

        int bitMask = 1 << pos;
        if ((bitMask & number) == 0){
            System.out.println("Bit at position " + pos + " is zero(0).");
        } else {
            System.out.println("Bit at position " + pos + " is one(1).");
        }

    }
}
