package BitManipulation;

// lc excel sheet question - find columnnumber

public class BasektoBase10 {
    public static void main(String[] args) {
        titleToNumber("ZY", 26);
    }
    public static int titleToNumber(String columnTitle, int k) {
        int n = columnTitle.length();
        int ans = 0;
        for(int i=0; i<n; i++){
            int value = (columnTitle.charAt(i) - 'A') + 1; // map A->1 B-> 2 .... Z->26
            ans = ans * k + value; // 💥treat the string as a base‑26 number system.
        }
        return ans;
    }
}
