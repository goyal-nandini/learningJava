package Trees.DPonTrees;

// TODO:

// subtree aggregation
// check HWI_24_H3

// sack technique it is called :)
/*At each node:
👉 remove small
👉 keep heavy
👉 merge small → heavy
👉 add node
👉 answer
👉 delete if needed*/

import java.util.ArrayList;

public class DSUonTrees {
    int N = 100005; // 10^5 nodes

    // given parents and color values for each node, building adj list out of parent
    // we have n-ary tree so we gonna have adjacency list
    ArrayList<Integer>[] adj = new ArrayList[N];
    int[] color = new int[N]; // color for each node

    int[] size = new int[N]; // size of subtree of each node [rem we did in dp on tree]
    int[] ans = new int[N]; // main goal: finding the count of distinct color value for each node in its subtree

    int[] freq = new int[N]; // freq if each color
    int distinct = 0; // no of distinct color in curr subtree

    // first task we know, getting the subtree size, recursive manner
    void dfsSize(int node, int parent){
        size[node]=1;
        for(int child: adj[node]){
            if(child != parent){
                dfsSize(child, node);
                size[node] += size[child]; // adding child subtree size into the main node [getting ans from sub-problems] :)
            }
        }
    }

    // real battle starts:

    // adding a node, getting its info and updating freq and distinct variables acc to its color value
    void add(int node){
        int c = color[node]; // get the color of the node, and act accordingly
        if(freq[c] == 0) distinct++;
        freq[c]++;
    }

    void remove(int node){
        int c = color[node];
        freq[c]--;
        if(freq[c] == 0) distinct--; // color gone, remove it completely
    }

    // used for merging the small to heavy
    void addSubtree(int node, int parent){

    }

    void dfs(int node, int parent, boolean keep){
        int maxSize = -1;
        int heavy = -1;

        // find the heavy child/largest subtree
        for(int child: adj[node]){
            if(child!=parent){
                if(size[child]>maxSize){
                    maxSize = size[child];
                    heavy = child;
                }
            }
        }

        // now time for small child
        for(int child: adj[node]){
            if(child!=parent){
                if(child!=heavy){
                    dfs(child, node, false); // false means we don't have to keep this child
                }
            }
        }

        if(heavy!=-1){
            dfs(heavy, node, true);
        }





    }


}

