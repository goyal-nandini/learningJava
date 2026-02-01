package BitManipulation;

// lc excel sheet question - find columntitle

public class Base10toBasek {
    public static void main(String[] args) {
        System.out.println(convertToTitle(26));
    }
    public static String convertToTitle(int columnNumber) {
        // this basicaly came from LC 1837, basically here k = 26
        String res = "";
        while(columnNumber > 0){
            columnNumber--;
            int rem = columnNumber % 26;
            char remS = (char)(rem + 'A');
            res = remS + res; // prepending
            columnNumber /= 26;
        }
        return res;
    }
}
