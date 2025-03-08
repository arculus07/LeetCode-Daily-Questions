// You are given a 0-indexed string blocks of length n, where blocks[i] is either 'W' or 'B', representing the color of the ith block. The characters 'W' and 'B' denote the colors white and black, respectively.

// You are also given an integer k, which is the desired number of consecutive black blocks.

// In one operation, you can recolor a white block such that it becomes a black block.

// Return the minimum number of operations needed such that there is at least one occurrence of k consecutive black blocks.

 

// Example 1:

// Input: blocks = "WBBWWBBWBW", k = 7
// Output: 3
// Explanation:
// One way to achieve 7 consecutive black blocks is to recolor the 0th, 3rd, and 4th blocks
// so that blocks = "BBBBBBBWBW". 
// It can be shown that there is no way to achieve 7 consecutive black blocks in less than 3 operations.
// Therefore, we return 3.
// Example 2:

// Input: blocks = "WBWBBBW", k = 2
// Output: 0
// Explanation:
// No changes need to be made, since 2 consecutive black blocks already exist.
// Therefore, we return 0.
 

// Constraints:

// n == blocks.length
// 1 <= n <= 100
// blocks[i] is either 'W' or 'B'.
// 1 <= k <= n

2 Approaches[Brute Force | Sliding Window]simplest solutions with beating %age 92 each🐱‍👤✅

Ayush Ranjan
200 Days Badge 2024
0
a few seconds ago
Array
String
Sliding Window
Java
Approach 1 (Brute Force - Commented Code)
In this approach, we iterate through all possible contiguous substrings of length k within the blocks string. For each substring, we count the number of white ('W') blocks that need to be recolored to make the entire substring black ('B'). We then take the minimum count among all possible substrings. This brute-force approach has a time complexity of O(n * k) since for each starting position, we traverse k elements to count white blocks.

Approach 2 (Sliding Window - Optimized Code)
Here, we use a sliding window of size k to efficiently track the number of white ('W') blocks within any window. We move the window one step at a time, adding the new character at the right (j) and removing the left (i) character when the window size exceeds k. We update the minimum count of recolors required as we slide the window across the string. This approach improves efficiency to O(n) by ensuring each character is processed only once.

Code
class Solution {
    public int minimumRecolors(String blocks, int k) {
    //     int n = blocks.length();
    //     char[] arr = blocks.toCharArray();
    //     int min = Integer.MAX_VALUE;
    //     for(int i = 0;i<=n-k;i++){
    //         int x = solve(i,arr,k);
    //         min = Math.min(x,min);
    //     }
    //     return min;
    // }
    // public int solve(int start,char[] arr,int length){
    //     int count = 0;
    //     for(int i = start;i<start+length;i++){
    //         if(arr[i] == 'B')count++;
    //     }
    //     return length-count;
    int count = 0;
    int i = 0;
    int j = 0;
    int res = k;
    while(j<blocks.length()){
        if(blocks.charAt(j)=='W')count++;
        if(j-i+1 == k){
            res = Math.min(res,count);
            if(blocks.charAt(i)=='W')count--;
        i++;
        }
        j++;
    }
    return res;
    }
}