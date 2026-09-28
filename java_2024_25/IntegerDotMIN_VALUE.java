// Java program to show what happens when
// a value less than Integer.MIN_VALUE
// is stored in an int variable

public class  IntegerDotMIN_VALUE {

    // Driver code
    public static void main(String[] arg)
    {

        try {

            System.out.println(
                    "Trying to initialize"
                            + " a N with value"
                            + " Integer.MIN_VALUE - 1");

            // Try to store value Integer.MIN_VALUE - 1
            int N = Integer.MIN_VALUE - 1;

            // Print the value of N
            System.out.println("N = " + N);
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}
