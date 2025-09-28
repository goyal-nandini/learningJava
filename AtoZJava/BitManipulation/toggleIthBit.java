package BitManipulation;

public class toggleIthBit {
    public static void main(String[] args) {
        System.out.println(toggleithBit(13, 1));
    }
    public static int toggleithBit(int n, int i){
        return n ^ (1 << i);
    }
}
