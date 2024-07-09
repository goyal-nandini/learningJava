//        1                1
//        12              21
//        123            321
//        1234          4321
//        12345        54321
//        123456      654321
//        1234567    7654321
//        12345678  87654321
//        123456789987654321
//        12345678  87654321
//        1234567    7654321
//        123456      654321
//        12345        54321
//        1234          4321
//        123            321
//        12              21
//        1                1
// NOT CLEARED LOGIC !!
import java.util.*;
public class pattern16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int j;
        for (int i = 0; i <= 8; i++) {
            for (j = 1; j <= i + 1; j++) {
                System.out.print(j);
            }
            // not yet cleared
            //new concept
            //String.format() in Java is a powerful method that allows you to create formatted strings.
            // It’s especially useful for beginners because it helps you construct strings with placeholders
            //  and replace those placeholders with specific values
            System.out.print(String.format("%" + ((10 - j) * 2 != 0 ? (10 - j) * 2 : "") + "s", ""));

            for (j = i + 1; j >= 1; j--) {
                System.out.print(j);
            }
            System.out.println();

        }
        for (int i = 8; i >= 1; i--) {
            for (j = 1; j <= i; j++) {
                System.out.print(j);
            }

            System.out.print(String.format("%" + ((10 - j) * 2 != 0 ? (10 - j) * 2 : "") + "s", ""));

            for (j = i; j >= 1; j--) {
                System.out.print(j);
            }
            System.out.println();
        }
    }
}