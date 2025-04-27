package collection_framework.ArrayList;

import java.util.ArrayList;
import java.util.Iterator;


public class LearnArrayList {
    public static void main(String[] args) {
        // type[] arrayName; <-- array declaration
        // creation of array of 5 Strings -->
        String[] cars = new String[30];
        cars[0] = "BMW";
        // cars[1] ....cars[28]
        cars[29] = "Ford";

        //cars[30] = "Tesla"; // ArrayIndexOutOfBoundsException
// 📍📍
        ArrayList<String> stud = new ArrayList<>();
        stud.add("Rakesh"); //this will add at end of the list
        stud.add("Raman");

        stud.add(1, "Ram");
        System.out.println(stud); // [Rakesh, Ram, Raman]

        ArrayList<String> newStud = new ArrayList<>(); // creating new list
        newStud.add("Rina");
        newStud.add("Tina");

        stud.addAll(newStud);

        System.out.println(stud); //[Rakesh, Ram, Raman, Rina, Tina]

        System.out.println(stud.get(1)); //Ram

        /*stud.remove(2);

        stud.remove(String.valueOf("Tina"));

        stud.clear(); // this will remove all the elements from the list*/

        stud.set(2, "Hina");

        System.out.println(stud.contains("Jaya"));

        System.out.println(stud);

        //iterating over an ArrayList — there are several ways
        //1. traditional for loop
        for (int i = 0; i < stud.size(); i++) {
            System.out.println("The student is: " + stud.get(i));
        }
        //2. for-each loop
        for(String studName : stud){
            System.out.println("forEach loop student name is: " + studName);
        }
        //3. iterator
        Iterator<String> it = stud.iterator();
        //hasNext()
        while(it.hasNext()){
            System.out.println("Iterator "+it.next());
        }
//        iterator() method creates an Iterator object for the ArrayList.
//
//        hasNext() method checks if there is a next element available.
//
//        next() method moves the cursor forward and returns the next element.

//        Step	What happens
//        1	    iterator() - Give me the remote control!
//        2	    hasNext() - Is there another channel?
//        3	    next() - Go to that channel and show!







        System.out.println("size of list is: " + stud.size());
//
//        for(String name : stud){
//            System.out.println(name);
//        }
//        System.out.println(stud);

// 📌vedio m sir used this list interface
//        List<String> list = new ArrayList();
//        list.add("Anjana");
//        list.add("Rama");
//        System.out.println(list);

    }
}
//List<String> is an interface, and ArrayList<String> is a concrete class implementing
// that interface.
//
//The methods (like add(), get(), set(), remove(), etc.) will work exactly the same way
// whether you use ArrayList directly or declare it as a List.

