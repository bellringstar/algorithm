package programmers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class P42840 {

	class Solution {
		public int[] solution(int[] answers) {

			Person person1 = new Person(1, 0, new int[] {1, 2, 3, 4, 5});
			Person person2 = new Person(2, 0, new int[] {2, 1, 2, 3, 2, 4, 2, 5});
			Person person3 = new Person(3, 0, new int[] {3, 3, 1, 1, 2, 2, 4, 4, 5, 5});

			List<Person> persons = new ArrayList<>();
			persons.add(person1);
			persons.add(person2);
			persons.add(person3);

			int maxScore = Integer.MIN_VALUE;

			for (Person p : persons) {
				compareScore(p, answers);
				if (p.score > maxScore)
					maxScore = p.score;
			}

			List<Integer> result = new ArrayList<>();
			for (Person p : persons) {
				if (maxScore == p.score) {
					result.add(p.number);
				}
			}

			int[] answer = new int[result.size()];

			for (int i = 0; i < answer.length; i++) {
				answer[i] = result.get(i);
			}
			return answer;

		}

		static class Person {
			int number;
			int score;
			int[] chooseList;

			public Person(int number, int score, int[] chooseList) {
				this.number = number;
				this.score = score;
				this.chooseList = chooseList;
			}
		}

		private void compareScore(Person person, int[] answer) {
			int score = 0;
			for (int i = 0; i < answer.length; i++) {
				if (answer[i] == person.chooseList[i % person.chooseList.length])
					score++;
			}
			person.score = score;
		}
	}

	class Solution2 {
		private static final int[][] RULES = {
			{1, 2, 3, 4, 5},
			{2, 1, 2, 3, 2, 4, 2, 5},
			{3, 3, 1, 1, 2, 2, 4, 4, 5, 5},
		};

		public int[] solution(int[] answers) {
			int[] corrects = new int[3];
			int max = 0;

			for (int problem = 0; problem < answers.length; problem++) {
				int answer = answers[problem];

				for (int person = 0; person < 3; person++) {
					int picked = getPicked(person, problem);
					if (answer == picked) {
						if (++corrects[person] > max) {
							max = corrects[person];
						}
					}
				}
			}

			final int maxCorrects = max;
			return IntStream.range(0, 3)
				.filter(i -> corrects[i] == maxCorrects)
				.map(i -> i + 1)
				.toArray();
		}

		private int getPicked(int person, int problem) {
			int[] rule = RULES[person];
			int index = problem % rule.length;
			return rule[index];
		}

	}
}
