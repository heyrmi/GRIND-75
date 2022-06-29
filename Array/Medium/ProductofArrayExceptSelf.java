class Solution {
    public int[] productExceptSelf(int[] nums) {
        /**
         * Time Complexity O(n) : 2 loops
         * Space Complexity O(1): ans doesnot counts in this question
         */

        // given: [1,2,3,4]

        int[] ans = new int[nums.length];

        // because we want to multiply based on this starting point
        // if left 0, then every index will be 0 even after the prefix and postfix
        ans[0] = 1;

        // prefix iteration
        for (int i = 1; i < nums.length; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }
        // Result: [1,1,2,6]

        int right = 1;
        // postfix iteration
        for (int i = nums.length - 1; i >= 0; i--) {
            ans[i] *= right;
            right *= nums[i];
        }
        // Result: [24,12,8,6]

        return ans;
    }
}