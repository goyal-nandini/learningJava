// while loop
import java.util.Scanner;

public class decimalToBinary0 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int decnum = sc.nextInt();
        int[] binnum = new int[20];
        int i=0;
        while(decnum != 0){
            binnum[i] = decnum % 2;
            i++;
            decnum = decnum / 2;
        }
        i=(i-1);
        while(i>=0){
            System.out.print(binnum[i]);
            i--;
        }
    }
}

