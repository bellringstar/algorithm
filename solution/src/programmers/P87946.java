package programmers;

public class P87946 {
/*
dfs를 사용해 탐색 깊이 갱신
1. 던전을 선택한다.
2. 그 던전의 최소 피로도와 자신의 피로도를 비교해 가능하면 탐색
3. 자신의 피로도를 소모 피로도만큼 제거하고 다음 던전 탐색
*/

	class Solution {

		static int result = 0;

		private void dfs(int depth, int k, int[][] dungeons, boolean[] visited) {
			result = Math.max(result, depth);

			for (int i = 0; i < dungeons.length; i++) {
				if (visited[i]) continue;
				if (k >= dungeons[i][0]) {
					visited[i] = true;
					dfs(depth + 1, k - dungeons[i][1], dungeons, visited);
					visited[i] = false;
				}
			}
		}

		public int solution(int k, int[][] dungeons) {
			dfs(0, k, dungeons, new boolean[dungeons.length]);
			return result;
		}
	}
}
