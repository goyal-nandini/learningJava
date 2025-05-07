import java.util.ArrayList;
public class printPrime {

        public static ArrayList<Integer> primeNumbersTillN(int N) {
            // Write your code here
            ArrayList<Integer> ls = new ArrayList<>();
            for (int i = 2; i <= N; i++) { // here starting from 2 as 1 is not a prime number
                int count = 0;
                for (int j = 1; j * j <= i; j++) {
                    if (i % j == 0) {
                        count++;
                        if ((i / j) != j) {
                            count++;
                        }
                    }
                }
                if (count == 2) {
                    ls.add(i);
                }
            }
            return ls;
        }

    public static void main(String[] args) {
        ArrayList<Integer> list = printPrime.primeNumbersTillN(36);
        System.out.println(list);
    }

}


