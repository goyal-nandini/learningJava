//Take an array of names as input from the user and print them on the screen.
// an important lesson very important in commented out words
import java.util.*;
 public class arrays3{
     public static void main(String[] args){
         Scanner sc = new Scanner(System.in);
         int size = sc.nextInt();
         //When you use sc.nextInt() to read an integer, it only consumes the integer value itself.
         //However, it does not consume the **newline character (Enter key)** that you press after entering the integer.
         //After reading the integer, there is still a newline character left in the input buffer.
         //When you subsequently call sc.nextLine(), it reads that leftover newline character as an empty string.
         String[] names = new String[size];
         String a = sc.nextLine(); // consumes the newline character
         System.out.println("consumed part :"+a);
         for(int i=0; i<size; i++){
             names[i] = sc.nextLine();
             //names[i] = sc.next();  // can also be used!!
         }
         System.out.println("names input by user are :");
         for(int i=0; i<size; i++){
             System.out.println("name "+ (i+1)+ " is "+ names[i]);
         }
     }
 }