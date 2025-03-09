// Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

 

// Example 1:

// Input: n = 3
// Output: ["((()))","(()())","(())()","()(())","()()()"]
// Example 2:

// Input: n = 1
// Output: ["()"]
 

// Constraints:

// 1 <= n <= 8
class Solution {
    List<String>arr = new ArrayList<>();
    int N = 0;
    public List<String> generateParenthesis(int n) {
        N = n;
        solve(new StringBuilder(),0,0);
        return arr;
    }
    public void solve(StringBuilder str,int open,int close){
        if(str.length() == 2*N){
            if(isValid(str.toString()))arr.add(str.toString());
            return;
        }

        if(open<N){
            str.append("(");
            solve(str,open+1,close);
            str.deleteCharAt(str.length()-1);
        }
        if(close<N){
            str.append(")");
            solve(str,open,close+1);
            str.deleteCharAt(str.length()-1);
        }
    }
    public boolean isValid(String str){
        // String res = str;
        // while(res.contains("()"))res = res.replace("()","");
        // return res.length()==0;
        Stack<Character>st = new Stack<>();
        for(char c:str.toCharArray()){
            if(c == '(')st.push(')');
            else{
                if(st.isEmpty())return false;
                st.pop();
            }
        }
        return true;
    }
}