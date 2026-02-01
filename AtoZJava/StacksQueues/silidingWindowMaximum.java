package StacksQueues;
import java.util.*;
public class silidingWindowMaximum {
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};

//        System.out.println();
        maxSlidingWindow(nums, 3);

    }
    public static void maxSlidingWindow(int[] nums, int k) {
        // i guess i have done similar GFG POTD, i'll attach link wait:
        // https://www.geeksforgeeks.org/problems/count-distinct-elements-in-every-window/1
        // it has to provide list of count of distinct ele from each window of size k
        // here to provide max ele from each window of size k

        int r = 0;
        int l = 0;
        int n = nums.length;
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        int max = Integer.MIN_VALUE;
        // if(k==1) return nums; for [1, -1] k=1 but other tc failing
        while (r < n) {
            q.add(nums[r]);
            while (!q.isEmpty() && nums[r] > q.peek()) {
                q.poll();
            }

            if (r - l + 1 == k) {
                ans.add(q.peek());
            }

            if (r - l + 1 > k) {
                // if(q.contains(nums[l])) q.poll();
                l++;
            }

        }
//        return ans;
        System.out.println(ans);
    }


}
