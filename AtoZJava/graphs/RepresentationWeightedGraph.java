package graphs;

import java.util.ArrayList;
import java.util.Scanner;

class Pair{
    int node;
    int weight;

    public Pair(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }
}

public class RepresentationWeightedGraph {
    public static void main(String[] args) {
        adjList();
        adjMat();

        /*INPUT:
        1 2 2
        1 3 4
        2 3 1
        */

    }
    public static void adjMat(){
        System.out.println("Adjacency matrix for weighted graph: ");
        Scanner sc = new Scanner(System.in);
        int n = 3; // no. of nodes
        int m = 3; // no. of edges

        int[][] adjMt = new int[n+1][n+1];

        // input edges: // ⭐ size of the matrix used: n+1 * n+1, space used: O(n*n)
        for(int i=0; i<m; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();

            adjMt[u][v] = w;

            // remove this line in case of directed graph
            adjMt[v][u] = w;

        }
        for(int i=0; i<=n; i++){
            for(int j=0; j<=n; j++){
                System.out.print(adjMt[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void adjList(){
        System.out.println("Adjacency List for weighted graph: ");
        Scanner sc = new Scanner(System.in);
        int n = 3; // no. of nodes
        int m = 3; // no. of edges

        ArrayList<ArrayList<Pair>> adjList = new ArrayList<>();

        for(int i=0; i<=n; i++){
            adjList.add(new ArrayList<>());
        }

        // input edges and weight: u, v, w
        for(int i=0; i<m; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();

            adjList.get(u).add(new Pair(v, w));

            // for directed graph, remove this line!!
            adjList.get(v).add(new Pair(u, w));
        }

        // lets print the adjacency list
        for(int i=0; i<n; i++){
            System.out.print(i + " -> ");
            for(Pair p: adjList.get(i)){
                System.out.print("(" + p.node + ", " + p.weight + ")");
            }
            System.out.println();
        }
    }
}
