package Contest_CC_CF_LC_CSES.CSES;
import java.util.*;

public class countingTilings {
    static long MOD = 1000000007;
    static long[][] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        // no of ways we can fill n*m grid using 1*2 and 2*1 tiles

        // keep smaller dimension as n, mask has 2^n possibilities, we want n to be small
        if(n>m){
            int temp = n;
            n = m;
            m = temp;
        }

        dp = new long[m+1][1<<n];

        for(long[] row: dp) Arrays.fill(row, -1);

        System.out.println(solve(0, 0, n, m));
    }
    // mask: which cell of my current column are already occupied
    // say, n=2 m=2, solve(1, 01) -> i am at column 1, and the top cell of this column is already occupied
    // our job: complete this column and all columns after it.
    // que: which cell to handle first?! ans: need other function: to look at the cells one by one
    // function: fillColumn(...) -> i am inside one column, let me fill its cells from top to bottom
    // outgoingMask: saying to next column, that your top cell is already occupied.

    // incomingMask: What is already occupied in the current column?
    // outgoingMask: What am I going to occupy in the next column?

    // Current column receives incomingMask; while filling it, we build outgoingMask for the next column.

    // col: current column, 
    // mask: which cells of this column are already occupied by horizontal dominoes coming from prev column
    // que: why horizontal domino, not vertical: https://chatgpt.com/s/t_6a7b181f46dc819191d8212fc6f385d0

    //----- start -----

    // this function says: i am at this column and mask tell me which cells are already occupied, find the number of ways
    // from here.
    private static long solve(int col, int mask, int n, int m){
        // base case: says: i have gone past the last column, did i finish cleanly?!
        // if mask == 00 nothing is left outside the grid, valid tiling, return 1
        // if mask == 01, then something is trying to occupy beyond the grid, return 0
        if(col == m){
            return (mask == 0) ? 1 : 0;
        }

        if(dp[col][mask] != -1) return dp[col][mask];
        
        // start filling from row 0
        // incomingMask = mask
        // outgoingMask = 0 initially
        
        long ans = fillColumn(0, col, mask, 0, n, m);
        return dp[col][mask] = ans;
    }
    // notice: solve(col, mask) calls fillColumn(0, col, mask, 0), which recurses down rows,
    // and when it finishes a column (row == n), it calls solve(col+1, outgoing_mask) —
    // which starts the next column's fillColumn from scratch. So the two functions call each other
    // back and forth: solve → fillColumn → ... → solve → fillColumn → ... until col == m.
    
    // filling current column row by row
    // row: which row we are currently filling
    // column: current column
    // incomingMask: cells already occupied in current column
    // outgoingMask: cells we have occupied in next column
    // this function says: let me fill this column from top to bottom
    private static long fillColumn(int row, int col, int incomingMask, int  outgoingMask, int n, int m){
        // if row == n, means current column is filled
        if(row == n) {
            // move to next column
            return solve(col+1, outgoingMask, n, m); // current column finishes, so the outgoing mask becomes the
            // next column's incoming mask.
        }
        
        // case1: this cell is filled already
        if((incomingMask & (1<<row)) != 0){  // the row bit in incomingMask is set
            return fillColumn(row+1, col, incomingMask,  outgoingMask, n, m);
        }
        
        // case2: this cell is empty
        long ways = 0;
        
        // option1: put vertical domino, covers curr row and next row, we need row+1 to exist, 
        // also next row must not occupied
        if(row+1<n && (incomingMask & (1<<(row+1)))==0){ // row bit is not set
            ways += fillColumn(row+2, col, incomingMask, outgoingMask, n, m);
            
            ways %= MOD;
        }
        
        // option2: put a horizontal domino, goes to curr col and next col, we mark this same row in outgoingMask
        int newOutgoingMask =  outgoingMask | (1<<row); // set the 'row' bit
        ways += fillColumn(row+1, col, incomingMask, newOutgoingMask, n, m);

        ways %= MOD;

        return ways;
    }

    /*
    * result = (num & (1 << i))
    * result != 0  → bit IS SET → cell OCCUPIED
    * result == 0  → bit IS NOT SET → cell EMPTY
    */
}
