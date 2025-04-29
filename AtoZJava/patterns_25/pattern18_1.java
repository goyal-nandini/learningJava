package patterns_25;

// by me
public class pattern18_1 {
    static void pattern1(int n){
        char ch = (char)('A'+n-1);
        for (int i = 1; i <= n; i++) {
            for (char c = ch; c < 'A'+n; c++) {
                System.out.print(c+" ");
            }
            ch--;
            System.out.println();
        }
    }
    static void pattern2(int n){
        char ch;
        for(int i=n; i>=1; i--) {
            ch = (char)('A' + i-1);
            for (char c = ch; c < 'A' + n; c++) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        pattern1(5);
        pattern2(5);
    }
}
