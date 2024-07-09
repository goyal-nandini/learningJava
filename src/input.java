// important learnings

import java.util.*;  // this is a package imported, from which our useful code can be extracted.

public class input {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String name = sc.next();   //name is variable next() takes only one token
        String a = sc.nextLine();
     //The sc.nextLine() call immediately after sc.next() consumes the leftover newline character.

        System.out.println("name :"+ name);
        System.out.println("consumed part :"+a);

        String name1 = sc.nextLine(); // name1 is variable
        System.out.println("name1 :"+name1);

    }
}