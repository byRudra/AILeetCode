# 83. Remove Duplicates from Sorted List

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/remove-duplicates-from-sorted-list/)

`Linked List`

## Intuition
Because the list is already sorted, any duplicate values will appear consecutively.  
Thus, we only need to compare each node with its immediate successor; if they share the same value, the successor can be removed without affecting the rest of the list.

## Approach
1. Handle the trivial case where the list is empty (`head == null`) by returning `null`.  
2. Use two pointers:  
   * `Prev` starts at the first node (`head`).  
   * `Curr` starts at the second node (`head.next`).  
3. Iterate while `Curr` is not `null`:  
   * If `Prev.val == Curr.val`, the current node is a duplicate.  
     * Skip it by setting `Prev.next = Curr.next`.  
   * Otherwise, move `Prev` forward to `Curr`.  
   * Advance `Curr` to its next node (`Curr = Curr.next`).  
4. After the loop, the list contains only unique values and is returned.

This in‑place traversal removes duplicates in a single pass without extra data structures.

## Complexity
- **Time:** O(n) – each node is examined once.  
- **Space:** O(1) – only a few pointer variables are used regardless of input size.

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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode Prev = head;
        ListNode Curr = head.next;

        while(Curr != null){
            if (Prev.val == Curr.val){
                Prev.next = Curr.next;
            }
            else{
            Prev = Curr;
        }
            Curr = Curr.next;
        }
        return head;
    }
}
```

---

**Runtime** 0 ms · **Memory** 44.2 MB

<sub>Synced by AILeetHub on 2025-04-02.</sub>
