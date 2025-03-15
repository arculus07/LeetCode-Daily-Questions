// Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

// A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.


 

// Example 1:

// Input: digits = "23"
// Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
// Example 2:

// Input: digits = ""
// Output: []
// Example 3:

// Input: digits = "2"
// Output: ["a","b","c"]
 

// Constraints:

// 0 <= digits.length <= 4
// digits[i] is a digit in the range ['2', '9'].

class Solution {
    List<String>result = new ArrayList<>();
    int N;
    HashMap<Character,String>map = new HashMap<>();
    public List<String> letterCombinations(String digits) {
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        N = digits.length();
        if(digits.length() == 0)return result;
        solve(digits,new StringBuilder(),0);
        return result;
    }
    public void solve(String digits,StringBuilder str,int index){
        if(index == N){
            result.add(str.toString());
            return;
        }   
        String fetch = map.get(digits.charAt(index));
        for(int i = 0;i<fetch.length();i++){
            str.append(fetch.charAt(i));
            solve(digits,str,index+1);
            str.deleteCharAt(str.length()-1);
        }
    }
}