//Write a program to count the number of 1’s in a binary representation of the number.
import java.util.*;
public class count1InBinary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int binnum = sc.nextInt();
        int count = 0;

        String binStr = Integer.toString(binnum);
        for(int i=0; i<binStr.length(); i++){
            char c = binStr.charAt(i);
            if(c == '1')
                count++;
        }
        System.out.println(count);
    }
}
