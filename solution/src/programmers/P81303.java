package programmers;

/*
명령의 개수가 20만개 -> 시뮬레이션시 시간초과
위치 = 상대적
각 인덱스별로 up,down 배열로 관리
1. U, D -> 해당 횟수만큼 배열을 재귀
2. C -> 현재 위치의 정보를 스택에 저장, up, down 배열 갱신
3. Z -> 스택에서 정보를 꺼내 up, down 배열 갱신
*/

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class P81303 {
	class Solution {
		public String solution(int n, int k, String[] cmd) {
			Deque<Integer> deleted = new ArrayDeque<>();
			int[] up = new int[n + 2];
			int[] down = new int[n + 2];

			for (int i = 0; i < n + 2; i++) {
				up[i] = i - 1;
				down[i] = i + 1;
			}

			k++;

			for (String c : cmd) {
				if (c.startsWith("C")) {
					deleted.addLast(k);
					up[down[k]] = up[k];
					down[up[k]] = down[k];
					k = n < down[k] ? up[k] : down[k];
				} else if (c.startsWith("Z")) {
					int restore = deleted.pollLast();
					down[up[restore]] = restore;
					up[down[restore]] = restore;
				} else {
					String[] s = c.split(" ");
					int x = Integer.parseInt(s[1]);
					for (int i = 0; i < x; i++) {
						k = s[0].equals("U") ? up[k] : down[k];
					}
				}
			}

			char[] answer = new char[n];
			Arrays.fill(answer, 'O');

			for (int i : deleted) {
				answer[i - 1] = 'X';
			}

			return new String(answer);
		}
	}
}
