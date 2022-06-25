class Solution {
    /**
     * Time Complexity O(n) : 1 loop
     * Space Complexity O(1)
     */
    public int maxProfit(int[] prices) {

        // Min value so far in the array
        int buyingValue = Integer.MAX_VALUE;

        // Selling value (must be max for max profit)
        // Also no need to check for the prices.length == 1
        // because 0 will be returned anyways
        int sellingValue = 0;

        for (int i = 0; i < prices.length; i++) {

            // At first, any min value lesser than Integer.max will be picked,
            // then we will get the least value after comparision with the whole array
            buyingValue = Math.min(buyingValue, prices[i]);

            // First any value >= 0 will be picked
            // then higher value will be picked
            // if values come out to be negative then max(-ve value, 0) will be picked
            // thus 0 will be picked
            // thus selling value never becomes -ve
            sellingValue = Math.max(sellingValue, prices[i] - buyingValue);
        }

        // reutrn the max value that you have obtained

        return sellingValue;
    }
}