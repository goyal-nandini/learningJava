package Sorting;

import java.util.Scanner;

public class Insertion_sort {
    public static void insertion_sort(int[] arr, int n){
        // insertion sort --> compare with its left and swap till its correct position
        for(int i=0; i<=n-1; i++){
            int j=i;
            while(j>0 && arr[j-1] > arr[j]){
                swap(arr, j-1, j);
                j--;
            }
        }
    }

    // optimises way --> we have this same in out notebook rem na...!! yess!!
    public static void optimised_insertion_sort(int[] arr, int n){
        for(int i = 1; i < n; i++){
            int key = arr[i];
            int j = i - 1;

            // shift elements greater than key to the right
            while(j >= 0 && arr[j] > key){
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key; // insert key at correct position
        }
        // 🔍 Why Better?
        //Shifting is less expensive than swapping repeatedly.
        //You avoid the extra temporary variable used for each swap.
        //Fewer assignments overall.
    }

    public static void swap(int[] arr, int i, int j) {
        int temp;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        insertion_sort(arr, size);
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
