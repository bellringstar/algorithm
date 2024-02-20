package programmers;

public class P81302 {
	/*
	두 사람 사이에 파티션이 존재 -> 거리가 2 이하여도 ok
	응시자 p, 테이블 o, 파티션 x
	1. 각 장소별로 거리두기가 잘 돼있는지 확인 -> 확인하는 메서드 작성, 5번 반복. 리턴은 0 or 1 -> ex [1, 0, 1, 1, 1]
	 */

	class Solution {

		private static final int[] dx = {0, 1, -1, 0};
		private static final int[] dy = {-1, 0, 0, 1};

		public int[] solution(String[][] places) {

			int[] answer = new int[places.length];

			for (int i = 0; i < places.length; i++) {
				String[] place = places[i];
				char[][] room = new char[place.length][];
				for (int j = 0; j < room.length; j++) {
					room[j] = place[j].toCharArray();
				}

				// 거리 확인 로직
				if (isDistanced(room)) {
					answer[i] = 1;
				} else {
					answer[i] = 0;
				}
			}
			return answer;
		}

		private boolean isDistanced(char[][] room) {

			for (int y = 0; y < room.length; y++) {
				for (int x = 0; x < room.length; x++) {
					if (room[y][x] != 'P')
						continue;
					// 응시자 위치 확인완료. 응시자 기준으로 상하좌우 확인
					if (!isDistanced(room, x, y))
						return false;
				}
			}

			return true;
		}

		private boolean isDistanced(char[][] room, int x, int y) {
			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				if (ny < 0 || ny >= room.length || nx < 0 || nx >= room[ny].length)
					continue;

				switch (room[ny][nx]) {
					case 'P':
						return false;
					case 'O':
						// 비어있으니 해당 위치에서 다시 한번 탐색
						if (isNextVolunteer(room, nx, ny, 3 - d))
							return false;
						break;
				}
			}
			return true;
		}

		private boolean isNextVolunteer(char[][] room, int x, int y, int exclude) {
			for (int d = 0; d < 4; d++) {
				if (d == exclude)
					continue;

				int nx = x + dx[d];
				int ny = y + dy[d];

				if (ny < 0 || ny >= room.length || nx < 0 || nx >= room[ny].length)
					continue;

				if (room[ny][nx] == 'P')
					return true;

			}
			return false;
		}
	}
}
