class Solution {
    // Solution one
    // Note: This is not the desired solution tho
    public int[] sortedSquares1(int[] nums) {
        /**
         * Time Complexity O(n logn) : 1 loop + 1 sort
         * Space Complexity O(1)
         */
        for (int i = 0; i < nums.length; i++) {
            nums[i] *= nums[i];
        }

        Arrays.sort(nums);

        return nums;
    }

    // Solution two
    public int[] sortedSquares2(int[] nums) {
        /**
         * Time Complexity O(n) : 1 loop
         * Space Complexity O(n): 1 Array
         */
        // This one uses 2 pointer approach
        // Making new array same length as that of the nums array
        int[] ans = new int[nums.length];

        int left = 0, right = nums.length - 1;

        // Iterate from the end and left < right
        // First conditional check is useless (you can also remove it)
        // Only the second condition counts here
        for (int i = nums.length - 1; i < nums.length && left <= right; i--) {
            // Right larger than left
            if (Math.abs(nums[left]) < Math.abs(nums[right])) {
                ans[i] = nums[right] * nums[right];
                right--;
            }

            // Left larger than right
            else {
                ans[i] = nums[left] * nums[left];
                left++;
            }
        }
        return ans;

    }
}