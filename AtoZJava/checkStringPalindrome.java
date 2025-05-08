import java.util.Scanner;

public class checkStringPalindrome {
    public static boolean checkString(String s, int i){
        // say string of n size
        int n = s.length();
        if(i>=n/2) return true;
        if(s.charAt(i) != s.charAt(n-i-1)) return false;
        return checkString(s, i+1);
    }
    public static void main(String[] args) {
        // string input
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        System.out.println(checkString(s, 0));
    }
}
