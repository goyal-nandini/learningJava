package Strings;

public class atoi {
    public static void main(String[] args) {
        System.out.println(myAtoi("  -04 2"));
    }

    public static int myAtoi(String s) {

        int num = 0;
        int sign = 1;
        boolean isStarted = false;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isWhitespace(ch) && !isStarted) continue; // skip leading spaces only

            // Handle sign only if not started yet
            if (ch == '-' || ch == '+') {
                if (isStarted) break;       // sign after digits → stop
                sign = (ch == '-') ? -1 : 1;
                isStarted = true;           // parsing has started
                continue;
            }

            // Handle digits
            if (ch >= '0' && ch <= '9') {
                int digit = ch - '0';

                // Overflow check before multiplying
                if (num > (Integer.MAX_VALUE - digit) / 10) {
                    return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                num = num * 10 + digit;
                isStarted = true;           // mark as started after first digit

            } else {
                // it stops parsing at the first non-digit after the number starts.(handles tc as 0-1)
                break;  // non-digit → stop parsing
            }
        }


        // int num = 0;
        // int sign = 1;
        // boolean isStarted = false;

        // for(int i=0; i<s.length(); i++){
        //     if(Character.isWhitespace(s.charAt(i))) continue;

        //     if (s.charAt(i) == '-' || s.charAt(i) == '+') {
        //         if (isStarted) break;   // sign after digits → invalid
        //         sign = (s.charAt(i) == '-') ? -1 : 1;
        //         isStarted = true;
        //     } else if((s.charAt(i) - '0') >= 0 && (s.charAt(i) - '0') <= 9){

        //         if((s.charAt(i) - '0') == 0 && num == 0) continue;
        //         num = num*10+(s.charAt(i) - '0');

        //     } else break;

        // }
        // // if(num % 10 == 0) num = num/10;
        // return num*sign;
        return num*sign;
    }

}
