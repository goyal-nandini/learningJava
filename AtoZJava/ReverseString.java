public class ReverseString {

    public static Boolean isPalindrome(String s) {
        String revString = "";

        for(int i=0; i<s.length(); i++){
            revString = s.charAt(i) + revString;
        }
        if(s.equals(revString)) return true;
        else return false;
    }
    public static void main(String[] args) {

        System.out.println(isPalindrome("racecar"));
    }
}
