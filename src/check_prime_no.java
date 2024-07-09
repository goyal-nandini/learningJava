//Print if a number is prime or not (Input n from the user).
//[In this problem you will learn how to check if a number is prime or not]

import java.util.*;

public class check_prime_no{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int count = 0;
        for (int i = 2; i < num; i++){
            if(num % i == 0){
                count ++;
                System.out.println("the num " + num + " is a composite number");
                break;
            }
            if(count == 0){
                System.out.println("the num " + num + " is prime number");
            }
        }
    }
}