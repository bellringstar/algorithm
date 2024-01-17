public class LC344 {
	class Solution {
		public void reverseString(char[] s) {
			for (int i = 0; i < s.length / 2; i++) {
				swap(s, i, s.length-1-i);
			}
		}

		public void swap(char[] s, int start, int end) {
			char c1 = s[start];
			s[start] = s[end];
			s[end] = c1;
		}
	}
}
