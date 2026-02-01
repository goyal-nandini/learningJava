package fundamentals;

// STILL TODO: LEFT!!
/* here's still quick overview!!
Purpose: Fast INPUT reading (NOT string manipulation!)
Use case: Reading input in competitive programming
Why: Much FASTER than Scanner for large inputs

This is DIFFERENT from StringBuilder/StringBuffer!*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FasterInputs {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine(); // read a line
        int n = Integer.parseInt(line); // cover to int

        String[] parts = br.readLine().split(" ");
        int a = Integer.parseInt(parts[0]);
        int b = Integer.parseInt(parts[1]);
    }
}
