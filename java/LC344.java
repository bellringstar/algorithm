public class LC344 {
	class Solution {
		public void reverseString(char[] s) {
			for (int i = 0; i < s.length/2; i++) {
				char tmp = s[i];
				s[i] = s[s.length-1-i];
				s[s.length-1-i] = tmp;
			}
		}
	}

	class Solution2 {
		public void reverseString(char[] s) {
			int start = 0;
			int end = s.length - 1;
			while (start < end) {
				char tmp = s[start];
				s[start] = s[end];
				s[end] = tmp;
				start++;
				end--;
			}
		}
	}
}
