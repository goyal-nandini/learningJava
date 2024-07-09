import java.util.*;

public class prime_numbers{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int starting_number = sc.nextInt();
        int ending_number = sc.nextInt();
        int count = 0;
        for(int i = starting_number; i <= ending_number; i++){
            for(int j = 2; j < i; j++){
                if(i % j == 0){
                    count ++;
                    break;
                }
            }
            if(count == 0)
                System.out.println(i);

            count = 0;
        }
    }
}