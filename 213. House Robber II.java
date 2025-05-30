// You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.

// Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

 

// Example 1:

// Input: nums = [2,3,2]
// Output: 3
// Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are adjacent houses.
// Example 2:

// Input: nums = [1,2,3,1]
// Output: 4
// Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
// Total amount you can rob = 1 + 3 = 4.
// Example 3:

// Input: nums = [1,2,3]
// Output: 3
 

// Constraints:

// 1 <= nums.length <= 100
// 0 <= nums[i] <= 1000

class Solution {
    int[] dp;
    public int rob(int[] nums) {
        dp = new int[nums.length+1];
        for(int i=0;i<dp.length;i++)dp[i] = -1;
        int n = nums.length;
        if(nums.length == 1)return nums[0];
        if(nums.length == 2)return Math.max(nums[0],nums[1]);
        int take = solve(nums,0,n-2);
        dp = new int[nums.length+1];
        for(int i=0;i<dp.length;i++)dp[i] = -1;
        int nTake = solve(nums,1,n-1);
        return Math.max(take,nTake);
    }


    public int solve(int[] nums,int i,int n){
        if(i>n)return 0;
        if(dp[i]!=-1)return dp[i];
        int st = nums[i] + solve(nums,i+2,n);
        int nS = solve(nums,i+1,n);

        return dp[i] = Math.max(st,nS);
    }
}


#Approach 2

class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1)return nums[0];
        if(nums.length == 2)return Math.max(nums[0],nums[1]);

        int t = solve(nums,0,nums.length-2);
        int nt = solve(nums,1,nums.length-1);

        return Math.max(t,nt);
    }
    public int solve(int[] nums,int i,int n){
        int p = 0,pp =0;
        for(int j = i;j<=n;j++){
            int s = p;
            int t = nums[j]+pp;
            int x = Math.max(s,t);
            pp = p;
            p = x;
        }
        return p;
    }
}
//