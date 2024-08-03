// without using array
import java.util.*;
public class decimalToBinary1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int decnum = sc.nextInt();
        int binnum = 0, m = 1, rem;
        while(decnum != 0){
            rem = decnum % 2;
            binnum = binnum + (rem * m); // building binary value
            m *= 10; // updating place value
            decnum /= 2;
        }
        System.out.println(binnum);
    }
}
