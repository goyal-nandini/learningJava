import java.util.*;

public class loop1{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.printf("table of %d is\n", num);
        //System.out.println("table of " + num + " is"); // an another correct way.

        for (int counter = 1; counter < 11; counter ++){
            System.out.print((num * counter)+" ");
            //System.out.println((num * counter) +" ");  this will make a difference on printing the answer
            //System.out.println(num + '*' + counter  +'=' + num * counter); wrong output don't know reason
        }

    }
}