package collection_framework.HashMap;

import java.util.HashMap;
import java.util.Map;

public class LearnHashMap {
    public static void main(String[] args) {
        Map<String, Integer> hm = new HashMap<>();
        hm.put("One", 1);
        hm.put("Two", 2);
        hm.put("Three", 3);

        System.out.println(hm); // {One=1, Two=2, Three=3}

        hm.putIfAbsent("Four", 4);

        System.out.println(hm); // {One=1, Four=4, Two=2, Three=3}
        //👉 HashMap does not preserve insertion order.

        System.out.println(hm.containsKey("Four"));
        System.out.println(hm.containsValue(5));
        System.out.println(hm.isEmpty());

        System.out.println(hm.get("Four")); //4 as value for key
        // In Java, the get() method of a HashMap is used to retrieve the value
        // associated with a specific key.
        System.out.println(hm.remove("Three")); //3 as value for key three

        // iterate through map
        /*  map.entrySet() returns a set of entries.
            Each entry is an object of type Map.Entry<K, V>
            🔹 What is Map.Entry<K, V>?
            It’s a nested interface inside the Map interface that
            represents one key-value pair.
            💡 What is Map.Entry?
            Map.Entry is just a small object that stores a key and its value.

            Java created this as a tiny helper "class-like" thing inside the Map
            interface — that’s why it’s called a nested interface.

            Think of it like this:

            interface Map {
                interface Entry<K, V> {
                    K getKey();
                    V getValue();
                }
            }
            So every item inside map.entrySet() is actually a Map.Entry object —
            a key-value pair.


        */
        for(Map.Entry<String, Integer> e: hm.entrySet()) {
            // entrySet() --> Access both key & value
            System.out.println(e);

            System.out.println(e.getKey());
            System.out.println(e.getValue());
        }

        // only want key set
        for(String key: hm.keySet()){
            System.out.println(key);
        }

        // only wants value set
        for(Integer val: hm.values())
            System.out.println(val);

//        hm.clear();
    }
}
