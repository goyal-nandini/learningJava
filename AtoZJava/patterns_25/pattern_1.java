package patterns_25;

import java.util.Scanner;

public class pattern_1 {
        void pattern(int n){
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    System.out.print("x ");
                }
                System.out.println();
            }
        }
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            // t for test cases
            int t = sc.nextInt();
            for(int i=0; i<t; i++){
                // for very test case t, value of n changes and your code is
                // checked upon the that input
                int n = sc.nextInt();
                pattern_1 obj = new pattern_1();
                obj.pattern(n);
            }

        }
}

