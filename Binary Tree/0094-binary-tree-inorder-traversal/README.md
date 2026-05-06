# 94. Binary Tree Inorder Traversal

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/binary-tree-inorder-traversal/)

`Stack` · `Tree` · `Depth-First Search` · `Binary Tree`

## Intuition
Inorder traversal visits a binary tree in the order *left subtree → node → right subtree*.  
Because the tree is binary, a simple depth‑first recursion naturally follows this pattern: first descend to the leftmost node, then record the node’s value, and finally explore the right subtree.

## Approach
The solution defines a helper `inOrder(TreeNode root, List<Integer> results)` that performs a recursive inorder walk.  
* If the current node is `null`, the recursion stops.  
* Otherwise, it recursively processes the left child, appends the current node’s value to the result list, and then recursively processes the right child.  
The public method `inorderTraversal` initializes an empty list, handles the trivial empty‑tree case, and invokes the helper. The final list contains the node values in inorder sequence.

## Complexity
- **Time:** O(n) – each node is visited once during the recursion.  
- **Space:** O(h) – the recursion stack depth equals the tree height (≤ n), so auxiliary space is proportional to the height.

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
```

---

**Runtime** 0 ms · **Memory** 42.9 MB

<sub>Synced by AILeetHub on 2026-05-06.</sub>
