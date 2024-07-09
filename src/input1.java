// important learnings

import java.util.*;  // this is a package imported, from which our useful code can be extracted.

public class input1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String name = sc.next();   //name is variable next() takes only one token
        String a = sc.next(); // consumes leading space and next complete token eg "nandini goyal is my name" output--> "nandini"
        // takes in by "name" and  " goyal" consumes by sc.next(); and " is my name" takes in by "name1"
        // but sc.next(); in line 10 reads only "goyal" as printed (you can check).


        System.out.println("name :"+ name);
        System.out.println("consumed part :"+a);

        String name1 = sc.nextLine(); // name1 is variable
        System.out.println("name1 :"+name1);
    }
}