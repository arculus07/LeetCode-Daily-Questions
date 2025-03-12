// Given an array nums sorted in non-decreasing order, return the maximum between the number of positive integers and the number of negative integers.

// In other words, if the number of positive integers in nums is pos and the number of negative integers is neg, then return the maximum of pos and neg.
// Note that 0 is neither positive nor negative.

 

// Example 1:

// Input: nums = [-2,-1,-1,1,2,3]
// Output: 3
// Explanation: There are 3 positive integers and 3 negative integers. The maximum count among them is 3.
// Example 2:

// Input: nums = [-3,-2,-1,0,0,1,2]
// Output: 3
// Explanation: There are 2 positive integers and 3 negative integers. The maximum count among them is 3.
// Example 3:

// Input: nums = [5,20,66,1314]
// Output: 4
// Explanation: There are 4 positive integers and 0 negative integers. The maximum count among them is 4.
 

// Constraints:

// 1 <= nums.length <= 2000
// -2000 <= nums[i] <= 2000
// nums is sorted in a non-decreasing order.
 

// Follow up: Can you solve the problem in O(log(n)) time complexity?
🐱‍👤🌴3 Approaches[Brute Force | Java Streams | Binary Search] Beats 100% in both cases ✅💯

Ayush Ranjan
200 Days Badge 2024
0
a few seconds ago
Array
Binary Search
Counting
Java
Intuition
The problem requires us to find the maximum count between positive and negative numbers in the given array. The simplest approach is to count positives and negatives and return the larger count.

Approach
Brute Force (Linear Scan):
Iterate through the array while maintaining two counters, one for negative numbers and one for positive numbers. The maximum of these two gives the result.

Using Java Streams:
Utilize Java Streams with filter() to count positive and negative numbers separately, then return the maximum count. This approach is concise but slightly less efficient due to overhead from stream processing.

Binary Search (Optimized Approach):
Since the array is sorted, we can use binary search (lower bound method) to find the index of the first positive and the first non-negative number. Using these indices, we calculate and return the maximum count of either positive or negative numbers efficiently.

Complexity Analysis
Brute Force:
Time Complexity: O(n) (Iterate through array once)
Space Complexity: O(1) (Only a few extra variables)

Java Streams:
Time Complexity: O(n) (Stream processing)
Space Complexity: O(1) (No extra storage apart from primitive counters)

Binary Search (Optimized):
Time Complexity: O(log n) (Binary search for indices)
Space Complexity: O(1) (Only a few variables used)
The binary search approach is the most efficient for large inputs due to its O(log n) time complexity. 🚀

Code
class Solution {
    public int maximumCount(int[] nums) {
        // int n=0,p=0;
        // for(int i:nums){
        //     if(i<0)n++;
        //     else if(i>0)p++;
        // }
        // return n>p?n:p;
        
        
        // IntPredicate lP = num->num>0;
        // IntPredicate lN = num->num<0;
        // int p = (int)Arrays.stream(nums).filter(lP).count();
        // int n = (int)Arrays.stream(nums).filter(lN).count();
        
        
        // return Math.max(p,n);
        int n = nums.length;
        int fP = lB(nums,1);
        int fN = lB(nums,0);
        return Math.max(n-fP,fN);
    }
    public int lB(int[] nums,int target){
        int i = 0;
        int j = nums.length-1;
        int res = nums.length;
        while(i<=j){
            int mid = i + (j-i)/2;
            if(nums[mid]<target){
                i = mid+1;
            }else{
                res = mid;
                j = mid-1;
            }
        }
        return res;
    }
}