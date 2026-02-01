package Strings;
// gpt edition -> yrr ye same hi hai pichle se...!!
public class RecursiveAtoi_3 {

    public int myAtoi(String s) {
        if (s == null || s.length() == 0) return 0;
        s = s.trim();                          // Step 1: remove spaces
        if (s.length() == 0) return 0;

        int sign = 1;
        int index = 0;

        // Step 2: check sign
        if (s.charAt(0) == '+' || s.charAt(0) == '-') {
            sign = (s.charAt(0) == '-') ? -1 : 1;
            index++;
        }

        // Step 3: start recursive conversion
        return helper(s, index, 0, sign);
    }

    // Recursive helper: builds number digit by digit
    private int helper(String s, int index, long value, int sign) {
        // base case: stop if end or non-digit
        if (index >= s.length() || !Character.isDigit(s.charAt(index))) {
            long ans = value * sign;
            if (ans > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (ans < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            return (int) ans;
        }

        int digit = s.charAt(index) - '0';
        value = value * 10 + digit;

        // overflow check before next call
        long signedValue = value * sign;
        if (signedValue > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if (signedValue < Integer.MIN_VALUE) return Integer.MIN_VALUE;

        // recursive step
        return helper(s, index + 1, value, sign);
    }
}
