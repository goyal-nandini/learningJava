package Contest_CC_CF_LC;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// good DISCUSSION ON THIS PS
//https://chatgpt.com/s/t_6967e9d636fc81919e03190cf66ba29d

public class CC_Odd_String {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        while(q-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();

            Map<Character, Integer> map = new HashMap<>();

            for(int i=0; i<n; i++){
                char c = s.charAt(i);
                map.put(c, map.getOrDefault(c, 0) + 1);
            }

            boolean possible = true;

            for(int freq: map.values()){
                if(freq > 2){
                    possible = false;
                    break;
                }
            }
            System.out.println(possible ? "YES" : "NO");

//            You are printing YES / NO for every character
//            But the problem expects ONLY ONE answer per test case
//            for(Map.Entry<Character, Integer> m: map.entrySet()){
//                if(m.getValue() > 2){
//                    System.out.println("NO");
//                } else {
//                    System.out.println("YES");
//                }
//            }


        }

    }
}
