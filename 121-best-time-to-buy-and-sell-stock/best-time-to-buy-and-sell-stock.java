class Solution {
    /*
    Input: array of ints where value is price of stock on give day(index)
    Output: maximum profit that can be achieved, if none possible -> 0
    Constraints: only one transaction completed, stock must be sold after bought,
    prices of stock will always be positive
    Ex. [4, 3, 6, 2, 5, 12, 0, 4] -> 10
            ^  ^

    Ex. [10, 4, 3, 2, 1, 0] -> 0

    Approach: window that keeps track of max profit
    - minimize the price of buying a stock, and maximizing sell -> buy low, sell high
    - move left pointer to right pointer when right value becomes smaller than left
    - always increment the right pointer by one
     */
    public int maxProfit(int[] stocks) {
        int left = 0;
        int right = 0;
        int maxProfit = 0;

        while (right < stocks.length) {
            maxProfit = Math.max(maxProfit, stocks[right] - stocks[left]);
            if (stocks[right] < stocks[left]) {
                left = right;
            }
            right++;
        }

        return maxProfit;
    }
}