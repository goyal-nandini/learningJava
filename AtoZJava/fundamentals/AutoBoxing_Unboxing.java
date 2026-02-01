package fundamentals;

import java.util.ArrayList;
import java.util.List;

public class AutoBoxing_Unboxing {
    public static void main(String[] args) {
        autoboxingDemo();
    }
    public static void autoboxingDemo() {
        System.out.println("\n=== AUTOBOXING & UNBOXING ===\n");

        //⭐ Autoboxing: int → Integer (automatic conversion)
        // primitive -> object
        Integer num1 = 5;  // Java automatically converts int to Integer

        // This is what Java does behind the scenes:
        Integer num2 = Integer.valueOf(5);

        System.out.println("num1: " + num1);
        System.out.println("num2: " + num2);

        //⭐ Unboxing: Integer → int (automatic conversion)
        // object to primitive
        int primitive = num1;  // Java automatically converts Integer to int

        // This is what Java does behind the scenes:
        int primitive2 = num1.intValue();

        System.out.println("primitive: " + primitive);

        // In Collections:
        List<Integer> list = new ArrayList<>();
        list.add(10);     // Autoboxing: 10 (int) → Integer object
        list.add(20);

        int value = list.get(0);  // Unboxing: Integer → int
        System.out.println("value from list: " + value);

        // IMPORTANT: Comparison trap!
        Integer a = 128;
        Integer b = 128;
        System.out.println("\na == b: " + (a == b));  // false! (different objects)
        System.out.println("a.equals(b): " + a.equals(b));  // true! (same value)

        // But this works:
        Integer c = 5;
        Integer d = 5;
        System.out.println("c == d: " + (c == d));  // true! (cached values -128 to 127)
    }
}
