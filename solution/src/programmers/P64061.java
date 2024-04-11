package programmers;
/*
* 각 인형뽑는 위치를 스택으로 관리. 박스도 스택으로 관리
* 박스의 peek와 넣을 인형이 같으면 poll 하고 정답의 개수 증가
* */

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class P64061 {
	class Solution {
		public int solution(int[][] board, int[] moves) {
			Map<Integer, Deque<Integer>> boardMap = new HashMap<>();
			for (int i = 1; i <= board.length; i++) {
				boardMap.put(i, new ArrayDeque<>());
			}

			for (int i = 0; i < board.length; i++) {
				Deque<Integer> deque = boardMap.get(i + 1);
				for (int j = 0; j < board.length; j++) {
					if (board[j][i] != 0) {
						deque.addFirst(board[j][i]);
					}
				}
			}

			Deque<Integer> box = new ArrayDeque<>();
			int cnt = 0;
			for (int m : moves) {
				Deque<Integer> stack = boardMap.get(m);
				if (stack.isEmpty()) continue;
				int item = stack.pollLast();
				if (!box.isEmpty() && box.peekLast() == item) {
					box.pollLast();
					cnt++;
				} else {
					box.addLast(item);
				}
			}
			return cnt * 2;
		}
	}
}
