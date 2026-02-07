package graphs;

import java.util.Scanner;

public class RepresentationAdjacencyMatrix {
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
        4 5*/

        int[][] adjMt = new int[n+1][n+1];

        // input edges: // ⭐ size of the matrix used: n+1 * n+1, space used: O(n*n)
        for(int i=0; i<m; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();

            adjMt[u][v] = 1;

            // remove this line in case of directed graph
            adjMt[v][u] = 1;

        }
        for(int i=0; i<=n; i++){
            for(int j=0; j<=n; j++){
                System.out.print(adjMt[i][j]);
            }
            System.out.println();
        }
    }
}
