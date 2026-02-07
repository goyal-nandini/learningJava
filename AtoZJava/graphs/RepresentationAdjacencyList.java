package graphs;

import java.util.ArrayList;
import java.util.Scanner;

public class RepresentationAdjacencyList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 5; // no. of nodes
        int m = 6; // no. of edges
        /*INPUT:
        1 2
        1 3
        2 4
        3 4
        3 5
        4 5
        */
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
//        outer list → nodes
//        inner list → neighbors of that node

        // for each node create an empty list for storing its neighbours
        for(int i=0; i<=n; i++){ // ⭐ size of list: n+1, space used: O(2m)
            adjList.add(new ArrayList<>());
        }

        // input edges
        for(int i=0; i<m; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();

            adjList.get(u).add(v);

            // for directed graph, remove this line!!
            adjList.get(v).add(u);
        }

        // lets print the adjacency list
        for(int i=0; i<n; i++){
            System.out.print(i + " -> ");
            for(int neighbour: adjList.get(i)){
                System.out.print(neighbour + " ");
            }
            System.out.println();
        }

    }
}
