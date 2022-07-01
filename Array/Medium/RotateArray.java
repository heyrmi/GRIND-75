class Solution {
    public void rotate(int[] nums, int k) {
        /*
         * //Solution 1. first way: Use extra space
         * int n = nums.length;
         * int[] ans = new int[nums.length];
         * 
         * for(int i=0; i<n; i++){
         * //if you divide by length of the array then will not be out of bounds
         * //do it on a piece of paper to get the idea
         * int idx = (i+k) % n;
         * ans[idx] = nums[i];
         * }
         * 
         * for(int i=0; i<n; i++){
         * nums[i] = ans[i];
         * }
         */

        // Solution 2

        int n = nums.length;
        // even if k is big we want it to be in the range o (0, n)
        // becasue extra rotation will give us the same output
        k = k % n;

        // 1. reverse the whole array : [7,6,5,4,3,2,1]
        reverse(nums, 0, n - 1);
        // 2. reverse the first k elements : [5,6,7,4,3,2,1]
        reverse(nums, 0, k - 1);
        // 3. reverse the last remaining elements: [5,6,7,1,2,3,4]
        reverse(nums, k, n - 1);
    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;

            // 4. increment the left index after swap, and decrement the right index after
            // swap
            i++;
            j--;
        }
    }
}
