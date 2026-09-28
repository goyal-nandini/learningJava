import java.util.*;
public class findnCr{
    public static void main(String[] args){
        //nCr = n!/(n-r)!r!
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();
        System.out.println(calculateNcr(n, r));
    }
    public static int calculateNcr(int n, int r){
    //return fact(n) /(fact(n-r)*fact(r));
        int num = fact(n);
        int den = fact(n-r)*fact(r);
        int res = num/den;
        return res;
    }
    public static int fact(int num) {
//         int fact = 1;
//         for (int i = 1; i <= num; i++) {
//                fact *= i;
//            }
//            return fact;
        if (num == 1 || num == 0) // use of recursion
            return 1;
        else
            return (num * fact(num - 1));
    }
}