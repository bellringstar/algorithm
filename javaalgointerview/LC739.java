import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LC739 {
	/*
	더 따뜻한 날까지 며칠을 기다려야하는가. 만약 더 따뜻한 날이 없다면 0으로
	temperatures = [73,74,75,71,69,72,76,73]
	answer = [1,1,4,2,1,1,0,0]
	 */
	class Solution {
		public int[] dailyTemperatures(int[] temperatures) {
			List<List<Integer>> temperatureWithIndex = new ArrayList<>(temperatures.length);
			Deque<List<Integer>> stack = new ArrayDeque<>();
			int[] answer = new int[temperatures.length];
			for (int i = 0; i < temperatures.length; i++) {
				List<Integer> temperature = new ArrayList<>();
				temperature.add(temperatures[i]);
				temperature.add(i);
				temperatureWithIndex.add(temperature);
			}
			for (List<Integer> temp : temperatureWithIndex) {
				while (!stack.isEmpty() && stack.peekLast().get(0) < temp.get(0)) {
					int idx = stack.pollLast().get(1);
					answer[idx] = temp.get(1) - idx;
				}
				stack.addLast(temp);
			}
			return answer;
		}
	}

}
