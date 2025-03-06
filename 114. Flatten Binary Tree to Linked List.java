// Given the root of a binary tree, flatten the tree into a "linked list":

// The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list and the left child pointer is always null.
// The "linked list" should be in the same order as a pre-order traversal of the binary tree.
 

// Example 1:


// Input: root = [1,2,5,3,4,null,6]
// Output: [1,null,2,null,3,null,4,null,5,null,6]
// Example 2:

// Input: root = []
// Output: []
// Example 3:

// Input: root = [0]
// Output: [0]
 

// Constraints:

// The number of nodes in the tree is in the range [0, 2000].
// -100 <= Node.val <= 100
 

// Follow up: Can you flatten the tree in-place (with O(1) extra space)?
Approach 1: Recursion
This approach uses recursion to flatten the tree. We first recursively flatten the left and right subtrees. Then, we rearrange the tree by making the left subtree the right subtree and setting the left child to null. After that, we traverse to the rightmost node of the newly attached subtree and attach the original right subtree to it. This way, we gradually convert the tree into a linked list following the pre-order traversal order.

For example, consider this tree:
,
1
/ \
2 5
/ \ \
3 4 6
First, we flatten the left subtree (2 -> 3 -> 4), then attach it to 1's right. Now 5 -> 6 is detached. We find the rightmost node (4) and attach 5 -> 6 back. The final structure becomes:
1 -> 2 -> 3 -> 4 -> 5 -> 6
Everything is now a single right-leaning linked list.

Approach 2: Stack (Iterative)
This method uses a stack to process the nodes iteratively. We push the root onto the stack and keep processing nodes in a pre-order fashion. If the node has a right child, we push it onto the stack first, then the left child. This ensures that the left subtree is processed before the right subtree. We then adjust pointers so that each node's right points to the next node in pre-order, and we set the left child to null.

For example, consider this tree:

.
1
/ \
2 5
/ \ \
3 4 6
We push 1, then process 2 before 5, then 3, 4, and finally 6. While popping, we adjust 1's right to 2, 2's right to 3, and so on. The final structure is:
1 -> 2 -> 3 -> 4 -> 5 -> 6
Again, the tree is converted into a linked list.

Approach 3: Morris Traversal (Constant Space)
This is the most optimized approach, using no extra space. We check if a node has a left child; if it does, we find its rightmost node (predecessor) and link its right to the node’s right subtree. Then, we move the left subtree to the right and set the left to null. We repeat this process until we traverse the entire tree.

For example, take this tree:

.
1
/ \
2 5
/ \ \
3 4 6
We start at 1, move 2 to the right, and find 4 as 2's rightmost node, attaching 5 -> 6 to 4. Then, we move 2 to 1's right. Repeating this for 2, 3, and 4, we get the final flattened tree:
1 -> 2 -> 3 -> 4 -> 5 -> 6
This approach efficiently flattens the tree in O(n) time without using extra space.

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
    public void flatten(TreeNode root) {
        // if(root == null)return;
        // TreeNode left = root.left;
        // TreeNode right = root.right;
        // flatten(root.left);
        // flatten(root.right);
        // root.left = null;
        // root.right = left;
        // TreeNode temp = root;
        // while(temp!=null && temp.right!=null){
        //     temp = temp.right;
        // }
        // temp.right = right; 

        // if(root == null)return;
        // Stack<TreeNode>st = new Stack<>();
        // st.push(root);
        // while(!st.isEmpty()){
        //     TreeNode curr = st.pop();
        //     if(curr.right!=null){
        //         st.push(curr.right);
        //     }
        //     if(curr.left!=null){
        //         st.push(curr.left);
        //     }

        //     if(!st.isEmpty()){
        //         curr.right = st.peek();
        //     }
        //     curr.left = null;
        // }

        TreeNode curr = root;

        while(curr!=null){
            if(curr.left==null){
                curr = curr.right;
            }else{
                TreeNode temp = curr.left;
                while(temp.right!=null)temp = temp.right;
                temp.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }
        }



    }
}