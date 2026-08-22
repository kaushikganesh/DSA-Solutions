BestTimeToBuyAndSellStock121.java

Problem:

Given an array of integers prices, where prices[i] represents the price of a stock on the ith day, return the maximum profit that can be achieved by buying on one day and selling on a different day in the future.

If no profit is possible, return 0.


Example:

Input:

prices = [7,1,5,3,6,4]

Output:

5

Explanation:

The maximum profit is obtained by:

Buy  → 1
Sell → 6

Profit = 6 - 1
       = 5


Approach:

Use two variables:

min → stores the lowest price found so far.

profit → stores the maximum profit found so far.

For every price:

If the current price is smaller than min,
update min.

Otherwise, calculate the profit by:

current price - minimum price

Then compare the current profit with the previous maximum profit using Math.max().


Code:

class Solution {
    public int maxProfit(int[] prices) {

        int min = prices[0];
        int profit = 0;

        for (int i = 0; i < prices.length; i++) {

            if (prices[i] < min) {
                min = prices[i];
            }

            profit = Math.max(profit, prices[i] - min);
        }

        return profit;
    }
}


Important Line:

profit = Math.max(profit, prices[i] - min);

prices[i] - min
        ↓
Current price - Lowest price
        ↓
Profit possible today


Math.max(profit, prices[i] - min)
        ↓
Compare:
Previous maximum profit
        VS
Today's possible profit
        ↓
Keep the bigger value


Example:

prices = [7,1,5,3,6,4]

7:
min = 7
profit = 0

1:
1 < 7
min = 1
profit = 0

5:
5 - 1 = 4
Math.max(0, 4) = 4
profit = 4

3:
3 - 1 = 2
Math.max(4, 2) = 4
profit = 4

6:
6 - 1 = 5
Math.max(4, 5) = 5
profit = 5

4:
4 - 1 = 3
Math.max(5, 3) = 5
profit = 5


Algorithm:

1. Initialize min with prices[0].
2. Initialize profit with 0.
3. Traverse through the array.
4. Find the lowest price.
5. Calculate the profit using current price - min.
6. Compare the current profit with the previous profit.
7. Keep the maximum profit.
8. Return profit.


Easy Rule:

Find minimum price
        ↓
Buy at minimum price
        ↓
Check current price
        ↓
Calculate profit
        ↓
Compare with previous profit
        ↓
Keep maximum
        ↓
Continue


Complexity:

Time Complexity: O(n)

The array is traversed only once.
Therefore, each price is checked once.

Space Complexity: O(1)

Only two variables, min and profit, are used.
No extra array or data structure is required.



