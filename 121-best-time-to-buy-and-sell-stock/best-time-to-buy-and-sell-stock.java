class Solution {
    public int maxProfit(int[] prices) {
        /*
        Input: array of integers where index is the day and value is the price
        Output: maximum profit that can be achieved
        prices are btwn 0 and 100, the nubmer of days is btwn 1 and 100

        Brute force -> calculating every single possibility and track the max profit

        currentMax = 3
        [1, 0, 4, 0, 2, 3, 6]
                  ^        ^ 
        -In order to max profit, buying low and selling high
        */
        int maxProfit = 0;
        int left = 0;
        int right = 1;
        while (right < prices.length) {
            while (prices[right] < prices[left] && right < prices.length - 1) {
                left = right;
                right++;
            }
            int currentProfit = prices[right] - prices[left];
            maxProfit = Math.max(currentProfit, maxProfit);
            right++;
        }

        return maxProfit;
    }
}