//Make a menu driven program. The user can enter 2 numbers, either 1 or 0.
//If the user enters 1 then keep taking input from the user for a student’s marks(out of 100).
//If they enter 0 then stop.
//If he/ she scores :
//Marks >=90 -> print “This is Good”
//89 >= Marks >= 60 -> print “This is also Good”
//59 >= Marks >= 0 -> print “This is Good as well”
//	Because marks don’t matter but our effort does.
//(Hint : use do-while loop but think & understand why)

import java.util.*;
public class que3{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("enter 2 numbers, either 0 or 1");
        int input = sc.nextInt();
        if(input == 1){
            System.out.println("enter the marks of a student");
            double marks = sc.nextDouble();
            if(marks >= 90)
                System.out.println("this is good");
            else if(marks >= 60 && marks <= 89)
                System.out.println("this is also good");
            else if(marks >= 0 && marks <= 59)
                System.out.println("this is good as well");
            else
                System.out.println("marks doesn't matter but our efforts does");
        } else System.out.println("stop");

    }
}