package BitManipulation;

import java.lang.StringBuilder;


public class Concert2Binary {
    public static void main(String[] args) {
        int n=13;
        System.out.println(dec2Bin(n));
    }
    public static StringBuilder dec2Bin(int n){
        StringBuilder res = new StringBuilder();
        while(n!=0){
            if(n%2==1) res.append('1');
            else res.append('0');

            n = n/2;
        }
        return reverse(res);
    }
    public static StringBuilder reverse(StringBuilder val){
        int left = 0;
        int right = val.length()-1;

        while(left <= right){
            // swap
            char temp = val.charAt(left);
            val.setCharAt(left, val.charAt(right));
            val.setCharAt(right, temp);

/*StringBuilder gives you .charAt() to read, but you can’t assign directly.
Use .setCharAt(index, char) instead of val.charAt(left) = ....*/

            left++;
            right--;
        }
        return val;
    }

}
