package Strings;
// correct from of that git repo code...gpt
public class RecursiveAtoi_2{
    public static void main(String[] args) {
        System.out.println(myAtoi("  -04 2"));   // Output: -4
        System.out.println(myAtoi("4193 with words")); // Output: 4193
        System.out.println(myAtoi("words and 987"));   // Output: 0
        System.out.println(myAtoi("-91283472332"));    // Output: -2147483648
    }

    // Recursive helper function
    public static int myAtoiHelper(String s, int index, int sign, long result) {
        // Base case: stop if index is out of range
        if (index == s.length()) {
            return (int)(result * sign);
        }

        char c = s.charAt(index);

        // If current character is not a digit, stop recursion
        if (!Character.isDigit(c)) {
            return (int)(result * sign);
        }

        int digit = c - '0';
        result = result * 10 + digit;

        // Check overflow safely
        if (sign == 1 && result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (sign == -1 && -result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        // Continue recursion
        return myAtoiHelper(s, index + 1, sign, result);
    }

    public static int myAtoi(String s) {
        s = s.trim();
        if (s.length() == 0) return 0;

        int sign = 1;
        int index = 0;

        // Handle sign
        if (s.charAt(0) == '+' || s.charAt(0) == '-') {
            sign = (s.charAt(0) == '-') ? -1 : 1;
            index++;
        }

        // If no digits after sign
        if (index >= s.length() || !Character.isDigit(s.charAt(index))) return 0;

        return myAtoiHelper(s, index, sign, 0);
    }
}

