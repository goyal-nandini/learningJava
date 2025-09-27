package BitManipulation;

import java.util.Arrays;
import java.util.ArrayList;

public class Swap2Num {
    public static void main(String[] args) {
        System.out.println(swap_using_XOR(23, 32));
    }
    public static ArrayList<Integer> swap_using_XOR(int a, int b){
        a = a ^ b;
        b = a ^ b; // means b = a
        a = a ^ b; // means a = b

        return new ArrayList<>(Arrays.asList(a, b));

    }
}
