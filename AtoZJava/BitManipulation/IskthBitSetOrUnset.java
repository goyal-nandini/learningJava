package BitManipulation;

// 2 approaches -> left shift and right shift

public class IskthBitSetOrUnset {
    public static void main(String[] args) {
        System.out.println(isKthBitSet_leftShift(13, 2));
        System.out.println(isKthBitSet_rightShift(13, 1));
    }
    static boolean isKthBitSet_leftShift(int n, int k) {
        // 1. left shift:
         if((n & (1 << (k))) != 0)
             return true;
         else
             return false;

// or simply this way -> left shift
        // return (n & (1 << (k))) != 0;
    }
    static boolean isKthBitSet_rightShift(int n, int k) {
        // 2. right shift:
         if((n >> (k) & 1) == 0)
             return false;
         else
             return true;

        // or simply this way -> right shift
//       return ((n>>(k))&1)==1;
    }

}
