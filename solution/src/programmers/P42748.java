package programmers;

import java.util.Arrays;

public class P42748 {

    class Solution {
        public int[] solution(int[] array, int[][] commands) {

            int[] answer = new int[commands.length];

            for (int idx = 0; idx < commands.length; idx++) {
                int[] command = commands[idx];
                int i = command[0];
                int j = command[1];
                int k = command[2];
                int[] splicedArray = Arrays.copyOfRange(array, i - 1, j);

                Arrays.sort(splicedArray);
                answer[idx] = splicedArray[k - 1];
            }

            return answer;
        }
    }
}
