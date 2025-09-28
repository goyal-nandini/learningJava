package BitManipulation;

public class cntSetBits {
    public static void main(String[] args) {
        System.out.println(cntSetBits(13));
        System.out.println(cntSetBits_2(13));
    }
    // method1: brute:
    public static int cntSetBits(int n){
        int cnt = 0;
        while(n > 1){ // converting to binary

// 💛TO CHECK FOR ODD: If the least significant bit is 0, the number is even; otherwise, it's odd

            if((n & 1) == 1) cnt+=1;
            n =  n >> 1;
        }
        if(n == 1) cnt+=1;
        return cnt;
    }

    //method2:
    public static int cntSetBits_2(int n){
        int cnt = 0;
        while(n != 0){
            n = n & n-1;
            cnt++;
        }
        return cnt;
    }
}
