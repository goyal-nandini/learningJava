//HACKERRANK

import java.util.*;
// hackerrank problem loopII
//You are given q queries in the form of a, b, and n.
// For each query, print the series corresponding to the given a, b, and n values as a single
// line of n space-separated integers.
//Input Format
//The first line contains an integer, q, denoting the number of queries. Each line i of the q
// subsequent lines contains three space-separated integers describing the respective ai, bi, and ni
// values for that query.
//Output Format
//For each query, print the corresponding series on a new line. Each series must be printed
// in order as a single line of n space-separated integers.

public class loopII{
    public static void main(String []argh){
        Scanner in = new Scanner(System.in);
        int a,b,n;
        int t=in.nextInt();
        for(int i=0;i<t;i++){
            a = in.nextInt();
            b = in.nextInt();
            n = in.nextInt();
            int sum = 0;
            for(int j=0; j<n; j++){
                //int x = a + (int)Math.pow(2,j)*b;
                int x = (int)Math.pow(2,j)*b;
                sum = sum + x;
                System.out.print(a + sum + " ");
            }
            System.out.println();
        }
    }
}
