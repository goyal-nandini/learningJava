package Strings;

// tc: O(n) and sc: O(1)
// directly took from striver notes after dry run
// doesn't work for multiple spaces and trailing/leading spaces

public class ReverseWordsInString3 {
    public static String reverseWords(String s){
        int left = 0;
        int right = s.length() - 1;

        String temp = "";
        String ans = "";

        //Iterate the string and keep on adding to form a word in "temp"
        //If empty space is encountered then add the current word to the result
        while (left <= right) {
            char ch = s.charAt(left);
            if (ch != ' ') {
                temp += ch; // word forming here
            }
            else if (ch == ' ') {
                if (!ans.equals("")) {
                    ans = temp + " " + ans; // when "ans" is not empty, add the word(temp) to front of "ans" with a space
                } else {
                    ans = temp; // used in the starting when "ans" is empty
                }
                temp = ""; // marking empty for starting a new word
            }
            left++; // moving the pointer
        }

        // adding Last word
        if (!temp.equals("")) { // "temp" is not empty so add it to the "ans"
//            ans = temp + " " + ans;
            if (!ans.equals("")) {
                ans = temp + " " + ans;
            } else {
                ans = temp;
            }
        }
        return ans;

//        StringBuilder ans = new StringBuilder();
//        for(int i=s.length()-1; i>=0; i--){
//            if(s.charAt(i) != ' '){
//                ans.append(s.charAt(i));
//            } else{
//                continue;
//            }
//        }
//        return ans.toString();
    }
    public static void main(String[] args) {
        String s = "a good   example";
        System.out.println("After reversing words: ");
        System.out.println(reverseWords(s));
    }
}
