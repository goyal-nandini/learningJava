package patterns_25;

public class pattern19_1 {
    static void pattern(int N){
        int iniS = 0;
        for(int i=0;i< N;i++){

            for(int j=1;j<=N-i;j++){
                System.out.print("*");
            }

            for(int j=0;j<iniS;j++){
                System.out.print(" ");
            }

            for(int j=1;j<=N-i;j++){
                System.out.print("*");
            }

            // The spaces increase by 2 every time we hit a new row.
            iniS+=2;
            System.out.println();
        }

        // for lower half of the pattern
        iniS = 2*N -2;
        for(int i=1;i<=N;i++) {

            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }

            for (int j = 0; j < iniS; j++) {
                System.out.print(" ");
            }

            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }

            // The spaces decrease by 2 every time we hit a new row.
            iniS -= 2;
            System.out.println();
        }
    }

    public static void main(String[] args) {
            pattern(5);
        }

    }

