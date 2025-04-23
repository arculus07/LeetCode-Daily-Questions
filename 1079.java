// You have n  tiles, where each tile has one letter tiles[i] printed on it.

// Return the number of possible non-empty sequences of letters you can make using the letters printed on those tiles.

 

// Example 1:

// Input: tiles = "AAB"
// Output: 8
// Explanation: The possible sequences are "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA".
// Example 2:

// Input: tiles = "AAABBC"
// Output: 188
// Example 3:

// Input: tiles = "V"
// Output: 1
 

// Constraints:

// 1 <= tiles.length <= 7
// tiles consists of uppercase English letters.

// Approach 1:
// in the first approach we are basically following the principle of recursion
// we are creating a hashSet to keep the track of unique elements (unique valid strings) and in the end we are returning it's size.

// a StringBuilder object is taken and passed to a function called solve together with boolean array which will keep track of used element(for every iteration) and making it back to false in each iteration.

// for each iteration we are running a for loop in which we are checking for valid combinations and if found storing it to the set , if not then continue [NoTE: it is possible for the functuion to get multiple similar valid combination , that is why we are using set , to keep track of only unique strings]

// finally after everything we are returning size - 1(for the empty string which we are adding in the very first function call)

// Approach 2:
// This is one of the coolest approach , where you are decreasing the space complexity to O(n) , previously it was O(n*n!){because of set boolean and recursion stack}

// here we are using the approach of Counting

// in place of taking the track of valid strings , we are just storing the count of each character in that string [we can use map also which is the ideal case , but we know there will be only 26 alphabets (Capital) that is why we are taking a constant arr instead of map]

// initially the main method is counting the number of each character in the string , ---> and then applying the permutation combination method , by calling the function

// checking how many valid combination can be formed for each count present in the arr . i'm not able to properly explain you this , but this is a very famous method , so you can search it on yt , you will easily find it there . Thanks

// Code
// <!-- Approach 1 -->
// class Solution {
//     public HashSet<String>set = new HashSet<>();
//     public int numTilePossibilities(String tiles) {
//         boolean[] ref = new boolean[tiles.length()];
//         StringBuilder str = new StringBuilder();
//         solve(tiles,ref,str);
//         return set.size()-1;
//     }
//     public void solve(String tiles,boolean[] ref,StringBuilder str){
//         set.add(str.toString());

//         for(int i =0;i<tiles.length();i++){
//             if(ref[i]){
//                 continue;
//             }
//             ref[i] = true;
//             str.append(tiles.charAt(i));
//             solve(tiles,ref,str);
//             ref[i] = false;
//             str.deleteCharAt(str.length()-1);
//         }
//     }
// } 
// <!-- Approach 2 -->

class Solution {
    public int res = 0;
    private void solve(int[] arr) {
        res++;
        for(int i =0;i<26;i++){
            if(arr[i] == 0)continue;
            arr[i]--;
            solve(arr);
            arr[i]++;
        }
    }

    public int numTilePossibilities(String tiles) {
        int[] arr = new int[26];
        for(char c:tiles.toCharArray()){
            arr[c-'A']++;
        }
        solve(arr);
        return res-1;
    }
}gg