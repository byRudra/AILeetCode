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
    // Using Recursive Approach
    private static void preOrder(TreeNode root, List<Integer> results){
        if (root == null) return;

        results.add(root.val);
        preOrder(root.left, results);
        preOrder(root.right, results);
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        
        List<Integer> results = new ArrayList<>();
        if (root == null) return results ;

        preOrder(root, results);

        return results;
    }
}