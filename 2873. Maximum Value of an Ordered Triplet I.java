// You are given a 0-indexed integer array nums.

// Return the maximum value over all triplets of indices (i, j, k) such that i < j < k. If all such triplets have a negative value, return 0.

// The value of a triplet of indices (i, j, k) is equal to (nums[i] - nums[j]) * nums[k].

 

// Example 1:

// Input: nums = [12,6,1,2,7]
// Output: 77
// Explanation: The value of the triplet (0, 2, 4) is (nums[0] - nums[2]) * nums[4] = 77.
// It can be shown that there are no ordered triplets of indices with a value greater than 77. 
// Example 2:

// Input: nums = [1,10,3,4,19]
// Output: 133
// Explanation: The value of the triplet (1, 2, 4) is (nums[1] - nums[2]) * nums[4] = 133.
// It can be shown that there are no ordered triplets of indices with a value greater than 133.
// Example 3:

// Input: nums = [1,2,3]
// Output: 0
// Explanation: The only ordered triplet of indices (0, 1, 2) has a negative value of (nums[0] - nums[1]) * nums[2] = -3. Hence, the answer would be 0.
 

// Constraints:

// 3 <= nums.length <= 100
// 1 <= nums[i] <= 106

🗣Beats 99.31% using 2 Approaches [Brute Force | Prefix/Suffix Arrays] with the easiest code✅🐱‍👤

Ayush Ranjan
200 Days Badge 2024
0
a few seconds ago
Array
Suffix Array
Prefix Sum
Java
Brute Force Approach
The brute force approach iterates through all possible triplets
(i,j,k) in the array, ensuring
i<j<k. For each triplet, it calculates the expression
(nums[i]−nums[j])×nums[k] and keeps track of the maximum value found. This method guarantees finding the optimal solution but has a time complexity of 𝑂(n^3)
making it inefficient for large inputs.

**For example, given nums = [5, 3, 8, 2], the algorithm will check all triplets like (5-3)8 = 16, (5-8)2 = -6, etc., ultimately selecting the maximum valid result. While simple, this approach is computationally expensive due to excessive nested loops.

Optimized Approach (Using Prefix and Suffix Arrays)
The optimized approach improves efficiency by using prefix and suffix maximums. The prefix array stores the maximum value encountered up to each index, ensuring efficient access to the best nums[i] for subtraction. The suffix array stores the maximum value from the current index to the end, quickly retrieving the best nums[k]. Using these precomputed arrays, the algorithm iterates through the array once more to calculate
(best nums[i]−nums[j])×best nums[k] in
O(n) time.

*For example, given nums = [5, 3, 8, 2], the prefix array stores [5, 5, 8, 8], and the suffix array stores [8, 8, 8, 2]. When checking index j=1 (value 3), we take pref[0] = 5 and suff[2] = 8, computing (5-3)8 = 16. This ensures we find the optimal value efficiently compared to the brute force approach.

Code
class Solution {
    public long maximumTripletValue(int[] nums) {
        // long max = 0;
        // for(int i = 0;i<nums.length-2;i++){
        //     for(int j=i+1;j<nums.length-1;j++){
        //         for(int k=j+1;k<nums.length;k++){
        //             max = Math.max(((long)(nums[i]-nums[j])*(long)nums[k]),max);
        //         }
        //     }
        // }
        // return max;
        int[] pref = new int[nums.length];
        int[] suff = new int[nums.length];
        int max1 = 0;
        for(int i = 0;i<nums.length-2;i++){
            pref[i] = Math.max(nums[i],max1);
            max1 = pref[i];
        }
        int max2 = 0;
        for(int i = nums.length-1;i>=0;i--){
            suff[i] = Math.max(max2,nums[i]);
            max2 = suff[i];
        }
        long result = 0;
        for(int i =1;i<nums.length-1;i++){
            result = Math.max(((long)(pref[i-1]-nums[i])*(long)suff[i+1]),result);
        } 
        return result;
    }
}