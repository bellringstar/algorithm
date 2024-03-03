import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class P86051 {

	class Solution {
		public int solution(int[] numbers) {
			Set<Integer> numberSet = IntStream.range(0, 10).boxed().collect(Collectors.toSet());

			for (int num : numbers) {
				numberSet.remove(num);
			}

			int sum = 0;

			for (int num : numberSet) {
				sum += num;
			}

			return sum;

		}
	}
}
