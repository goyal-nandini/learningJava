package Strings;

import java.util.Scanner;
// note: this i get from my prev year doubt resolving this year...👏👏👏🚩🚩🚩💛💛💛
public class Strings_method2 {
    public static void main(String[] args) {
        String email = "name@email.com";
        String username = new Scanner(email).useDelimiter("@").next();
        System.out.println(username); // prints-> name
/*🔍 What’s Happening?
new Scanner(email) creates a Scanner object to read from the string "name@email.com".
.useDelimiter("@") tells the Scanner to split input using "@" as the delimiter.
Scanner splits "name@email.com" into:
["name", "email.com"]
Then next() returns the first token = "name"
.next() reads the first token before the "@".(for more check next_method file!!)

🔁 Internally:
It works like doing:
*/
String[] parts = email.split("@");
String username2 = parts[0];

/*For just extracting parts of strings, split() is simpler and faster.

Scanner is slower and more suited for reading streams of input (like files, System.in).*/


        String[] words = {"apple", "banana", "cherry"};
        String joinedWord = String.join(", ", words);
        System.out.println(joinedWord); // prints-> apple, banana, cherry
    }
}
