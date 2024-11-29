package leetcode;

public class LC1071 {
	/*
	 * 1. 두 문자에서 공통으로 등장하는 문자를 찾아야한다.
	 * 2. 해당 문자로 두 문자열이 분해가 되는지 확인해야한다.
	 * s = t + t + ... + t + t 인것이고 이 조건을 str1, str2 모두 만족하는 t 중 가장 길이가 긴 t를 찾아야 한다.
	 * 그렇다면 s = str1 + str2를 합친 문자열도 t로 분할이 될 것이다. 그리고 t로 s가 나누어떨어져야 한다.
	 * 또한 만약 str1 + str2 != str2 + str1이라면 t로 분할할 수 없다는 것이 된다.
	 * */
	class Solution {
		public String gcdOfStrings(String str1, String str2) {
			if (!(str1 + str2).equals((str2 + str1))) {
				return "";
			}
			String s = str1 + str2;

			int gcdLength = gcd(str1.length(), str2.length());

			return str1.substring(0, gcdLength);
		}

		private int gcd(int a, int b) {
			while (b != 0) {
				int tmp = b;
				b = a % b;
				a = tmp;
			}
			return a;
		}
	}
}
