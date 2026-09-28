// copy paste but i know about it from program1 ....you can check it out !!
// as on 2/07/24 not known much about classes and objects so leaving the (try block as it is) from JAVA GUIDES WEBSITE
//check if the next token can be parsed as an integer.
import java.util.Scanner;

public class hasNextInt{
    public static void main(String[] args) {
        String input = "123 456 abc123";

        // Create Scanner object in try-with-resources to ensure it closes automatically
        try (Scanner scanner = new Scanner(input)) {

            while (scanner.hasNext()) { // This method returns true if the scanner has another token in its input.
                if (scanner.hasNextInt()) {
                    System.out.println("Found an integer: " + scanner.nextInt());
                } else {
                    System.out.println("Found a non-integer token: " + scanner.next());
                }
            }
        } // Scanner is automatically closed here
    }
}