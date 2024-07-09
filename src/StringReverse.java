public class StringReverse {
    public static void main(String[] args) {
     StringBuilder sentence = new StringBuilder("My name is Nandini.");
        System.out.println("original sentence is : "+sentence);
        for(int i=0; i<sentence.length()/2; i++){
            int first = i;
            int last = sentence.length() - 1 - i;

            char firstchar = sentence.charAt(first);
            char lastchar = sentence.charAt(last);

            sentence.setCharAt(first, lastchar);
            sentence.setCharAt(last, firstchar);
        }
        System.out.println("string after reverse : ");
        System.out.println(sentence);
    }
}
