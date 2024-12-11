public class Solution {
    public static int maxProfit(int[] prices){
        int profit = 0;
        for(int i = 1; i<prices.length; i++){
            if(prices[i] > prices[i-1]){
                profit += prices[i] - prices[i-1];
            }
        }
        System.out.println("profit " + profit);
        return profit;
    }

    public static void main(String[] args) {
        int[] prices = {1,2,3,4,5};
         maxProfit(prices);
    }
}
