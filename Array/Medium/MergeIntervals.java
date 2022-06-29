class Solution {
    /**
     * Time Complexity O(n) : 1 Loop
     * Space Complexity O(n) : ArrayList
     */
    public int[][] merge(int[][] intervals) {

        // 1. Make ans as arrayList to add array in this arrayList
        List<int[]> ans = new ArrayList<>();

        // 2. Check for null or size = 1
        if (intervals == null || intervals.length <= 0)
            return ans.toArray(new int[0][]);

        // 3. Sort the array on their first values
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int start = intervals[0][0];
        int end = intervals[0][1];

        for (var i : intervals) {
            // 4. Check for overlapping intervals
            if (i[0] <= end)
                end = Math.max(end, i[1]);
            // 5. Check for non overlapping intervals and adding them to ans
            else {
                ans.add(new int[] { start, end });
                start = i[0];
                end = i[1];
            }
        }
        // to add last iteration
        ans.add(new int[] { start, end });
        return ans.toArray(new int[0][]);
    }
}
