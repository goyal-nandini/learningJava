package fundamentals;

import java.util.*;
/*
| Class Type            | Purpose                          | Common Methods                                |
|------------------------|----------------------------------|-----------------------------------------------|
| Integer, Character, etc. | Wrapper (Object version of primitives) | `parseInt()`, `toString()`, `MAX_VALUE`       |
| Arrays                | Utility (Array operations)       | `sort()`, `binarySearch()`, `toString()`      |
| Collections           | Utility (Collection operations)  | `sort()`, `reverse()`, `shuffle()`, `max()`   |
| Math                  | Utility (Mathematical operations)| `abs()`, `max()`, `pow()`, `sqrt()`           |
| String                | Class (String manipulation)      | `substring()`, `split()`, `replace()`         |
| StringBuilder         | Class (Mutable strings)          | `append()`, `reverse()`, `insert()`           |
| Random                | Class (Random number generation) | `nextInt()`, `nextDouble()`                   |
 */
public class ImportantJavaClasses {
    public static void main(String[] args) {
        wrapperClassesBasics();
        wrapperClassMethods();
        wrapperClassPitfalls();

        // A utility class in Java is a class that defines a set of static methods that perform common, often-reused
        // functions across an application
        arrayUtilityClass();
        collectionsUtilityClass();
        mathUtilityClass();

        stringClassMethods();
        randomClass();
    }

    public static void wrapperClassesBasics(){
        // Wrapper classes provide a way to use primitive data types (int, boolean, etc..) as objects.
        // WHY NEED?
        // 1. Collections need objects, not primitives
        // 2. Provide useful methods
        // 3. Can be null (primitives can't be null)

        // all 8 wrapper classes
        Integer intObj = 10;
        Double doubleObj = 10.5;
        Character charObj = 'A';
        Boolean boolObj = true;
        Long longObj = 100L;
        Float floatObj = 10.5f;
        Byte byteObj = 1;
        Short shortObj = 10;

        System.out.println(intObj);
        System.out.println(doubleObj);
        System.out.println(charObj);
        System.out.println(boolObj);
        System.out.println(longObj);
        System.out.println(floatObj);
        System.out.println(byteObj);
        System.out.println(shortObj);

        // next concept of AUTOBOXING and UNBOXING
        // In Collections (happens automatically)

        List<Integer> list = new ArrayList<>();
        list.add(5);  // Autoboxing: 5 (int) → Integer
        int value = list.get(0);  // Unboxing: Integer → int
        System.out.println("From list: " + value);
    }

    public static void wrapperClassMethods(){
        // VERY IMPORTANT:

        // INTEGER METHODS:
        //⭐ string to int:
        int num1 = Integer.parseInt("123");
        System.out.println(num1);

        int num2 = Integer.parseInt("1010", 2);
        System.out.println(num2);

        int num3 = Integer.parseInt("FF", 16);
        System.out.println(num3);

        //⭐ int to string:
        String str1 = Integer.toString(123);
        System.out.println(str1);

        String binary = Integer.toBinaryString(10);
        System.out.println(binary);

        String hex = Integer.toHexString(255);
        System.out.println(hex);

        // min and max:
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);

        // comparing:
        int compare = Integer.compare(10, 20);
        System.out.println(compare);

        // bit operations:
        int bitCnt = Integer.bitCount(7);
        System.out.println(bitCnt);

        // CHARACTER METHODS:
        System.out.println("isDigit('5'): " + Character.isDigit('5'));
        System.out.println("isLetter('A'): " + Character.isLetter('A'));
        System.out.println("isLetterOrDigit('A'): " + Character.isLetterOrDigit('A'));
        System.out.println("isUpperCase('A'): " + Character.isUpperCase('A'));
        System.out.println("isLowerCase('a'): " + Character.isLowerCase('a'));
        System.out.println("isWhitespace(' '): " + Character.isWhitespace(' '));

        System.out.println("toLowerCase('A'): " + Character.toLowerCase('A'));
        System.out.println("toUpperCase('a'): " + Character.toUpperCase('a'));

        // Character to int value
        System.out.println("getNumericValue('5'): " + Character.getNumericValue('5'));
        System.out.println("getNumericValue('A'): " + Character.getNumericValue('A'));  // 10 in hex

        // DOUBLE METHODS:
        double d = Double.parseDouble("3.14");
        System.out.println("parseDouble('3.14'): " + d);

        System.out.println("Double.MAX_VALUE: " + Double.MAX_VALUE);
        System.out.println("Double.MIN_VALUE: " + Double.MIN_VALUE);

        System.out.println("isNaN(0.0/0.0): " + Double.isNaN(0.0/0.0));
        System.out.println("isInfinite(1.0/0.0): " + Double.isInfinite(1.0/0.0));
    }

    public static void wrapperClassPitfalls(){
        // 1.⭐ == vs equals()
        Integer a = 100;
        Integer b = 100;
        Integer c = 200;
        Integer d = 200;

        System.out.println((a==b)); // true (cached)
        System.out.println((c==d)); // false (not cached)

        System.out.println(a.equals(b)); // true
        System.out.println(c.equals(d)); // true

        // RULE: Java caches Integer objects from -128 to 127
        // For other values, new objects are created

        System.out.println("\n✅ BEST PRACTICE: Always use .equals() for wrapper classes!");

        // 2.
        Integer nullInt = null; // Ok
        int x = nullInt; // NO, RTE

        System.out.println("\n⚠️ Wrapper classes can be null, primitives cannot!");

        // 3.
        System.out.println("\n⚠️ Autoboxing/Unboxing in loops is SLOW!");

        // BAD - Creates many Integer objects
        Integer sum1 = 0;
        for (int i = 0; i < 1000; i++) {
            sum1 += i;  // Unboxing + boxing in every iteration!
        }

        // GOOD - Use primitives
        int sum2 = 0;
        for (int i = 0; i < 1000; i++) {
            sum2 += i;  // No boxing/unboxing
        }
    }

    public static void arrayUtilityClass(){
        int[] arr = {5, 2, 8, 1, 9};

        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        // only on sorted arrays
        int ind = Arrays.binarySearch(arr, 8);
        System.out.println("index of key 8 is " + ind);

        //⭐ Fill array with value
        int[] arr2 = new int[5];
        Arrays.fill(arr2, 7);
        System.out.println("After fill(7): " + Arrays.toString(arr2));

        // Copy array
        int[] copy = Arrays.copyOf(arr, arr.length);
        System.out.println("Copy: " + Arrays.toString(copy));

        // Copy range
        int[] range = Arrays.copyOfRange(arr, 1, 4);  // [start, end)
        System.out.println("Range [1,4): " + Arrays.toString(range));

        // Compare arrays
        boolean equal = Arrays.equals(arr, copy);
        System.out.println("Arrays equal: " + equal);

        //⭐⭐ Convert to List (FIXED SIZE!) Fixed-size List
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println("asList: " + list);
        // list.add(6);  // ❌ UnsupportedOperationException - fixed size!

        // 2D array toString
        int[][] matrix = {{1,2,3}, {4,5,6}};
        System.out.println("2D array: " + Arrays.deepToString(matrix));
    }

    public static void collectionsUtilityClass(){
        // Collections (utility class) has static methods:

        // ⭐⭐ Resizable ArrayList
        List<Integer> list = new ArrayList<>(Arrays.asList(5, 2, 8, 1, 9));
        System.out.println("Original: " + list);

        // Sorting
        Collections.sort(list);
        System.out.println("After sort: " + list);

        // Reverse
        Collections.reverse(list);
        System.out.println("After reverse: " + list);

        // Shuffle
        Collections.shuffle(list);
        System.out.println("After shuffle: " + list);

        // Binary search (on sorted list)
        Collections.sort(list);
        int index = Collections.binarySearch(list, 8);
        System.out.println("Index of 8: " + index);

        // Min and Max
        int max = Collections.max(list);
        int min = Collections.min(list);
        System.out.println("Max: " + max + ", Min: " + min);

        // Frequency
        list.add(5);
        list.add(5);
        int freq = Collections.frequency(list, 5);
        System.out.println("Frequency of 5: " + freq);

        // Swap
        Collections.swap(list, 0, 1);
        System.out.println("After swap(0,1): " + list);

        // Fill
        Collections.fill(list, 0);
        System.out.println("After fill(0): " + list);

        // Create immutable collections
        List<Integer> immutable = Collections.unmodifiableList(Arrays.asList(1, 2, 3));
        // immutable.add(4);  // ❌ UnsupportedOperationException

        // Create empty collections
        List<Integer> empty = Collections.emptyList();
        Set<Integer> emptySet = Collections.emptySet();
        Map<Integer, String> emptyMap = Collections.emptyMap();

        // ⭐⭐Collections.nCopies() - Create list with N copies
        // Create a list with 5 copies of "Hello"
        List<String> list1 = Collections.nCopies(5, "Hello");
        System.out.println("nCopies(5, 'Hello'): " + list1);

        // Create a list with 10 zeros
        List<Integer> zeros = Collections.nCopies(10, 0);
        System.out.println("nCopies(10, 0): " + zeros);

        // IMPORTANT: This list is IMMUTABLE!
        // list1.set(0, "World");  // ❌ UnsupportedOperationException

        // If you need a mutable copy:
        List<Integer> mutableZeros = new ArrayList<>(Collections.nCopies(10, 0));
        mutableZeros.set(0, 5);
        System.out.println("Mutable copy after modification: " + mutableZeros);

        List<Integer> list2 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

        // Rotate - shifts elements
        Collections.rotate(list2, 2);  // Rotate right by 2
        System.out.println("After rotate(2): " + list2);

        // Replace all occurrences
        list2 = new ArrayList<>(Arrays.asList(1, 2, 3, 2, 2, 5));
        boolean replaced = Collections.replaceAll(list2, 2, 99);
        System.out.println("After replaceAll(2, 99): " + list2);
        System.out.println("Was anything replaced? " + replaced);

        // Add all
        List<Integer> list3 = new ArrayList<>();
        Collections.addAll(list3, 10, 20, 30, 40);
        System.out.println("addAll: " + list3);

        // Disjoint - check if two collections have no common elements
        List<Integer> a = Arrays.asList(1, 2, 3);
        List<Integer> b = Arrays.asList(4, 5, 6);
        List<Integer> c = Arrays.asList(3, 4, 5);
        System.out.println("disjoint(a, b): " + Collections.disjoint(a, b));  // true
        System.out.println("disjoint(a, c): " + Collections.disjoint(a, c));  // false

        // Singleton - immutable set/list/map with one element
        Set<String> singleSet = Collections.singleton("only");
        System.out.println("singleton: " + singleSet);
        // singleSet.add("another");  // ❌ UnsupportedOperationException
    }

    public static void mathUtilityClass() {
        System.out.println("\n=== MATH UTILITY CLASS ===\n");

        // Basic operations
        System.out.println("abs(-5): " + Math.abs(-5));
        System.out.println("max(10, 20): " + Math.max(10, 20));
        System.out.println("min(10, 20): " + Math.min(10, 20));

        // Power and roots
        System.out.println("pow(2, 3): " + Math.pow(2, 3));
        System.out.println("sqrt(16): " + Math.sqrt(16));
        System.out.println("cbrt(27): " + Math.cbrt(27));

        // Rounding
        System.out.println("ceil(3.2): " + Math.ceil(3.2));
        System.out.println("floor(3.8): " + Math.floor(3.8));
        System.out.println("round(3.5): " + Math.round(3.555));

        // Trigonometry (in radians)
        System.out.println("sin(Math.PI/2): " + Math.sin(Math.PI/2));
        System.out.println("cos(0): " + Math.cos(0));

        // Logarithm
        System.out.println("log(Math.E): " + Math.log(Math.E));  // Natural log
        System.out.println("log10(100): " + Math.log10(100));

        // Random (0.0 to 1.0)
        System.out.println("random(): " + Math.random());

        // Random integer in range [min, max]
        int min = 1, max = 10;
        int randomInt = (int)(Math.random() * (max - min + 1)) + min;
        System.out.println("Random [1,10]: " + randomInt);

        // Constants
        System.out.println("PI: " + Math.PI);
        System.out.println("E: " + Math.E);
    }

    //⭐⭐ STRING CLASS (Quick Review)
    public static void stringClassMethods() {
        System.out.println("\n=== STRING CLASS IMPORTANT METHODS ===\n");

        String s = "Hello World";

        // Length
        System.out.println("length(): " + s.length());

        // Character access
        System.out.println("charAt(0): " + s.charAt(0));

        // Substring
        System.out.println("substring(0, 5): " + s.substring(0, 5));
        System.out.println("substring(6): " + s.substring(6));

        // Case conversion
        System.out.println("toUpperCase(): " + s.toUpperCase());
        System.out.println("toLowerCase(): " + s.toLowerCase());

        // Trimming
        String s2 = "  hello  ";
        System.out.println("trim(): '" + s2.trim() + "'");

        // Splitting
        String csv = "apple,banana,cherry";
        String[] parts = csv.split(",");
        System.out.println("split(','): " + Arrays.toString(parts));

        // Replace
        System.out.println("replace('l', 'x'): " + s.replace('l', 'x'));
        System.out.println("replaceAll('[aeiou]', '*'): " + s.replaceAll("[aeiou]", "*"));

        // Checking
        System.out.println("contains('World'): " + s.contains("World"));
        System.out.println("startsWith('Hello'): " + s.startsWith("Hello"));
        System.out.println("endsWith('World'): " + s.endsWith("World"));
        System.out.println("isEmpty(): " + s.isEmpty());

        // Index methods
        System.out.println("indexOf('o'): " + s.indexOf('o'));
        System.out.println("lastIndexOf('o'): " + s.lastIndexOf('o'));

        // Comparison
        System.out.println("equals('Hello World'): " + s.equals("Hello World"));
        System.out.println("equalsIgnoreCase('hello world'): " + s.equalsIgnoreCase("hello world"));
        System.out.println("compareTo('Hello'): " + s.compareTo("Hello"));

        // Joining (Java 8+)
        String joined = String.join("-", "2025", "01", "15");
        System.out.println("join('-', ...): " + joined);

        // Repeat (Java 11+)
        System.out.println("'ab'.repeat(3): " + "ab".repeat(3));

        //⭐ toCharArray()
        String str = "Hello";
        char[] chars = str.toCharArray();
        System.out.println(Arrays.toString(chars));

        //⭐ back to string from char array
        String string = new String(chars);
        // OR: String fromCharArray = String.valueOf(chars);
        System.out.println(string);
    }

    // Random Class
    public static void randomClass() {
        System.out.println("\n=== RANDOM CLASS ===\n");

        Random rand = new Random();

        // Random int
        System.out.println("nextInt(): " + rand.nextInt());

        // Random int in range [0, bound)
        System.out.println("nextInt(10): " + rand.nextInt(10));

        // Random int in range [min, max]
        int min = 5, max = 15;
        int randomInRange = rand.nextInt(max - min + 1) + min;
        System.out.println("Random [5, 15]: " + randomInRange);

        // Random double [0.0, 1.0)
        System.out.println("nextDouble(): " + rand.nextDouble());

        // Random boolean
        System.out.println("nextBoolean(): " + rand.nextBoolean());

        // Random long
        System.out.println("nextLong(): " + rand.nextLong());
    }
}
