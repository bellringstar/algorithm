package programmers;

public class P12980 {
/*
최초는 반드시 1칸 앞으로 이동 필요
1이 될때까지 2로 나누면서 나머지를 더한다.
*/
	public class Solution {
		public int solution(int n) {
			int ans = 1;
			while (n != 1) {
				ans += n%2;
				n /= 2;
			}

			return ans;
		}
	}

	public int solution2(int n) {
		return Integer.toBinaryString(n).replace("0", "").length();
	}
}
