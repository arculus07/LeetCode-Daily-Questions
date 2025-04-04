// Given the root of a binary tree, return the lowest common ancestor of its deepest leaves.

// Recall that:

// The node of a binary tree is a leaf if and only if it has no children
// The depth of the root of the tree is 0. if the depth of a node is d, the depth of each of its children is d + 1.
// The lowest common ancestor of a set S of nodes, is the node A with the largest depth such that every node in S is in the subtree with root A.
 

// Example 1:


// Input: root = [3,5,1,6,2,0,8,null,null,7,4]
// Output: [2,7,4]
// Explanation: We return the node with value 2, colored in yellow in the diagram.
// The nodes coloured in blue are the deepest leaf-nodes of the tree.
// Note that nodes 6, 0, and 8 are also leaf nodes, but the depth of them is 2, but the depth of nodes 7 and 4 is 3.
// Example 2:

// Input: root = [1]
// Output: [1]
// Explanation: The root is the deepest node in the tree, and it's the lca of itself.
// Example 3:

// Input: root = [0,1,3,null,2]
// Output: [2]
// Explanation: The deepest leaf node in the tree is 2, the lca of one node is itself.
 

// Constraints:

// The number of nodes in the tree will be in the range [1, 1000].
// 0 <= Node.val <= 1000
// The values of the nodes in the tree are unique.
 

// Note: This question is the same as 865: https://leetcode.com/problems/smallest-subtree-with-all-the-deepest-nodes/\

💯🗣Beats 100% using the Simplest , DFS approach with easiest explanation✅💯

Ayush Ranjan
365 Days Badge
0
a few seconds ago
Hash Table
Tree
Depth-First Search
Binary Tree

1+
Approach
To find the Lowest Common Ancestor (LCA) of the deepest leaves in a binary tree, we first calculate the maximum depth (height) of the tree using a helper function. Once we know the depth of the deepest leaves, we use a Depth-First Search (DFS) approach to traverse the tree. While going down, we keep track of the current level. When we reach a node that is a leaf and also at the deepest level, we return it. While coming back up, if both left and right children return non-null (meaning both sides have deepest leaves), then the current node is their lowest common ancestor. If only one side has the deepest leaf, we return that side.

For example, suppose we have a tree like this:
1
/ \
2 3
/ \
4 5
Here, the deepest leaves are nodes 4 and 5, both at depth 3. We first find the height of the tree (which is 3), then start DFS from the root. Node 4 is the deepest leaf in the left subtree, and node 5 is the deepest leaf in the right subtree. Since both deepest leaves are found on different sides of node 1, the function returns node 1 as their LCA. So, the answer is node 1.

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
    int h;
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        h = calcH(root);
        return dfs(root,1);
    }
    public TreeNode dfs(TreeNode root,int k){
        if(root == null)return null;
        if(root.left == null && root.right == null && k == h)return root;

        TreeNode left = dfs(root.left,k+1);
        TreeNode right = dfs(root.right,k+1);

        if(left!=null && right != null)return root;
        return left!=null?left:right;
    }
    public int calcH(TreeNode root){
        if(root == null)return 0;

        return 1 + (int)Math.max(calcH(root.left),calcH(root.right));
    }
}