package BT;
import java.util.*;

class Node {
    int data;
    Node left, right;
    Node(int val) {
        data = val;
        left = right = null;
    }
}

public class BoundaryTraversal {

    // Placeholder for boundary traversal logic
    static ArrayList<Integer> boundaryTraversal(Node root) {
        // TODO: implement boundary traversal logic here
        ArrayList<Integer> ans = new ArrayList<>();
        // 1. Add root (if not leaf)
        if (!(root.left == null && root.right == null)) {
            ans.add(root.data);

        }
        // 2. left boundary
        leftBoundary(root.left, ans);

        // 3. leaf traversal
        leafNodes(root, ans);

        // 4. right boundary reversed
        Stack<Integer> st = new Stack<>();
        rightBoundary(root.right, st);
        while(!st.isEmpty())
            ans.add(st.pop());

        return ans;

    }

    public static void leftBoundary(Node node, ArrayList<Integer> ans){
        if(node == null) return;

        if(node.left != null){
            ans.add(node.data);
            node = node.left;
            leftBoundary(node, ans);
        } else if(node.right != null) {
            ans.add(node.data);
            node = node.right;
            leftBoundary(node, ans);
        } else {
            return;
        }
    }

//    Preorder, Inorder, Postorder all work for leaf collection.
//    For boundary traversal, inorder is often the most intuitive because it
//    naturally gives leaves in left-to-right order, which matches the boundary
//    path.
    public static void leafNodes(Node node, ArrayList<Integer> ans){
        // have to traverse the BT (doing preorder) and add only leaf node to ans
        if(node == null) return;

        if(node.left == null && node.right == null){
            ans.add(node.data);
            return;
        }
        leafNodes(node.left, ans);
        leafNodes(node.right, ans);

    }
    public static void rightBoundary(Node node, Stack<Integer> st){
        if(node == null) return;

        if(node.right != null){
            st.push(node.data);
            node = node.right;
            rightBoundary(node, st);
        } else if(node.left != null) {
            st.push(node.data);
            node = node.left;
            rightBoundary(node, st);
        } else {
            return;
        }

    }
    public static void main(String[] args) {
        // Example tree construction
//        Node root = new Node(20);
//        root.left = new Node(8);
//        root.right = new Node(22);
//        root.left.left = new Node(4);
//        root.left.right = new Node(12);
//        root.left.right.left = new Node(10);
//        root.left.right.right = new Node(14);
//        root.right.left = new Node(21);
//        root.right.right = new Node(25);


        // Build the tree from input [1,2,3,4,5,6,7,N,N,8,9,N,N,N,N]
         Node root = new Node(1);
         root.left = new Node(2);
         root.right = new Node(3);
         root.left.left = new Node(4);
         root.left.right = new Node(5);
         root.right.left = new Node(6);
         root.right.right = new Node(7);
         root.left.right.left = new Node(8);
         root.left.right.right = new Node(9);

        // Call boundary traversal
        ArrayList<Integer> result = boundaryTraversal(root);

//         Print result
        System.out.print("Boundary Traversal: ");
        for (int val : result) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}

