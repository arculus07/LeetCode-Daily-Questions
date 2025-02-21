Approach
We useDepth First Search (DFS)to traverse the tree and assign correct values to each node while storing them in a HashSet. Starting from the root (0), we recursively set values for the left (2x + 1) and right (2x + 2) children. This ensures that every node follows the given reconstruction rules. When the find function is called, we simply check if the given target exists in our HashSet, making lookups fast.

Complexity
Time Complexity:

O(n) — Each node is visited once during the DFS traversal, and lookups in a HashSet are
O(1) on average.
Space Complexity:
O(n) — We store all node values in a HashSet, which takes additional space proportional to the number of nodes.

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
class FindElements {
    HashSet<Integer>set =new HashSet<>();
    public FindElements(TreeNode root) {
        dfs(root,0);   
    }
    public boolean find(int target) {
        return set.contains(target);
    }
    public void dfs(TreeNode root,int val){
        if(root==null)return;
        root.val = val;
        set.add(val);
        dfs(root.left,2*val+1);
        dfs(root.right,2*val+2);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */