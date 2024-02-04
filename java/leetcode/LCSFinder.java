package leetcode;

public class LCSFinder {

	public int findLCSWithOneModification(String X, String Y) {
		int m = X.length();
		int n = Y.length();
		int[][] dp = new int[m + 1][n + 1];

		// 기본 LCS 계산
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (X.charAt(i - 1) == Y.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}

		// 문자 변경 고려
		int maxLength = dp[m][n];
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (X.charAt(i - 1) != Y.charAt(j - 1)) {
					// 변경하여 매칭되는 경우를 탐색
					int potentialLength = dp[i - 1][j - 1];
					if (i < m) {
						potentialLength += 1 + dp[m][n] - dp[i][j];
					}
					maxLength = Math.max(maxLength, potentialLength);
				}
			}
		}

		return maxLength;
	}

	public static void main(String[] args) {
		LCSFinder finder = new LCSFinder();
		String X = "ACCABCBA";
		String Y = "CABCAB";

		int result = finder.findLCSWithOneModification(X, Y);
		System.out.println("The length of the longest common subsequence is: " + result);
	}
}
