
/**
 * Definition for an interval.
 * public class Interval {
 * int start;
 * int end;
 * Interval() { start = 0; end = 0; }
 * Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    /**
     * Time Complexity O(n logn) : 1 loop
     * Space Complexity O(1)
     */
    public boolean canAttendMeetings(Interval[] intervals) {
        // sort function also accepts comparators on the basis of which sorting happens

        /*
         * We can also use this for java 8
         * Arrays.sort(intervals, (x, y) -> x.start - y.start);
         */
        Arrays.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });

        /*
         * We can do this in 2 ways
         * 1. for each loop
         * 2. for loop
         */

        // 1. for each loop
        /*
         * // Will assign value later in for loop
         * Interval last = null;
         * 
         * // for each loop with var keyword, require java 10+ to compile/run
         * for (var i : intervals) {
         * 
         * // if last assigned then compare else dont
         * // if next iterations start < last itertations end then they overlap
         * // thus return 'false'
         * if (last != null && i.start < last.end) {
         * return false;
         * }
         * last = i;
         * }
         * // if they don't overlap then return true
         * return true;
         */

        // 2. for loop
        // Note: keep index out of bound exception in mind
        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i].end > intervals[i + 1].start)
                return false;
        }
        return true;
    }
}