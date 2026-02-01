package Strings;

import java.util.*;

public class TextJustification {

    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int i = 0;

        while (i < words.length) {
            int j = i;
            int lineLen = 0;

            // pick maximum words for current line
            while (j < words.length &&
                    lineLen + words[j].length() + (j - i) <= maxWidth) {
                lineLen += words[j].length();
                j++;
            }

            int wordCount = j - i;
            StringBuilder line = new StringBuilder();

            // last line OR single word -> left justified
            if (j == words.length || wordCount == 1) {
                for (int k = i; k < j; k++) {
                    line.append(words[k]);
                    if (k < j - 1) line.append(" ");
                }
                while (line.length() < maxWidth) {
                    line.append(" ");
                }
            }
            // center aligned
            else {
                StringBuilder text = new StringBuilder();
                for (int k = i; k < j; k++) {
                    text.append(words[k]);
                    if (k < j - 1) text.append(" ");
                }

                int remaining = maxWidth - text.length();
                int leftSpaces = remaining / 2;
                int rightSpaces = remaining - leftSpaces;

                for (int s = 0; s < leftSpaces; s++) line.append(" ");
                line.append(text);
                for (int s = 0; s < rightSpaces; s++) line.append(" ");
            }

            result.add(line.toString());
            i = j;
        }

        return result;
    }

    public static void main(String[] args) {

        String[] words = {
                "Science","is","what","we","understand",
                "well","enough","to","explain","to","a",
                "computer.","Art","is","everything",
                "else","we","do"
        };

        int maxWidth = 20;

        List<String> output = fullJustify(words, maxWidth);

        // print output
        for (String line : output) {
            System.out.println("\"" + line + "\"");
        }
    }
}
