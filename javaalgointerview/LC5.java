public class LC5 {
	class Solution {
		int left, maxLen;
		public String longestPalindrome(String s) {
			int len = s.length();
			if (len < 2) return s;

			for (int i = 0; i < len; i++) {
				expandPalindrome(s, i, i+1);
				expandPalindrome(s, i, i+2);
			}
			return s.substring(left, left + maxLen);
		}

		public void expandPalindrome(String s, int l, int r) {
			while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
				l--;
				r++;
			}
			if (maxLen < r - l - 1) {
				left = left + 1;
				maxLen = r - l - 1;
			}
		}
	}
}
