package Arrays;

public class CheckForRotationAndSorted {
    public static boolean isSorted(int[] nums){
        int count = 0;
        for(int i=0; i<nums.length-1; i++){
            if(nums[i] > nums[i+1])
               count++;
        }
//        for (int i = 0; i < nums.length; i++) {
//            int next = nums[(i + 1) % nums.length];
//            if (nums[i] > next) {
//                count++;
//            }
//        }
        System.out.println(count);
        return count <= 1;
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, 5, 1, 2};
        System.out.println(isSorted(nums));
    }
}
