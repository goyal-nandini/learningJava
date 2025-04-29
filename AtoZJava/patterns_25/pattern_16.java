package patterns_25;

public class pattern_16 {
    public static void alphaRamp(int n) {
        // this i made
        // char ch ='A';
        // for(int i=0; i<n; i++){
        //     for(int j=0; j<=i; j++){
        //         System.out.print(ch+" ");
        //     }
        //     System.out.println();
        //     ch++;
        // }
        // this striver made
        for(int i=0; i<n; i++){
            char ch =(char)('A' + i); // this casting is important here!!
            // 'A' + i becomes an int (because char + int → int)
            //You are trying to store this int directly into a char
            // without a cast.
            for(int j=0; j<=i; j++){
                System.out.print(ch+" ");
            }
            System.out.println();
        }
        //tuf website
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<=i;j++){
        //       System.out.print((char)('A'+i)) + " ");
        //     }
        //     System.out.println();
        // }
    }
    public static void main(String[] args) {
        alphaRamp(6);
    }
}
