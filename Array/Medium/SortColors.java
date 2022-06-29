class Solution {
    /**
     * Time Complexity : O(n)
     * Space Complexity : O(1)
     */

    public void sortColors(int[] nums) {

        // start, mid index
        int start = 0, mid = 0;
        // end index
        int end = nums.length - 1;
        // for swapping
        int temp;

        while (mid <= end) {
            switch (nums[mid]) {
                case 0:
                    swapIt(nums, start, mid);
                    // swap will not work if we called a function and just passed in index
                    // as tehre is no 'pass by reference'
                    // thus swapping it here

                    // temp = nums[start];
                    // nums[start] = nums[mid];
                    // nums[mid] = temp;
                    start++;
                    mid++;
                    break;

                case 1:
                    mid++;
                    break;

                case 2:
                    swapIt(nums, mid, end);
                    // temp = nums[mid];
                    // nums[mid] = nums[end];
                    // nums[end] = temp;
                    end--;
                    break;
            }
        }
    }

    public void swapIt(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}