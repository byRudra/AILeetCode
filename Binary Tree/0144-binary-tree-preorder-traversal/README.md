# 144. Binary Tree Preorder Traversal

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/binary-tree-preorder-traversal/)

`Stack` · `Tree` · `Depth-First Search` · `Binary Tree`

## Approach

Accepted easy solution in java.
Relevant topics: Stack, Tree, Depth-First Search, Binary Tree.

## Complexity

- **Time:** _not analysed_
- **Space:** _not analysed_

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
```

---

**Runtime** 0 ms · **Memory** 43.3 MB

<sub>Synced by AILeetHub on 2026-05-06.</sub>
