//package HWI_Solid_prep.HWI_25;
//
//import java.util.Scanner;
//
//public class HWI_25_E3 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int C = sc.nextInt();
//        int[] A = new int[n];
//        for(int i=0; i<n; i++){
//            A[i] = sc.nextInt();
//        }
//        int res = solve(A, C);
//        System.out.println(res);
//    }
//    // difference array tech, BS on answer, overlapping interval, lc 1109 DONE
//    private static int solve_2(int[] A, int C){
//        // binary Search on ans
//        int l=0;
//        int h=C;
//        int ans = 0;
//        while(l<h){
//            int mid = l + (h - l)/2;
//            if(isValid(A, mid, C)){
//                ans = mid;
//                h = mid-1;
//            } else {
//                l = mid+1;
//            }
//        }
//        return ans;
//    }
//    private static boolean isValid(int[] arr, int cap, int C){
//        int level = cap;
//        for(int i=0; i<arr.length; i++){
//            if(arr[i] == -1){
//                level--;
//            } else {
//                level++;
//            }
//            if(level > cap){
//
//            }
//
//
//        }
//    }
//    private static int solve(int[] A, int C){
//        int n = A.length;
//        int dist = Integer.MAX_VALUE;
//        int res = 0;
//        // for each x from 0 to C
//        for(int x=0; x<=C; x++){ // can be 0 to C
//            int cap = x;
//            int d = 0;
//            // i will check disturbances for overall ppls
//            for(int i=0; i<A.length; i++){
//                if(A[i] == -1){
//                    cap--;
//                } else {
//                    cap++;
//                }
//                if(cap < 0) {
//                    d++;
//                    cap = 0;
//                } else if(cap > C){
//                    d++;
//                    cap = C;
//                }
//            }
//            if(d < dist){
//                res = x;
//                dist = d;
//            }
//        }
//        return res;
//    }
//    private static int solve_1(int[] A, int C){
//        int cap = 1;
//        int n = A.length;
//        int i=0;
//        while(cap < C){
//            for(i=0; i<n; i++){
//                if(A[i] == -1){
//                    cap--;
//                } else {
//                    cap++;
//                }
//            }
//        }
//        while(i<n){
//            if(A[i] == -1){
//                cap--; // buy
//            } else {
//                cap++; // sold
//            }
//            if(cap <= 0) {
//                cap++;
//                i=0; // start again
//            }
//            i--;
//        }
//        return cap;
//    }
//}
