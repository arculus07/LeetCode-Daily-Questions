// Recurssive approach to Solve the Problem , Not the best one but yeah its good👍

// Ayush Ranjan
// 200 Days Badge 2024
// 0
// a few seconds ago
// Backtracking
// Recursion
// Java
// Approach:
// The idea is simple—we take each number from 1 to n, square it, and then check if we can split its digits into parts that sum up to the original number. If yes, we add the square to our result. The helper function gg does this by trying different ways to split the squared number and checking if the sum of those parts equals the original number. If it does, we include that square in our total sum.

// Let's take n = 10. For 9, its square is 81. Now, we check if we can split 81 into parts summing to 9. If we take "8" and "1", their sum is 9, which matches! So, we add 81 to the result. Similarly, for 1, 4, and 9, their squares (1, 16, 81) also work, and we sum them up. This is how the program finds numbers whose squares can be split correctly!

// The function tries to break the squared number into smaller parts and checks if their sum matches the original number. For example, take n = 9 → its square is 81. Now, we try different ways to split "81": taking "8" and "1", their sum is 8 + 1 = 9, which matches n. So, we add 81 to our result. Similarly, for n = 10, the square is 100. We try different splits like "10" and "0" or "1", "0", "0", but none sum to 10, so we skip it. The function explores all possible splits and stops early if the sum exceeds n, making it efficient! 🚀

// Code
class Solution {
    public int punishmentNumber(int n) {
        int res = 0;
        for(int i=1;i<=n;i++){
            int x = i*i;
            String str = Integer.toString(x);
            if(gg(str,i,0,0))res+=x;
        }
        return res;
    }
    public boolean gg(String str,int t,int i,int cS){
        if(i==str.length()){
            return cS==t;
        }
        if(cS>t)return false;
        boolean p = false;
        for(int j =i;j<str.length();j++){
            String ss = str.substring(i,j+1);
            int val = 0;
            if (!ss.isEmpty()) {
        val = Integer.parseInt(ss);
        }
            p = p||gg(str,t,j+1,cS+val);
            if(p)return true;
        }
        return false;
    }
}