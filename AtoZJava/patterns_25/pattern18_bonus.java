package patterns_25;

//actually this pattern doesn't match with striver sheet in codestudio so
// consider it a bonus with pattern 18
public class pattern18_bonus {
    public static void alphaTriangle(int n) {
        // Write your code here
        for(int i=0; i<n; i++){
            char ch = (char)('A' + n-1);
            for(int j=0; j<=i; j++){
                System.out.print(ch+" ");
                ch--;
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
            alphaTriangle(5);
    }
}
