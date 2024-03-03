package programmers;

import java.util.Arrays;
import java.util.stream.Collectors;

public class P42746 {

	class Solution {
		public String solution(int[] numbers) {

			return Arrays.stream(numbers)
				.mapToObj(String::valueOf)
				.sorted((s1, s2) -> {
					int original = Integer.valueOf(s1 + s2);
					int reversed = Integer.valueOf(s2 + s1);

					return reversed - original;
				}).collect(Collectors.joining(""))
				.replaceAll("^0+", "0");
		}
	}
}
