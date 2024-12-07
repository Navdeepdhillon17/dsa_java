# Best Time to Buy and Sell Stock

## Problem Description
The goal of this program is to find the maximum profit that can be achieved by buying and selling a stock once. You are given an array `prices`, where `prices[i]` represents the stock price on the `i-th` day. 

- You can only buy and sell the stock once.
- You must buy the stock before selling it.

### Example
#### Input:
```plaintext
prices = [3, 2, 6, 5, 0, 7]
```

#### Output:
```plaintext
Profit is: 7
```

#### Explanation:
- Buy the stock at price `0` (day 5).
- Sell it at price `7` (day 6).
- Maximum profit = `7 - 0 = 7`.

---

## How the Code Works
The program uses a **single-pass algorithm** with a time complexity of `O(n)` to find the maximum profit.

### Code Walkthrough

1. **Initialization**:
   - `buyingPrice`: Keeps track of the lowest price encountered so far (initially set to the first price in the array).
   - `profit`: Tracks the maximum profit calculated so far (initially set to `0`).

2. **Iterating Through Prices**:
   - Start from the second day (index 1) and loop through the prices array.

3. **Updating `buyingPrice`**:
   - For every price, check if it's smaller than the current `buyingPrice`.
   - If so, update `buyingPrice` since this is now the best price to buy the stock.
   - **Why No Profit Calculation Here?**
     - When you update the `buyingPrice`, it means you're resetting the potential buy point.
     - You cannot sell the stock on the same day you buy it, so there's no valid profit calculation at this step.
     - The profit is calculated on subsequent iterations when a higher price (potential sell point) is encountered.

4. **Calculating Profit**:
   - If the current price is higher than `buyingPrice`, calculate the profit (`prices[i] - buyingPrice`).
   - Compare the calculated profit (`updatedProfit`) with the current `profit`. Update `profit` if `updatedProfit` is larger.

5. **Return the Result**:
   - After looping through all the prices, return the `profit`.

---

## Code
```java
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
```

---

## Explanation of Key Parts
1. **Initialization**:
   ```java
   int buyingPrice = prices[0];
   int profit = 0;
   ```
   - `buyingPrice` starts with the first price in the array.
   - `profit` is initially set to `0` because no transactions have been made yet.

2. **Finding the Minimum Price**:
   ```java
   if (prices[i] < buyingPrice) {
       buyingPrice = prices[i];
   }
   ```
   - Updates `buyingPrice` whenever a lower price is encountered.
   - **No profit calculation here**, because if you're "buying" at this point, you cannot "sell" the stock on the same day. The profit calculation will be handled in subsequent iterations.

3. **Calculating Maximum Profit**:
   ```java
   int updatedProfit = prices[i] - buyingPrice;
   if (updatedProfit > profit) {
       profit = updatedProfit;
   }
   ```
   - Calculates the profit for the current price and updates `profit` if the new profit is higher.

---

## Complexity Analysis
1. **Time Complexity**:
   - The program runs in `O(n)` because it traverses the array only once.
   
2. **Space Complexity**:
   - The program uses `O(1)` extra space because no additional data structures are used.

---

## Edge Cases
1. **Empty or Small Array**:
   - If the array has fewer than 2 prices, no transactions can be made, and the profit is `0`.

2. **Constant Prices**:
   - Example: `[5, 5, 5, 5]`
   - Maximum profit is `0` because no profitable transaction is possible.

3. **Decreasing Prices**:
   - Example: `[9, 7, 5, 3]`
   - Maximum profit is `0` because the stock price only decreases, so no profit can be made.

---

## Input/Output Examples

### Example 1:
#### Input:
```plaintext
prices = [3, 2, 6, 5, 0, 7]
```

#### Output:
```plaintext
Profit is: 7
```

---

### Example 2:
#### Input:
```plaintext
prices = [7, 6, 4, 3, 1]
```

#### Output:
```plaintext
Profit is: 0
```
#### Explanation:
- Prices are in decreasing order, so no profit can be made.

---

### Example 3:
#### Input:
```plaintext
prices = [1, 2, 3, 4, 5]
```

#### Output:
```plaintext
Profit is: 4
```
#### Explanation:
- Buy at `1` (day 1), sell at `5` (day 5).
- Maximum profit = `5 - 1 = 4`.
