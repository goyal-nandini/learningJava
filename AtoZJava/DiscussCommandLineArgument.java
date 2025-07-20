public class DiscussCommandLineArgument {
    public static void main(String[] args) {
        System.out.println(args[0]);
        // args is an array of Strings
        for (int i = 0; i < args.length; i++) {
            System.out.println("Argument " + i + ": " + args[i]);
        }

        // All arguments come in as strings, even if you pass numbers.
        //If you want to use them as integers, you must parse them:

        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        System.out.println("Sum: " + (a + b));
    }
}
