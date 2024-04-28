package programmers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class P92345 {

	/*
	발판으로 이동 -> 기존 발판은 사라짐 -> 발판을 0과 1로 상태 표시
	번갈아가며 상하좌우 이동 -> 번갈아 가며 동작하는 것 구현
	패배 조건
	1. 자신의 차례에서 움직일 수 없을 때
	2. 자신의 차례인데 발판이 사라진 경우
	-> 자신의 차례에 현재 상태를 확인해 패배처리 가능
	최적의 플레이 -> 이길 수있는 플레이어, 질 수밖에 없는 플레이어 -> 어떻게 판단? ->

	*/

	class Solution {

		static class Result {
			boolean win;
			int step;

			public Result(boolean win, int step) {
				this.win = win;
				this.step = step;
			}
		}

		private static int ROW, COL;

		private static final int[] DR = {0, 1, 0, -1};
		private static final int[] DC = {-1, 0, 1, 0};
		private static boolean[][] visited;
		private static int[][] Board;

		private static boolean isValidPos(int r, int c) {
			return 0 <= r && r < ROW && 0 <= c && c < COL;
		}

		private static Result recursive(int[] alpha, int[] beta, int step) {
			int[] now = step % 2 == 0 ? alpha : beta;
			boolean canMove = false;
			boolean isOpponentWinner = true;

			List<Integer> winSteps = new ArrayList<>();
			List<Integer> loseSteps = new ArrayList<>();

			for (int i = 0; i < 4; i++) {
				int nr = now[0] + DR[i];
				int nc = now[1] + DC[i];
				if (isValidPos(nr, nc) && !visited[nr][nc] && Board[nr][nc] == 1) {
					canMove = true;
					if (alpha[0] == beta[0] && alpha[1] == beta[1]) {
						return new Result(true, step + 1);
					}
					visited[now[0]][now[1]] = true;
					Result result = step % 2 == 0 ? recursive(new int[] {nr, nc}, beta, step + 1) :
						recursive(alpha, new int[] {nr, nc}, step + 1);
					visited[now[0]][now[1]] = false;

					isOpponentWinner &= result.win;
					if (result.win) {
						winSteps.add(result.step);
					} else {
						loseSteps.add(result.step);
					}
				}
			}

			if (!canMove) {
				return new Result(false, step);
			}

			if (isOpponentWinner) {
				return new Result(false, winSteps.stream().max(Comparator.comparingInt(o -> o)).get());
			}

			return new Result(true, loseSteps.stream().min(Comparator.comparingInt(o -> o)).get());
		}

		public int solution(int[][] board, int[] aloc, int[] bloc) {
			Board = board;
			ROW = board.length;
			COL = board[0].length;
			visited = new boolean[ROW][COL];
			return recursive(aloc, bloc, 0).step;
		}
	}
}
