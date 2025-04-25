import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BufferedReaderClass {
    void printNumber() {
        try{
            //  Creation of a InputStreamReader object that reads from the standard input (usually the keyboard)
            InputStreamReader in = new InputStreamReader(System.in); // Connects Java to your keyboard

            // Creation of a BufferedReader object that uses the InputStreamReader for reading input
            BufferedReader bf = new BufferedReader(in); // Wraps the keyboard reader to make it better

            System.out.println("Enter a number: ");
            String numstr = bf.readLine(); // Reads everything you type until you hit Enter
            int n = Integer.parseInt(numstr); // Converts the typed text into a number
            System.out.println("Number is: " + n);
        } catch(IOException e) {
            System.out.println("There is an issue " + e.getMessage());
        } catch(NumberFormatException e){
            System.out.println("Enter a valid number " + e.getMessage());
        }
    }
    public static void main(String[] args){
        BufferedReaderClass obj = new BufferedReaderClass();  // Create an instance of the class
        obj.printNumber();  // Call the non-static method using the object
    }
}
