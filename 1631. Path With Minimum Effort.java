// You are a hiker preparing for an upcoming hike. You are given heights, a 2D array of size rows x columns, where heights[row][col] represents the height of cell (row, col). You are situated in the top-left cell, (0, 0), and you hope to travel to the bottom-right cell, (rows-1, columns-1) (i.e., 0-indexed). You can move up, down, left, or right, and you wish to find a route that requires the minimum effort.

// A route's effort is the maximum absolute difference in heights between two consecutive cells of the route.

// Return the minimum effort required to travel from the top-left cell to the bottom-right cell.

 

// Example 1:



// Input: heights = [[1,2,2],[3,8,2],[5,3,5]]
// Output: 2
// Explanation: The route of [1,3,5,3,5] has a maximum absolute difference of 2 in consecutive cells.
// This is better than the route of [1,2,2,2,5], where the maximum absolute difference is 3.
// Example 2:



// Input: heights = [[1,2,3],[3,8,4],[5,3,5]]
// Output: 1
// Explanation: The route of [1,2,3,4,5] has a maximum absolute difference of 1 in consecutive cells, which is better than route [1,3,5,3,5].
// Example 3:


// Input: heights = [[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]
// Output: 0
// Explanation: This route does not require any effort.
 

// Constraints:

// rows == heights.length
// columns == heights[i].length
// 1 <= rows, columns <= 100
// 1 <= heights[i][j] <= 106

🗣Simplest approach and the best Application of Dijkstra's Algorithm to solve the problem✅💫

Ayush Ranjan
365 Days Badge
0
a few seconds ago
Breadth-First Search
Graph
Heap (Priority Queue)
Java
Approach
This solution uses Dijkstra's algorithm to find the path from the top-left to the bottom-right of the grid with the minimum maximum effort. The "effort" between two cells is defined as the absolute difference in their heights, and the path’s total effort is the maximum effort of any single step along that path. So instead of summing the efforts like in regular shortest path problems, we're tracking the worst step we’d have to take. We use a priority queue to always expand the path with the lowest current maximum effort, and a result matrix to keep track of the smallest effort needed to reach each cell.

Let’s take a small example:
heights = [[1,2,2],[3,8,2],[5,3,5]]
The goal is to go from (0,0) to (2,2) while minimizing the worst jump. For instance, going right → right → down → down gives you the efforts: |2-1|=1, |2-2|=0, |2-2|=0, |5-2|=3. The max effort here is 3. But there's a better path: down → down → right → right with efforts |3-1|=2, |5-3|=2, |3-5|=2, |5-3|=2, so the max effort is 2, which is better. The algorithm finds this optimal path for you by always choosing the next cell with the lowest possible maximum effort so far.

Code
class Solution {
    class Pair{
        int i,j,w;
        Pair(int i ,int j,int w){
            this.i = i;
            this.j = j;
            this.w = w;
        }
    }
    public boolean isCheck(int x,int y){
        return x >= 0 && y >= 0 && x < m && y < n;
    }
    public static final int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
    int m,n;
    public int minimumEffortPath(int[][] heights) {
        m = heights.length;
        n = heights[0].length;

        PriorityQueue<Pair>que = new PriorityQueue<>((a,b)->a.w-b.w);
        que.offer(new Pair(0,0,0));
        int[][] result = new int[m][n];
        for(int[] i:result)Arrays.fill(i,Integer.MAX_VALUE);
        result[0][0] = 0;

        while(!que.isEmpty()){
            var temp = que.poll();
            int x = temp.i,y = temp.j,d = temp.w;

            for(var i:dir){
                int x_ = x+i[0];
                int y_ = y+i[1];
                if(isCheck(x_,y_)){
                    int com = Math.max(d,Math.abs(heights[x_][y_] - heights[x][y]));
                    if(com < result[x_][y_]){
                        result[x_][y_] = com;
                        que.offer(new Pair(x_,y_,com));
                    }
                }
                
            }
        }
        return result[m-1][n-1];
    }
}