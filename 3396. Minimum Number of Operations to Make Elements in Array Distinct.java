// You are given an integer array nums. You need to ensure that the elements in the array are distinct. To achieve this, you can perform the following operation any number of times:

// Remove 3 elements from the beginning of the array. If the array has fewer than 3 elements, remove all remaining elements.
// Note that an empty array is considered to have distinct elements. Return the minimum number of operations needed to make the elements in the array distinct.

 

// Example 1:

// Input: nums = [1,2,3,4,2,3,3,5,7]

// Output: 2

// Explanation:

// In the first operation, the first 3 elements are removed, resulting in the array [4, 2, 3, 3, 5, 7].
// In the second operation, the next 3 elements are removed, resulting in the array [3, 5, 7], which has distinct elements.
// Therefore, the answer is 2.

// Example 2:

// Input: nums = [4,5,6,4,4]

// Output: 2

// Explanation:

// In the first operation, the first 3 elements are removed, resulting in the array [4, 4].
// In the second operation, all remaining elements are removed, resulting in an empty array.
// Therefore, the answer is 2.

// Example 3:

// Input: nums = [6,7,8,9]

// Output: 0

// Explanation:

// The array already contains distinct elements. Therefore, the answer is 0.

 

// Constraints:

// 1 <= nums.length <= 100
// 1 <= nums[i] <= 100



Simplest and Easiest Approach beats 72% in O(n) complexity ✅

Ayush Ranjan
365 Days Badge
0
a few seconds ago
Array
Hash Table
Java
In this approach, we are trying to find the minimum number of operations needed to remove the last set of repeated elements in the array. We start checking from the end of the array, and we keep track of the elements we see using a HashSet. If we come across a number that we’ve already seen, it means repetition has started, and we mark that index. Now, from that repeated index till the end, we calculate how many operations are needed to remove that part—assuming in one operation we can remove 3 elements at once. So, we divide the number of elements by 3 and round it up.

For example, let’s say the array is [1, 2, 3, 4, 2, 5, 6]. Starting from the end, we track unique numbers: 6, 5, 2 → now we hit 2 again, which is already in the set. So we stop and note the index as 4. From index 4 till the end, the subarray is [2, 5, 6]—that’s 3 elements. So only 1 operation is needed (as 3/3 = 1). If the length had been 4 or 5, we would need 2 operations (rounding up). This is how the solution smartly figures it out!

Code
class Solution {
    public int minimumOperations(int[] nums) {
        HashSet<Integer>set = new HashSet<>();
        int index = Integer.MAX_VALUE;
        for(int i = nums.length-1;i>=0;i--){
            if(!set.contains(nums[i])){
                set.add(nums[i]);
            }else{
                index = i;
                break;
            }
        }
        if(index == Integer.MAX_VALUE)return 0;
        index++;
        int result = index/3;
        return index%3 == 0?result:result+1;
    }
}