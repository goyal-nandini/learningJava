public class findnCr_nPr{
    public static void main(String[] args){
        System.out.println("nCr :"+nCr(3, 2));
        System.out.println("nPr : "+(nCr(3, 2))*(fact(2)));

    }
    // logic seen in pascal's triangle pattern15
    public static int nCr(int n, int r) {
        if (r > n / 2) r = n - r;   //The purpose of this line is to optimize the calculation of
                                    // the binomial coefficient (C(n, r)), also known as “n choose r” or
                                    // “combinations.”
        //The optimization occurs when (r > \fac{n}{2}).
        //In this case, it’s more efficient to calculate (C(n, n-r)) instead of (C(n, r)) because
        // they are equivalent.
        //By choosing the smaller value between (r) and (n-r),
        // we reduce the number of multiplications and divisions needed.
        int ans = 1, i;
        for (i = 1; i <= r; i++) {
            ans *= n - r + i;
            ans /= i;
        }
        return ans;
    }
    public static int fact(int num){
        if(num==1 || num==0)
            return 1;
        else
            return (num*fact(num-1));
    }
}

