package programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
1. 트리를 구성한다.
2. seller와 amount를 통해 이익과 수익을 계산
3. 부모로 거슬러 올라가면서 이익 갱신
*/

public class P77486 {

	class Solution {
		static class Node {
			Node parent;
			int profit;
			List<Node> children = new ArrayList<>();
		}

		private void getProfit(Node node, int money) {
			int up = (int)(money * 0.1);
			int profit = money - up;
			node.profit += profit;


			if (node.parent != null) {
				getProfit(node.parent, up);
			}
		}

		public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
			Map<String, Node> nodeMap = new HashMap<>();
			nodeMap.put("root", new Node());
			for (int i = 0; i < enroll.length; i++) {
				Node node = new Node();
				Node parent = null;
				String p = referral[i];
				if (p.equals("-")) {
					parent = nodeMap.get("root");
				} else {
					parent = nodeMap.get(p);
				}
				node.parent = parent;
				parent.children.add(node);
				nodeMap.put(enroll[i], node);
			}

			for (int i = 0; i < seller.length; i++) {
				getProfit(nodeMap.get(seller[i]), amount[i] * 100);
			}

			int[] answer = new int[enroll.length];
			for (int i = 0; i < answer.length; i++) {
				answer[i] = nodeMap.get(enroll[i]).profit;
			}
			return answer;
		}
	}

	class Solution2 {
		public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
			Map<String, String> parent = new HashMap<>();
			for (int i = 0; i < enroll.length; i++) {
				parent.put(enroll[i], referral[i]);
			}

			Map<String, Integer> total = new HashMap<>();

			for (int i = 0; i < seller.length; i++) {
				String curName = seller[i];
				int money = amount[i] * 100;
				while (money > 0 && !curName.equals("-")) {
					total.put(curName, total.getOrDefault(curName, 0) + money - (money / 10));
					curName = parent.get(curName);
					money /= 10;
				}
			}

			int[] answer = new int[enroll.length];
			for (int i = 0; i < enroll.length; i++) {
				answer[i] = total.getOrDefault(enroll[i], 0);
			}
			return answer;
		}
	}
}
