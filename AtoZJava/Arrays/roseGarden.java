package Arrays;

public class roseGarden {
//    public static int roseGarden(int[] arr, int m, int k) {
//        if (arr.length < m * k) return -1;
//        int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;
//        for (int n : arr) {
//            low = Math.min(low, n);
//            high = Math.max(high, n);
//        }
//
//        int ans = -1;
//        while(low <= high){
//            // int mid = (low+high)/2;
//            int mid = low + (high - low) / 2;
//            if(willMakeBouquet(arr, m, k, mid)){
//                ans = mid;
//                high = mid - 1; // we need minimum days
//            } else {
//                low = mid + 1;
//            }
//        }
//        return ans;
//    }
    public static int roseGarden(int[] arr, int k, int m) {
        long val = (long) m * k;
        int n = arr.length; // Size of the array
        if (val > n) return -1; // Impossible case.
        // Find maximum and minimum:
        int mini = Integer.MAX_VALUE, maxi = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            mini = Math.min(mini, arr[i]);
            maxi = Math.max(maxi, arr[i]);
        }

        for (int i = mini; i <= maxi; i++) {
            if (willMakeBouquet(arr, i, m, k))
                return i;
        }
        return -1;
    }

    // function to calculate the validity of making bouquet
//    public static boolean willMakeBouquet(int[] arr, int m, int k, int mid) {
//        int resultCnt = 0;
//        int cnt = 0;
//        int n = arr.length;
//        for (int i = 0; i < n; i++) {
//            if (arr[i] <= mid) { // current day is valid for bloom and incre the cnt
//                cnt++;
//                if (cnt == k) {
//                    resultCnt++; // one bouquet done
//                    cnt = 0; // now, count for next bouquet
//                     if(resultCnt == m){ // required bouquet done
//                         return true;
//                     }
//                }
//            } else cnt = 0; // else make the cnt 0 for adjacent flowers (broken consecutiveness)
//        }
//        // return false;
//        return resultCnt >= m;
//    }
    public static boolean willMakeBouquet(int[] arr, int m, int k, int mid) {
        int n = arr.length; // Size of the array
        int cnt = 0;
        int noOfB = 0;
        // Count the number of bouquets:
        for (int i = 0; i < n; i++) {
            if (arr[i] <= mid) {
                cnt++;
            } else {
                noOfB += (cnt / k);
                cnt = 0;
            }
        }
        noOfB += (cnt / k);
        return noOfB >= m;
    }
    public static void main(String[] args) {
//        int[] arr = {7, 7, 7, 7, 13, 11, 12, 7};
        int[] arr = {1,2,1,2,7,2,2,3,1};
        int k = 3;
        int m = 2;
        int ans = roseGarden(arr, k, m);
        if (ans == -1)
            System.out.println("We cannot make m bouquets.");
        else
            System.out.println("We can make bouquets on day " + ans);
    }
}

