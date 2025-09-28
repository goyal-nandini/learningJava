package BitManipulation;

public class checkPowerOf2 {
    public static void main(String[] args) {
        System.out.println(checkPowerOf2(13));
    }
    public static boolean checkPowerOf2(int n){
        if((n & (n-1)) == 0) return true;
        return false;
    }
}
