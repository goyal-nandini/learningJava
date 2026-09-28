//Write a function that takes in age as input and returns if that person is eligible to vote or not.
// A person of age > 18 is eligible to vote.
import java.util.*;
public class checkForVoting {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("check for voting eligibility \nenter your age: ");
        int age = sc.nextInt();
        System.out.println("Is eligible to vote?");
        System.out.println(checkForVoting(age));
    }
    public static String checkForVoting(int a){
        if (a>18){
           return "yes";
        } else {
            return "no";
        }
    }
}