package HWI_Solid_prep.HWI_24_SampleQues;

import java.util.Scanner;

public class HWI_24_Q6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        for(int i=0; i<n; i++){

            int min = arr[i];
            int idx = i;
            // from i+1 to i+k range, as per given condition
            // "distance (defined as the difference of their indices) is at most K"
            for(int j=i+1; j<=Math.min(n-1, i+k); j++){ // be careful here!
                if(arr[j] < min){
                    min = arr[j]; // by min, we'll be getting min lexicographical array
                    idx = j;
                }
            }
            if(min < arr[i]){
                swap(arr, idx, i); // only one swap!
                break;
            }

            for(int x: arr){
                System.out.println(x + " ");
            }
        }
/*ONE SWAP?!
* its written: “You are allowed to choose at most one pair of elements … and swap them.”
👉 “at most one pair” = ONLY ONE SWAP ⚠️
*
* u can do 0 swaps or 1 swaps not multiple!*/
    }
    static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
