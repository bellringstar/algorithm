package programmers;

import java.util.Arrays;

public class P60062 {
/*
어디서, 어느방향으로, 이동거리 => 해당 영역에서 커버되는 취약지점
방향은 고려 x = 10 -> 1로 가나 1 -> 10으로 가나 똑같다.
원형구조 -> 범위 확장 선형구조
1. 배치할 친구의 순서를 정한다.
2. 취약지점에 배치해 취약지점을 제거한다
*/
	static class Solution {

		private static int length, answer;
		private static int[] Weak;
		private static boolean[] used;

		private static boolean check(int[] dist) {
			// dist로 모든 취약지점 커버 가능한가
			for (int i = 0; i < length; i++) {
				// 시작점 이동
				int idx = i;
				for (int distance : dist) {
					int position = Weak[idx++] + distance;
					while (idx < Weak.length && Weak[idx] <= position) {
						idx++;
					}
				}
				if (idx - i >= length) return true;
			}
			return false;
		}

		private static void backtrack(int n, int[] dist, int[] org) {
			if (n == org.length) {
				if (check(dist)) {
					answer = n;
				}
				return;
			}
			for (int i = 0; i < org.length; i++) {
				if (!used[i]) {
					used[i] = true;
					dist[n] = org[i];
					backtrack(n + 1, dist, org);
					used[i] = false;
				}
			}
		}

		public static int solution(int n, int[] weak, int[] dist) {
			length = weak.length;
			Weak = new int[length * 2];
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < length; j++) {
					Weak[j + (i * length)] = weak[j] + (i * n);
				}
			}
			Arrays.sort(dist);
			answer = -1;
			used = new boolean[dist.length];

			for (int i = 1; i < dist.length; i++) {
				int[] org = new int[i];
				System.arraycopy(dist, dist.length - i, org, 0, i);
				backtrack(0, new int[i], org);
				if (answer > 0) break;
			}

			return answer;
		}
	}
}
