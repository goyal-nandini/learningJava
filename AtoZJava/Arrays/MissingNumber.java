package Arrays;

public class MissingNumber {
    public static void main(String[] args) {
        int[] arr = {3, 0, 1};
        int ans = missing(arr);
        System.out.println(ans);
    }
    public static int missing(int[] arr){
        // first we'll sort the array

        int i=0;
        int n = arr.length;
        while(i<n){
            int curr = arr[i];
            int validInd = curr; // index where curr should go

            // real question you should ask is:
            //“Is the current value already at its correct index?”

            if(curr < n && curr != arr[validInd]){
                swap(arr, i, validInd);
            } else {
                i++;
            }
        }

        // after swapping, one more pass on array to get missing number
        for(int k=0; k<n; k++){
            if(arr[k] != k) {
                return k;
            }
        }
        return n;
    }
    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
