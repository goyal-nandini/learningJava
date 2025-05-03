// HACKERRANK

//The try Block and the catch block:
//The try block contains a set of statements that might throw an exception.
//When an exception occurs within the try block, the control transfers to the
// corresponding catch block.
//The catch block defines a block of code to handle the exception.
//It specifies the type of exception it can catch (e.g., Exception, ArithmeticException, etc.).
//If an exception of the specified type occurs in the try block, the code inside the catch
// block is executed.

import java.util.*;
public class datatype{
    public static void main(String []args)
    {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt(); // test cases
        for(int i=0;i<t;i++)
        {
            try
            {
                long x=sc.nextLong();
                System.out.println(x+" can be fitted in:");
                if(x>=-128 && x<=127)System.out.println("* byte");
                if(x >= -32768 && x <= 32767) System.out.println("* short");
                if (x>= -2147483648 && x <= 2147483647) System.out.println("* int");
                if (x >= -(Math.pow(2,63)) && x <=(Math.pow(2,63)-1) ) System.out.println("* long");

                //Complete the code
            }
            catch(Exception e)
            {
                System.out.println(sc.next()+" can't be fitted anywhere.");
            }

        }
    }
}



