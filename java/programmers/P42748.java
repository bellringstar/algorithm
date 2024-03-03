package programmers;

import java.util.Arrays;

public class P42748 {

	class Solution {
		public int[] solution(int[] array, int[][] commands) {
			int[] answer = new int[commands.length];
			int idx = 0;

			for (int[] command : commands) {
				int targetIdx = command[2] - 1;
				int start = command[0];
				int end = command[1];

				int[] slicedArray = slice(array, start, end);
				Arrays.sort(slicedArray);
				answer[idx++] = slicedArray[targetIdx];
			}

			return answer;

		}

		private int[] slice(int[] array, int start, int end) {
			int[] arr = new int[end - start + 1];

			int idx = 0;
			for (int i = start - 1; i < end; i++) {
				arr[idx++] = array[i];
			}
			return arr;
		}

		public int[] solution2(int[] array, int[][] commands) {
			int[] answer = new int[commands.length];

			for (int i = 0; i < answer.length; i++) {
				int[] command = commands[i];
				int from = command[0] - 1;
				int to = command[1];
				int k = command[2] - 1;

				int[] sub = Arrays.copyOfRange(array, from, to);
				Arrays.sort(sub);
				answer[i] = sub[k];
			}
			return answer;
		}

	}
}
