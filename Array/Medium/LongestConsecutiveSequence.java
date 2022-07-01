class Solution {
    /**
     * Time Complexity O(n) : 1 loop
     * Space Complexity O(n) : Using set
     */
    public int longestConsecutive(int[] nums) {

        Set<Integer> hset = new HashSet<>();

        // 1. Add each element in the HashSet to avoid duplication
        for (var num : nums) {
            hset.add(num);
        }

        int longest = 0;

        // 2. Check if n-1 and n+1 values are present in the hashSet for each value
        // inserted
        for (var num : hset) {
            // 2.1 If lower value is present then continue searching
            if (hset.contains(num - 1)) {
                continue;
            }
            // 2.2 If lower value is not present then its the lowest and check for nextNum
            else {
                int nextNum = num + 1;
                while (hset.contains(nextNum)) {
                    nextNum++;
                }
                // How far we have come from num?
                int longestTillNow = nextNum - num;

                // 2.3 Find the largest among the two
                longest = Math.max(longest, longestTillNow);

            }
        }

        return longest;
    }
}