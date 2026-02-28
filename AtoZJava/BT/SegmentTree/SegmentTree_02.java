package BT.SegmentTree;

// Array-Based Segment Tree
public class SegmentTree_02 {
    private int[] tree;
    private int n;

    public SegmentTree_02(int[] arr){
        n = arr.length;
        tree = new int[4 * n];
        buildTree(arr, 0, 0, n-1); // arr, idx, start, end
    }

    private void buildTree(int[] arr, int idx, int start, int end){
        if(start == end){
            tree[idx] = arr[start];
        } else {
            int mid = (start+end)/2;
            // left
            buildTree(arr, 2*idx+1, start, mid);
            // right
            buildTree(arr, 2*idx+2, mid+1, end);
            // merge
            tree[idx] = tree[2*idx+1]+tree[2*idx+2];
        }
    }
    public int query(int l, int r){
        return query(0, 0, n-1, l, r);
    }

    private int query(int idx, int start, int end, int l, int r){
        // 3 cases

        // completely inside
        if(start >= l && end <= r){
            return tree[idx];
        }
        // completely outside
        else if(end < l || start > r) {
            return 0;
        }
        // overlapping
        else {
            int mid = (start+end)/2;

            int leftSum = query(2*idx+1, start, mid, l, r);
            int rightSum = query(2*idx+2, mid+1, end, l, r);

            return leftSum + rightSum;
        }
    }

    public void update(int index, int val){
        update(0, 0, n-1, index, val);
    }

    private void update(int idx, int start, int end, int i, int val){
        if(start == end){
            tree[i] = val;
            return;
        }

        int mid = (start+end)/2;

        if(idx <= mid){
            update(2*idx+1, start, mid, i, val);
        } else {
            update(2*idx+1, mid+1, end, i, val);
        }

        tree[idx] = tree[2*idx+1] + tree[2*idx+2];
    }

    public void display2() {
        System.out.println("Segment Tree Array:");
        for (int i = 0; i < tree.length; i++) {
            if (tree[i] != 0) {
                System.out.println("Index " + i + " -> " + tree[i]);
            }
        }
    }

    private void display(int node, int start, int end) {
        if (start == end) {
            System.out.println("[" + start + "] = " + tree[node]);
            return;
        }

        int mid = (start + end) / 2;

        System.out.println("[" + start + "-" + end + "] = " + tree[node]);

        display(2*node+1, start, mid);
        display(2*node+2, mid+1, end);
    }

    public void display() {
        display(0, 0, n-1);
    }
}
