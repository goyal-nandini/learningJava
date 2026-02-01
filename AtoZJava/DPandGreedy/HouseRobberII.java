package DPandGreedy;

public class HouseRobberII {
    public static void main(String[] args) {
        int[] arr = {2, 1, 4, 9};
        System.out.println(robCircular(arr));
    }
    // just doing space optimization one
    public static int robCircular(int[] arr) {
        int n = arr.length;
        if (n == 1) return arr[0];

        // case 1: exclude first house
        int[] case1 = new int[n - 1];
        for (int i = 1; i < n; i++) {
            case1[i - 1] = arr[i];
        }

        // case 2: exclude last house
        int[] case2 = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            case2[i] = arr[i];
        }

        return Math.max(
                maxSumWithNonAdj_SP(case1),
                maxSumWithNonAdj_SP(case2)
        );
    }

    public static int maxSumWithNonAdj_SP(int[] arr){
        if (arr.length == 0) return 0;
        if (arr.length == 1) return arr[0];

        int prev = arr[0]; // dp[i-1]
        int prev2 = 0; // dp[i-2]
        for(int i=1; i<arr.length; i++){

            int pick = arr[i] + prev2;
            int notPick = prev;

            int curri = Math.max(pick, notPick);
            prev2 = prev;
            prev = curri;
        }
        return prev;

    }
}
