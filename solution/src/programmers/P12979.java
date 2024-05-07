package programmers;

public class P12979 {
	class Solution {
		public int solution(int n, int[] stations, int w) {
			int answer = 0;
			int location = 1;
			int idx = 0;

			while (location <= n) {
				if (idx < stations.length && location >= stations[idx] - w) {
					location = stations[idx] + w + 1;
					idx++;
				} else {
					location += 2 * w + 1;
					answer++;
				}
			}
			return answer;
		}
	}
}
