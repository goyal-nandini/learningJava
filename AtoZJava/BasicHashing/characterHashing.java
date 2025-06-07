package BasicHashing;
import java.util.Scanner;

// string with small letters only

public class characterHashing {
    public static int withoutHashing(String s, char ch){
        int count = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == ch)
                count++;
        }
        return count;
    }
    public static int withHashing(String s, char ch){
        // we have array with character upto 26 --> so size of array we took as 26 b/c
        // first all 26 spaces for 26 char filled with 0(their freq) then their frequency is
        // incremented by the pre-computation loop in which the array will get filled with entered string
        // characters' frequency.

        int[] hash = new int[26];

        for(int i : hash)
            hash[i] = 0;
        // pre-computation i.e. assigning frequencies for character in string s
        for(int i=0; i<s.length(); i++){
            hash[s.charAt(i) - 'a']++;
        }
        // fetching and returning
        return hash[ch-'a']; // ch-'a' is the desired character whose frequency is user willing to see
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the string: ");
        String s = sc.nextLine();

        System.out.println("how many test cases you want to check for: ");
        int t = sc.nextInt(); // t is number of test cases

        System.out.println("occurance of the characters in the string:\nenter the character");
        for(int i=0; i<t; i++){
            char ch = sc.next().charAt(0);
            // for very test case t, value of ch changes and your code is
            // checked upon the that input
            // System.out.println(withoutHashing(s, ch));
            System.out.println(withHashing(s, ch));
        }


    }


//        int x = 'a';
//        System.out.println(x); // 97 --> typecasting

}
