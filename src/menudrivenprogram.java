//Make a menu driven program. The user can enter 2 numbers, either 1 or 0.
//If the user enters 1 then keep taking input from the user for a student’s marks(out of 100).
//If they enter 0 then stop.
//If he/ she scores :
//Marks >=90 -> print “This is Good”
//89 >= Marks >= 60 -> print “This is also Good”
//59 >= Marks >= 0 -> print “This is Good as well”
//	Because marks don’t matter but our effort does.
//(Hint : use do-while loop but think & understand why)

import java.util.Scanner;

public class menudrivenprogram {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice; // to store the user's choice
        do {
            // display the menu
            System.out.println("Enter 1 to enter marks");
            System.out.println("Enter 0 to exit");
            // get the user's choice
            choice = sc.nextInt();
            // perform the action based on the choice
            switch (choice) {
                case 1:
                    // get the marks from the user
                    System.out.println("Enter the marks (out of 100):");
                    int marks = sc.nextInt();
                    // print the message based on the marks
                    if (marks >= 90) {
                        System.out.println("This is Good");
                    } else if (marks >= 60) {
                        System.out.println("This is also Good");
                    } else if (marks >= 0) {
                        System.out.println("This is Good as well");
                    } else {
                        System.out.println("Invalid marks");
                    }
                    break;
                case 0:
                    // exit the program
                    System.out.println("Thank you for using the program");
                    break;
                default:
                    // invalid choice
                    System.out.println("Invalid choice. Please try again");
            }
        } while (choice != 0); // repeat the loop until the user enters 0
    }
}
