package BitManipulation;

public class Conver2Decimal {
    public static void main(String[] args) {
        String binNo = "1111";
        System.out.println(bin2Dec(binNo));
    }
    public static int bin2Dec(String binNo){
        int num = 0;
        int len = binNo.length();
        int powerOf2 = 1;
        for(int i=len-1; i>=0; i--){
            //moving right to left
            if(binNo.charAt(i) == '1'){
                num += powerOf2;
            }
            powerOf2 *= 2;
        }
        return num;

    }
}
