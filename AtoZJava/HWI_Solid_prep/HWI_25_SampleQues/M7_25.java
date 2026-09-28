package HWI_Solid_prep.HWI_25_SampleQues;

// interesting to know we've done here smaller to larger merging and DSU!!

// and if we do same in tree means DSU on tree then this is called sack technique :)
// "DSU on tree" (Disjoint Set Union on tree), also known as "sack" (from the Persian word Guni meaning "sack"), is an
// algorithm optimization technique used to efficiently answer queries about properties of subtrees in a rooted tree
// structure. It is primarily a technique for trees, not general graphs.
// check HWI_24_H3

import java.util.HashSet;
import java.util.Scanner;

public class M7_25 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int t = sc.nextInt();
        DisjointSet_01 dsu = new DisjointSet_01(n);
        int ans = 0;
        for(int k=0; k<q; k++){
            int type = sc.nextInt();
            if(type == 1){
                int i = sc.nextInt();
                int j = sc.nextInt();
                dsu.unionBySize(i, j);
            } else if(type == 2){
                int u = sc.nextInt();
                // size[x]-consec[x]
                // parent same -> add edge, not same add edge componenet -= 1 size[u] += size[v]
                int root = dsu.findUParent(u);
//                int beauty = dsu.size[root] - dsu.consectivePairs[root]; //**
                int beauty = dsu.beauty[root];
                ans += beauty;
            }
        }
        System.out.println(ans);
    }
/*
** ❓ “how do I calculate consecutive pairs?”
👉 Answer:
🚫 Don’t calculate it directly
✅ Instead simulate interval merging via neighbors
*
* instead of counting the consecutive pairs,
* think how many segments are formed!! -> that's what beauty is.
* Beauty = number of groups of consecutive numbers
*
* 👉 DSU only tells you:
which nodes are connected
👉 BUT beauty depends on:
values inside that component
So DSU alone is NOT enough.
*
* for each component we need to know what nodes are inside it?
* that's why we store/use a set -> set[root] = all values in this component
*
* while adding x, check if x-1 or x+1 exists? -> 3 situations:
* 1. No neighbors
add 10 to {5,6,8}
→ new segment
→ beauty++

2. One neighbor
add 7 to {5,6,8}
→ connects to 6, join exists, no change
→ no new segment
→ beauty unchanged

3. Both neighbors
add 7 to {5,6,8}
(assuming 6 and 8 both exist)
→ merges two segments
→ beauty--
*
*
* union ??!! yes: lets come over this:
* we have comp A say {2, 3} now again query 1 comes of comp B say {1, 2}
* so comp A and comp B we simulate: take all values of B insert into A,
* update beauty while inserting!, updation takes place in union function
* */
}
class DisjointSet_01 {
    int[] parent;
    int[] size; // size[i] = number of elements in the tree rooted at i
    HashSet<Integer>[] set; // for each node, need to know what nodes are inside component made from this node
    int[] beauty; // we'll be tracking beauty of each node //??

    public DisjointSet_01(int n) {
        parent = new int[n + 1];
        size = new int[n + 1];
        set = new HashSet[n+1];
        beauty = new int[n+1];

        // to initialize the arrays
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
            size[i] = 1; // each node has size 1 initially of their own
            set[i] = new HashSet<>(); // for storing the components
            set[i].add(i); // each node is its own component
            beauty[i] = 1; // node itself cover a range
            /*❌ First misconception
            👉 We do NOT store beauty per node
            👉 We store beauty per connected component


            🔑 Golden Rule
            Every node belongs to exactly ONE component
            Each component has ONE beauty value

            for each node that query 2 asks for beauty, we go to its root and asks for beauty,
            because overall we are asked is its connected component min covered range!, right!*/
        }
    }

    // find ultimate parent
    public int findUParent(int x) {
        // path compression: While finding the root, make everyone point directly to it.
        // This flattens the tree!

        if (parent[x] == x) {
            return x;
        }
        return parent[x] = findUParent(parent[x]);
    }

    // merge two groups and update the beauty
    public void unionBySize(int u, int v) {
        int ulp_u = findUParent(u);
        int ulp_v = findUParent(v);

        if (ulp_v == ulp_u) return; // already in same group

        // attach smaller to larger: merging sets
        // why: to avoid rebuilding entire set every time
        if(set[ulp_u].size() < set[ulp_v].size()){
            // swap because to ensure small set smaller set merged to big set
            int temp = ulp_u;
            ulp_u = ulp_v;
            ulp_v = temp;
        }

        // hey this loop is doing two things merging values to set and updating the beauty of the component forming after
        // merging, don't think of updating the parent in the loop, see after this loop yr ulp gets its parent and size
        // updated so other nodes of that ulp will automatically gets same parent by path compression.
        // try with dry run find(7) and find(1) on this good ex where every case is covered **

        // merging sets
        for(int x: set[ulp_v]){
            // here big set k checking x-1 or x+1, checking neighbors because big set is
            // the current built component
            boolean left = set[ulp_u].contains(x-1);
            boolean right = set[ulp_u].contains(x+1);

            // situation1: no neighbor
            if(!left && !right) beauty[ulp_u]++;
            // situation2: no change one neighbor
            // situation3: both neighbor
            else if(left && right) beauty[ulp_u]--;

            set[ulp_u].add(x);
        }

        // dsu updates in nodes
        parent[ulp_v] = ulp_u;
        size[ulp_u] += size[ulp_v];

        // no need this now: remember: When using custom merging (set size),
        //DO NOT re-decide parent using DSU size

//        // attach smaller to larger
//        if (size[ulp_u] < size[ulp_v]) {
//            parent[ulp_u] = ulp_v;
//            size[ulp_v] += size[ulp_u]; // increase size
//        } else { // handles >=
//            parent[ulp_v] = ulp_u;
//            size[ulp_u] += size[ulp_v];
//        }

        // after merging this set of ulp_v is useless
        set[ulp_v].clear(); // optional
    }
}
/*
** dry run example covering everything:
n = 7

Queries:
1, 2, 3
1, 5, 6
1, 3, 5
1, 1, 7
1, 1, 2

*
for query 2, find yr self see how you will get the min no of covered ranges from the root of the node [part of the compo
- nent]
i get final arrays as:
* index:  1 2 3 4 5 6 7
* parent: 2 2 2 4 2 2 2 ulp
* size:   1 6 1 1 2 1 1
* beauty: 2 2 1 1 2 1 1
* sets: 2 = {2, 3, 5, 6, 1, 7}
*       4 = {4}
* overall matters is for ulp which here i can see are 2 and 4
*
*
* 🧠 FINAL MENTAL CHECKLIST (LOCK THIS)

Whenever union happens:

1. Find roots
2. Make big set
3. Insert small → big
4. Update beauty using neighbors
5. Update parent ONCE
6. Done
*/