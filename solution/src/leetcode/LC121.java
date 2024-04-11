package leetcode;

public class LC121 {
	// 가격 배열이 주어졌을 때 최대 이익이 나는 날을 정해 주식을 사라
	// 이익이 없다면 0 을 리턴
	class Solution {
		public int maxProfit(int[] prices) {
			int profit = Integer.MIN_VALUE;
			int min = prices[0];
			for (int i = 1; i < prices.length; i++) {
				if (prices[i] < min) {
					min = prices[i];
				}
				profit = Math.max(profit, prices[i] - min);
			}
			if (profit < 0) {
				profit = 0;
			}
			return profit;
		}
	}
}
