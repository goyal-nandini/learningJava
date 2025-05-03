// palindromic pattern
//____1
//___212
//__32123
//_4321234
//543212345

 import java.util.*;
public class pattern12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
//        for(int i=1; i<=n; i++){
//            //spaces
//            for(int j=1; j<=n-i; j++){
//                System.out.print("  ");
//            }
//            //first half
//            for(int j=i; j>0; j--){
//                System.out.print(j+" ");
//            }
//            //second half
//            for(int j=2; j<=i; j++){
//                //for(int j=1; j<=i; j++){ // can try it out
//                System.out.print(j+" ");
//            }
//            System.out.println();
//        }
        for(int i=0; i<n; i++){
            //spaces
            for(int j=0; j<n-1-i; j++){
                System.out.print("  ");
            }
            //first half
            for(int j=i+1; j>0; j--){
                System.out.print(j+" ");
            }
            //second half
            for(int j=2; j<=i+1; j++){
                //for(int j=1; j<=i+1; j++){ // can try it out
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
}