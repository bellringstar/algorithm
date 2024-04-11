package programmers;

import java.util.ArrayDeque;
import java.util.Queue;
/*
card1, card2를 q로 만들어서 peek가 원하는 단어이면 poll
원하는 단어가 없다면 => No 리턴
*/
public class P159994 {
	class Solution {
		public String solution(String[] cards1, String[] cards2, String[] goal) {

			Queue<String> q1 = new ArrayDeque<>();
			Queue<String> q2 = new ArrayDeque<>();
			for (String card : cards1) {
				q1.add(card);
			}
			for (String card : cards2) {
				q2.add(card);
			}

			for (String word : goal) {
				if (!q1.isEmpty() && q1.peek().equals(word)) {
					q1.poll();
					continue;
				}

				if (!q2.isEmpty() && q2.peek().equals(word)) {
					q2.poll();
					continue;
				}

				return "No";
			}

			return "Yes";
		}
	}
}
