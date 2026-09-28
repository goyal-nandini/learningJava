package patterns_25;

// https://www.reddit.com/r/javahelp/comments/is8rd6/need_help_with_the_2nd_part_of_an_assignment/?utm_source=chatgpt.com
//https://imgur.com/a/java-output-GLvaDod

/*

pattern is: [5, 9, -12, 5, 0, -6]

                    |*****
                    |*********
        ************|
                    |*****
                    |
              ******|
 */

/*

also we can have this way too to print:
no bars like
[3, -4, 2, -2, 3]
       |*|*|*|
*|*|*|*|
       |*|*|
   |*|*|
       |*|*|*|
 */
public class pattern_23_interviewIMP {
    static void main(String[] args) {

//        int[] arr = {5, 9, -12, 5, 25, -6, -25};
        int[] arr = {5, 9, -12, 5, 0, -6};

        // max range = 20 on both sidess...
        for(int i=0; i<arr.length; i++){

            // keep it in range [-20,20] only - as written in problem stmt to cap at +- 20 on >20 or <-20
            arr[i] = Math.max(-20, Math.min(20, arr[i]));

            if(arr[i]>0){
                // printSpaces
                for(int j=0; j<20; j++) System.out.print(" ");

                // printBar
                System.out.print('|');

                // printStar
                for(int j=0; j<arr[i]; j++) System.out.print("*");
                System.out.println();
            } else if(arr[i]<0){
                int magnitude = -(arr[i]);
                int spaces = 20-magnitude;
                // printSpaces
                for(int j=0; j<spaces; j++) System.out.print(" ");

                // printStar
                for(int j=0; j<magnitude; j++) System.out.print("*");

                // printBar
                System.out.print('|');
                System.out.println();
            } else {
                // printSpaces
                for(int j=0; j<20; j++) System.out.print(" ");

                // printBar
                System.out.print('|');
                System.out.println();
            }
        }
    }
}
