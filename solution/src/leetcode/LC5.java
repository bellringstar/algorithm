package leetcode;

public class LC5 {
	class Solution {
		int longestLength = 0;
		int start;

		public void expand(String s, int i, int j) {
			while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
				i--;
				j++;
			}
			if (j - i - 1 > longestLength) {
				start = i + 1;
				longestLength = j - i - 1;
			}
		}

		public String longestPalindrome(String s) {
			if (s.length() < 2) {
				return s;
			}
			for (int i = 0; i < s.length() - 1; i++) {
				expand(s, i, i + 1);
				expand(s, i, i + 2);
			}
			return s.substring(start, start + longestLength);
		}
	}
}
