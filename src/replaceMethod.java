//Input a string from the user. Create a new string called ‘result’ in which you will replace the letter
// ‘e’ in the original string with letter ‘i’.
//Example :
//original = “eabcdef’ ; result = “iabcdif”
//Original = “xyz” ; result = “xyz”

import java.util.*;
public class replaceMethod {
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      String str = sc.nextLine();
        System.out.println(str.replace('e','i'));
        System.out.println(str.replaceAll("n","k"));
    }
}
// much more I have written in notebook java