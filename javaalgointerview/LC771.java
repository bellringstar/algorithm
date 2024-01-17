import java.util.HashMap;
import java.util.Map;

public class LC771 {
	/*
	jewels = "aA"
	stones = "aAAbbbb"
	stones에 jewels가 몇개나 있나? -> a 1개 A 2개 = 3개
	 */
	class Solution {
		public int numJewelsInStones(String jewels, String stones) {
			Map<Character, Integer> stoneMap = new HashMap<>();
			for (int i = 0; i < stones.length(); i++) {
				stoneMap.put(stones.charAt(i), stoneMap.getOrDefault(stones.charAt(i), 0) + 1);
			}

			int answer = 0;
			for (int i = 0; i < jewels.length(); i++) {
				answer += stoneMap.getOrDefault(jewels.charAt(i), 0);
			}
			return answer;
		}
	}
}
