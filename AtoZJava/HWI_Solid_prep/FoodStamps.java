package HWI_Solid_prep;

import java.util.PriorityQueue;
import java.util.Scanner;

public class FoodStamps {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] v = new int[n];
        int[] d = new int[n];
        for(int i=0; i<n; i++){
            v[i] = sc.nextInt();
        }
        for(int i=0; i<n; i++){
            d[i] = sc.nextInt();
        }

        System.out.println(solve(v, d, n, m));
    }
    // lets optimise it: using binary search and math AP sum problem what !!?? HOW WHEN WHY ->
    // ok logic is correct but for m<=1e9 will be giving TLE for this
    // greedy+max-heap, picking best value m times - > mlogn -> can i run a loop 1e9 times??
    // no chance even 1e7 is risky!! so whenever u see do this x times and x is very very large 1e9 or 1e7, stop
    // and think of can i avoid iterating one by one!!
    /*
    * recognize the pattern: generating values v[i], v[i]-d[i], v[i]-2d[i]... this is AP so instead of taking values one
    * one,
    * how many values from this seq i take!! -> heap me bhai mujhe next greater value doo,
    * optimised m bahi tu mujhe
    * isse badi, sari values ek baari m dede!! its like how many values >= some threshold
    *
    * lets calc:
    * X = minimum taste allowed
    * k = how many times we take a food
    * a min val x and takes everything >= x, x is the min taste val we are willing to accept,
    * so instead of picking m values we ask if i only pick values >= x how many can i take?
    *
    * k is ? -> for one food we want how many terms >= x,
    * k = number of times we can take this food while value ≥ X
    *
    * 1. get x
    * 2. compute k for each food
    * 3. sum of all k, total meals
    * 4. if total >= m, x is valid else x is big
    *
    * This X is the minimum value among chosen meals, and BS is doing what is largest x st I can still take >= m meals?
    * larger x -> more taste points
    *
    * X gives you:
       which values are allowed
       k gives you:
       how many from each food
    * */
    public static long countMeal(int[] v, int[] d, long x, long m){
        // for each x, return the total no of meals with value >= x
        // x is a threshold, ki bhaii mujhe x se bdi taste values lake doo...!!
        // this ans: “If minimum taste allowed is X, how many meals can I take?”
        long total = 0;
        for(int i=0; i<v.length; i++){
            if(total >= m) break; // hm max m times hi sare meal le skt hai

            if(d[i] == 0){
                // then /0 exception so handle it well
                total += m;
            }
            if(v[i]>=x){
                long k = (v[i]-x)/d[i] + 1;
                total += k;
            }
        }
        return total;
    }
    // we have given v[i]-(ti-1)*d[i] taste points now if i take food item k times
    // so i have taste point as v[i]-(k-1)*d[i]
    // if i take taste values only >= x -> v[i]-(k-1)*d[i]>=x
    // now cal for k, k <= (v[i]-x)/d[i] + 1,
    // i take food k times, or less than (v[i]-x)/d[i] + 1

    // BS on ans starts:
    // Q: now x is >= v[i]-(k-1)*d[i], so x can be low as v[i]-(k-1)*d[i] ??
    // A: no, k is unknown and values can go to 0 or neg[will dec by sub the d[i]] and we need a safe search range so is 0
    // and high is max of taste value
    // also we need BS on fixed range and that low is not fixed by any way!
    // countMeals(0) = maximum possible meals (very large)
    // monotonic dec
    // let do it now:

    private static long BS(int[] v, int[] d, int m){
        int max = 0;
        for(int i=0; i<v.length; i++) max = Math.max(max, v[i]);
        long low = 0;
        long high = max; // max taste value which we can put as threshold!
        long ans = 0;
        while(low <= high){
            long mid = low+(high-low)/2;
            if(countMeal(v, d, mid, m) >= m){
                // valid x, move to more expand the space fo entry of more threshold to get more taste values
                ans = mid;
                low = mid+1; // want max x as We want the minimum taste among chosen meals to be as large as possible
                // and try to push min val UPP as much as possible, this is maximize the minimum :( :)
            } else {
                high = mid -1;
            }
        }
        return ans; // gives u best threshold x,
        // means You can pick ≥ M meals, and the minimum taste among them is X
    }

    // next we need total taste:
    private static long totalTaste(int[] v, int[] d, int m){
        long x = BS(v, d, m);
//        long k = countMeal(v, d, x, m);
        long ans = 0;
        long totalcnt = 0;

        for(int i=0; i<v.length; i++){
//          for each i count how many values > x
            long k = 0L;
            if(d[i] == 0){
                k = m;
            }
            if(v[i]>x){
                k = ((v[i] - (x+1)) / d[i]) + 1;
            }
            // k per food -> sum per food

            //        ap sum:
            long sum = k/2L * (2L*v[i]-(k-1)*d[i]); // common diff is -d[i]
            ans += sum;
        }
        // fill rem with x
        long rem = m - totalcnt;
        if(rem > 0){
            ans += rem * x;
        }
        return ans;
    }

    public static int solve(int[] v, int[] d, int n, int m){
        int maxPoints = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1]-a[1]);
        // index i with next value v[i] after dec d[i] for each food type

        for(int i=0; i<n; i++){
            pq.add(new int[]{i, v[i]});
        }
        int i=0; // just a counter here to count till all total meals exceed m
        while(i<m){
            int[] pair = pq.poll();

            if(pair[1]>0) maxPoints += pair[1];

            pair[1] = pair[1] - d[pair[0]]; // assign new value to the item
            pq.add(new int[]{pair[0], pair[1]}); // additional check to add only if pair[1] > 0

            m--; // reduce the meal count
        }
        return maxPoints;
    }
}
