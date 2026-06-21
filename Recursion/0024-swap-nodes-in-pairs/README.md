# 24. Swap Nodes in Pairs

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/swap-nodes-in-pairs/)

`Linked List` · `Recursion`

## Intuition
Swapping nodes in pairs can be done by re‑linking the nodes rather than changing their values.  
If the list starts with nodes `A → B → …`, after swapping the first pair it should become `B → A → …`.  
The rest of the list, starting at the node after `A`, can be processed in the same way, so a recursive approach naturally fits.

## Approach
The recursive function `swapPairs` handles the base case when the list has fewer than two nodes – it simply returns the head.  
For a list with at least two nodes:

1. Let `temp` point to the second node (`head.next`).  
2. Link the first node to the node after the pair: `head.next = temp.next`.  
3. Link the second node to the first: `temp.next = head`.  
4. Recursively swap the remaining list starting from `head.next` and attach the result to `head.next`.  
5. Return `temp`, which is now the new head of the swapped pair.

This process continues until the end of the list is reached, building the fully swapped list as the recursion unwinds.

## Complexity
- **Time:** O(n) – each node is visited once.  
- **Space:** O(n) – recursion depth equals the number of node pairs, up to n/2 frames.

## Solution (java)

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = head.next;
        head.next = temp.next;
        temp.next = head;
        head.next = swapPairs(head.next);
        return temp;
    }
}
```

---

**Runtime** 0 ms · **Memory** 43 MB

<sub>Synced by AILeetHub on 2026-06-21.</sub>
