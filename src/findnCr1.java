public class findnCr1{
    public static void main(String[] args){
        System.out.println(nCr(3, 2));
    }
    public static int nCr(int n, int r) {
        //if (r > n / 2) r = n - r;
        int ans = 1, i;
        for (i = 1; i <= r; i++) {
            ans *= n - r + i;
            ans /= i;
        }
        return ans;
    }
}

