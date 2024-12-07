class Solution {
    public static int maxProfit(int[] prices) {
        int buyingPrice = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < buyingPrice) {
                buyingPrice = prices[i]; // Update to the lowest price found so far
            } else {
                int updatedProfit = prices[i] - buyingPrice; // Calculate profit
                if (updatedProfit > profit) {
                    profit = updatedProfit; // Update max profit
                }
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] prices = {3, 2, 6, 5, 0, 7};
        System.out.println("Profit is: " + maxProfit(prices));
    }
}
