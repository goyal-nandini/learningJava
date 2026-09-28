import java.util.*;

public class print_even{
    public static void main(String[] args){
        Scanner sc = new Scanner (System.in);
        int numbers_of_even = sc.nextInt();
        int count = 0;

        for(int i = 0; i < numbers_of_even; i++){
            if(i % 2 == 0){
                count ++;
            }
            if(count != 0){
                System.out.println(i+" ");
            } else {
                System.out.print(i+"  ");
            }
            count = 0;
        }

    }
}