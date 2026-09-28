package Arrays;
// 17 august 2026
/*
Remember the pattern 🧠
< 0  --> swap with low, low++, mid++
= 0  --> mid++
> 0  --> swap with high, high--

Pointers represent:

[ negatives ][ zeros ][ unknown ][ positives ]
      low        mid              high

This is a direct 3-way partitioning problem and is a common DSA interview question.

[0 ........ low-1]       → negative
[low ..... mid-1]        → zero
[mid ..... high]         → unknown
[high+1 ........ n-1]    → positive
ques always: "Is there anything unknown left?"
*/
public class GroupIntegers {
    static void main(String[] args) {
        int[] nums = {2, 4, -4, -6, 7, 9, 0, 4, -1, 0};
        solve(nums);
        for(int n: nums) System.out.print(n + " ");
    }

    // just doing for the sake of revising DNF :)
    // say given some numbers [2, 4, -4, -6, 7, 9, 0, 4, -1, 0] now group them as -ves 0's and +ves
    // without using any space - in-place grouping, there comes DNF Dutch National Flag, 3 pointer approach we can say
    // low, mid, high

    // tc: O(n) sc: O(1)
    private static void solve(int[] nums){
        int n = nums.length;
        int low = 0;
        int mid = 0;
        int high = n-1;

        while(mid <= high){ // attention pls, use mid <= high not low <= high :)
            if(nums[mid] < 0){
                swap(low, mid, nums);
                low++;
                mid++;
            } else if(nums[mid] == 0){
                mid++;
            } else {
                swap(mid, high, nums);
                high--;
            }
        }
    }
    private static void swap(int i, int j, int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
