package patterns_25;

public class pattern_7 {
    public static void nStarTriangle(int n) {
        // Write your code here
        // this i made it
        for(int i=1; i<=n; i++) {
            for (int j = 0; j < n - (i + 1) + 1; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < 2 * i - 1; k++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        nStarTriangle(7);
    }
}
