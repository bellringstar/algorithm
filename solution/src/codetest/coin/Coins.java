package codetest.coin;

public class Coins {

    public static int calculateChange(int n) {
        if (n <= 0) {
            return -1;
        }

        int[] coins = {25, 10, 5, 1};
        return calculateChange(n, coins, 0);
    }

    private static int calculateChange(int amount, int[] coins, int position) {
        if (position >= coins.length - 1) {
            return 1;
        }

        int coin = coins[position];
        int count = 0;
        for (int i = 0; i * coin <= amount; i++) {
            int remaining = amount - i * coin;
            count += calculateChange(remaining, coins, position + 1);
        }
        return count;
    }

    public static int calculateChangeMem(int n) {
        if (n <= 0) {
            return -1;
        }

        int[] coins = {25, 10, 5, 1};
        int[][] cache = new int[n + 1][coins.length];

        return calculateChangeMem(n, coins, 0, cache);
    }

    private static int calculateChangeMem(int amount, int[] coins, int position, int[][] cache) {
        if (cache[amount][position] > 0) {
            return cache[amount][position];
        }

        if (position >= coins.length - 1) {
            return 1;
        }

        int coin = coins[position];
        int count = 0;

        for (int i = 0; i * coin <= amount; i++) {
            int remaining = amount - i * coin;
            count += calculateChangeMem(remaining, coins, position + 1, cache);
        }

        return cache[amount][position] = count;
    }


}
