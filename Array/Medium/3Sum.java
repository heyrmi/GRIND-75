class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        /**
         * 
         * int target = 0;
         * int n = nums.length;
         * 
         * List<List<Integer>> result = new ArrayList<List<Integer>>();
         * 
         * // sorting to remove duplication
         * Arrays.sort(nums);
         * 
         * for (int i = 0; i < n; i++) {
         * // taking target2 to calculate the rest 2 elements
         * int target2 = target - nums[i];
         * // front and back: 2 pointers
         * int front = i + 1;
         * int back = n - 1;
         * // While they don't cross each other
         * while (front < back) {
         * 
         * // calculate the 2sum
         * int twoSum = nums[front] + nums[back];
         * // if target is greater then increase the front
         * if (twoSum < target2)
         * front++;
         * // if sum is greater then decrease back
         * else if (twoSum > target2)
         * back--;
         * // if they are equal
         * else {
         * List<Integer> triplet = new ArrayList<>();
         * triplet.add(nums[i]);
         * triplet.add(nums[front]);
         * triplet.add(nums[back]);
         * // add the arraylist in the ans (arrayList)
         * result.add(triplet);
         * 
         * // skip repeating elements
         * while (front < back && nums[front] == triplet.get(1))
         * ++front;
         * while (front < back && nums[back] == triplet.get(2))
         * --back;
         * }
         * 
         * }
         * // if we could not match then skip the repating elements in the main array
         * while (i + 1 < n && nums[i + 1] == nums[i])
         * ++i;
         * }
         * return result;
         */

        class Solution {
            public List<List<Integer>> threeSum(int[] nums) {
                /**
                 * Time Complexity O(n^2) : 2 loops + 1 sort
                 * Space Complexity O(n): List<List<>>
                 */
                List<List<Integer>> ans = new ArrayList<List<Integer>>();
                int n = nums.length;
                // will use this to calculate target2
                int target = 0;

                // To avoid duplication
                Arrays.sort(nums);

                // 1. For first element iteration
                for (int i = 0; i < n; i++) {
                    // to calculate the rest 2 elements whose sum will be equal to target2
                    int target2 = target - nums[i];
                    // initialise front and back: these are the 2 pointers
                    int front = i + 1;
                    int back = n - 1;
                    // 2. While they don't cross eachother
                    while (front < back) {
                        // calculate their sum to compare with target2
                        int twoSum = nums[front] + nums[back];

                        // 3. comparisons
                        if (twoSum < target2)
                            front++;
                        else if (twoSum > target2)
                            back--;
                        // 4. if they match
                        else {
                            List<Integer> triplets = new ArrayList<>();
                            // because its the first element
                            triplets.add(nums[i]);
                            // Add remaining two elements
                            triplets.add(nums[front]);
                            triplets.add(nums[back]);

                            // add them to main ans list
                            ans.add(triplets);

                            // 5. skip remaining repeating elements by 2 pointers
                            while (front < back && nums[front] == triplets.get(1))
                                ++front;
                            while (front < back && nums[back] == triplets.get(2))
                                --back;
                        }
                    }
                    // 6. skip remaining first element in the main array
                    while (i + 1 < n && nums[i + 1] == nums[i])
                        ++i;
                }
                return ans;
            }
        }
    }
}