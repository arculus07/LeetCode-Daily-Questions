// You are given an integer array nums and an integer k.

// An integer h is called valid if all values in the array that are strictly greater than h are identical.

// For example, if nums = [10, 8, 10, 8], a valid integer is h = 9 because all nums[i] > 9 are equal to 10, but 5 is not a valid integer.

// You are allowed to perform the following operation on nums:

// Select an integer h that is valid for the current values in nums.
// For each index i where nums[i] > h, set nums[i] to h.
// Return the minimum number of operations required to make every element in nums equal to k. If it is impossible to make all elements equal to k, return -1.

 

// Example 1:

// Input: nums = [5,2,5,4,5], k = 2

// Output: 2

// Explanation:

// The operations can be performed in order using valid integers 4 and then 2.

// Example 2:

// Input: nums = [2,1,2], k = 2

// Output: -1

// Explanation:

// It is impossible to make all the values equal to 2.

// Example 3:

// Input: nums = [9,7,5,3], k = 1

// Output: 4

// Explanation:

// The operations can be performed using valid integers in the order 7, 5, 3, and 1.

 

// Constraints:

// 1 <= nums.length <= 100 
// 1 <= nums[i] <= 100
// 1 <= k <= 100

🗣 Simplest and Shortest Approach to solve the problem BEATS 82% ✅🌴

Ayush Ranjan
365 Days Badge
0
a few seconds ago
Array
Hash Table
Java
The approach of this solution involves using a HashSet to track the unique elements in the given array. By storing each element in the set, we can easily determine how many distinct numbers are present. The solution then finds the smallest element in the array.

If this smallest element matches the target value k, it means we need to make all elements equal to k, and the number of operations required would be one less than the number of unique elements (since we keep one instance of k and remove the rest). If the smallest element is greater than k, we need to remove all elements except one, which requires operations equal to the number of unique elements.

If the smallest element is less than k, the solution returns -1, indicating it's not possible to make all elements equal to k with the given operations.

Code
class Solution {
    public int minOperations(int[] nums, int k) {
        HashSet<Integer>set = new HashSet<>();
        for(int i:nums)set.add(i);
        int min = Integer.MAX_VALUE;
        for(int i:nums){
            min = Math.min(min,i);
        }
        if(min == k)return set.size()-1;
        if(min > k)return set.size();
        return -1;
    }
}