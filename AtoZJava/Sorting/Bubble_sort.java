package Sorting;

import java.util.Scanner;

public class Bubble_sort {
    public static void bubble_sort(int[] arr, int n) {
        // bubble sort --> kind of opposite to selection sort --> take num compare it with its neighbour
        // and put it in its correct pos
        for(int i=n-1; i>=0; i--){
            int didSwap = 0; // for optimisation
            for(int j=0; j<=i-1; j++){
                if(arr[j] > arr[j+1]){
                    swap(arr, j, j+1);
                    didSwap = 1;
                }
            }
            if(didSwap == 0)
                break;

            System.out.print("runs\n"); // only to check-->this inner loop will not run when the sorted array
            // is given
        }
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
        bubble_sort(arr, size);
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}