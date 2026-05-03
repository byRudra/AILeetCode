# 148. Sort List

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/sort-list/)

`Linked List` · `Two Pointers` · `Divide and Conquer` · `Sorting` · `Merge Sort`

## Approach

Accepted medium solution in java.
Relevant topics: Linked List, Two Pointers, Divide and Conquer, Sorting, Merge Sort.

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
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        // partition
        ListNode mid = getMiddle(head);
        ListNode right = mid.next;
        mid.next = null;
        ListNode left = head;
        left = sortList(left);
        right = sortList(right);
        return mergeList(left, right);
    }

    private ListNode mergeList(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (left != null && right != null) {
            if (left.val < right.val) {
                tail.next = left;
                left = left.next;
            } else {
                tail.next = right;
                right = right.next;
            }
            tail = tail.next;
        }

        if (left != null)
            tail.next = left;
        if (right != null)
            tail.next = right;
        return dummy.next;
    }

    private ListNode getMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;

    }
}
```

---

**Runtime** 10 ms · **Memory** 59.2 MB

<sub>Synced by AILeetHub on 2026-05-03.</sub>
