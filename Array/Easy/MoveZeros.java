class Solution {
    /**
     * Time Complexity O(n) : 1 loop
     * Space Complexity O(1)
     */
    public void moveZeroes(int[] nums) {

        // using two pointer approach
        // i: slow pointer
        // j: fast pointer

        int left = 0, right = 0;
        int n = nums.length;

        if (n == 0 || n == 1)
            return;

        while (right < n) {
            if (nums[right] == 0) {
                // preincrement so that we increase the value of right immidiately
                // we could have written right = right + 1
                ++right;
            }
            // if right is other than 0, then swap
            // and increment both i and j (left and right)
            else {
                swap(nums, left, right);
                ++left;
                ++right;
            }
        }

    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}