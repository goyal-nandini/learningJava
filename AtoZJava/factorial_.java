// here, this is somewhat different, to handle factorials of
// large value than even "long" can handle!!
import java.math.BigInteger;
import java.util.Scanner;
public class factorial_ {

        public static void main(String args[]) {

            // Write code here
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            System.out.println(fact(BigInteger.valueOf(n)));


        }
        public static BigInteger fact(BigInteger n) {
            if (n.equals(BigInteger.ZERO) || n.equals(BigInteger.ONE)) {
                return BigInteger.ONE;
            }
            return n.multiply(fact(n.subtract(BigInteger.ONE)));
        }

}

