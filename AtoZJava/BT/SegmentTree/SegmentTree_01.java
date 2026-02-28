package BT.SegmentTree;
// Node-based Segment Tree
/**
 * Segment Tree Implementation
 * Public methods: Simple interface for users (tree.query(), tree.update())
 * Private methods: Internal recursive helpers that do the actual work
 * This pattern:
 * - Hides implementation details (user doesn't see Node or root)
 * - Prevents errors (user can't pass wrong parameters)
 */

public class SegmentTree_01 {
    private static class Node{
        int data;
        int start; // start of interval
        int end; // end of interval
        Node left;
        Node right;

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    private Node root;
    public SegmentTree_01(int[] arr){
        // create a tree using this array
        this.root = constructTree(arr, 0, arr.length-1);
    }
    // these all are the methods of class SegmentTree_01
    private Node constructTree(int[] arr, int start, int end){
        // recursion

        // base case
        if(start == end){
            Node leaf = new Node(start, end);
            leaf.data = arr[start]; // value
            return leaf;
        }

        // new node
        Node node = new Node(start, end);

        int mid = (start+end)/2;

        node.left = constructTree(arr, start, mid);
        node.right = constructTree(arr, mid+1, end);

        node.data = node.left.data + node.right.data; // sum as query over intervals
        return node;
    }

    public void display(){
        display(this.root);
    }

    private void display(Node node){
        if(node == null) return;

        String str = "";

        // left child
        if(node.left != null){
            str += "Interval = [" + node.left.start + "-" + node.left.end + "] Sum = " + node.left.data + " => ";
        } else {
            str += "No left child => ";
        }

        // current node
        str += "Interval = [" + node.start + "-" + node.end + "] Sum = " + node.data;

        // right child
        if(node.right != null){
            str += " <= Interval = [" + node.right.start + "-" + node.right.end + "] Sum = " + node.right.data;
        } else {
            str += " <= No right child";
        }

        System.out.println(str);

        // recursive calls
        display(node.left);
        display(node.right);
    }

    public int query(int qsi, int qei){
        return this.query(this.root, qsi, qei);
    }

    private int query(Node node, int qsi, int qei){
        // we have to find sum of interval [2, 6]
        // Returns the sum of all elements from query start index to query end index
        // 3 cases:
        // case 1. node interval completely inside the query interval
        if(node.start >= qsi && node.end <= qei){
            return node.data;
        }
        // case 2. completely outside
        else if(node.end < qsi || node.start > qei){
            return 0;
        }
        // case 3. overlapping
        else {
            // go left
            int l = query(node.left, qsi, qei);
            // go right
            int r = query(node.right, qsi, qei);
            return r+l;
        }
    }
    public void update(int idx, int val){
        this.root.data = update2(this.root, idx, val);
        // we're assigning because when a val get changed then the root will definitely modified!!
    }

    // this has O(n) tc!!
    private int update(Node node, int idx, int val){
        // have to update the val at idx, so have to reach idx and get it
        // updated, in this series we tend to update all its corresponding queries as well,
        // which has this idx in their intervals

        // say, idx = 3 in interval [0, 7]
        if(idx >= node.start && idx <= node.end){
            if(idx == node.start && idx == node.end){
                node.data = val;
                return node.data;
            } else {
                int l = update(node.left, idx, val);
                int r = update(node.right, idx, val);

                node.data = l+r;
                return node.data;
            }
        }
        return node.data;
    }

    // prefer this!! for O(logn)
    private int update2(Node node, int index, int value){
        // Base case: reached the leaf node
        if(node.start == node.end){
            node.data = value;
            return node.data;
        }

        // Find mid point
        int mid = (node.start + node.end) / 2;

        // If index is in left subtree
        if(index <= mid){
            node.data = update(node.left, index, value) + node.right.data;
        }
        // If index is in right subtree
        else {
            node.data = node.left.data + update(node.right, index, value);
        }
        return node.data;
    }
}
