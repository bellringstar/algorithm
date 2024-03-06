import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class P42627 {

	/*
	시작 시간 순으로 정렬한다.
	시간을 저장하면서 현재 시간 내에 실행할 수있는 일들 중 걸리는 시간이 가장 짧은 순으로 처리한다.
	 */

	class Solution {

		private static class Job {
			private final int start;
			private final int duration;

			public Job(int start, int duration) {
				this.start = start;
				this.duration = duration;
			}
		}

		public int solution(int[][] rawJobs) {
			Job[] jobs = new Job[rawJobs.length];

			for (int i = 0; i < jobs.length; i++) {
				jobs[i] = new Job(rawJobs[i][0], rawJobs[i][1]);
			}

			Arrays.sort(jobs, Comparator.comparingInt(job -> job.start));

			Queue<Job> q = new LinkedList<>(Arrays.asList(jobs));

			PriorityQueue<Job> pq = new PriorityQueue<>(Comparator.comparingInt(job -> job.duration));

			int time = 0;
			int exec = 0;

			while (!q.isEmpty() || !pq.isEmpty()) {
				while (!q.isEmpty() && q.peek().start <= time) {
					pq.add(q.poll());
				}

				if (pq.isEmpty()) {
					time = pq.peek().start;
					continue;
				}

				Job job = pq.poll();
				exec += time + job.duration - job.start;
				time += job.duration;
			}

			return exec / jobs.length;
		}
	}
}
