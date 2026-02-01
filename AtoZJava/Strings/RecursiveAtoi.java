package Strings;
// took from git repo...
public class RecursiveAtoi {
    public static void main(String[] args) {
        System.out.println(myAtoi("  -04 2"));
    }
    // Recursive helper function
    public static int myAtoiHelper(String s, int index, int sign, long result) {
        // Base case: if the index is out of bounds, return the current result
        if (index == s.length()) {
            return (int) result * sign;
        }

        char c = s.charAt(index);

        // Handle the sign (only on the first character)
        if (index == 0 && (c == '-' || c == '+')) {
            sign = (c == '-') ? -1 : 1;
            return myAtoiHelper(s, index + 1, sign, result);
        }

        // If the current character is a digit, process it
        if (Character.isDigit(c)) {
            result = result * 10 + (c - '0');

            // Handle overflow and return bounds
            if (result * sign <= Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }

            if (result * sign >= Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }

            return myAtoiHelper(s, index + 1, sign, result);
        }

        // If a non-digit character is encountered, return the current result
        return (int) result * sign;
    }

    // 1st Approoach: Using Recursion - Time Complexity = O(n), Space Complexity = O(n)
    public static int myAtoi(String s) {

        return myAtoiHelper(s.trim(), 0, 1, 0);
    }
}



