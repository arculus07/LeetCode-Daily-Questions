// Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

 

// Example 1:

// Input: nums = [1,2,3]
// Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// Example 2:

// Input: nums = [0,1]
// Output: [[0,1],[1,0]]
// Example 3:

// Input: nums = [1]
// Output: [[1]]
 
//  💯🎶Beats 92.76% using 3 Approaches [Swapping | Boolean | HashSet] with EASE✅

// Ayush Ranjan
// 200 Days Badge 2024
// 1
// an hour ago
// Array
// Hash Table
// Backtracking
// Hash Function

// 1+
// Solution 1 (Swapping Approach)
// This approach generates permutations by swapping elements within the given list. It starts with the first index and recursively swaps each element with every other element ahead of it. This ensures that all possible orderings are explored. After each recursive call, the swap is undone (backtracking) to restore the original order before the next iteration.

// The key part of this approach is using Collections.swap(list, index, i) to modify the list directly. Since Java passes primitive types by value, swapping integers without modifying the list would not work. By swapping elements in the list itself, we effectively rearrange the order in-place, making it efficient without needing extra space.

// Solution 2 (Backtracking with Boolean Array)
// Here, we use a boolean array to track which numbers have already been included in the current permutation. This ensures that each number is used exactly once per permutation. The function iterates through all numbers, adds an unused number to the current list, marks it as used (bool[i] = true), and continues building the permutation recursively.

// After reaching a valid permutation, the function backtracks by removing the last added element and marking it as unused (bool[i] = false). This backtracking step allows exploring all possibilities. Since we are not modifying the input array, this method is safer and avoids unnecessary swaps, making it a straightforward and readable approach.

// Solution 3 (Set-Based Approach - Commented Out)
// This version originally attempted to track used elements using a HashSet instead of a boolean array. The idea was similar: add an element if it hasn't been used, proceed recursively, then remove it during backtracking. However, a boolean array is more efficient for this case since it provides constant-time access (O(1)) compared to a set (O(log N) for insertions/removals).

// Since this method was commented out, it seems the focus shifted to using either swapping or boolean arrays. Both approaches work well, but swapping is more memory-efficient, while the boolean array method is more intuitive and avoids unnecessary swaps.

// Code
class Solution {
    List<List<Integer>>arr= new ArrayList<>();
    int N = 0;
    // HashSet<Integer>set = new HashSet<>();
    public List<List<Integer>> permute(int[] nums){
        // N = nums.length;
        // List<Integer>list = new ArrayList<>();
        // for(int i : nums)list.add(i);
        // solve(list,0);
        // return arr;
        N = nums.length;
        List<Integer>list = new ArrayList<>();
        boolean[] bool = new boolean[N];
        
        solve(nums,list,bool);
        // solve(nums,list);
        return arr;
    }
    public void solve(int[] nums,List<Integer>list,boolean[] bool){
        if(list.size()==N){
            arr.add(new ArrayList<>(list));
            return;
        }
        
        for(int i = 0;i<N;i++){
            // if(!set.contains(nums[i])){
                if(!bool[i]){
                bool[i] = true;
                // set.add(nums[i]);
                list.add(nums[i]);
                // solve(nums,list);
                solve(nums,list,bool);
                bool[i] = false;
                // set.remove(nums[i]);
                list.remove(list.size()-1);
            }
        }
 
    }
    // public void solve(List<Integer>list,int index){
    //     if(index == N){
    //         arr.add(new ArrayList<>(list));
    //         return;
    //     }
    //     for(int i = index;i<N;i++){
    //         Collections.swap(list,index,i);
    //         solve(list,index+1);
    //         Collections.swap(list,index,i);
    //     }
    // }
}