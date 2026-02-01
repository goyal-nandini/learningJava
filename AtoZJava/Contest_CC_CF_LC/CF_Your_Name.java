package Contest_CC_CF_LC;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CF_Your_Name {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        while(q-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();
            String t = sc.next();
            if(s.length() != t.length()){
                System.out.println("NO");
                continue;
            }
            Map<Character, Integer> map = new HashMap<>();
            for(int i=0; i<s.length(); i++) {
                map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            }
//            for(int i=0; i<t.length(); i++){
//                if(map.containsKey(t.charAt(i))) continue;
//                else System.out.println("NO");
//            }
            boolean possible = true;

            for (int i = 0; i < t.length(); i++) {
                char ch = t.charAt(i);
                if (!map.containsKey(ch) || map.get(ch) == 0) {
                    possible = false;
                    break;
                }
                map.put(ch, map.get(ch) - 1);
            }

            System.out.println(possible ? "YES" : "NO");
        }
    }
}
