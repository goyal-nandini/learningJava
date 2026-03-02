package Trees.DisjointSet;
/*Disjoint set is used to know if nodes are connected or not, and
to merge/union two nodes.

The main operations are:
    Find: Are these connected?
    Union: Merge these groups.
*/

// Union by Size
//Concept: Always attach the smaller group under the larger group
//Why? If you have a group of 100 people and a group of 2 people, it's better to add those 2 people to the big group
// than to add 100 people under the small group!

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DisjointSet_01 {
    int[] parent;
    int[] size; // size[i] = number of elements in the tree rooted at i

    public DisjointSet_01(int n){
        parent = new int[n+1];
        size = new int[n+1];

        // to initialize the arrays
        for(int i=0; i<n; i++){ // this loop will assign the initial config for the disjoint set,
            // means to set all nodes size as 1 and parent as itself only. then later on calling union methods,
            // the operations takes place. so don't feel heavy with the implementaion!!!
            parent[i]=i;
            size[i]=1; // each node has size 1 initially of their own
        }
    }

    // find ultimate parent
    public int findUParent(int x){
        // path compression: While finding the root, make everyone point directly to it.
        // This flattens the tree!

        if(parent[x]==x){
            return x;
        }
        return parent[x] = findUParent(parent[x]);
    }

    // merge two groups
    public void unionBySize(int u, int v){
        int ulp_u = findUParent(u);
        int ulp_v = findUParent(v);

        if(ulp_v == ulp_u) return; // already in same group

        // attach smaller to larger
        if(size[ulp_u] < size[ulp_v]){
            parent[ulp_u] = ulp_v;
            size[ulp_v] += size[ulp_u]; // increase size
        } else { // handles >=
            parent[ulp_v] = ulp_u;
            size[ulp_u] += size[ulp_v];
        }
    }
    /***Why 2 cases?**
     - When sizes are **EQUAL**, we DON'T need special handling
     - We just pick one root (doesn't matter which) and add the sizes
     - No need to distinguish between `>` and `==`

     Size is just a count, so we always add regardless of equal or not!*/

    public boolean isConnected(int u, int v){
        return findUParent(u) == findUParent(v);
    }

    public void printGroups() {
        Map<Integer, List<Integer>> groups = new HashMap<>();

        for (int i = 0; i < parent.length; i++) {
            int root = findUParent(i);
            groups.putIfAbsent(root, new ArrayList<>());
            groups.get(root).add(i);
        }

        System.out.println("\nGroups:");
        int groupNum = 1;
        for (Map.Entry<Integer, List<Integer>> entry : groups.entrySet()) {
            System.out.println("Group " + groupNum + " (root=" + entry.getKey() + "): " + entry.getValue());
            groupNum++;
        }

        System.out.println("-------------------");
    }

}
