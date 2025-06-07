package BasicHashing;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
// case insensitivity!!
public class CharacterHashMap {
    public static void main(String[] args) {
        // just refinement and revising at same time

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the String: ");
        String st = sc.nextLine().toLowerCase(); // string input

        Map<Character, Integer> map = new HashMap<>();


        for(int i=0; i<st.length(); i++){
            map.put(st.charAt(i), map.getOrDefault(st.charAt(i), 0) + 1);
        }
        System.out.println("Enter the character you want to get frequency of: ");
        char ch = sc.next().toLowerCase().charAt(0);
        System.out.println(map.getOrDefault(ch, 0));

    }
}
