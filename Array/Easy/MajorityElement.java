class Solution {
    /**
     * Time Complexity O(n) : 1 loop
     * Space Complexity O(1)
     */

    public int majorityElement(int[] nums) {

        // considering first element as the major one
        int major = nums[0];
        // for counting the occurance of the element in the given array
        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            // if count = 0, then assign major = nums[idx]
            // and increase count
            if (count == 0) {
                count++;
                major = nums[i];
            }
            // If major maches the nums[idx], increase count
            else if (major == nums[i]) {
                count++;
            }
            // If major does not maches then decrese the count
            else
                count--;

        }
        // Thus whatever occured most number of times and
        // could not get cancelled was majority element
        return major;

    }
}
