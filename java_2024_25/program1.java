//Write a program to enter the numbers till the user wants and
// at the end it should display the count of positive, negative and zeros entered.
// self designed helped by copilot
import java.util.*;
public class program1 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int countP = 0;
        int countN = 0;
        int count0 = 0;
        float num;
        //The program uses a do-while loop to repeatedly prompt the user for input.

        do{
            //num = sc.nextFloat();
            if(sc.hasNextFloat()) {    //'hasNextFloat()' method is used to check if the next token in the input can be interpreted as a
                                       // float value. It returns true if the next token can be translated into a float, otherwise, it returns false.
                num = sc.nextFloat();  //If the whitespace is between valid float values (e.g., 3.14 5.67),
                                       // hasNextFloat() will recognize the first float (3.14), and a subsequent call to nextFloat()
                                       // would read the next float (5.67), skipping over the whitespace.
                if (num > 0)
                    countP++;
                else if (num < 0)
                    countN++;
                else
                    count0++;
            }
            else break;
//            System.out.println(countP);
//            System.out.println(countN);
//            System.out.println(count0);
        } while (true);
        // can be applied to while loop as well--> while(true){...}

        System.out.println(countP);
        System.out.println(countN);
        System.out.println(count0);

    }
}