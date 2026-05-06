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
    private int height(TreeNode root){
        if (root == null) return 0;

        // cal left height

        int leftHeight = height(root.left);

        // checking if left is unbalanced or not
        if (leftHeight == -1) return -1;

        // similary for right

        // cal right height

        int rightHeight = height(root.right);

        // checking if right is unbalanced or not
        if (rightHeight == -1) return -1;

        // now checking for the current node

        if(Math.abs(leftHeight - rightHeight) > 1) return -1;

        // now returning the normal height

        return 1 + Math.max(leftHeight, rightHeight); 
    }
    public boolean isBalanced(TreeNode root) {
        int rootHeight;
        return height(root) != -1;
    }
}