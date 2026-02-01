package StacksQueues;

public class trapping_rainwater {
    public static void main(String[] args) {
        int[] height = {4,2,0,3,2,5};
//        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
    }
    public static int trap(int[] height) {
        int n = height.length;
        int total = 0;
        int[] right = rightMax(height);

        int prevMax = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            prevMax = Math.max(height[i], prevMax); // dynamic leftMax
            total += Math.max(0, Math.min(prevMax, right[i]) - height[i]); // negatives ko skip kr deng...
        }
        return total;
    }

    public static int[] rightMax(int[] height){
        int n = height.length;
        int[] rightMax = new int[n];
        rightMax[n-1] = height[n-1];
        for (int i = n-2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i+1], height[i]);
        }
        return rightMax;
    }
}
