package Strings;

public class largestEvenNumber {
    public static void main(String[] args) {
        System.out.println(largestEven("221"));
    }

    public static String largestEven(String s) {
        int n = s.length();
        if(s.equals("1")) return "";
        int i=n-1;
        boolean isChanged = false;
        while(s.charAt(i) == '1'){
            i--;
            isChanged = true;
        }
        if(!isChanged) return s;
        s = s.substring(0, i+1);
        return s;


    }

}
