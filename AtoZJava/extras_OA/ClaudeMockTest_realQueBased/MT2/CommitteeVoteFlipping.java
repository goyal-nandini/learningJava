package extras_OA.ClaudeMockTest_realQueBased.MT2;
/***This was 100% a Greedy problem.**

 ### Why does Greedy work here?

 1. **Optimal Substructure:** To minimize the number of flips, every single flip you perform *must* deliver the maximum
 possible change to the vote margin (the largest "net swing").
 2. **Greedy Choice Property:** Flipping a 0-voter with weight $W$ gives a $+2W$ swing to the target gap ($+W$ for,
 $-W$ against). Picking the largest available $W$ at each step guarantees reaching the required condition in the fewest
 steps possible.

 ---

 ### LeetCode Practice Set (Same Core Pattern)

 To master this exact intuition—calculating a gap/margin and greedily applying operations sorted by maximum impact—
 practice these problems in order:

 #### 1. [LeetCode 1775 — Equal Sum Arrays With Minimum Number of Operations]

 * **Why it's identical:** You have two arrays with different sums. In 1 operation, you can change a number ($1 \dots 6$)
 * to minimize the gap between array sums.
 * **The Greedy Shift:** Calculate `diff = sum1 - sum2`. Build a list of maximum available changes (e.g., changing a `1`
 * to `6` gives a swing of `5`), sort them descending, and pick greedily until `diff <= 0`.

 #### 2. [LeetCode 1005 — Maximize Sum Of Array After K Negations]

 * **Why it's identical:** You have K flips. Flipping a negative number -X to +X changes the total sum by +2X.
 * **The Greedy Shift:** Sort, negate the most negative numbers first to get the highest positive gain, and handle
 * remaining K operations gracefully.

 #### 3. [LeetCode 2202 — Maximize the Topmost Element After K Moves]

 * **Why it's relevant:** Focuses on $K$ allowed budget operations and handling edge cases where $K$ exceeds available
 * choices or forces invalid states.

 ---*/
import java.util.*;
public class CommitteeVoteFlipping {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] votes = new int[n];
        int[] weights = new int[n];

        for(int i=0; i<n; i++){
            votes[i] = sc.nextInt();
        }
        for(int i=0; i<n; i++){
            weights[i] = sc.nextInt();
        }

        int ans = solve(n, k, votes, weights);
        System.out.println(ans);
    }

    // greedy
    private static int countFlips(int n, int k, int[] votes, int[] weights){

        // baseline sums
        int forVotes = 0;
        int againstVotes = 0;
        for(int i=0; i<n; i++){
            if(votes[i] == 1){
                forVotes+=weights[i];
            } else {
                againstVotes+=weights[i];
            }
        }
        if(forVotes > againstVotes) return 0;

        // time for flip the againstVoters for the proposal to pass
        // want min flips so that forVotes reach 1+againstVotes -
        // getting againstVoters and sorting with max weights

        // candidate selection
        ArrayList<Integer> againstVoters = new ArrayList<>();
        for(int i=0; i<n; i++){
            if(votes[i]==0){
                againstVoters.add(weights[i]);
            }
        }
        Collections.sort(againstVoters, Collections.reverseOrder());

        // time to flip these high weighted againstvoters
        int flip=0;
        int idx = 0;
        // one critical check, what if K > againstVoters.size()? If K = 5, but there are
        // only 2 against-voters in the list, idx will eventually hit 2 and crash with IndexOutOfBoundsException.
        // check idx<againstVoters.size()
        while(flip < k && idx < againstVoters.size()){
            forVotes += againstVoters.get(idx);
            againstVotes -= againstVoters.get(idx);
            flip++;
            idx++;
            if(forVotes > againstVotes) return flip;
        }
        return -1;
    }
    
    /*Complexity Analysis
    
    Time Complexity: O(N \log N)
        Computing baseline sums: O(N)
        Filtering againstVoters: O(N)
        Sorting againstVoters: O(M \log M), where M \le N is the number of against voters.
        Flipping loop: O(\min(K, M))
        Overall: O(N \log N), dominated by the sort step. This comfortably runs within the 10^5 constraint 
        inside standard 1-second time limits.
    
    Space Complexity: O(N)
         O(M) extra space to store the weights of against voters in the ArrayList.*/

    // broken code structure = buggy code and logic
    private static int solve(int n, int k, int[] votes, int[] weights){
        int[][] ppl = new int[n][2];
        for(int i=0; i<n; i++){
            ppl[i][0] = votes[i];
            ppl[i][1] = weights[i];
        }

        // sorted by descending order of weights
        Arrays.sort(ppl, (a, b) -> b[1]-a[1]);

        int forVotes = 0;
        int againstVotes = 0;
        for(int i=0; i<n; i++){
            if(ppl[i][0] == 0){
                againstVotes += ppl[i][1];
            }
        }
        int flips = 0;
        boolean proposalFulfilled = false;
        for(int i=0; i<n; i++){
            if(ppl[i][0] == 1){
                forVotes += ppl[i][1]; // (Broken because flips happen before original 1s are even counted!)
            } else if(flips<k){
                forVotes += ppl[i][1];
                againstVotes -= ppl[i][1];
                flips++;
            }
            if(forVotes > againstVotes) {
                proposalFulfilled = true;
                break;
            }
        }
        if(!proposalFulfilled) return -1;
        return flips;

//        int idx = 0;
//        int flips = 0;
//        if(valid > invalid){
//            return 0;
//        } else {
//            // have to perform min flips atmost k...
//            while(valid < invalid){
//                if(ppl[idx][0] == 0){
//                    valid += ppl[idx][1];
//                    idx++;
//                    flips++;
//                }
//            }
//        }
    }
}
