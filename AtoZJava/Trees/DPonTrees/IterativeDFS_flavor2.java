package Trees.DPonTrees;
// 📌📌 very very imp :)
/*template:
Deque<Integer> stack = new ArrayDeque<>();
boolean[] processed = new boolean[n + 1];

stack.push(root);

while (!stack.isEmpty()) {
    int node = stack.peek();  // PEEK not pop

    if (!processed[node]) {
        processed[node] = true;
        // push children (exclude parent)
    } else {
        stack.pop();
        // POST ORDER WORK HERE
    }
}*/
// TASK: say we have a adj list given/we can build it for a tree,
// we have process the subtree sizes for each node

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class IterativeDFS_flavor2 {
    public static void main(String[] args) {
        int n = 7; // no of nodes
        // for each node we have given its parent 1-based, starting from node 2, node 1 is the root
// child nodes     2, 3, 4, 5, 6, 7
        int[] a = {1, 2, 2, 4, 4, 1}; // parent of each node

        // building adj list:
        // tip: avoid using arrayList at every occasion, its slow, use arrays, For graph problems on Codeforces
        // where n can be up to 2*10^5, the difference can matter under tight time limits. Always prefer
        // ArrayList<Integer>[] when n is known upfront.
        // Rule of Thumb
        // n is known → use ArrayList<Integer>[]
        // n is unknown / grows dynamically → use ArrayList<ArrayList<Integer>>
        ArrayList<Integer>[] adj = new ArrayList[n+1];
        for(int i=0; i<=n; i++){
            adj[i] = new ArrayList<>();
        }
        for(int i=0; i<n-1; i++){
            adj[a[i]].add(i+2); // parent nodes -> child nodes [directed, we build,
            // else if undirected need to use parent array to skip parent edge]
        }
        // note: Your adj is built directed (parent → child only). A child has no way to reach its parent through
        // adj. So processed[] alone is enough to avoid revisiting — visited[] is doing nothing extra.

        int [] subtreeSizes = dfs(n, a, adj);
        System.out.print("subtree sizes of each node: \n");
        for(int i=1; i<=n; i++){
            System.out.print(subtreeSizes[i]+" ");
        }
    }

    private static int[] dfs(int n, int[] a, ArrayList<Integer>[] adj){
        // tip: Stack class itself Never use java.util.Stack in CP. It's legacy and slow.
        // Always use ArrayDeque as your stack.

        Deque<Integer> st = new ArrayDeque<>();
        int[] processed = new int[n+1]; // 1-based indexing hai too +1 lena padega :)
        int[] visited = new int[n+1]; // NO NEED here, as we have directed adj list
        int[] subtreeSizes = new int[n+1];

        st.push(1); // root node
        visited[1] = 1;
        while(!st.isEmpty()){
            int node = st.peek();
            if(processed[node]!=1){
                // if node is not processed yet, then process it by pushing its children
                processed[node] = 1; // means its children are been pushed
                for(int child: adj[node]){
                    if(visited[child]!=1){
                        st.push(child);
                        visited[child]=1;
                    }
                }
            } else {
                // here the node's children are done, time for node to get its work done [have its subtree size]
                st.pop();
                subtreeSizes[node] = 1;
                for(int child: adj[node]){
                    subtreeSizes[node] += subtreeSizes[child];
                }
                // honestly line 84 to 87 same as we did in recursive call, <- an imp lesson for further problems :)
            }
        }
        return subtreeSizes;

    }
}
