class Solution {

    private int f(int i, int end, int[] nums, int[] dp){
        if(i>end) return 0;

        if(dp[i]!=-1) return dp[i];

        int pick = nums[i] + f(i+2, end, nums, dp);
        int notPick = f(i+1, end, nums, dp);

        return dp[i] = Math.max(pick, notPick);
    }

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int[] dp = new int[nums.length];

        Arrays.fill(dp, -1);
        
        int n1 = f(0, nums.length-2, nums, dp);

        Arrays.fill(dp, -1);
        int n2 = f(1, nums.length-1, nums, dp);

        return Math.max(n1, n2);

    }
}
