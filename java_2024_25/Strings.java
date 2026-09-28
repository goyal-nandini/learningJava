import java.util.*;
public class Strings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        //concatenate
        System.out.println("concatenation : "+str + " is the STRING entered by user");
        //length()
        System.out.println("length of the string is : "+str.length());
        //get charAt()
        // 1st way
        System.out.println("character at index 0 : "+str.charAt(0));
        //2nd way
        System.out.print("left characters are : ");
        for(int i=1; i<str.length(); i++){
            System.out.print(str.charAt(i));
        }
        //compare
        // 1st way
        sc.nextLine(); // very good to me !!
        String str1 = sc.nextLine();
        if(str.equals(str1)){
            System.out.println("the strings are equal");
        } else {
            System.out.println("the strings are not equal");
        }
        // 2nd way
        // nandini > kartik --> gives any positive value if str nandini and str1 kartik
        int value = str.compareTo(str1);
        System.out.println(value);
        //3rd way
        if(str.compareTo(str1) > 0){
            System.out.println("str is greater than str1");
        } else if(str.compareTo(str1) < 0) {
            System.out.println("str is less than str1");
        } else {
            System.out.println("both strings are equal");
        }
        // substring
        System.out.print("enter a sentence :");
        String sentence = sc.nextLine();
        String subpart = sentence.substring(0, sentence.length());
        System.out.println(subpart);
    }
}
