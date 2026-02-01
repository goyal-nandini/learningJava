package BitManipulation;

public class built_in_for_conversion {
    public static void main(String[] args) {
        int decimalNumber = 25;
        String binaryString = Integer.toBinaryString(decimalNumber);
        System.out.println("Decimal " + decimalNumber + " to Binary: " + binaryString);

        String binaryString_2 = "11001"; // Represents decimal 25
        int decimalNumber_2 = Integer.parseInt(binaryString_2, 2); // Radix 2 for binary
        System.out.println("Binary " + binaryString_2 + " to Decimal: " + decimalNumber);
    }
}
