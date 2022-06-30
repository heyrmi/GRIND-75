class Solution {
    /**
     * Time Complexity O(n) : 1 loop
     * Space Complexity O(1)
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {

        // 1. check if we even have a solution available
        int isSolutionPossible = 0;
        for (int i = 0; i < gas.length; i++) {
            isSolutionPossible += gas[i] - cost[i];
        }

        // if we dont have the delta (gas - cost) then we wont be able to move thus
        // return -1
        if (isSolutionPossible < 0) {
            return -1;
        }

        // 2. Since we are guranteed that we have one solution thus checking whats the
        // solution here
        // Find where to start
        int start = 0;
        int tank = 0;
        for (int i = 0; i < gas.length; i++) {
            tank += gas[i] - cost[i];

            // if tank value is negative you won't be able to move forward
            if (tank < 0) {
                // move start index
                start = i + 1;
                // update tank
                tank = 0;
            }
        }
        // now we have found the solution
        return start;
    }
}