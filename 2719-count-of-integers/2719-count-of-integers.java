class Solution {
    static final int MOD = (int) (1e9 + 7);
    long[][][] dp;

    public long solve(int idx, int sum, boolean tight, int min_sum, int max_sum, String s) {
        if (idx == s.length()) {
            return (sum >= min_sum && sum <= max_sum) ? 1 : 0;
        }

        if (dp[idx][sum][tight ? 1 : 0] != -1) {
            return dp[idx][sum][tight ? 1 : 0];
        }

        long ans = 0;
        if (tight) {
            for (int i = 0; i <= s.charAt(idx) - '0'; i++) {
                if (s.charAt(idx) - '0' == i) {
                    ans = (ans + solve(idx + 1, sum + i, true, min_sum, max_sum, s)) % MOD;
                } else {
                    ans = (ans + solve(idx + 1, sum + i, false, min_sum, max_sum, s)) % MOD;
                }
            }
        } else {
            for (int i = 0; i <= 9; i++) {
                ans = (ans + solve(idx + 1, sum + i, false, min_sum, max_sum, s)) % MOD;
            }
        }

        return dp[idx][sum][tight ? 1 : 0] = ans;
    }

    public int count(String num1, String num2, int min_sum, int max_sum) {
        dp = new long[23][401][2];
        for (int i = 0; i < 23; i++) {
            for (int j = 0; j < 401; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        long upper = solve(0, 0, true, min_sum, max_sum, num2);
        for (int i = 0; i < 23; i++) {
            for (int j = 0; j < 401; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        long lower = solve(0, 0, true, min_sum, max_sum, num1);

        int sum = 0;
        for (char c : num1.toCharArray()) {
            sum += (c - '0');
        }

        if (sum >= min_sum && sum <= max_sum) {
            lower--;
        }

        long result = (upper - lower + MOD) % MOD;
        return (int) result;
    }
}