# 2181. Merge Nodes in Between Zeros

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/merge-nodes-in-between-zeros/)

`Linked List` · `Simulation`

## Intuition
The zeros in the list act as sentinels that separate groups of values.  
Between any two consecutive zeros we must replace the whole group with a single node whose value is the sum of that group.  
Thus the problem reduces to scanning the list once, accumulating a running sum until a zero is encountered, then emitting a new node with that sum.

## Approach
Create a dummy head and a pointer `tail` that will always point to the last node of the result list.  
Skip the very first zero (`head = head.next`).  
Traverse the original list with a `while` loop.  
If the current node’s value is non‑zero, add it to a running `sum`.  
When a zero is seen, it marks the end of a segment: create a new node with the accumulated `sum`, link it after `tail`, advance `tail`, and reset `sum` to zero.  
Move to the next node and repeat until the list ends.  
Finally return `dummy.next`, which is the head of the merged list.

## Complexity
- **Time:** O(n) – each node is visited once.  
- **Space:** O(1) – only a few pointers and a sum variable are used; the output nodes are the ones already created.

## Solution (java)

```java
class Solution {
    public ListNode mergeNodes(ListNode head) {

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        int sum = 0;
        head = head.next; // skip first zero

        while (head != null) {

            if (head.val == 0) {
                // end of segment
                tail.next = new ListNode(sum);
                tail = tail.next;
                sum = 0;
            } else {
                sum += head.val;
            }

            head = head.next;
        }

        return dummy.next;
    }
}
```

---

**Runtime** 6 ms · **Memory** 261 MB

<sub>Synced by AILeetHub on 2026-02-24.</sub>
