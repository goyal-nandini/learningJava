package Trees;

import java.util.ArrayList;

// # INCOMPLETE

public class LCA_1 {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.left.right.left = new Node(8);
        root.left.right.right = new Node(9);

        Node p = root.left.right; // Node with value 5
        Node q = root.left.right.right; // Node with value 9


        // lca brute: idea: get the path of both nodes and through one pass, get the last matched node
        // tc: O(3n) for finding paths using dfs and path traversal
        // sc: O(4n) recursion stack space + two path arrays

        ArrayList<Node> pPath = new ArrayList<>();
        ArrayList<Node> qPath = new ArrayList<>();

        nodePath(root, p, pPath);
        nodePath(root, q, qPath);
         int pathSize = (pPath.size() < qPath.size()) ? pPath.size() : qPath.size();
//        int pathSize = 0;
//        if(pPath.size() < qPath.size()) pathSize=pPath.size();
//        else pathSize = qPath.size();

        Node lca_brute = null;
         for(int i=0; i<pathSize; i++){
             if(pPath.get(i) == qPath.get(i)) lca_brute = pPath.get(i);
             else break;
         }
        System.out.println(lca_brute.data);

        // lca optimal: get the lca in one pass by dfs traversal -> tc: O(n) for dfs traversal
        // sc:O(n) recursion stack space only
        Node lca = dfs(root, p, q);
        System.out.println("LCA: " + lca.data);

    }
    public static boolean nodePath(Node node, Node x, ArrayList<Node> path){
        // dfs and backtracking
        if(node == null) return false;

        path.add(node);
        if(node == x) return true;
        if(nodePath(node.left, x, path) || nodePath(node.right, x, path)) return true;
        path.remove(path.size()-1);
        return false;
    }

    public static Node dfs(Node node, Node x, Node y){
        if(node == null) return null;

        if(node == x) return x;
        else if(node == y) return y;

        Node left = dfs(node.left, x, y);
        Node right = dfs(node.right, x, y);

        if(left != null && right != null) return node;
        return (left != null) ? left : right;
    }
}
