import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {

    /**
     * There can be 3 possible solutions
     * 1. Two for loops: comparing each elemnt with next set of elements
     * 2. Sorting and then comparing
     * 3. Using HashSet
     * 
     * Here we have done both 2 and 3
     */

    // 2. Sotring and comparing

    /**
     * Time Complexity O(n logn) : sorting and 1 loop
     * Space Complexity O(1)
     */
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        // Note: keep index out of bound exception in mind
        // either start from 1st index or stop at last-1
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }

    // 3. HashSet (Becasue it doesnot contains duplicate values)
    /**
     * Time Complexity O(n logn) : 1 loop
     * Space Complexity O(n) : HashSet
     */
    public boolean containsDuplicate2(int[] nums) {

        // final HashSet because we don't want to change the data after insertion
        final Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            // check if the element exists in the hashmap
            // Yes: then return 'true'
            if (set.contains(nums[i])) {
                return true;
            }
            // else add the element in the HashSet
            // becasue this is the first time its getting added
            set.add(nums[i]);
        }
        // If we could not find any repeating elements in the hashSet
        // then return 'false'
        return false;
    }
}