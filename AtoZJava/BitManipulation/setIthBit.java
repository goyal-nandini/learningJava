package BitManipulation;

public class setIthBit {
    public static void main(String[] args) {
        System.out.println(setithBit(9, 2));
    }
    public static int setithBit(int n, int i){
        return n | (1 << i);
    }
}
