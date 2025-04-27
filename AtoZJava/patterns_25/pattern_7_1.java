package patterns_25;

public class pattern_7_1 {
    public static void nStarTriangle(int n) {
        // Write your code here
        //this striver made it
        for(int i=0; i<n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print("-"); // - for just to check for correct pattern
            }
            for (int k = 0; k < 2 * i + 1; k++){
                System.out.print("*");
            }
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print("-");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        nStarTriangle(7);
    }
}
