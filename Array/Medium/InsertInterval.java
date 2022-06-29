class Solution {

    /**
     * Time Complexity O(n) : 1 loop
     * Space Complexity O(n): 1 Array
     */
    public int[][] insert1(int[][] intervals, int[] newInterval) {

        // Make a new List and name it ans
        List<int[]> ans = new ArrayList<>();

        // Note: Keeping i outside to run just one iteration over intervals
        int i = 0;

        // 1. Add the intervals who end before the start of the newInterval
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            ans.add(intervals[i]);
            i++;
        }

        // 2. Merge overlapping intervals and make them new Interval
        // Add only if interval[first] < newInterval[last] then only we can compare
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            // 2.1 Set the new values in newIntervals to later set them in the ans array
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }

        // 3. Add the interval that you got in step-2
        ans.add(newInterval);

        // 4. Add the remaining in ans
        while (i < intervals.length) {
            ans.add(intervals[i]);
            i++;
        }

        // 5. return by converting ArrayList into int[][] Array
        return ans.toArray(new int[ans.size()][]);
    }

    /**
     * If given the List<>() version of this questions same logic can be applied
     * just the transformation is not required.
     */

    /**
     * Time Complexity O(n) : 1 loop
     * Space Complexity O(n): 1 Array
     */

    public List<Interval> insert2(List<Interval> intervals, Interval newInterval) {
        // Make a new List and name it ans
        List<Interval> ans = new LinkedList<>();
        // Note: Keeping i outside to run just one iteration over intervals
        int i = 0;
        // 1. Add the intervals who end before the start of the newInterval
        while (i < intervals.size() && intervals.get(i).end < newInterval.start)
            ans.add(intervals.get(i++));
        // 2. Merge overlapping intervals and make them new Interval
        while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
            newInterval = new Interval( // we could mutate newInterval here also
                    Math.min(newInterval.start, intervals.get(i).start),
                    Math.max(newInterval.end, intervals.get(i).end));
            i++;
        }
        // 3. Add the interval that you got in step-2
        ans.add(newInterval);
        // 4. Add the remaining in ans
        while (i < intervals.size())
            ans.add(intervals.get(i++));
        return ans;
    }

}