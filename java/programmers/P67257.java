package programmers;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P67257 {
	/*
	+, -, * 연산자의 우선순위 정하기
	계산 결과가 음수일시 절대값으로 변환하여 제출하고 제출한 숫자가 가장 큰 사람 우승

	결과값 = long
	연산자는 최대 3가지 뿐 -> 많아도 6가지 경우의 수만 계산해서 그중 최대를 찾으면 된다.

	1. 연산자의 우선순위를 반복하며 정한다.
	2. 반복 내에서 해당 운선순위로 계산을 한다
	3. 계산값의 절대값 중 최대를 리턴한다.
	 */

	class Solution {

		static final String[][] precedences = {
			"+-*".split(""), "+*-".split(""), "-+*".split(""),
			"-*+".split(""), "*-+".split(""), "*+-".split(""),
		};

		public long solution(String expression) {
			StringTokenizer tokenizer = new StringTokenizer(expression, "+*-", true);
			List<String> tokens = new ArrayList<>();
			while (tokenizer.hasMoreTokens()) {
				tokens.add(tokenizer.nextToken());
			}

			long max = 0;
			for (String[] precedence : precedences) {
				long value = Math.abs(calculate(new ArrayList<>(tokens), precedence));
				if (value > max) {
					max = value;
				}
			}
			return max;
		}

		private long calculate(List<String> tokens, String[] precedences) {
			for (String op : precedences) {
				for (int i = 0; i < tokens.size(); i++) {
					if (tokens.get(i).equals(op)) {
						long lhs = Long.parseLong(tokens.get(i - 1));
						long rhs = Long.parseLong(tokens.get(i + 1));
						long result = calculate(lhs, rhs, op);
						tokens.remove(i - 1);
						tokens.remove(i - 1);
						tokens.remove(i - 1);
						tokens.add(i - 1, String.valueOf(result));
						i -= 2;
					}
				}
			}
			return Long.parseLong(tokens.get(0));
		}

		private long calculate(long lhs, long rhs, String op) {
			return switch (op) {
				case "+" -> lhs + rhs;
				case "-" -> lhs - rhs;
				case "*" -> lhs * rhs;
				default -> 0;
			};
		}
	}

}
