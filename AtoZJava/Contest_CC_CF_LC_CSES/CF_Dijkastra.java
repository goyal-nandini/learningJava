package Contest_CC_CF_LC_CSES;

//💯 YES — pure Dijkstra, fully it is!

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class CF_Dijkastra {
    public static void main(String[] args) {
        FastReader9 fr = new FastReader9();
        PrintWriter out = new PrintWriter(System.out);

        int n = fr.nextInt();
        int m = fr.nextInt();

        int[][] directEdges = new int[m][3];
        for(int i=0; i<m; i++){
            directEdges[i][0] = fr.nextInt();
            directEdges[i][1] = fr.nextInt();
            directEdges[i][2] = fr.nextInt();
        }

        // building adj list of this input
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i=0; i<=n; i++){ // build adj from 1
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<m; i++){
            int u = directEdges[i][0];
            int v = directEdges[i][1];
            int w = directEdges[i][2];

            // undirected...
            adj.get(u).add(new int[]{v, w});
            adj.get(v).add(new int[]{u, w});
        }

        // lets write dijkastra
        // pq has node and weight

//  IMP: PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
//👉 Works for int, but for long:
//❌ subtraction can overflow
//❌ type mismatch

        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) ->
            Long.compare(a[1], b[1])
        );
        pq.add(new long[]{1, 0});
        long[] cost = new long[n+1];
        Arrays.fill(cost, Long.MAX_VALUE); // be careful if u have long type of cost then do fill it with long!
        cost[1] = 0;
        int[] parent = new int[n+1];
        Arrays.fill(parent, -1);

        while(!pq.isEmpty()){
            long[] pair = pq.poll();
            int node = (int)pair[0];
            long nodeWt = pair[1];
            if(nodeWt > cost[node]) continue;
            for(int[] l: adj.get(node)){
                int neigh = l[0];
                int wt = l[1];

                long newWt = wt + nodeWt;
                if(newWt < cost[neigh]){ // dijkastra is for shortest path!
                    cost[neigh] = newWt;
                    pq.add(new long[]{neigh, newWt});
                    parent[neigh] = node;
                }
            }
        }
        if(cost[n] == Long.MAX_VALUE){ // no path to n
            out.println(-1);
            out.flush();
            return;
        }
        int curr = n;
        List<Integer> route = new ArrayList<>();
        while(curr!=-1){
            route.add(curr);
            curr = parent[curr];
        }
        Collections.reverse(route);
        for(int i=0; i<route.size(); i++){
            out.println(route.get(i));
            if(i < route.size() - 1) out.print(" ");
        }
        out.println();
        out.flush();
    }
}
class FastReader9{
    BufferedReader reader;
    StringTokenizer tokenizer;

    public FastReader9(){
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    String next(){
        while(tokenizer == null || !tokenizer.hasMoreElements()){
            try{
                String line = reader.readLine();
                if(line == null) return null;
                tokenizer = new StringTokenizer(line);
            } catch (IOException e){
                return null;
            }
        }
        return tokenizer.nextToken();
    }

    public int nextInt(){
        return Integer.parseInt(next());
    }
    public Long nextLong(){
        return Long.parseLong(next());
    }
}

