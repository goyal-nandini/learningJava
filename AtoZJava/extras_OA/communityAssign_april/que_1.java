package extras_OA.communityAssign_april;

import java.util.*;

public class que_1 {
    static class Graph {
        int n;
        List<List<Integer>> adj, rev;
        boolean[] visited;
        Stack<Integer> stack;
        int[] compId;
        List<List<Integer>> sccList;

        Graph(int n) {
            this.n = n;
            adj = new ArrayList<>();
            rev = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                adj.add(new ArrayList<>());
                rev.add(new ArrayList<>());
            }
        }

        void addEdge(int u, int v) {
            adj.get(u).add(v);
            rev.get(v).add(u);
        }

        void dfs1(int u) {
            visited[u] = true;
            for (int v : adj.get(u)) {
                if (!visited[v]) dfs1(v);
            }
            stack.push(u);
        }

        void dfs2(int u, int id) {
            visited[u] = true;
            compId[u] = id;
            sccList.get(id).add(u);
            for (int v : rev.get(u)) {
                if (!visited[v]) dfs2(v, id);
            }
        }

        List<List<Integer>> getSCCs() {
            visited = new boolean[n];
            stack = new Stack<>();
            for (int i = 0; i < n; i++) {
                if (!visited[i]) dfs1(i);
            }
            visited = new boolean[n];
            compId = new int[n];
            sccList = new ArrayList<>();
            int id = 0;
            while (!stack.isEmpty()) {
                int u = stack.pop();
                if (!visited[u]) {
                    sccList.add(new ArrayList<>());
                    dfs2(u, id++);
                }
            }
            return sccList;
        }

        int maxPathValue() {
            List<List<Integer>> sccs = getSCCs();
            int sccCount = sccs.size();
            List<List<Integer>> dag = new ArrayList<>();
            int[] value = new int[sccCount];
            for (int i = 0; i < sccCount; i++) {
                dag.add(new ArrayList<>());
                value[i] = sccs.get(i).size(); // example: SCC size as value
            }
            for (int u = 0; u < n; u++) {
                for (int v : adj.get(u)) {
                    if (compId[u] != compId[v]) {
                        dag.get(compId[u]).add(compId[v]);
                    }
                }
            }
            int[] indeg = new int[sccCount];
            for (int u = 0; u < sccCount; u++) {
                for (int v : dag.get(u)) indeg[v]++;
            }
            Queue<Integer> q = new LinkedList<>();
            int[] dp = new int[sccCount];
            for (int i = 0; i < sccCount; i++) {
                dp[i] = value[i];
                if (indeg[i] == 0) q.add(i);
            }
            while (!q.isEmpty()) {
                int u = q.poll();
                for (int v : dag.get(u)) {
                    if (dp[v] < dp[u] + value[v]) {
                        dp[v] = dp[u] + value[v];
                    }
                    indeg[v]--;
                    if (indeg[v] == 0) q.add(v);
                }
            }
            int ans = 0;
            for (int x : dp) ans = Math.max(ans, x);
            return ans;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        Graph g = new Graph(n);
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt(), v = sc.nextInt();
            g.addEdge(u, v);
        }
        System.out.println(g.maxPathValue());
        sc.close();
    }
}
