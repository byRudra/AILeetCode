# 82. Remove Duplicates from Sorted List II

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/)

`Linked List` · `Two Pointers`

## Approach

Accepted medium solution in java.
Relevant topics: Linked List, Two Pointers.

## Complexity

- **Time:** _not analysed_
- **Space:** _not analysed_

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
        if (head == null)
            return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode curr = head;

        while (curr != null) {
            if (curr.next != null && curr.val == curr.next.val) {
                int currVal = curr.val;

                while (curr != null && curr.val == currVal) {
                    curr = curr.next;
                }
                prev.next = curr;
            } else {
                prev = curr;
                curr = curr.next;
            }
        }
        return dummy.next;
    }
}
```

---

**Runtime** 0 ms · **Memory** 45.2 MB

<sub>Synced by AILeetHub on 2025-12-28.</sub>
