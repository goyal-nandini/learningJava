package DPandGreedy;

import java.util.Comparator;
import java.util.Arrays;

class Pair{
    int val;
    int wt;
    double ratio;
    Pair(int val, int wt){
        this.val = val;
        this.wt = wt;
        this.ratio = (double)val/wt;
    }
}
public class FractionalKnapsack {
    public static void main(String[] args) {
        int[] wt = {60, 100, 120};
        int[] val = {10, 20, 30};
        System.out.println(fractionalKnapsack(wt, val, 50));
    }
    // REALLY WHAT A IMPLEMENTATION OMG
    // tc: O(nlogn + n)
    // sc: O(1) in-place sorting, not considering it

    public static double fractionalKnapsack(int[] val, int[] wt, int capacity) {
        // code here
        // val/wt in descending order array
        // “Value, weight, and ratio must move together.”

        int n = val.length;

        // converting val and wt values to a Pair array
        // bundle value & weight together
        Pair[] items = new Pair[n];
        for(int i=0; i<n; i++){
            Pair p = new Pair(val[i], wt[i]);
            items[i] = p;
        }

        // time for sorting
        Arrays.sort(items, new Comparator<Pair>(){
            public int compare(Pair a, Pair b){
                // descending order
                if(a.ratio < b.ratio) return 1;
                if(a.ratio > b.ratio) return -1;
                return 0;
            }
        });

        double finalVal = 0.0;
        int currCap = capacity;
        for(int i=0; i<n; i++){
            if(currCap >= items[i].wt){
                currCap -= items[i].wt;
                finalVal += items[i].val;
            } else {
                finalVal += ((double)items[i].val/items[i].wt) * currCap;
                break;
            }
        }
        return finalVal;

    }
}
