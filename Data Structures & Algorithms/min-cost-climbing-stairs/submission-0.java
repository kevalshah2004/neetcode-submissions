class Solution {

    private int f(int i, int n, int[] cost, int[] dp){
        if(i >= n) return 0;

        if(dp[i]!=-1) return dp[i];

        int one = cost[i] + f(i+1, n, cost, dp);
        int second = cost[i] + f(i+2, n, cost, dp);

        return dp[i] = Math.min(one, second);
    }

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;

        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);

        return Math.min(f(0, n, cost, dp), f(1, n, cost, dp));
    }
}
