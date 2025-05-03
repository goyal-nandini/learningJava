import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PrintDivisiors {
    public static List<Integer> printDivisors (int n) {
        List<Integer> ls = new ArrayList<>();
//      for(int i=1; i<=(int)Math.sqrt(n); i++){
        for(int i=1; i*i<=n; i++){ // better than using library function
                if(n%i==0){
                    ls.add(i);
                    if((n/i) != i){
                        ls.add(n/i);
                    }
                }

        }
//      ORRR
//        for(int i=1; i<=n; i++){
//            if(n%i==0){
//                ls.add(i);
//            }
//        }
        Collections.sort(ls);
        return ls;
    }
    public static void main(String[] args) {
        List<Integer> divisors = PrintDivisiors.printDivisors(36);

        // Calling the method:
        //When you write PrintDivisors.printDivisors(36);, you're invoking the
        // printDivisors method of a class. The 36 is passed as an argument to the method, which will
        // then use that number to calculate divisors.
        //
        //Assigning to a variable:
        //The return type of printDivisors is List<Integer>, meaning it returns a
        // list of integers. By writing List<Integer> divisors = ..., you’re storing
        // the result of printDivisors(36) in a variable called divisors so you can
        // use it later (for example, printing it or processing the divisors further).

        for(int num : divisors){
            System.out.print(num + " ");
        }

        // pov: u can avoid extra space after last element:
//        List<Integer> divisors = PrintDivisiors.printDivisors(36);
//        for (int i = 0; i < divisors.size(); i++) {
//            System.out.print(divisors.get(i));
//            if (i < divisors.size() - 1) {  // check if it's not the last element
//                System.out.print(" ");
//            }
//        }


    }
}
