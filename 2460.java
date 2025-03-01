// Intuition
// The problem requires modifying an array based on two rules: doubling adjacent equal elements and shifting zeros to the end. The challenge is efficiently performing these operations in a single pass.

// Approach
// We iterate through the array, checking adjacent elements. If two consecutive numbers are the same, we double the first one and set the second to zero. We then move non-zero elements to the front and fill the remaining spaces with zeros.

// For example, given [2,2,0,4,4], we first double 2 to 4 and set the next 2 to 0, then double 4 to 8 and set the next 4 to 0, resulting in [4,0,0,8,0]. After shifting non-zeros, we get [4,8,0,0,0]]

// Code
class Solution {
    public int[] applyOperations(int[] nums) {
        // for(int i = 0;i<nums.length-1;i++){
        //     if(nums[i]==nums[i+1]){
        //         nums[i]=nums[i]*2;
        //         nums[i+1] = 0;
        //     }
        // }
        // int j = 0;
        // for(int i:nums){
        //     if(i!=0){
        //         nums[j++] = i;
        //     }
        // }

        // while(j<nums.length){
        //     nums[j++] = 0;
        // }
        // return nums;
        int j=0;
        int arr[] = new int[nums.length];
        for(int i = 0;i<nums.length-1;i++){
            if(nums[i]!=0){
            if(i!=nums.length-1 && nums[i]==nums[i+1]){
                arr[j] = nums[i]*2;
                nums[i+1] = 0;
            }else{
                arr[j] = nums[i];
            }
            j++;
        }
        }
        if(nums[nums.length-1]!=0)arr[j] = nums[nums.length-1]; 
        return arr;


    }
}