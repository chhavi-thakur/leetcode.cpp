 public class Solution {
    public int checkRecord(int n) {
        int MOD = 1_000_000_007;

         int[][][] dp = new int[n + 1][2][3];
        dp[0][0][0] = 1;

        for (int i = 0; i < n; i++) {
            for (int a = 0; a < 2; a++) {
                for (int l = 0; l < 3; l++) {
                    int val = dp[i][a][l];
                    if (val == 0) continue;

                     dp[i + 1][a][0] = (dp[i + 1][a][0] + val) % MOD;

                      if (a < 1)
                        dp[i + 1][a + 1][0] = (dp[i + 1][a + 1][0] + val) % MOD;

                     if (l < 2)
                        dp[i + 1][a][l + 1] = (dp[i + 1][a][l + 1] + val) % MOD;
                }
            }
        }

        int result = 0;
        for (int a = 0; a < 2; a++) {
            for (int l = 0; l < 3; l++) {
                result = (result + dp[n][a][l]) % MOD;
            }
        }

        return result;
    }
}
