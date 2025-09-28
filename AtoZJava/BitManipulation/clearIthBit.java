package BitManipulation;

public class clearIthBit {
    public static void main(String[] args) {
        System.out.println(clearithBit(13, 2));
    }
    public static int clearithBit(int n, int i){
        // return n ^ (1 << i); // (me) -> works but let me verify -->
        // it toggles the ith bit

        return n & ~(1 << i);
    }
}
