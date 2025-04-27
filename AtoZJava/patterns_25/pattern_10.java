package patterns_25;

public class pattern_10 {
    public static void nStarTriangle(int n) {
        // Write your code here
        for(int i=0; i<n; i++){
            for(int j=0; j<=i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
        for(int i=1; i<n; i++){
            for(int j=0; j<n-i; j++){
                System.out.print("*");
            }
            System.out.println();
        }

    }
    public static void main(String[] args) {
        nStarTriangle(7);
    }
}
