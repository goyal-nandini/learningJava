//import java.util.*;
public class StringsBuilder {
    public static void main(String[] args) {
       StringBuilder sb = new StringBuilder("raman");
        System.out.println("original string : "+sb);
       //String str = "naman";
       //1.set char at
        sb.setCharAt(2,'j');
        System.out.println("setting character : "+sb);

        //2.insert char at
        sb.insert(1,'a');
        System.out.println("inserting character : "+sb);


        //3.delete char at
        sb.delete(1, 2);
        System.out.println("deleting character : "+sb);

        //4.append char at
        sb.append(" roy");
        System.out.println("appending character : "+sb);

    }
}
