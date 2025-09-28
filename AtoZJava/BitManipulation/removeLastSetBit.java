package BitManipulation;

public class removeLastSetBit {
    public static void main(String[] args) {
        System.out.println(removeLastSetBit(40));
    }
    public static int removeLastSetBit(int n){
        return n & n-1;
    }
}
