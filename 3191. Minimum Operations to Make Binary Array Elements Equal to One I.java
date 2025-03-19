// You are given a binary array nums.

// You can do the following operation on the array any number of times (possibly zero):

// Choose any 3 consecutive elements from the array and flip all of them.
// Flipping an element means changing its value from 0 to 1, and from 1 to 0.

// Return the minimum number of operations required to make all elements in nums equal to 1. If it is impossible, return -1.

 

// Example 1:

// Input: nums = [0,1,1,1,0,0]

// Output: 3

// Explanation:
// We can do the following operations:

// Choose the elements at indices 0, 1 and 2. The resulting array is nums = [1,0,0,1,0,0].
// Choose the elements at indices 1, 2 and 3. The resulting array is nums = [1,1,1,0,0,0].
// Choose the elements at indices 3, 4 and 5. The resulting array is nums = [1,1,1,1,1,1].
// Example 2:

// Input: nums = [0,1,1,1]

// Output: -1

// Explanation:
// It is impossible to make all elements equal to 1.

 

// Constraints:

// 3 <= nums.length <= 105
// 0 <= nums[i] <= 1
💯🐱‍👤Best approach beats 100% using Sliding Window concept , in less than 10 lines of code✅

Ayush Ranjan
200 Days Badge 2024
0
a few seconds ago
Array
Sliding Window
Java
iterating through the array and flipping three consecutive elements whenever a 0 is encountered. This is done by changing the current element and the next two elements (i.e., nums[i], nums[i+1], and nums[i+2]) to their opposite values (0 → 1, 1 → 0). A counter tracks the number of operations performed. The loop runs until the third-last element, ensuring that every encountered 0 can be flipped. After the loop, if the last two elements remain 0, it means the array cannot be fully converted to all 1s, so the function returns -1. Otherwise, it returns the total count of operations performed.

class Solution {
    public int minOperations(int[] nums) {
         int n = nums.length;
         int count = 0;
         for(int i = 0;i<n-2;i++){
            if(nums[i] == 0){
                nums[i] = 1 -nums[i];
                nums[i+1]=1 -nums[i+1];
                nums[i+2]=1 -nums[i+2];
                count++;
            }
         }
         if(nums[n-1]==0||nums[n-2]==0)return -1;
         return count;
    }
}