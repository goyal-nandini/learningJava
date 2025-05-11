package BasicHashing;

import java.util.Scanner;
public class Hashing {
    public static int withoutHashing(int n, int[] arr, int num){
        int count = 0;
        for(int i=0; i<num; i++){
            if(arr[i] == n)
                count++;
        }
        return count;
    }
    public static int withHashing(int n, int[] arr, int num){
        // we have given array with numbers range upto 12

       int[] hash = new int[13];

        for(int i : hash)
            hash[i] = 0;
        // pre-computation i.e. assigning frequencies for each number in given array arr.
        for(int i=0; i<arr.length; i++){
            hash[arr[i]] += 1;
        }
        // fetching and returning
        return hash[n]; // n is the desired number whose frequency is user willing to see
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("how many test cases you want to check for: ");
        int t = sc.nextInt(); // t is number of test cases

        System.out.println("how many numbers you want in array: ");
        int num = sc.nextInt();
        int[] arr = new int[num];
        System.out.println("enter the numbers: ");
        for (int i = 0; i < arr.length; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("which numbers to be counted by program: ");
        for(int i=0; i<t; i++){
            int n = sc.nextInt();
            // for very test case t, value of n changes and your code is
            // checked upon the that input
            System.out.println(withoutHashing(n, arr, num));
            System.out.println(withHashing(n, arr, num));
        }


    }
}
