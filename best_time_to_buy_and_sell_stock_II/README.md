# **Max Profit from Stock Prices - Problem Solution**

## **Problem Description**
Given an array of stock prices, where the `i`-th element represents the stock price on the `i`-th day, the goal is to determine the maximum profit that can be obtained by buying and selling the stock multiple times.

You are allowed to make multiple transactions, but **you cannot hold more than one stock at a time** (i.e., after selling a stock, you must wait until the next day to buy again).

## **Approach**
The problem can be approached using the **greedy algorithm** where we attempt to **buy at a low price and sell at a higher price** whenever the next day's price is higher than the current day's price.

### **Why This Approach Works**
- For each day, we compare the price with the previous day's price. 
- If the current day's price is **higher** than the previous day's price, it means we can **make a profit** by selling the stock at today's price after buying it at the previous day's price. So, we add the difference to our total profit.
- If the price is **lower** than the previous day's price, we **don't make a profit**, so we skip to the next day.

### **Key Observations:**
- This approach essentially captures all **small profits** in each price increase, and because there's no restriction on how many transactions we can make, it guarantees the maximum profit possible.

### **Code Explanation**
```java
public class Solution {
    public static int maxProfit(int[] prices){
        int profit = 0;
        // Iterate through the array of prices starting from the second day
        for(int i = 1; i < prices.length; i++){
            // If the current price is higher than the previous price
            if(prices[i] > prices[i-1]){
                // Add the difference to the profit
                profit += prices[i] - prices[i-1];
            }
        }
        System.out.println("Profit: " + profit);
        return profit;
    }

    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 4, 5};
        maxProfit(prices);  // Call maxProfit with the given prices array
    }
}
```

### **Algorithm Breakdown:**
1. **Initialization:**
   - The variable `profit` is initialized to `0`, which will hold the accumulated profit.
2. **Loop through the array:**
   - We start the loop from day `1` (second day) and compare the current price with the previous day's price.
   - If the current price is **higher**, we add the difference to `profit`.
3. **Return the total profit**:
   - After iterating through the entire array, the function returns the `profit`.

### **Why This Approach:**
- The approach of comparing the current price with the previous price and adding the difference when it is positive is efficient because it directly captures every opportunity to make a profit from **every increase in the price**.
  
- An **alternative approach** could involve checking both the previous day's and the next day's prices to determine whether to buy or sell. However, this would require additional checks and conditions to compare the prices for each day, making it more complex than the solution presented here. The current approach is simple and intuitive — buy a stock when the price is low and sell it when the price is higher on the next day.

---

## **Complexity Analysis**
- **Time Complexity:** `O(n)` where `n` is the length of the prices array. We iterate through the array once to calculate the total profit.
- **Space Complexity:** `O(1)` as we are only using a constant amount of extra space.

---

## **Example Walkthrough**
Given the array: `{1, 2, 3, 4, 5}`

### Iteration:
- **Day 1 to Day 2:** Price goes from 1 to 2 → Buy at 1, sell at 2 → Profit = 2 - 1 = 1
- **Day 2 to Day 3:** Price goes from 2 to 3 → Buy at 2, sell at 3 → Profit = 3 - 2 = 1
- **Day 3 to Day 4:** Price goes from 3 to 4 → Buy at 3, sell at 4 → Profit = 4 - 3 = 1
- **Day 4 to Day 5:** Price goes from 4 to 5 → Buy at 4, sell at 5 → Profit = 5 - 4 = 1

### Total Profit = 1 + 1 + 1 + 1 = 4

---

## **Conclusion**
This solution uses a simple greedy approach to calculate the maximum possible profit from stock prices, ensuring that we make the most profit by buying at the lowest price and selling at the highest price whenever possible.

