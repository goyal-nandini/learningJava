// use of switch statement
 import java.util.*;

public class button_system{
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        switch(num){
            case 1 :
                System.out.println("hello");
            case 2 :
                System.out.println("namaste");
            case 3 :
                System.out.println("bonjour");
            default :
                System.out.println("invalid number");
        }
    }
}