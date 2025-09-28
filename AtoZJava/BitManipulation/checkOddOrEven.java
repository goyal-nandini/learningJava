package BitManipulation;

public class checkOddOrEven {
    public static void main(String[] args) {
        int n = 13;

        if((n & 1) == 1) System.out.println("Odd");
        else System.out.println("Even");

//        ✅ This is faster than % 2 because no division is involved.
    }
}
