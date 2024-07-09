
public class findGCD1 {
    public static void main(String[] args){
        System.out.println(GCD(8, 12));
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
}