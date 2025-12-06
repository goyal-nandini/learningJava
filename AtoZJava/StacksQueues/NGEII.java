/*🔥Yes, your logic would work only if all elements are 🔴distinct.
🟢 What your idea assumes

        You rotate the array so that the maximum comes at last.
        Then you find the Next Greater Element using value → value mapping (HashMap).
        Since all values are unique, no overwriting happens in the map, so mapping stays correct.
        So for distinct elements, your approach can work.

🔴 Why it breaks when elements are repeated

        HashMap uses the element value as a key.
        Duplicate values overwrite each other.

        Example:
        map.put(1, 2);  // first 1's result
        map.put(1, -1); // second 1 overwrites the first answer

        Result becomes wrong.
🔥 Extra Tip

       Even with distinct elements, rotation + extra space + map is too heavy and complex.
       A double traversal stack method is the clean and optimal approach.*/

package StacksQueues;
import java.util.*;
public class NGEII {
    public static void main(String[] args) {
        int[] nums = {5, 2, 8, 3};
        int n=nums.length;
        int maxi = Integer.MIN_VALUE;

        for(int q: nums){
            maxi = Math.max(maxi, q);
        }

        System.out.println(maxi);

        int[] newNums = Arrays.copyOf(nums, n);
        int p=newNums.length;

        while(newNums[n-1] != maxi)
            rotateBynMinus1(newNums, n-1);

        for(int s: nums){
            System.out.print(s+" ");
        }
        System.out.println();
        for(int m: newNums){
            System.out.print(m+" ");
        }
        System.out.println();
        int[] ans = nextGreaterElements(nums);
        for(int a: ans){
            System.out.print(a+" ");
        }


    }

    public static int[] nextGreaterElements(int[] nums) {
        // have to use hashmap and we'll solve it correct !!
        Stack<Integer> st = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int[] ans = new int[n];
        int[] newNums = new int[n];
        newNums = Arrays.copyOf(nums, n);

        // finding greatest element
        int maxi = Integer.MIN_VALUE;
        for(int m: nums){
            maxi = Math.max(maxi, m);
        }

        while(newNums[n-1] != maxi)
            rotateBynMinus1(newNums, n-1);

        // here its need of hashmap ans will run on newNums(final rotated one)
        for(int i=n-1; i>=0; i--){
            while(!st.isEmpty() && st.peek() < newNums[i])
                st.pop();

            // if(st.isEmpty()) ans[i] = -1;
            // else ans[i] = at.peek();

            map.put(newNums[i], st.isEmpty() ? -1 : st.peek());
            st.push(newNums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            ans[i] = map.get(nums[i]);
        }
        return ans;

    }

    public static void rotateBynMinus1(int[]  arr, int d){
        // 1. say we have [1 2 3 4 5 6 7] and d=3
        int n=arr.length;
        int temp[] = new int[d];
        for(int i=0; i<d; i++)
            temp[i] = arr[i];

        for(int i=d; i<n; i++) // shifting
            arr[i-d] = arr[i];

        int j=0;
        for(int i=n-d; i<n; i++) {
            arr[i] = temp[j];
            j++;
        }
    }
}
