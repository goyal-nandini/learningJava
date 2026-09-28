import java.util.Scanner;

// here we'll see common confusion with when you mix nextInt() (or any nextXYZ()) with nextLine() —
// this is a common trap for beginners.

/* remember this:
"nextInt()" reads only the number, but leaves the newline (\n) behind in the buffer.
Then "nextLine()" immediately reads that leftover newline as an empty string.

Add one extra nextLine() to consume the leftover newline. 🚩🚩*/


public class next {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your age: ");
        int age = sc.nextInt();  // reads the number

        sc.nextLine(); // 👈 eats the leftover \n 🚩🚩

        System.out.print("Enter your name: ");
        String name = sc.nextLine();  // tries to read the full line
        System.out.println("Name: " + name);

    }
}
