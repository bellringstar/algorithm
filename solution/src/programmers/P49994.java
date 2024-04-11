package programmers;

import java.util.HashSet;
import java.util.Set;

/*
처음 걸어본 길의 길이 => 이동한 경로를 관리해야한다.
1. (0,0) 시작 dirs를 순회하며 이동
2. 범위를 벗어나면 패스
3. 범위 내라면 해당 이동 경로를 저장
만약 이미 존재하는 경로라면 cnt 그대로 새로운 길이라면 cnt 증가
*/
public class P49994 {

	class Solution {
		private boolean isValid(int nx, int ny) {
			return nx >= -5 && nx <= 5 && ny >= -5 && ny <= 5;
		}

		private String generateKey(int x, int y, int nx, int ny) {
			return x + "," + y + " " + nx + "," + ny;
		}

		public int solution(String dirs) {
			Set<String> route = new HashSet<>();
			int cnt = 0;
			int x = 0;
			int y = 0;
			for (char d : dirs.toCharArray()) {
				int nx = x;
				int ny = y;
				if (d == 'U') {
					ny = y + 1;
				} else if (d == 'D') {
					ny = y - 1;
				} else if (d == 'L') {
					nx = x - 1;
				} else {
					nx = x + 1;
				}

				if (!isValid(nx, ny))
					continue;
				String key = generateKey(x, y, nx, ny);
				if (!route.contains(key)) {
					route.add(key);
					route.add(generateKey(nx, ny, x, y));
					cnt++;
				}
				x = nx;
				y = ny;
			}

			return cnt;
		}
	}
}
