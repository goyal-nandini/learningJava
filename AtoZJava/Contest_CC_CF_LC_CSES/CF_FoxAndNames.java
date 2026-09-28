package Contest_CC_CF_LC_CSES;

// like alien dictionary GFG
// a great lesson: why to get or make a disturbed vibe with handling characters just put {ch-'a'} and handle integers all
// way in adj, array, queue :)

import java.util.*;

public class CF_FoxAndNames {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String[] a = new String[n];
        for(int i=0; i<n; i++){
            a[i] = sc.next();
        }

        // building graph from string comparison
        ArrayList<HashSet<Integer>> adj = new ArrayList<>();
        for(int i=0; i<26; i++){
            adj.add(new HashSet<>());
        }

        // adj list prep
        for(int i=0; i<a.length-1; i++){
            String s1 = a[i];
            String s2 = a[i+1];

            // edge case, longer string first with same prefix, violates the lexicographical rule
            if(s1.length() > s2.length() && s1.startsWith(s2)) {
                System.out.println("Impossible");
                return;
            } // eg "abcde" and "abc"

            for(int j=0; j<Math.min(s1.length(), s2.length()); j++){
                int u = s1.charAt(j) - 'a';
                int v = s2.charAt(j) - 'a';
                if(u!=v){
                    // find first mismatch only
                    adj.get(u).add(v);
                    break;
                }
            }
        }

        // indegree
        int[] indegree = new int[26];
        for(int i=0; i<adj.size(); i++){
            for(int x: adj.get(i)){
                indegree[x]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        List<Character> order = new ArrayList<>();
        for(int i=0; i<26; i++){
            if(indegree[i] == 0){
                q.add(i);
//  only (ch+'a') gives compilation error as java first converts (i+'a') into 'int' and then it doesn't auto convert
// int -> char, so the correct way is (char)(ch+'a')
            }
        }

        while(!q.isEmpty()){
            int node = q.poll();
            order.add((char)(node+'a')); // kept this line here only... process inside BFS
            for(int neigh: adj.get(node)){
                indegree[neigh]--;
                if(indegree[neigh] == 0){
                    q.add(neigh);
                }
            }
        }
//        if(order.size() == 26) means no cycle is present
        if(order.size() < 26){ // cycle exits and lexicographical rule breaks
            System.out.println("Impossible");
            return;
        }

        for(int i=0; i<order.size(); i++){
            System.out.print(order.get(i));
        }
    }
}
/*wondering where other character came other than these edge building characters??!!
* so all other characters as nodes [independent nodes] we can say have no incoming edge so they all get
* add to the queue and processed along the way without any worry!!
*
* and one more imp thing to note: we are asked: If there exists such order of letters that the given names are sorted
* lexicographically, output any such order as a permutation of characters 'a'–'z' (i. e. first output the first letter
* of the modified alphabet, then the second, and so on).
*
* so the order list we finally made is a valid topological order of characters and we can say its a
* lexicographical order in latin language/a diff lang as in eng we have normal lexicographical as a-z
* but here the constraints as per the given input name decides the order.
*
* 🎯 What problem asks
Find ANY permutation of a–z such that given names are sorted
👉 That permutation = your order.
*
* 🧠 So your list represents:
👉 “custom alphabet order”
NOT:
👉 dictionary order using standard alphabet
* */


