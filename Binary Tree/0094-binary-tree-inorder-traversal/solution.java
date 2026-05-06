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
 * }r
 */
class Solution {
    // Using Recursive Approach
    private static void inOrder(TreeNode root, List<Integer> results){
        if (root == null) return;

        inOrder(root.left, results);
        results.add(root.val);
        inOrder(root.right, results);
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        
        List<Integer> results = new ArrayList<>();
        if (root == null) return results ;

        inOrder(root, results);

        return results;
    }

    // Using Iterative Approach(Better)
}