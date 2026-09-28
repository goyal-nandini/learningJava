package extras_OA.communityAssign_april;

import java.util.*;

public class que_2 {
    static class Edge {
        int to, weight;
        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static class Node implements Comparable<Node> {
        int v;
        long dist;
        Node(int v, long dist) {
            this.v = v;
            this.dist = dist;
        }
        public int compareTo(Node other) {
            return Long.compare(this.dist, other.dist);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt(), v = sc.nextInt(), w = sc.nextInt();
            graph.get(u - 1).add(new Edge(v - 1, w));
            graph.get(v - 1).add(new Edge(u - 1, w)); // if undirected, remove if directed
        }

        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        long[] ways = new long[n];
        int[] edges = new int[n];
        Arrays.fill(edges, Integer.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[0] = 0;
        ways[0] = 1;
        edges[0] = 0;
        pq.add(new Node(0, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (cur.dist > dist[cur.v]) continue;
            for (Edge e : graph.get(cur.v)) {
                if (dist[e.to] > dist[cur.v] + e.weight) {
                    dist[e.to] = dist[cur.v] + e.weight;
                    ways[e.to] = ways[cur.v];
                    edges[e.to] = edges[cur.v] + 1;
                    pq.add(new Node(e.to, dist[e.to]));
                } else if (dist[e.to] == dist[cur.v] + e.weight) {
                    ways[e.to] += ways[cur.v];
                    edges[e.to] = Math.min(edges[e.to], edges[cur.v] + 1);
                }
            }
        }

        System.out.println(dist[n - 1] + " " + ways[n - 1] + " " + edges[n - 1]);
        sc.close();
    }
}

