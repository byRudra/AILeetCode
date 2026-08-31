# 2058. Find the Minimum and Maximum Number of Nodes Between Critical Points

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/find-the-minimum-and-maximum-number-of-nodes-between-critical-points/)

`Linked List`

## Approach

Accepted medium solution in java.
Relevant topics: Linked List.

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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return new int[] { -1, -1 };
        }

        ListNode prev = head;
        ListNode curr = head.next;
        int idx = 1;

        int firstIdx = -1;
        int prevCritIdx = -1;
        int minDist = Integer.MAX_VALUE;
        int maxDist = -1;

        while (curr.next != null) {
            ListNode next = curr.next;
            boolean isCrit = (curr.val > prev.val && curr.val > next.val)
                    || (curr.val < prev.val && curr.val < next.val);

            if (isCrit) {
                if (firstIdx == -1) {
                    firstIdx = idx;
                } else {
                    minDist = Math.min(minDist, idx - prevCritIdx);
                    maxDist = idx - firstIdx;
                }
                prevCritIdx = idx;
            }
            prev = curr;
            curr = next;
            idx++;
        }
        return minDist == Integer.MAX_VALUE ? new int[] { -1, -1 } : new int[] { minDist, maxDist };

    }
}
```

---

**Runtime** 5 ms · **Memory** 105.7 MB

<sub>Synced by AILeetHub on 2026-08-31.</sub>
