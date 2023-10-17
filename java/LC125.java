public class LC125 {

	class Solution {
		public boolean isPalindrome(String s) {
			StringBuilder sb = new StringBuilder();
			s = s.toLowerCase();
			for (int i = 0; i < s.length(); i++) {
				if (Character.isAlphabetic(s.charAt(i)) || Character.isDigit(s.charAt(i))) {
					sb.append(s.charAt(i));
				}
			}
			s = sb.toString();
			boolean flag = true;
			for (int i = 0; i < s.length() / 2; i++) {
				if (s.charAt(i) == s.charAt(s.length() - i - 1))
					continue;
				flag = false;
				break;
			}
			if (flag) {
				return true;
			} else {
				return false;
			}
		}
	}

	class Solution2 {
		public boolean isPalindrome(String s) {
			int start = 0;
			int end = s.length() - 1;
			while (start < end) {
				if (!Character.isLetterOrDigit(s.charAt(start))) {
					start++;
				} else if (!Character.isLetterOrDigit(s.charAt(end))) {
					end--;
				} else {
					if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) {
						return false;
					}
					start++;
					end--;
				}
			}
			return true;
		}
	}

	class Solution3 {
		public boolean isPalindrome(String s) {
			String filteredS = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
			StringBuilder sb = new StringBuilder(filteredS);
			String reversedS = sb.reverse().toString();
			return filteredS.equals(reversedS);
		}
	}

}
