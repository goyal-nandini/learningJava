package Trees.SegmentTree;
// we did Range Add, Range Min

public class LazyPropagation_ST {
    private int[] tree;
    private int[] lazy;
    private int n;

    public LazyPropagation_ST(int[] arr){
        n = arr.length;
        tree = new int[4*n];
        lazy = new int[4*n];
//        Arrays.fill(lazy, 0);
// initialize lazy with 0, no need in JAVA
        buildTree(arr, 0, 0, n-1);
    }

    private void buildTree(int[] arr, int idx, int start, int end){
        if(start == end) {
            tree[idx] = arr[start];
        } else {
            int mid = (start + end) / 2;

            buildTree(arr, 2 * idx + 1, start, mid);
            buildTree(arr, 2 * idx + 2, mid + 1, end);

            tree[idx] = Math.min(tree[2 * idx + 1], tree[2 * idx + 2]);
        }
    }

    // increment by a value in range [l, r]
    public void update(int l, int r, int val){
        update(0, 0, n-1, l, r, val);
    }

    private void update(int idx, int start, int end, int qsi, int qei, int val){
        // apply any pending lazy to this node idx first
        if(lazy[idx]!=0){
            tree[idx] += lazy[idx]; // this make node up-to-date
            if(start != end) { // not a leaf
                // propagate the pendings to child nodes
                lazy[2 * idx + 1] += lazy[idx];
                lazy[2 * idx + 2] += lazy[idx];
            }
            lazy[idx] = 0; // as the node idx gets updated, so mark the same in lazy array as well
            // rem for a node to check for its up-to-date or not?! go and check for same index in the lazy array
            // if it is 0, means the node is up-to-date!!
        }

        // completely outside
        if(qei<start || end<qsi) return;

        // completely inside, start and end are inside of qsi and qei
        // complete overlap -> will do the needed update,
        // and left the pending task on its child
        if(qsi <= start && qei >= end){
            tree[idx] += val; // here, we performed the needed tasks,
            // and lazily leaving the pending task to its children in lazy array.
            if(start != end){
                lazy[2*idx+1] += val;
                lazy[2*idx+2] += val;
            }
            return; // as we have done the req updation
        }

        // partial overlap - recurse
        int mid = (start+end)/2;
        update(2*idx+1, start, mid, qsi, qei, val);
        update(2*idx+2, mid+1, end, qsi, qei, val);

        tree[idx] = Math.min(tree[2 * idx + 1], tree[2 * idx + 2]);
    }

    // min in the range [l, r]
    public int query(int l, int r){
        return query(0, 0, n-1, l, r);
    }

    private int query(int idx, int start, int end, int qsi, int qei){
//        apply any pending lazy to this node idx first
        if(lazy[idx]!=0){
            tree[idx] += lazy[idx];

            if(start != end){
                lazy[2*idx+1] += lazy[idx];
                lazy[2*idx+2] += lazy[idx];
            }
            lazy[idx] = 0;
        }

        // no overlap
        if(qei < start || end < qsi){
            return Integer.MAX_VALUE;
        }

        // total overlap, return the val
        if(qsi <= start && end <= qei){
            return tree[idx];
        }

        // partial overlap - recurse
        int mid = (start+end)/2;
        int leftMin = query(2*idx+1, start, mid, qsi, qei);
        int rightMin = query(2*idx+2, mid+1, end, qsi, qei);

        return Math.min(leftMin, rightMin);
    }
    public static void main(String[] args) {
        int[] arr = {3, 1, 4, 1, 5, 9, 2, 6};
        LazyPropagation_ST st = new LazyPropagation_ST(arr);

        System.out.println(st.query(0, 7));  // → 1
        st.update(0, 3, 2);                  // add 2 to index 0..3
        System.out.println(st.query(0, 3));  // → 3
        System.out.println(st.query(0, 7));  // → 2
    }
}
