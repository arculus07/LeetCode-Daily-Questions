// Given an array of strings nums containing n unique binary strings each of length n, return a binary string of length n that does not appear in nums. If there are multiple answers, you may return any of them.

 

// Example 1:

// Input: nums = ["01","10"]
// Output: "11"
// Explanation: "11" does not appear in nums. "00" would also be correct.
// Example 2:

// Input: nums = ["00","01"]
// Output: "11"
// Explanation: "11" does not appear in nums. "10" would also be correct.
// Example 3:

// Input: nums = ["111","011","001"]
// Output: "101"
// Explanation: "101" does not appear in nums. "000", "010", "100", and "110" would also be correct.
 

// Constraints:

// n == nums.length
// 1 <= n <= 16
// nums[i].length == n
// nums[i] is either '0' or '1'.
// All the strings of nums are unique.

// First Approach: Using HashSet and Checking All Numbers
// In this approach, we first convert all given binary strings into decimal numbers and store them in a set. Then, we iterate through all possible decimal numbers from 0 to 2^n - 1 and check which one is missing. Once we find a missing number, we convert it back to a binary string and ensure it has the correct length by adding leading zeros if necessary. This guarantees that we find a unique binary string that is not present in the input list. However, this method is less efficient because it requires extra space for the set and iterates over all possible values.

// For example, if nums = ["00", "01", "11"], we first convert them into decimal {0, 1, 3}. Then, we check from 0 to 3 and find that 2 is missing. Converting 2 to binary gives "10", which is not in the list, so we return it. This approach ensures correctness but can be slow for larger values of n since it checks every possible number.

// Second Approach: Flipping the Diagonal Characters
// This approach is more efficient and clever. Instead of checking all possible numbers, we construct a new binary string by flipping the diagonal elements of the given list. Specifically, if nums[i][i] is 0, we change it to 1, and if it is 1, we change it to 0. This guarantees that the new string is different from all given ones because it differs from each string at least in one position. This method runs in O(n) time and requires no extra space, making it more optimized.

// For example, if nums = ["00", "01", "11"], we take the diagonal characters—nums[0][0] = '0', nums[1][1] = '1', and nums[2][2] = '1'. Flipping them gives "10", which is different from all given strings. Since it modifies at least one character from every string, we are guaranteed to get a unique binary string efficiently.

// Code
class Solution {
    public String findDifferentBinaryString(String[] nums) {
    //     int n = nums.length;
    //     HashSet<Integer>set = new HashSet<>();
    //     for(String s:nums){
    //         set.add(Integer.parseInt(s,2));
    //     }
    //     String res = "";
    //     int x = (int)Math.pow(2,16) - 1;
    //     for(int i = 0;i<=x;i++){
    //         if(!set.contains(i)){
    //             res = Integer.toBinaryString(i);
    //             while(res.length()<n){
    //                 res = "0"+res;
    //             }
    //             return res;
    //         }
    //     }
    // return res;

    StringBuilder str = new StringBuilder();
    for(int i =0;i<nums.length;i++){
        if(nums[i].charAt(i) == '0')str.append("1");
        else str.append("0");
    }
    return str.toString();
    }
}