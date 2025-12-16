# 2095. Delete the Middle Node of a Linked List

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/)

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
    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) return null;
        int size = 0;
        ListNode temp = head;
        while(temp!= null){temp = temp.next;size++;}

        int middle = size / 2;
        temp = head;
        for(int i = 0; i<middle -1;i++){
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return head;
    }
}
```

---

**Runtime** 4 ms · **Memory** 202.5 MB

<sub>Synced by AILeetHub on 2025-12-16.</sub>
