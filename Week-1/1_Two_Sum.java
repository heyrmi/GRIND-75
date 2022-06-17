class Solution {
    /**
     * Time Complexity O(n) : 2 loops
     * Space Complexity O(n) : HashSet
     */
    public int[] twoSum(int[] nums, int target) {

        // making a hashSet rather than a hashmap,
        // repeating values makes no sense if all we are about is just two varaiable sum
        HashSet<Integer> set = new HashSet();

        // ans array to store and return ans
        int[] ans = new int[2];

        // for one value of the ans
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(target - nums[i])) {
                ans[0] = i;
                break;
            }
            set.add(nums[i]);
        }

        // for second value of the ans
        for (int i = 0; i < nums.length; i++) {
            // check for next value also, next value is not the same value
            if (nums[i] == target - nums[ans[0]] && ans[0] != i) {
                ans[1] = i;
            }
        }
        return ans;
    }
}