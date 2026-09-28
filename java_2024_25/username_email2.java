import java.util.*;
import org.apache.commons.lang3.StringUtils; // my views I have not installed any apache commons from any website, I have followed
//major steps given by chatgpt and few from copilot at last and worked only on intellij to get this package import at any means.
//anyways i don't understand what the maven is? what the adding this? to classpath? two files name pom.xml(Untitled-goyalnan) and
// src\pom.xml, also I have added dependencies as it is from chatgpt no but version changed
//i also created a new project named untitled-Nandini at first to initiate this package!!

import java.util.StringTokenizer;
public class username_email2 {
    public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
     //replaceAll --> done in username_email
     //1. split()
       String email1 = sc.next();
       String username = email1.split("@",2)[0]; // first part print out of two splitted part
       System.out.println(username);

       String[] username1 = email1.split("//@");//parts before @ and after @ prints
                                                     //'//@' or '@' both are correct but as per chatgpt -->
        // using '\\@' ensures consistency when escaping other special characters in regular expressions
       for(String part : username1){
           System.out.println(part);
       }

       String username2 = email1.split("@")[0]; // first part print out of two splitted part
       System.out.println(username2);


     //substring() indexOf()
        String email2 = sc.next();
        String username3 = email2.substring(0,email2.indexOf('@'));
        System.out.println(username3);

     //scanner useDelimiter()
        String email3 = sc.next();
        String username4 = new Scanner(email3).useDelimiter("@").next();
        System.out.println(username4);


     //StringUtils.substringBefore()
        String email5 = sc.next();
        String username6 = StringUtils.substringBefore(email5, "@");
        System.out.println(username6);


     //StringTokenizer is deprecated!!
        //Deprecated literally means disapproved of, but a more accurate translation would be retired.
        // Deprecated means this method is still usable, but you should not use it. It will gradually be phased out.
        // There is a new method to do the same thing.
        String email4 = sc.next();
        StringTokenizer username5 = new StringTokenizer(email4,"@");
        System.out.println(username5.nextToken());


    }
}
