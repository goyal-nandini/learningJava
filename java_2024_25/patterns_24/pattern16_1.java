// copy pasted hai
// disordered hai output don't know how
//left to find out
import java.util.*;
public class pattern16_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i <= 6; i++) {
            for (int j = 1; j <= i + 1; j++) {
                System.out.print(j);
            }
            System.out.print("\t");
            for (int j = 0; j < 6 - i; j++)
                System.out.print(" ");

            for (int k = 1; k <= i + 1; k++)
                System.out.print(k);

            System.out.println();

        }
        for (int i = 6; i >= 0; i--) {
            for (int j = 1; j <= i + 1; j++) {
                System.out.print(j);
            }
            System.out.print("\t");
            for (int j = 0; j < 6 - i; j++)
                System.out.print(" ");

            for (int k = 1; k <= i + 1; k++)
                System.out.print(k);

            System.out.println();
        }
    }
}
