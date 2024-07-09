public class splitMethod {
    public static void main(String[] args) {

                String str = "a,b,c";
                String[] parts = str.split(",", 3); // Split into at most 4 parts
                for (String part : parts) {
                    System.out.println("[" + part + "]");
                }
                // Output:
                // [a]
                // [b]
                // [c]
                // []
    }
}
