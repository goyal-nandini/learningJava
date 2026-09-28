package extras_OA.hackvegaR2_OA;

import java.util.*;

public class que2 {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: Read number of nodes
        int n = sc.nextInt();

        // Step 2: Read root node
        int root = sc.nextInt();

        // Step 3: Read remaining N-1 nodes
        String[] relations = new String[n];
        int[] values = new int[n];
        for (int i = 0; i < n - 1; i++) {
            String relation = sc.next();
            int value = sc.nextInt();
            relations[i] = relation;
            values[i] = value;
        }

        // At this point, you have:
        // - root node in 'root'
        // - relations[i] and values[i] for each child

        // TODO: Implement logic to build tree and calculate Super Nodes
        int ans = superNodes(n, root, relations, values);
        System.out.println(ans);
        sc.close();
    }
    // super node if sum of digit of left child and right child is same

    static int superNodes(int n, int root, String[] pos, int[] val){
        Map<String, Integer> pathToValue = new HashMap<>();
        pathToValue.put("", root);

        for(int i=0; i<n-1; i++){
            pathToValue.put(pos[i], val[i]);
        }
/*
mapping:
""   -> 21   (root)
L    -> 14
R    -> 23
LL   -> 7
LR   -> 70
RR   -> 11
RRL  -> 23
RRR  -> 32
*/
        int ans = 0;
        for(String path: pathToValue.keySet()){
            // eg for path = "", leftPath is L and rightPath is R
            // for path = "LL", leftPath is LLL and rightPath is LLR, but LLL and LLR doesn't exist in map
            // means no such child exist for node LL in the map
            // therefore we need to check the path if it is in the map or not?!

            String leftPath = path + 'L';
            String rightPath = path + 'R';

            // check if both paths in map
            if(pathToValue.containsKey(leftPath) && pathToValue.containsKey(rightPath)){
                int leftVal = pathToValue.get(leftPath);
                int rightVal = pathToValue.get(rightPath);

                int leftDigSum = digSum(leftVal);
                int rightDigSum = digSum(rightVal);

                if(leftDigSum == rightDigSum){
                    ans += pathToValue.get(path);
                }
            }
        }
        return ans;
    }

    private static int digSum(int n){
        int sum = 0;
        while(n>0){
            int dig = n%10;
            sum += dig;
            n /= 10;
        }
        return sum;
    }


}


