// Given an integer n, return true if it is possible to represent n as the sum of distinct powers of three. Otherwise, return false.

// An integer y is a power of three if there exists an integer x such that y == 3x.

 

// Example 1:

// Input: n = 12
// Output: true
// Explanation: 12 = 31 + 32
// Example 2:

// Input: n = 91
// Output: true
// Explanation: 91 = 30 + 32 + 34
// Example 3:

// Input: n = 21
// Output: false
 

// Constraints:

// 1 <= n <= 107

// ✅Very Unexpected Approach , just found the pattern Randomly and beat 100% with ease💯🐱‍👤

// Ayush Ranjan
// 200 Days Badge 2024
// 2
// 2 hours ago
// Math
// Simulation
// Java
// Well the idea is very simple , just keep dividing the number by 3 till it come to 0
// -- But in each iteration , keep checking whether the remainder for each each iteration is 2 or not , because one it comes to 2 it'll never be able to become the next power of 3 ,so return false , else return true....

// Code
class Solution {
    public boolean checkPowersOfThree(int n) {
        while(n>0){
            int x = n%3;
            if(x==2)return false;
            n = n/3;
        }
        return true;
    }
}