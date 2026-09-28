package extras_OA.communityAssign_feb;
import java.util.*;

public class que2 {
    static List<Integer>[] graph;
    static boolean[] visited;
    static int[] parent;
    static int n, m;

    public static boolean dfs(int node, int par) {
        visited[node] = true;
        parent[node] = par;

        for (int neighbor : graph[node]) {
            if (!visited[neighbor]) {
                if (dfs(neighbor, node)) return true;
            } else if (neighbor != par) {
                // Cycle found → reconstruct path
                printCycle(node, neighbor);
                return true;
            }
        }
        return false;
    }

    public static void printCycle(int u, int v) {
        List<Integer> cycle = new ArrayList<>();
        cycle.add(v);
        int curr = u;
        while (curr != v) {
            cycle.add(curr);
            curr = parent[curr];
        }
        cycle.add(v); // close the cycle

        Collections.reverse(cycle);
        System.out.println("Cycle found: " + cycle);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph[u].add(v);
            graph[v].add(u);
        }

        visited = new boolean[n + 1];
        parent = new int[n + 1];

        boolean cycleExists = false;
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                if (dfs(i, -1)) {
                    cycleExists = true;
                    break;
                }
            }
        }

        if (!cycleExists) {
            System.out.println("No cycle found");
        }
    }
}

