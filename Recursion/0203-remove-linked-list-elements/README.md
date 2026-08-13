# 203. Remove Linked List Elements

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/remove-linked-list-elements/)

`Linked List` · `Recursion`

## Intuition
Removing nodes from a singly linked list requires careful handling of the head pointer, especially when the first few nodes match the target value. A dummy node placed before the real head simplifies edge cases by ensuring that the node preceding any removable element is always accessible.

## Approach
Create a dummy node whose `next` points to the original head. Use a pointer `curr` starting at the dummy. Iterate while `curr.next` exists. If the next node’s value equals `val`, bypass it by setting `curr.next = curr.next.next`; otherwise advance `curr` to the next node. This single pass removes all matching nodes. Finally, return `dummy.next` as the new head, which correctly handles cases where the original head was removed or the list became empty.

## Complexity
- **Time:** O(n) – each node is examined once.
- **Space:** O(1) – only a few pointers are used regardless of list size.

## Solution (java)

```java
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0, head);
        ListNode curr = dummy;

        while (curr.next != null) {
            if (curr.next.val == val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }

        return dummy.next;
    }
}
```

---

**Runtime** 1 ms · **Memory** 47.3 MB

<sub>Synced by AILeetHub on 2026-08-13.</sub>
