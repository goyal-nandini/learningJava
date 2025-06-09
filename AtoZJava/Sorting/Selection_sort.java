package Sorting;

import java.util.Scanner;

public class Selection_sort {
    public static void selection_sort(int[] arr, int n){
        // selection sort --> choose minimum and swap
        for(int i=0; i<=n-2; i++){
            int min = i;
            // finding the minimum
            for(int j=i; j<=n-1; j++){
                if(arr[j]<arr[min]) min = j;
            }
            swap(arr, i, min);
        }
    }
    // Since Java passes primitive values by copy, your standalone swap method
    // won't actually modify the original array. Instead, the most efficient way
    // is to swap elements directly inside the loop.
    public static void swap_won_t_Work(int n, int m){
        int temp = n;
        n = m;
        m = temp;
    }
    // You can modify your swap function to work with array indices
    // instead of passing primitive values. Here’s how you do it:
    public static void swap(int[] arr, int i, int min){
        int temp;
        temp = arr[i];
        arr[i] = arr[min];
        arr[min] = temp;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];
        for(int i=0; i<size; i++){
            arr[i] = sc.nextInt();
        }
        selection_sort(arr, size);
        for(int i=0; i<size; i++){
            System.out.print(arr[i] + " ");
        }

    }


}
