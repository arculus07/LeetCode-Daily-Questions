// You are given a 0-indexed string pattern of length n consisting of the characters 'I' meaning increasing and 'D' meaning decreasing.

// A 0-indexed string num of length n + 1 is created using the following conditions:

// num consists of the digits '1' to '9', where each digit is used at most once.
// If pattern[i] == 'I', then num[i] < num[i + 1].
// If pattern[i] == 'D', then num[i] > num[i + 1].
// Return the lexicographically smallest possible string num that meets the conditions.

 

// Example 1:

// Input: pattern = "IIIDIDDD"
// Output: "123549876"
// Explanation:
// At indices 0, 1, 2, and 4 we must have that num[i] < num[i+1].
// At indices 3, 5, 6, and 7 we must have that num[i] > num[i+1].
// Some possible values of num are "245639871", "135749862", and "123849765".
// It can be proven that "123549876" is the smallest possible num that meets the conditions.
// Note that "123414321" is not possible because the digit '1' is used more than once.
// Example 2:

// Input: pattern = "DDD"
// Output: "4321"
// Explanation:
// Some possible values of num are "9876", "7321", and "8742".
// It can be proven that "4321" is the smallest possible num that meets the conditions.
 

// Constraints:

// 1 <= pattern.length <= 8
// pattern consists of only the letters 'I' and 'D'.

This approach uses a stack to generate the smallest number based on a given pattern of 'I' (increase) and 'D' (decrease). The idea is simple: we push numbers onto the stack as we go through the pattern. Whenever we hit an 'I' or reach the end, we pop all elements from the stack and add them to the result. This ensures that decreasing sequences are handled correctly, as the last pushed element (smallest in the current segment) comes out first, maintaining the correct order.

For example, if the pattern is "DID", we process it like this:
1 → push 1
2 → push 2 (since 'D', we wait)
3 → pop 2, pop 1 (since 'I', we flush the stack) → "21"
4 → push 3
5 → pop 3 (since 'D', we wait)
6 → push 4
7 → pop 4, pop 3 (flush stack at end) → "2143"
Final output: "2143", which follows the pattern. Simple and clean! 🚀

Code
class Solution {
    public String smallestNumber(String pattern) {
        // int n = pattern.length()+1;
        // int i =1;
        // int j = n;
        // String str = "";
        // for(char x:pattern.toCharArray()){
        //     if(x == 'D'){
        //         str = str+j;
        //         j--;
        //     }else{
        //         str+=i;
        //         i++;
        //     }
        // }
        // return str;


        // int n = pattern.length()+1;
        // int[] arr = new int[n];
        // for(int i =0;i<n;i++){
        //     arr[i] = i+1;
        // }
        // StringBuilder str = new StringBuilder();
        // for(int i =0;i<pattern.length();i++){
        //     if(pattern.charAt(i) == 'I'){
        //         if(arr[i]>arr[i+1]){
        //             int temp = arr[i+1];
        //             arr[i+1] = arr[i];
        //             arr[i] = temp;
        //         }
        //     }else{
        //         if(arr[i]<arr[i+1]){
        //             int temp = arr[i+1];
        //             arr[i+1] = arr[i];
        //             arr[i] = temp;
        //         }
        //     }
        // }
        Stack<Integer>st = new Stack<>();
        StringBuilder str = new StringBuilder();
        int count = 1;
        for(int i = 0;i<=pattern.length();i++){
            st.push(count);
            if(i == pattern.length() || pattern.charAt(i) == 'I'){
                while(!st.isEmpty()){
                    str.append(st.pop());
                }
            }
            count++;   
        }
        while(!st.isEmpty()){
            str.append(st.pop());
        }
        return str.toString();
    }
}