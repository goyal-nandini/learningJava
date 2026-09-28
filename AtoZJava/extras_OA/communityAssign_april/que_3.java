package extras_OA.communityAssign_april;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    int maxi = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        diameter(root);
        return maxi;
    }
    private int diameter(TreeNode node){
        if(node == null){
            return 0;
        }
        int lh = height(node.left);
        int rh = height(node.right);
        maxi = Math.max(maxi, lh + rh);
        return 1 + Math.max(lh, rh);
    }
    private int height(TreeNode node){
        if(node == null){
            return 0;
        }
        int l = height(node.left);
        int r = height(node.right);
        return 1 + Math.max(l, r);
    }
}

public class que_3 {
    public static void main(String[] args) {
        // Build a sample binary tree:
        //        1
        //       / \
        //      2   3
        //     / \
        //    4   5
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        Solution sol = new Solution();
        int diameter = sol.diameterOfBinaryTree(root);
        System.out.println("Diameter of the tree = " + diameter);
    }
}

