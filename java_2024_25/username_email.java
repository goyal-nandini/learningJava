//Input an email from the user. You have to create a username from the email by deleting the part that comes after ‘@’.
// Display that username to the user.
//Example :
//email = “apnaCollegeJava@gmail.com” ; username = “apnaCollegeJava”
//email = “helloWorld123@gmail.com”; username = “helloWorld123”

//replaceAll() method used as rules discusses in notebook but here in this example. I
// have a new application --> to replace/trimming off the string/character after any particular character!!
import java.util.*;
public class username_email {
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      System.out.println("enter your email\nget your username from your email");
      // eg -->nandinikartik1981@gmail.com username nandinikartik1981


      String email = sc.next();
      String username = email.replaceAll("@.*", "");
        //.*: The dot (.) matches any character except a newline, and the asterisk (*)
        // means "zero or more times". So, .* together means "zero or more of any character".
        //"@.*" matches the "@" character and everything that follows it in the string.
        System.out.println(username);
        String input = "myNameIsNandini goyal suman pawan";
        System.out.println(input.replaceAll("goyal.*", "kartik"));
        //output --> myNameIsNandini
        //           goyal
        // no replacement

    }
}
