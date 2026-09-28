package Strings;

//https://www.hackerrank.com/challenges/encryption/problem?isFullScreen=true

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

class Result2 {

    /*
     * Complete the 'encryption' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String encryption(String s) {
        // Write your code here
        int n = s.length();

        // removing spaces
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            if(s.charAt(i) != ' '){
                sb.append(s.charAt(i));
            }
        }

        // cal rows and cols
        int len = sb.length();

        int rows = (int)Math.floor(Math.sqrt(len));
        int cols = (int)Math.ceil(Math.sqrt(len));

        if(rows * cols < len) {
            rows++;
        }

        // fill grid and read column wise
        char[][] grid = new char[rows][cols];
        int k = 0;
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(k<len) grid[i][j] = sb.charAt(k);  // here k<len check is imp
                k++;
            }
        }

        StringBuilder res = new StringBuilder();
        for(int j=0; j<cols; j++){
            for(int i=0; i<rows; i++){
                if(grid[i][j] != '\0') res.append(grid[i][j]);
            }
            res.append(" ");
        }

        return res.toString();
    }
    /*few comment: code looks correct but two things:
**1. trailing space issue:**
res.append(" "); // adds space after last column too
add `.trim()` at return:
return res.toString().trim();

**2. min area check:**
PS says `floor(sqrt(n)) <= rows <= cols <= ceil(sqrt(n))`
so both rows AND cols must be between floor and ceil of sqrt. your code:
- `rows = floor(sqrt(len))` ✓
- `cols = ceil(sqrt(len))` ✓
- if `rows*cols < len`, increment `rows` ✓
this satisfies min area automatically because floor/ceil of sqrt gives the closest pair to a square —
which is always minimum area!

looks correct to me, run it!*/
}

public class encryption_HR_simulation {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result2.encryption(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

