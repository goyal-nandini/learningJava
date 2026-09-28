package Strings;

/* que:
## Problem Statement: Java: Encryption Decryption

Decrypt a message that was encrypted using the following logic:

* **Step 1:** First, the words in the sentence are reversed. For example, `"welcome to hackerrank"` becomes `"hackerrank
to welcome"`.
* **Step 2:** For each word, adjacent repeated letters are compressed in the format `<character><frequency>`.
For example, `"mississippi"` becomes `"mis2is2ip2i"` or `"baaa"` becomes `"ba3"`.

> **Note:** The compression format is not applied for characters with a frequency of 1. Also, the frequency will be
no greater than 9.

Return the completely decrypted string.

---
### Example
* **`encryptedMessage`** = `"world hel2o"`
1. Expand each word to get `"world hello"`.
2. Reverse the words to get `"hello world"`.
3. **Return value:** `"hello world"`

### Sample Case 0
* **Sample Input:**
seaside the to sent be to ne2ds army ten of team a
* **Sample Output:**
a team of ten army needs to be sent to the seaside

---

### Sample Case 1
* **Sample Input:**
a3b4q2i abcd2 abc
* **Sample Output:**
abc abcdd aaabbbbqqi
---

### Constraints

* $1 \le \text{length of encryptedMessage} \le 10^5$
* Character frequency counts in the encrypted string will be 9 or less.
* `encryptedMessage` consists of lowercase English letters, digits from 0 to 9, and spaces.*/

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

class Result {

    /*
     * Complete the 'decryptMessage' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING encryptedMessage as parameter.
     */

    public static String decryptMessage(String encryptedMessage) {
        // my code - i did it then some - built-in methods and spaces bug - i solved using gemini
        // expand the string first
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<encryptedMessage.length(); i++){

            char ch = encryptedMessage.charAt(i);

            if(Character.isDigit(ch)){
                // get real num instead of ASCII
                int cnt = Character.getNumericValue(ch);
                while(cnt > 1){
                    sb.append(encryptedMessage.charAt(i-1));
                    cnt--;
                }
            } else {
                sb.append(encryptedMessage.charAt(i));
            }
        }

        sb.append(" ");
        ArrayList<String> arr = new ArrayList<>();
        int prevIdx = 0;
        for(int i=0; i<sb.length(); i++){
            if(sb.charAt(i) == ' '){
                arr.add(sb.substring(prevIdx, i));
                prevIdx = i+1;
            }
        }

        // reverse the arraylist and making them a string
        int i=0;
        int j=arr.size()-1;
        while(i<j){
            String temp = arr.get(i);
            arr.set(i, arr.get(j));
            arr.set(j, temp);

            i++;
            j--;
        }

        StringBuilder res = new StringBuilder();
        for(int k=0; k<arr.size(); k++){
            res.append(arr.get(k));
            if(k<arr.size()-1){
                res.append(" ");
            }
        }
        return res.toString();



    }

}

public class encrypted_decrypted_HR_java_test {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String encryptedMessage = bufferedReader.readLine();

        String result = Result.decryptMessage(encryptedMessage);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

