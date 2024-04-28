package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

	class Solution2 {
		public String solution(int[] numbers) {
			List<String> lst = new ArrayList<>();
			for (int number : numbers) {
				lst.add(String.valueOf(number));
			}

			lst.sort((num1, num2) -> {
				int a = Integer.parseInt(num1 + num2);
				int b = Integer.parseInt(num2 + num1);
				return Integer.compare(b, a);
			});

			StringBuilder sb = new StringBuilder();
			for (String s : lst) {
				sb.append(s);
			}


			return sb.charAt(0) == '0' ? "0" : sb.toString();
		}
	}
}
