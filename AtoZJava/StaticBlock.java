class sample{
    static int num;
    static {
        System.out.println("Static block is running");
        // tip to rem
        // Variables inside static blocks are temporary (local) unless declared outside
        // (at class level) with static.
        int n;

        num = 10;
    }
}
// Static block runs before "using" the class, not before "starting" the program.
public class StaticBlock {
    public static void main(String[] args) {
        System.out.println("Main function is running...");
        sample.num = 100;
        System.out.println(sample.num);
//        sample.n;  here, error!!
    }
}




