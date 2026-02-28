package BT.SegmentTree;

public class Main {
    public static void main(String[] args) {
        int[] arr = {3, 8, 6, 7, -2, -8, 4, 9};
        SegmentTree_01 tree = new SegmentTree_01(arr);
        tree.display();

        System.out.println("\n --- Query for [2, 6] --- \n");
        int sum = tree.query(2, 6);
        System.out.println(sum);

        System.out.println("\n --- After update (3, 14) --- \n");
        tree.update(3, 14);
        tree.display();

        // Array-based
        SegmentTree_02 tree2 = new SegmentTree_02(arr);
        tree2.display();
        System.out.println("Sum [2, 6]: " + tree2.query(2, 6));

        tree2.update(3, 14);
        System.out.println("Sum[1, 3] after update: " + tree2.query(1, 3));
        tree2.display();
    }
}
