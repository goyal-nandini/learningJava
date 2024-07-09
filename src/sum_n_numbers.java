// sum of n natural numbers

import java.util.*;

public class sum_n_numbers{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        int n = sc.nextInt();
        for(int i = 1; i < n+1; i++){
            sum = sum + i;
        }
        System.out.println(sum);

    }
}