package Trees.DisjointSet;
/*
What is "Rank"?
Rank is an upper bound on the height of the tree. Think of it as the "potential height" or "depth" of the tree.

    Initially, every element has rank 0 (it's just a single node)
    When we merge two trees, we look at their ranks
    We attach the tree with smaller rank under the tree with larger rank

    Important: Rank only increases when two trees of equal rank are merged

Why Rank and Not Actual Height?
Because of path compression, the actual height of trees changes, but we don't update rank. Rank is just an estimate
that helps us make good decisions without the overhead of tracking actual height.

Key Takeaways for Union by Rank
    Rank represents tree height estimate - not the actual height
    Rank only increases when merging equal-rank trees
    Always attach smaller rank under larger rank
    If ranks are equal, pick one and increment its rank
    Path compression doesn't affect rank (we don't update it)
*/

// Union By Rank
//Concept: "Rank" is roughly the height of the tree. Attach the shorter tree under the taller tree.
//Why? Keeping trees shallow makes find operations faster!

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DisjointSet_02 {
    int[] parent;
    int[] rank; // rank[i] = approximate height of tree rooted at i

    public DisjointSet_02(int n){
        parent = new int[n+1];
        rank = new int[n+1];

        for(int i=0; i<n; i++){
            parent[i]=i;
            rank[i]=0;
        }
    }

    // find ultimate parent
    public int findUParent(int x){
        // path compression
        if(parent[x]==x){
            return x;
        }
        return parent[x] = findUParent(parent[x]);
    }

    public void unionByRank(int u, int v){
        int ulp_u = findUParent(u);
        int ulp_v = findUParent(v);

        if(ulp_v == ulp_u) return; // already in group

        // attach smaller to larger
        if(rank[ulp_u] < rank[ulp_v]){
            parent[ulp_u] = ulp_v; // smaller under larger
//            rank[ulp_v] += rank[ulp_u];
        } else if(rank[ulp_v] < rank[ulp_u]){
            parent[ulp_v] = ulp_u;
//            rank[ulp_u] += rank[ulp_v];
        } else {
            // equal ranks, choose anyone and increase its rank
            parent[ulp_u] = ulp_v;
            rank[ulp_v]++;
        }
    }
    /*
    **Why 3 cases?**
- When ranks are **EQUAL**, we need to **increment the rank** of the new root
- This is because merging two trees of equal height increases the height by 1*/

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
