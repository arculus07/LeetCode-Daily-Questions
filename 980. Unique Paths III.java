// You are given an m x n integer array grid where grid[i][j] could be:

// 1 representing the starting square. There is exactly one starting square.
// 2 representing the ending square. There is exactly one ending square.
// 0 representing empty squares we can walk over.
// -1 representing obstacles that we cannot walk over.
// Return the number of 4-directional walks from the starting square to the ending square, that walk over every non-obstacle square exactly once.

 

// Example 1:


// Input: grid = [[1,0,0,0],[0,0,0,0],[0,0,2,-1]]
// Output: 2
// Explanation: We have the following two paths: 
// 1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
// 2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)
// Example 2:


// Input: grid = [[1,0,0,0],[0,0,0,0],[0,0,0,2]]
// Output: 4
// Explanation: We have the following four paths: 
// 1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2),(2,3)
// 2. (0,0),(0,1),(1,1),(1,0),(2,0),(2,1),(2,2),(1,2),(0,2),(0,3),(1,3),(2,3)
// 3. (0,0),(1,0),(2,0),(2,1),(2,2),(1,2),(1,1),(0,1),(0,2),(0,3),(1,3),(2,3)
// 4. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2),(2,3)
// Example 3:


// Input: grid = [[0,1],[2,0]]
// Output: 0
// Explanation: There is no path that walks over every empty square exactly once.
// Note that the starting and ending square can be anywhere in the grid.
 

// Constraints:

// m == grid.length
// n == grid[i].length
// 1 <= m, n <= 20
// 1 <= m * n <= 20
// -1 <= grid[i][j] <= 2
// There is exactly one starting cell and one ending cell.

✅🐱‍👤Beats 100% with the basic Khandani BackTracking Method , with Simplest Approach✅💯

Ayush Ranjan
200 Days Badge 2024
1
3 hours ago
Array
Backtracking
Bit Manipulation
Matrix

1+
The problem requires finding all unique paths from the starting square to the ending square while covering all non-obstacle cells exactly once. A Backtracking + DFS (Depth First Search) approach is effective here. First, we determine the grid size and count all walkable cells (empty squares and the starting position). We locate the starting position and initiate a recursive DFS traversal. During the traversal, we mark visited cells as obstacles (-1) to prevent revisiting, explore all four possible directions, and backtrack after each move. If we reach the ending square and have visited all required cells, we count the path as valid.

A key optimization is passing a counter (map1) that tracks visited squares, ensuring we only count valid paths. Each recursive call explores all valid moves, and after visiting all possibilities from a position, we restore the original value (backtracking) to allow other paths to be explored. The time complexity is O(4^N) in the worst case, where N is the number of empty squares, as each square has at most four possible moves. Despite the exponential complexity, backtracking ensures unnecessary paths are pruned early, improving efficiency.

Code
class Solution {
    int count = 0;
    int M,N;
    int map = 0;
    public int uniquePathsIII(int[][] grid) {
        M = grid.length;
        N = grid[0].length;
        for(int i = 0;i<M;i++){
            for(int j = 0;j<N;j++){
                if(grid[i][j]==1 || grid[i][j] == 0)map++;
            }
        }
        for(int i = 0;i<M;i++){
            for(int j = 0;j<N;j++){
                if(grid[i][j] == 1){
                    solve(grid,i,j,0);
                }
            }
        }
    return count;
    }
    public void solve(int[][] grid,int i,int j,int map1){
        
        if(i<0 || j<0 || i==M || j==N || grid[i][j]==-1){
            return;
        }
        if(grid[i][j] == 2){
            if(map1 == map)count++;
            return;
        }
        map1++;
        int temp = grid[i][j];
        grid[i][j] = -1;
        solve(grid,i+1,j,map1);
        solve(grid,i-1,j,map1);
        solve(grid,i,j+1,map1);
        solve(grid,i,j-1,map1);
        grid[i][j] = temp;
    }
}