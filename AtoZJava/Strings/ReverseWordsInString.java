package Strings;

public class ReverseWordsInString {
    /**⏱ Time Complexity (TC)
     trim() and replaceAll() → O(n)
     First for loop (splitting) → O(n)
     substring() calls inside the loop → total O(n)
     Final reverse loop to build output → O(n)
     🔹 Overall: O(n), where n is the length of the input string.

     🧠 Space Complexity (SC)
     newS: O(n)
     sbArray: Fixed size 10000 → O(n) in worst case
     result: O(n)
     🔹 Overall: O(n) */

    public static String reverseWords(String s) {

        // Step 1: Remove leading/trailing spaces and replace multiple spaces with a single space
        String newS = s.trim().replaceAll("\\s+", " ");

        // Step 2: Create an array to store each word (max 10^4 words based on constraints)
        // can use this: List<StringBuilder> wordList = new ArrayList<>(); else here below size as per constraints
        StringBuilder[] sbArray = new StringBuilder[10000];

        int start = 0; // To mark the beginning of a word
        int j = 0; // Index to fill sbArray

        // Step 3: Split string into words manually by spaces
        for(int i=0; i<newS.length(); i++){
            if(newS.charAt(i) == ' '){ // a word completed

                // Found a word from 'start' to 'i - 1'
                String subStr = newS.substring(start, i);
                // sbArray[j] = new StringBuilder(subStr); // or this below:
                sbArray[j] = new StringBuilder(); // initialize
                sbArray[j].append(subStr); // now it's safe to use, else without initialization: sbArray[j] is still null — you're trying to call .append() on a null object, which causes: Exception in thread "main" java.lang.NullPointerException

                start = i+1; // Move start to the next word
                j++;

            }
        }

        // Step 4: Add the last word (as loop breaks before it)
        if (start < newS.length()) {
            sbArray[j++] = new StringBuilder(newS.substring(start));
        }

        // help us to see the array:
        for(int k = 0; k < j; k++){
            System.out.println("sbArray[" + k + "] = " + sbArray[k]);
        }

        // Step 5: Build the result by appending words in reverse order
        StringBuilder result = new StringBuilder();

//       for(int i=sbArray.length-1; i>=0; i--){ ->This will loop over
//       the entire array of size 10,000, but only the first j elements (words) were actually filled.
//       The rest of the entries in sbArray are still null. So if you do sbArray[i] where i >= j,
//       you'll get a NullPointerException.

        for(int i=j-1; i>=0; i--){
            result.append(sbArray[i]);
            if (i > 0) result.append(" "); // Add space between words, not after the last
        }
        return result.toString(); // Final reversed string
    }


    public static void main(String[] args) {
        String s = "the sky is blue";
        System.out.println("After reversing words: ");
        System.out.println(reverseWords(s));

    }
}
