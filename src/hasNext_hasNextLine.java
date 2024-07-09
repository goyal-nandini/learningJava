
//        Differences Between hasNext() and hasNextLine()
//        Scope:
//        hasNext(): Checks for the next token (a sequence of characters separated by whitespace).
//        hasNextLine(): Checks for the next line of input.

//        Whitespace Handling:
//        hasNext(): Skips leading whitespace and reads until the next whitespace.
//        hasNextLine(): Considers the entire line, including leading and trailing whitespace

//        Use Cases:
//        hasNext(): Suitable for tokenized input, where data is separated by spaces or other delimiters.
//        hasNextLine(): Suitable for line-by-line input, where each line is considered as a separate unit of input.

// my opinion as of now --> these methods would be used in logic building of various questions

import java.util.Scanner;

public class hasNext_hasNextLine{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter some words: ");

        // Check if there are more tokens
        while (scanner.hasNext()) {
            String token = scanner.next();
            System.out.println("Token: " + token);
        }

        scanner.close();
    }
}
