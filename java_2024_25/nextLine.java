// Java program to demonstrate
// the nextLine() and next() method
/*
| Method       | Reads up to...          | Skips whitespace? | Use case                                  |
        | ------------ | ----------------------- | ----------------- | ----------------------------------------- |
        | `next()`     | First space/tab/newline | ✅ Yes             | Get single words or tokens                |
        | `nextLine()` | End of line (`\n`)      | ❌ No              | Get full line of input (including spaces) |
*/

import java.util.Scanner;

public class nextLine {
    public static void main(String[] args)
    {
        // Creating the object of the Scanner class
        Scanner sc = new Scanner(System.in);

        // Use of nextLine() method
        String Input1 = sc.nextLine();
        System.out.println("using nextLine(): " + Input1);

        // Use of the next() method
        String Input2 = sc.nextLine();
        System.out.println("using next(): " + Input2);
    }
}
