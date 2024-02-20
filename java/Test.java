public class Test {

	/*
	P : 응시자, O : 빈테이블, X : 파티션
	1. 응시자의 위치를 찾는다.
	2. 상하좌우를 확인
	3. 이동할 수 있는 곳이면 그곳에서 다시 상하좌우 확인(이동한 방향은 확인 x)
	 */
	class Solution {
		public int[][] solution(int[][] arr1, int[][] arr2) {
			int[][] answer = new int[arr1.length][arr2[0].length];

			for (int i = 0; i < answer.length; i++) {
				for (int j = 0; j < answer[i].length; j++) {
					answer[i][j] = 0;

					for (int k = 0; k < arr1[i].length; k++) {
						answer[i][j] += arr1[i][k] * arr2[k][j];
					}
				}
			}

			return answer;
		}
	}
}
