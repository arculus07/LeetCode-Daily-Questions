// A digit string is good if the digits (0-indexed) at even indices are even and the digits at odd indices are prime (2, 3, 5, or 7).

// For example, "2582" is good because the digits (2 and 8) at even positions are even and the digits (5 and 2) at odd positions are prime. However, "3245" is not good because 3 is at an even index but is not even.
// Given an integer n, return the total number of good digit strings of length n. Since the answer may be large, return it modulo 109 + 7.

// A digit string is a string consisting of digits 0 through 9 that may contain leading zeros.

 

// Example 1:

// Input: n = 1
// Output: 5
// Explanation: The good numbers of length 1 are "0", "2", "4", "6", "8".
// Example 2:

// Input: n = 4
// Output: 400
// Example 3:

// Input: n = 50
// Output: 564908303

class Solution {
    public final long MOD = 1000000007;
    public int countGoodNumbers(long n) {
        
        // long result = 1;
        // for(int i =0;i<n;i++){
        //     if(i%2 == 0){
        //         result = (result*5)%MOD;
        //     }else{
        //         result = (result*4)%MOD;
        //     }
        // }
        // return (int)(result); TLE for some reason 
        return (int)(((long)findP(5,(n+1)/2) * (long)findP(4,n/2))%MOD);
        
    }
    public long findP(long a,long b){
        if(b ==0)return 1;

        long half = findP(a,b/2);
        long result = (half*half)%MOD;
        if(b%2 != 0)result=(result*a)%MOD;
        return result;
    }
}