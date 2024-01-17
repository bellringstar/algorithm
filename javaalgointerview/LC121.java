public class LC121 {
	class Solution {
		public int maxProfit(int[] prices) {
			int minValue = prices[0];
			int profit = Integer.MIN_VALUE;
			for (int i = 0; i < prices.length; i++) {
				minValue = Math.min(minValue, prices[i]);
				profit = Math.max(prices[i] - minValue, profit);
			}
			return profit;
		}
	}
}
