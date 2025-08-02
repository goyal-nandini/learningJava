package Strings;

public class PalindromCheck {
    public static void main(String[] args) {
        String str = "0P";
        System.out.println(isPalindrome(str));
    }
    static boolean isPalindrome(String str){
//        if(str == null || str.length() == 0) return true;
//        str = str.toLowerCase();
//        // two pointer approach:
//        int start = 0;
//        int end = str.length()-1;
//        while(start <= end){
//            /* They 👇 move the pointers inward (start++, end--) but only if the current character
//            is not a letter or digit.
//            this means:
//            If str.charAt(start) is a space, comma, dot, etc., we ignore it and move to the next valid character.
//            Same for str.charAt(end) — keep moving backward until you hit a valid character.*/
//
//            while (start < end && !Character.isLetterOrDigit(str.charAt(start))) start++;
//            while (start < end && !Character.isLetterOrDigit(str.charAt(end))) end--;
//
//            if(str.charAt(start) == str.charAt(end)) {
//                start++;
//                end--;
//            } else{
//                return false;
//            }
//        }
//        return true;
        // another approach:
        str = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        StringBuilder sb = new StringBuilder(str);
        return str.equals(sb.reverse().toString());

        // another approach:
//        for (int i = 0; i <= str.length() / 2; i++) {
//            char start = str.charAt(i);
//            char end = str.charAt(str.length() - 1 - i);
//
//            if (start != end) {
//                return false;
//            }
//        }
//        return true;
    }
}
