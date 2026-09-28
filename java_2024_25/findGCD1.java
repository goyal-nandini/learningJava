// Use of a function
import java.util.*;
public class findGCD1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int p = sc.nextInt();
        int q = sc.nextInt();
        System.out.println(GCD(p, q));
    }
    public static int GCD(int a, int b) {

        int remainder = a % b;
        while (remainder != 0) {

            a = b;
            b = remainder;
            remainder = a % b;
        }

        return b;
    }
    // EASY WAY, EASY WAY TO REMEMBER ACCORDING TO LOGIC
        public static int getHcf(int i, int j) {
        while(i%j != 0) {
            int temp = i%j;
            i = j;
            j = temp;
        }
        return j;  // divisor is hcf when rem = 0
    }
}