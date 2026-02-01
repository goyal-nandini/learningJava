package fundamentals;

public class aEqualb_IntegerCaching {
    public static void main(String[] args) {
        integerCachingExplained();
    }
    public static void integerCachingExplained() {
        System.out.println("\n=== INTEGER CACHING EXPLAINED ===\n");

        // ==========================================
        // THE CACHING RULE:
        // Java caches Integer objects from -128 to 127
        // ==========================================

        // In cached range [-128, 127]:
        Integer a = 100;
        Integer b = 100;
        System.out.println("a: " + a);
        System.out.println("b: " + b);
        System.out.println("a == b: " + (a == b));  // true - SAME object!
        System.out.println("System.identityHashCode(a): " + System.identityHashCode(a));
        System.out.println("System.identityHashCode(b): " + System.identityHashCode(b));
        System.out.println("^ Same hash = same object in memory!\n");

        // Outside cached range:
        Integer c = 200;
        Integer d = 200;
        System.out.println("c: " + c);
        System.out.println("d: " + d);
        System.out.println("c == d: " + (c == d));  // false - DIFFERENT objects!
        System.out.println("System.identityHashCode(c): " + System.identityHashCode(c));
        System.out.println("System.identityHashCode(d): " + System.identityHashCode(d));
        System.out.println("^ Different hash = different objects in memory!\n");

        // ==========================================
        // WHY?
        // ==========================================
        // When you do: Integer a = 100;
        // Java checks: "Is 100 in cache (-128 to 127)?"
        // YES → Returns existing cached object
        // NO → Creates NEW object

        // ==========================================
        // THE SOLUTION: ALWAYS use .equals()
        // ==========================================
        System.out.println("c.equals(d): " + c.equals(d));  // true - compares VALUES!

        System.out.println("\n🎯 RULE: For wrapper classes, ALWAYS use .equals(), NEVER use ==");
    }
}
