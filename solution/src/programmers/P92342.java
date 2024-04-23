package programmers;

public class P92342 {
	/*
어피치가 해당 점수를 가져가느냐 못가저가느냐
어치피가 해당 점수판을 맞춘 화살 수 >= 라이언 해당 점수 화살 수 => 어피치 점수
맞춘 화살이 0일 경우 그 점수는 누구도 갖지 못한다.
1. 점수를 순회하며 어피치가 해당 점수를 얻을 것인지 결정
2. 점수가 결정되면 어피치가 우승시 점수차를 최대로 갱신 / 라이언 우승시 [-1] 리턴
3. 최대로 갱신할 때 같은경우 -> 가장 낮은 점수를 더 많이 맞힌 경우를 저장
*/
	class Solution {

		static int maxGap = Integer.MIN_VALUE;
		static int[] answer;
		static int[] ryan;

		private int calcScoreGap(int[] apeach) {
			int apeachScore = 0;
			int ryanScore = 0;

			for (int i = 0; i < 11; i++) {
				if (apeach[i] == 0 && ryan[i] == 0)
					continue;
				if (apeach[i] >= ryan[i])
					apeachScore += 10 - i;
				else
					ryanScore += 10 - i;
			}

			return ryanScore - apeachScore;
		}

		private void dfs(int k, int arrows, int[] apeach) {
			if (k == 11 || arrows == 0) {
				// 모든 점수 확인
				int[] cand = ryan.clone();
				cand[10] += arrows;
				int gap = calcScoreGap(apeach);
				if (gap <= 0)
					return;
				if (gap > maxGap) {
					maxGap = gap;
					answer = cand;
				} else if (gap == maxGap) {
					for (int i = 10; i >= 0; i--) {
						if (cand[i] < answer[i]) {
							return;
						} else if (ryan[i] > answer[i]) {
							answer = cand;
							return;
						}
					}
				}
				return;
			}

			for (int i = k; i < 11; i++) {
				//i번 과녁
				if (arrows > apeach[i]) {
					ryan[i] = apeach[i] + 1;
					dfs(i + 1, arrows - ryan[i], apeach);
					ryan[i] = 0;
				}
				dfs(i + 1, arrows, apeach);
			}
		}

		public int[] solution(int n, int[] info) {
			ryan = new int[11];
			answer = new int[] {-1};
			dfs(0, n, info);
			return answer;
		}
	}
}
