//hollow rhombus (self-made logic from my learnings) yes !!
import java.util.Scanner;
public class pattern14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n value");
        int n = sc.nextInt();
        for(int i=1; i<=n;i++){
            for(int j=1; j<=n-i; j++){
                System.out.print(" ");
            }
            //System.out.print("*");
            for(int j=1; j<=n; j++){
                if(j==n||j==1||i==1||i==n) {
                    System.out.print("*");
                } else System.out.print(" ");
            }
            System.out.println();
        }
    }
}