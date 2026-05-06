# 145. Binary Tree Postorder Traversal

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/binary-tree-postorder-traversal/)

`Stack` · `Tree` · `Depth-First Search` · `Binary Tree`

## Intuition
Postorder traversal visits a node only after its left and right subtrees have been processed.  
Recursion naturally models this “process children first, then node” pattern, eliminating the need for an explicit stack.

## Approach
The solution defines a helper `postOrder` that takes a node and a list.  
1. If the node is `null`, return immediately.  
2. Recursively traverse the left child.  
3. Recursively traverse the right child.  
4. Append the current node’s value to the result list.  
The public method initializes an empty list, calls the helper with the root, and returns the populated list.

## Complexity
- **Time:** O(n) – each node is visited once.  
- **Space:** O(h) – recursion depth equals the tree height (worst‑case O(n) for a skewed tree).

## Solution (java)

```java
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
    private static void postOrder(TreeNode root, List<Integer> results){
        if (root == null) return;
        postOrder(root.left, results);
        postOrder(root.right, results);
        results.add(root.val);
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        postOrder(root, results);
        return results;
    }   
}
```

---

**Runtime** 0 ms · **Memory** 43.1 MB

<sub>Synced by AILeetHub on 2026-05-06.</sub>
