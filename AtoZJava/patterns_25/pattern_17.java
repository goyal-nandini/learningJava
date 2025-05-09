package patterns_25;

public class pattern_17 {
    public static void alphaHill(int n) {
        // Write your code here

        for(int i=0; i<n; i++){
            for(int j=1; j<=n-i-1; j++){
                System.out.print(" ");
            }
            char ch = 'A';
            int breakpoint = (2*i+1)/2;
            for(int j=1; j<=(2*i+1); j++){
                System.out.print(ch);
                 if(j<=breakpoint) ch++;
                 else ch--;
            }
            for(int j=1; j<=n-i-1; j++){
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        alphaHill(7);
    }
}
