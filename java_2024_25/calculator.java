//Make a Calculator. Take 2 numbers (a & b) from the user and an operation as follows :
//	1 : + (Addition) a + b
// 2 : - (Subtraction) a - b
// 3 : * (Multiplication) a * b
// 4 : / (Division) a / b
// 5 : % (Modulo or remainder) a % b
// Calculate the result according to the operation given and display it to the user.

import java.util.*;

public class calculator{
       public static void main (String[] args) {
           Scanner sc = new Scanner(System.in);

           int num1 = sc.nextInt();
           int num2 = sc.nextInt();

           System.out.println("1 for addition, 2 for subtraction, 3 for multiplication, 4 for division, 5 for modulo operation");
           int operation = sc.nextInt();
           if (operation > 0 && operation < 6) {
               switch (operation) {
                   case 1:
                       System.out.println(num1 + num2);
                       break;
                   case 2:
                       System.out.println(num1 - num2);
                       break;
                   case 3:
                       System.out.println(num1 * num2);
                       break;
                   case 4:
                       if (num2 == 0) {
                           System.out.println("enter valid number");
                       } else {
                           System.out.println(num1 / num2);
                           break;
                       }
                   case 5:
                       if (num2 == 0) {
                           System.out.println("enter valid number");
                       } else {
                           System.out.println(num1 % num2);
                           break;
                       }
                   default :
                       System.out.println("invalid operation");

               }
           } else {
               System.out.println("enter operation 1 to 5");
           }
       }
}






