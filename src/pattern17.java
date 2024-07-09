//       0
//      101
//     21012
//    3210123
//   432101234
//  54321012345
// 6543210123456
//765432101234567
// ANSI C book pattern taken
// method Math.abs()
import java.util.*;
public class pattern17 {
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
        System.out.print("Please enter a number: ");
        int n = sc.nextInt();
        System.out.println();

        for (int i = 0; i <= n; i++) {
            for (int spaces = 0; spaces < n - i; spaces++) {
                System.out.print(" ");
            }
            // numbers printing alike --> number line eg -2, -1, 0, 1, 2
            // The Math.abs() method returns the absolute value of a number.
            //If the argument is positive, the method returns the argument itself.
            //If the argument is negative, it returns the negation of the argument
            // (i.e., the positive value corresponding to the number)
            for (int j = -i; j <= i; j++) {
                System.out.print(Math.abs(j));
            }
            System.out.println();
        }
        // my logic created
//       int n = sc.nextInt();
//
//       for(int i=0; i<=n; i++){
//           //spaces n=7 then spaces=7 then logic here is n-i for spaces
//           for(int j=n-i; j>=1; j--){
//               System.out.print(" ");
//           }
//           for(int j=i; j>=0; j--){
//               System.out.print(j);
//           }
//           for(int j=1; j<=i; j++){
//               System.out.print(j);
//           }
//           System.out.println();
//       }




    }
}
