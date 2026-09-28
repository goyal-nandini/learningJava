// to set the bit as 1 at the given position.
import java.util.*;
public class setBit {
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number in decimal form: ");
        int number = sc.nextInt();
        System.out.println("Enter the position of bit to set: ");
        int pos = sc.nextInt();

        int bitMask = 1 << pos;
        int newNumber = bitMask | number;
        System.out.print("The new number after setting the bit at given position " + pos + " : ");
        System.out.println(newNumber);

    }
}
