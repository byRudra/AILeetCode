# 141. Linked List Cycle

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/linked-list-cycle/)

`Hash Table` · `Linked List` · `Two Pointers` · `Floyd's Cycle Finding Algorithm`

## Approach

Accepted easy solution in java.
Relevant topics: Hash Table, Linked List, Two Pointers, Floyd's Cycle Finding Algorithm.

## Complexity

- **Time:** _not analysed_
- **Space:** _not analysed_

## Solution (java)

```java
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null){
            if(slow == fast) return true;
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }
}
```

---

**Runtime** 0 ms · **Memory** 46.7 MB

<sub>Synced by AILeetHub on 2026-06-18.</sub>
