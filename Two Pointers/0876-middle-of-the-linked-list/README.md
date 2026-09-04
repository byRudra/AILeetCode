# 876. Middle of the Linked List

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/middle-of-the-linked-list/)

`Linked List` · `Two Pointers`

## Approach

Accepted easy solution in Java.
Relevant topics: Linked List, Two Pointers.

## Complexity

- **Time:** _not analysed_
- **Space:** _not analysed_

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

**Runtime** 0 ms (beats 100.0%) · **Memory** 43.3 MB (beats 16.0%)

<sub>Synced by AILeetHub on 2026-09-04.</sub>
