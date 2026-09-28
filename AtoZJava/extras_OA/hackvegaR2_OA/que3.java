package extras_OA.hackvegaR2_OA;
import java.util.HashMap;
import java.util.Scanner;

public class que3 {
    /*private static Node lca_recursion(Node root, Node a, Node b){
        // let me made you revise how the lca works in actual optimal way
        if(root == null || root == a || root == b){
            return root;
        }

        Node left = lca_recursion(root.left, a, b);
        Node right = lca_recursion(root.right, a, b);

        if (left != null && right != null) {
            return root; // p and q found in different subtrees
        }

        return (left != null) ? left : right;
    } */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: Read number of nodes
        int n = sc.nextInt();

        // Step 2: Read root node
        int root = sc.nextInt();

        // Step 3: Read N-1 relations and values
        String[] relations = new String[n];
        int[] values = new int[n];
        for (int i = 0; i < n - 1; i++) {
            String relation = sc.next();
            int value = sc.nextInt();
            relations[i] = relation;
            values[i] = value;
        }

        // Step 4: Read query nodes A and B
        int a = sc.nextInt();
        int b = sc.nextInt();

        // At this point you have:
        // - root node in 'root'
        // - relations[i] and values[i] for each child
        // - query nodes 'a' and 'b'

        // TODO: Implement logic to build tree and compute LCA
        int ans = lca(n, root, relations, values, a, b);
        System.out.println(ans);

        sc.close();
    }

    static int lca(int N, int Root, String[] pos, int[] val, int A, int B){
        // mapping node -> path from root
        /*
        1
      /   \
     2     3
    / \   / \
   4  5  6  7

mapping: node to path
1 -> ""
2 -> "L"
3 -> "R"
4 -> "LL"
5 -> "LR"
6 -> "RL"
7 -> "RR"

mapping: path to node
"" -> 1
"L" -> 2
"R" -> 3
"LL" -> 4
"LR" -> 5
"RL" -> 6
"RR" -> 7

A = 4
B = 5

paths:
4 -> LL
5 -> LR

Longest common prefix = "L"
Node having path "L" = 2
Answer = 2
        */

        HashMap<Integer, String> nodeToPath = new HashMap<>();
        HashMap<String, Integer> pathToNode = new HashMap<>();

        // root has empty path - path=""
        nodeToPath.put(Root, "");
        pathToNode.put("", Root);

        for(int i=0; i<N-1; i++){
            nodeToPath.put(val[i], pos[i]);
            pathToNode.put(pos[i], val[i]);
        }

        String p1 = nodeToPath.get(A);
        String p2 = nodeToPath.get(B);

        // aree say the has p1=LL and p2=LR so lca node is L ie found on path to node mapping
        // - such an easy que :]
        // lca depend on common prefix, not the common suffix

        int i=0;
        while(i<p1.length() && i<p2.length()){
            if(p1.charAt(i) == p2.charAt(i)) {
                i++;
            } else {
                break;
            }
        }
        int ans = pathToNode.get(p1.substring(0, i));
        return ans;
    }
}

