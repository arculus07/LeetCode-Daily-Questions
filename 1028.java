// Hard
// Topics
// Companies
// Hint
// We run a preorder depth-first search (DFS) on the root of a binary tree.

// At each node in this traversal, we output D dashes (where D is the depth of this node), then we output the value of this node.  If the depth of a node is D, the depth of its immediate child is D + 1.  The depth of the root node is 0.

// If a node has only one child, that child is guaranteed to be the left child.

// Given the output traversal of this traversal, recover the tree and return its root.

 

// Example 1:


// Input: traversal = "1-2--3--4-5--6--7"
// Output: [1,2,5,3,4,6,7]
// Example 2:


// Input: traversal = "1-2--3---4-5--6---7"
// Output: [1,2,5,3,null,6,null,4,null,7]
// Example 3:


// Input: traversal = "1-401--349---90--88"
// Output: [1,401,null,349,88,90]
 

// Constraints:

// The number of nodes in the original tree is in the range [1, 1000].
// 1 <= Node.val <= 109

Approach
The solution reconstructs a binary tree from a preorder string where dashes indicate depth. It uses a,recursive approach, with an index tracking the current position. First, it counts the dashes to determine the depth, then extracts the next number as the node’s value. If the depth doesn’t match the expected level, it stops and backtracks. The function is called recursively to build the left and right subtrees, ensuring the tree is structured correctly. This method works efficiently by processing the string in a single pass, creating nodes dynamically based on their depth.

For example, in "1-2--3--4-5--6--7", the tree is built step by step. 1 is the root, 2 is placed at depth 1 as its left child, and 3 and 4 go under 2 at depth 2. Similarly, 5 appears at depth 1 as the right child of 1, with 6 and 7 placed under it at depth 2. The function ensures that every node is correctly placed based on the dashes, effectively recreating the original tree structure from the given string.

Time Complexity:O(N) – Each character in the string is processed once.
Space Complexity:O(N) (worst case) / O(log N) (best case) – Due to recursion depth

Code
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int n = 0;
    int i = 0;
    public TreeNode recoverFromPreorder(String str) {
        n = str.length();
        return dfs(str,0); 
    }
    public TreeNode dfs(String str,int a){
        if(i>n)return null;
        int count = 0;
        int ti = i;
        while(ti<n && !Character.isDigit(str.charAt(ti))){
            count++;
            ti++;
        }
        if(count!=a)return null;
        i = ti;
        int val = 0;
        while(i<n && Character.isDigit(str.charAt(i))){
            val = val*10+(str.charAt(i)-'0');
            i++;
        }
        TreeNode node = new TreeNode(val);
        node.left = dfs(str,a+1);
        node.right = dfs(str,a+1);
        return node;
    }
}