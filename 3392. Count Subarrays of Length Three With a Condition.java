// Given an integer array nums, return the number of subarrays of length 3 such that the sum of the first and third numbers equals exactly half of the second number.

 

// Example 1:

// Input: nums = [1,2,1,4,1]

// Output: 1

// Explanation:

// Only the subarray [1,4,1] contains exactly 3 elements where the sum of the first and third numbers equals half the middle number.

// Example 2:

// Input: nums = [1,1,1]

// Output: 0

// Explanation:

// [1,1,1] is the only subarray of length 3. However, its first and third numbers do not add to half the middle number.

 

// Constraints:

// 3 <= nums.length <= 100
// -100 <= nums[i] <= 100

// Beats 100% with the easiest approach , and in O(n) time 💯✅

// Ayush Ranjan
// 365 Days Badge
// 0
// a few seconds ago
// Array
// Java
// the basic approach is to maintain the window of three (As you are talking about subarray)

// In the Window we are basically checking what the question is demanding -- (first + third)*2 == second

// if it's coming out to be true , just increment the count by 1 , and in the return no of count

// by doing this we are solving it in O(1) space and O(n) time , we are achieving 100% beating percentage
// maybe there are better options but this one will be the easiest......

// Code
class Solution {
    public int countSubarrays(int[] nums) {
        int count = 0;
        for(int i =2;i<nums.length;i++){
            int x = (nums[i]+nums[i-2])*2;
            if(x == nums[i-1])count++;
        }
        return count;
    }
}