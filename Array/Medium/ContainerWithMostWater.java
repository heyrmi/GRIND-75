class Solution {
    public int maxArea(int[] height) {

        // Count the amount
        int maxAmt = 0;

        // we will use 2 pointer approach
        int left = 0;
        int right = height.length - 1;

        // while they dont collide
        while (left < right) {
            // 1. Find the currentAmount
            // Consider it like a rectangle where
            // minHeight(left or right) * breadth (right-left) will give us the results
            int minHeight = Math.min(height[left], height[right]);
            int breadth = right - left;

            // Current amount of water stored
            int currentAmt = minHeight * breadth;

            // pick that is the maximum
            maxAmt = Math.max(currentAmt, maxAmt);

            // 2. To move the pointers
            // if right is bigger than left
            if (height[left] <= height[right]) {
                // move left in a hope to find a bigger value so that it may contain more amount
                left++;
            }

            else {
                // move right in a hope to find a bigger value so that it may contain more
                // amount
                right--;
            }
        }

        return maxAmt;
    }
}