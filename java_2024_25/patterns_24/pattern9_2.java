//hollow butterfly pattern (one line repeated in mid)
import java.util.Scanner;
public class pattern9_2{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter n value");
        int n=sc.nextInt();
        int sp=2*n-1,st=0;
        for(int i=1;i<=2*n-1;i++){
            if(i<=n){
                sp=sp-2;
                st++;
            }
            else{
                sp=sp+2;
                st--;
            }
            for(int j=1;j<=st;j++){
                if(j==1 || j==st || ((j+1)==st && i==n))
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            for(int k=1;k<=sp;k++){
                System.out.print(" ");
            }
            for(int l=1;l<=st;l++) {
                if(l==1 || l==st || ((l+1)==st && i==n)) {
                    if (l != n)
                        System.out.print("*");
                }
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }
}