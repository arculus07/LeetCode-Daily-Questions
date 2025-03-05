// There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.

// Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.

// The test cases are generated so that the answer will be less than or equal to 2 * 109.

 

// Example 1:


// Input: m = 3, n = 7
// Output: 28
// Example 2:

// Input: m = 3, n = 2
// Output: 3
// Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
// 1. Right -> Down -> Down
// 2. Down -> Down -> Right
// 3. Down -> Right -> Down
 

// Constraints:

// 1 <= m, n <= 100

// 💯3 Approaches[Brute Force | Memo | Combinatorial Maths] Beats 100% with ease💯✅

// Ayush Ranjan
// 200 Days Badge 2024
// 1
// an hour ago
// Math
// Divide and Conquer

// 5+
// Recursive Backtracking (Brute Force) – O(2^(m+n)) (TLE)
// This approach explores all possible paths from the start (0,0) to the destination (m-1, n-1). At each step, we either move right or down, recursively branching out. If we reach the destination, we increment the count. However, since this method doesn't store previous results, it keeps recalculating the same paths multiple times, leading to an exponential time complexity.

// For example, in a 3×3 grid, the function will explore all 6 possible paths, like moving all right first, then down, or alternating between right and down. As the grid size increases, the number of paths grows exponentially, making it extremely slow. For a 20×20 grid, it would take forever to compute. This is why it fails with Time Limit Exceeded (TLE) on larger test cases.

// Recursion + Memoization (DP) – O(m × n)
// This improves the brute-force approach by storing the number of ways to reach (i, j) in a DP table (dp[i][j]). If we have already computed paths for a certain cell, we reuse the value instead of recalculating it. This avoids redundant calculations and reduces the time complexity to O(m × n).

// For example, in a 3×3 grid, once we compute paths for (2,2), (1,2), and (2,1), we don’t need to recompute them. Instead, we use their stored values to quickly determine paths for (1,1), (0,1), and so on. This makes it much faster than brute force, but it still requires extra space (O(m × n)) to store results.

// Combinatorics (Best Approach) – O(m) or O(n)
// This is the fastest and most efficient approach. Instead of simulating the paths, we realize that the problem boils down to choosing (m-1) down moves from (m+n-2) total moves. This is a direct combinatorial formula:
// C(m+n−2,m−1)= (m+n−2)!/(m−1)!×(n−1)!
// ​

// To avoid large factorial calculations, we compute only the necessary multiplications and divisions, reducing the operations to just O(m) or O(n) instead of factorial time.

// For example, in a 3×7 grid, instead of checking every path, we directly compute C(8,2) = (8×7)/(2×1) = 28, giving us the answer instantly. This approach requires no extra space and is lightning-fast even for large grids like 100×100, making it the best solution. 🚀

// Code
class Solution {
    public int uniquePaths(int m, int n) {
    //     int count[] = new int[1];
    //     int[][] arr = new int[m][n];
    //     solve(0,0,arr,count);
    //     return count[0];
    // }
    // public static void solve(int i,int j,int[][] arr,int[] count){
    //     int n = arr.length;
    //     int m = arr[0].length;
    //     if(i<0||i>=n||j<0||j>=m||arr[i][j] == -1)return;

    //     if(i == n-1 && j == m-1){
    //         count[0]++;
    //         return;
    //     }

    //     arr[i][j]=-1;
    //     solve(i+1,j,arr,count);
    //     solve(i,j+1,arr,count);
    //     arr[i][j]=0; 37/63 test cases passed , TLE Time complexity 2^(m+n);
    //     int[][] dp = new int[101][101];
    //     for(int[] arr:dp){
    //         Arrays.fill(arr,-1);
    //     }
    //     return solve(0,0,m,n,dp);
    // }
    // public int solve(int i ,int j,int m,int n,int[][] dp){
    //     if(i>=m||j>=n)return 0;
    //     if(i == m-1 || j==n-1)return 1;

    //     if(dp[i][j]!=-1)return dp[i][j];

    //     int down = solve(i+1,j,m,n,dp);
    //     int right = solve(i,j+1,m,n,dp);
    //     return dp[i][j] = down + right; 
        long res = 1;
        for (int i = 1; i < Math.min(m, n); i++) {
            res = res * (m + n - 1 - i) / i;
        }
        return (int) res;

    }
}