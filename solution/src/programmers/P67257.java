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
			// return switch (op) {
			// 	case "+" -> lhs + rhs;
			// 	case "-" -> lhs - rhs;
			// 	case "*" -> lhs * rhs;
			// 	default -> 0;
			// };
			return 1;
		}
	}

	/*
    연산자 우선순위를 정한다. 연산자 3개 -> 3!가지
    결과가 음수라면 절대값으로 변환
    제출 점수가 가장 큰 참가자 우승
    1. 연산자를 기준으로 분리한다.(연산자가 포함 돼 있어야한다.)
    100,-,200,*,300,-,500,+,20
    2. 총 6가지 우선순위를 순회하며 계산을 한다.
    ex) +,-,* 순서 -> 순회하며 +를 만나면 계산 후 값을 그 위치에 넣는다...
    3. 최대값을 갱신한다.(long)
    */
	class Solution2 {

		static final List<String[]> precedences = new ArrayList<>();

		public long solution(String expression) {
			List<String> tokens = split(expression);
			generatePre(0, "+-*".split(""), new boolean[3], new String[3]);

			long answer = Long.MIN_VALUE;

			for (String[] pre : precedences) {
				long value = calculate(pre, new ArrayList<>(tokens));
				answer = Math.max(answer, Math.abs(value));
			}
			return answer;
		}

		private long calculate(String[] pre, List<String> tokens) {
			for (String op : pre) {
				for (int i = 0; i < tokens.size(); i++) {
					if (op.equals(tokens.get(i))) {
						long a = Long.parseLong(tokens.get(i - 1));
						long b = Long.parseLong(tokens.get(i + 1));
						long result = 0;
						switch (op) {
							case "+" -> result = a + b;
							case "-" -> result = a - b;
							case "*" -> result = a * b;
						}
						tokens.remove(i - 1);
						tokens.remove(i - 1);
						tokens.remove(i - 1);
						tokens.add(i - 1, Long.toString(result));
						i -= 2;
					}
				}
			}
			return Long.parseLong(tokens.get(0));
		}

		private List<String> split(String expression) {
			StringTokenizer tokens = new StringTokenizer(expression, "+-*", true);
			List<String> words = new ArrayList<>();
			while (tokens.hasMoreElements()) {
				words.add(tokens.nextToken());
			}
			return words;
		}

		private void generatePre(int depth, String[] cand, boolean[] visit, String[] orders) {
			if (depth == cand.length) {
				precedences.add(orders.clone());
				return;
			}

			for (int i = 0; i < cand.length; i++) {
				if (visit[i]) continue;
				orders[depth] = cand[i];
				visit[i] = true;
				generatePre(depth + 1, cand, visit, orders);
				visit[i] = false;
			}
		}
	}
}
