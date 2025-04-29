package patterns_25;

//by striver
public class pattern_18 {
    static void pattern(int n){
        for(int i=1; i<=n; i++){
            for(char ch = (char)('A'+n-i); ch<'A'+n; ch++){
                System.out.print(ch+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
    pattern(5);


    }
}
