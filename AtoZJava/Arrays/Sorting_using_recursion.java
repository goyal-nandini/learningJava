package Arrays;

import java.util.ArrayList;

public class Sorting_using_recursion {
    public static void main(String[] args) {
        // lets write code all by ourself...its great than just copy and paste it from gpt...
        ArrayList<Integer> list = new ArrayList<>();
        list.add(-9);
        list.add(21);
        list.add(-3);
        list.add(42);
        list.add(87);

        sort(list);
        System.out.println(list);
    }
    public static void sort(ArrayList<Integer> list){
        // wohoooo lets go recursion style:

        //base condition
        if(list.size() == 1) return; // when it has size one left, then its self sorted, single ele is sorted

        //hypothesis -> actual kaam jo function karega...
        int temp = list.remove(list.size()-1); // removing last ele for reducing input size
        sort(list);

        //induction
        insert(list, temp); // for actually sorting task, insert temp in actual list
    }
    public static void insert(ArrayList<Integer> list, int temp){
        //base condition
        if(list.size() == 0 || list.get(list.size()-1) <= temp){
            list.add(temp);
            return;
        }

        //hypothesis
        int val = list.remove(list.size()-1); // for reducing size of input
        insert(list, temp);

        //induction -> put value back
        list.add(val);
    }
}
