# 876. Middle of the Linked List

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/middle-of-the-linked-list/)

`Linked List` · `Two Pointers`

## Intuition  
If two pointers move through the list at different speeds, the slower one will be halfway when the faster one reaches the end. This classic “tortoise‑and‑hare” idea gives the middle node in a single pass without extra storage.

## Approach  
Initialize `slow` and `fast` both at `head`. In each loop iteration advance `slow` by one node (`slow = slow.next`) and `fast` by two nodes (`fast = fast.next.next`). The loop condition `fast != null && fast.next != null` stops when `fast` has stepped past the list’s tail. At that moment `slow` points to the second middle node for even‑length lists (because `fast` moves two steps, leaving `slow` one step behind the true center). Return `slow` as the required middle node.

## Complexity  
- **Time:** O(n) – each iteration moves `fast` two steps, so the loop runs at most n/2 times, visiting every node a constant number of times.  
- **Space:** O(1) – only two pointer variables are used regardless of list size.

## Solution (Java)

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
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
```

---

**Runtime** 0 ms (beats 100.0%) · **Memory** 43 MB (beats 16.0%)

<sub>Synced by AILeetHub on 2026-09-04.</sub>
