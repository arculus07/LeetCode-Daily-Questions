// There exists an infinitely large two-dimensional grid of uncolored unit cells. You are given a positive integer n, indicating that you must do the following routine for n minutes:

// At the first minute, color any arbitrary unit cell blue.
// Every minute thereafter, color blue every uncolored cell that touches a blue cell.
// Below is a pictorial representation of the state of the grid after minutes 1, 2, and 3.


// Return the number of colored cells at the end of n minutes.

 

// Example 1:

// Input: n = 1
// Output: 1
// Explanation: After 1 minute, there is only 1 blue cell, so we return 1.
// Example 2:

// Input: n = 2
// Output: 5
// Explanation: After 2 minutes, there are 4 colored cells on the boundary and 1 in the center, so we return 5. 
 

// Constraints:

// 1 <= n <= 105

// 1 LINE CODE🎶Beats 100% using simple maths , and deriving own formula (i believe)✅💯

// Ayush Ranjan
// 200 Days Badge 2024
// 1
// 31 minutes ago
// Math
// Simulation
// Combinatorics
// Counting

// 1+
// Approach 1
// In this approach, we start with res = 0 and decrement n in a loop. For each step, we add (n-1) * 4 to res, which represents the number of new cells added at each layer of expansion. The loop continues until n becomes 0. Finally, we return res + 1 to account for the initial center cell.

// For example, if n = 3, the expansion happens as follows:
// At n = 3, add 4 × (3-1) = 8 cells.
// At n = 2, add 4 × (2-1) = 4 cells.
// At n = 1, stop and add 1 (center cell).
// Total cells = 8 + 4 + 1 = 13.

// Approach 2 (Optimized Formula)
// Instead of using a loop, we derive a formula using the sum of the first (n-1) natural numbers: sum = (n-1) * n / 2. Since each layer contributes 4 times this sum, the final formula becomes 4 * sum + 1. This reduces time complexity to O(1).

// For example, if n = 3:
// Sum of (n-1) numbers = (3-1) * 3 / 2 = 3.
// Multiply by 4: 3 * 4 = 12.
// Add the center cell: 12 + 1 = 13.
// So, the total cells = 13, same as the loop method but much faster!

// Code
class Solution {
    public long coloredCells(int n) {
        long res = 0; 
        // while(n>0){
        //     res+= (n-1)*4;
        //     n--;
        // }
        // return res+1;
        long sum = ((long)(n-1)*(n))/2;
        return 4*sum+1;
    }
}