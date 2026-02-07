package graphs;
/* Adj List, it use!!
      0
     / \
    1   4
   / \
  2   3

*/
import java.util.*;
public class Bfs {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            adj.add(new ArrayList < > ());
        }
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(0).add(4);
        adj.get(4).add(0);
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(1).add(3);
        adj.get(3).add(1);

        ArrayList <Integer> ans = bfs(5, adj);
        int n = ans.size();
        for(int i = 0;i<n;i++) {
            System.out.print(ans.get(i) + " ");
        }
    }
    public static ArrayList<Integer> bfs(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here: tc: O(V + 2E) clarity over nb but still refer 👇👇
        // sc: O(3V) queue, visited array, bfs list as o/p space
        // 0-based graph given
        ArrayList<Integer> bfs = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        int[] visited = new int[V];

        // Arrays.fill(visited, 0); // why needed??
        // Java arrays default to 0 anyway. It doesn’t hurt — just redundant.
        // int[] arrays are initialized to 0 by default in Java.

        q.add(0); // here have to add first starting node
        visited[0] = 1;

        // bfs.add(0); // using the line 15 and 29 is also AC but only adding
        // line 20 is more standard and clean !!

        while(!q.isEmpty()){
            int node = q.poll();
            bfs.add(node); // add to result when dequeuing

            ArrayList<Integer> neighbours = adj.get(node);
            int size = neighbours.size();

            for(int i=0; i<size; i++){
                if(visited[neighbours.get(i)] != 1){
                    // basically queue m dlt hi marked visited!!
                    visited[neighbours.get(i)] = 1;
                    q.add(neighbours.get(i));

                    // bfs.add(neighbours.get(i));
                }

            }
            //⭐ else use enchanced for loop - much cleaner code!

        }
        return bfs;

/*👉👉⭐⭐

If u r confused about time complexity part, then see the following dry run of the while loop of this ques.

This is how nodes are connected(assuming undirected graph) :
0 -> 1 ,2, 3
1 -> 0
2 -> 0,  4
3 -> 0
4 -> 2
So, total no. of edges = E = 4

For first while loop ,
node = 0,   edges = 3
Now, before going to the for loop part, u see a constant time operation O(1)  --> q.pop( )
This step will be executed every time we enter into while loop.

So, for first while loop how many times for loop will execute ??
It will be equal to the no. of edges , here it will be 3.

Therefore, total =  ( 1 + 3 )

Similarly for all other nodes, this is how it will look :
( 1 + 3 )  + ( 1 + 1 ) + ( 1 + 2 ) + ( 1 + 1 ) + ( 1 + 1 )
   =   13
   =   O ( V  +  2 * E )
   =   O ( 5  +  2  * 4 )
   */
    }


}
