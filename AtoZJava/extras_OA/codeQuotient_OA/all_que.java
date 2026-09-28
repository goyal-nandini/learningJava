package extras_OA.codeQuotient_OA;

import Hashing_BS_Heap.CharacterHashMap;

public class all_que {
    static void main(String[] args) {
        System.out.println(addOne(1239));

        System.out.println(isLucky("2fr4s 2fr4f4"));
    }

    // que 1 Add 1 to each digit — ignore carry
    private static int addOne_mine(int n){
        // the reverse-twice approach looks intuitive but the leading zero edge case will bite you every time.
        int res = 0;
        while(n>0){
            int digit = n%10;
            int newDigit = (digit+1)%10; // ignore carry by doing %10 - means taking last digit only :)
            res = res * 10 + newDigit;
            n /= 10;
        }

        System.out.println(res);

        // reverse the res
        int ans = 0;
        while(res>0){
            int digit = res%10;
            ans = ans * 10 + digit;
            res /= 10;
        }
        return ans;
    }

    // Reverse: res = res * 10 + digit — just shift and append, no place needed
    // Straight: res = res + digit * place, then place *= 10 — place tracks where each digit belongs
    // That's the whole thing. Lock it in.

    private static int addOne(int n){
        int res = 0;
        int place = 1;

        while(n>0){
            int digit = n%10;
            int newDigit = (digit+1)%10;
            res = res + newDigit * place;
            place *= 10;
            n /= 10;
        }
        return res;

    }

    // que 2 check anagram - i know it - skip

    // que 3
    private static boolean isLucky(String input){
        String[] passwords = input.split(" ");
        for(String pwd: passwords){
            if(!isPassword(pwd)) return false;
        }
        return true;
    }

    private static boolean isPassword(String pwd){
        // cond 1: exactly 3 digits
        int digitCnt = 0;
        for(char c: pwd.toCharArray()){
            if(Character.isDigit(c)) digitCnt++;
        }
        if(digitCnt != 3) return false;

        // cond 2: no two adj digit
        for(int i=0; i<pwd.length()-1; i++){
            if(Character.isDigit(pwd.charAt(i)) && Character.isDigit(pwd.charAt(i+1))){
                return false;
            }
        }
        return true;
    }

}
