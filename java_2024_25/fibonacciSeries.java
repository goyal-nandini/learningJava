import java.util.Scanner;

// numbers upto n
public class fibonacciSeries{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        fibonacciNumbers(n);
    }
    public static void fibonacciNumbers(int n){
        int firstTerm = 0, secondTerm = 1;

        for(int i=0; i<=n; i++){
            System.out.println(firstTerm);
            int nextTerm = firstTerm + secondTerm;
            firstTerm = secondTerm;
            secondTerm = nextTerm;
        }
    }
}