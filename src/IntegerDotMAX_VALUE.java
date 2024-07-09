// Java program to show what happens when
// a value greater than Integer.MAX_VALUE
// is stored in an int variable

public class IntegerDotMAX_VALUE {
    // Driver code
    public static void main(String[] arg){
        try {

            System.out.println(
                    "Trying to initialize"
                            + " a N with value"
                            + " Integer.MAX_VALUE + 1");

            // Try to store value Integer.MAX_VALUE + 1
            int N = Integer.MAX_VALUE + 1;

            // Print the value of N
            System.out.println("N = " + N);
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}
