# 138. Copy List with Random Pointer

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/copy-list-with-random-pointer/)

`Hash Table` · `Linked List`

## Intuition  
When we need to duplicate a structure that contains arbitrary cross‑links (the `random` pointers), the main obstacle is locating the copy of a target node without scanning the list repeatedly. The key observation is that if we can store a one‑to‑one correspondence between every original node and its newly created clone, then any later pointer can be resolved in O(1) by a simple lookup. This eliminates the need for a second traversal per pointer, a hash‑set‑based visitation check, or recursive cloning. The solution therefore follows the classic *hash‑map* pattern: first build the map of originals to clones, then wire the `next` and `random` edges using that map.

## Approach  
1. **Handle empty input** – If `head` is `null`, return `null` immediately. This guards the algorithm against a degenerate list.  
2. **First pass – create nodes**  
   - Initialise `curr = head`.  
   - While `curr != null`:  
     - Insert `curr` as a key and `new Node(curr.val)` as its value into `map`.  
     - Advance `curr = curr.next`.  
   - Invariant: after each iteration, every node visited so far has an entry in `map` pointing to its clone, and `curr` points to the next unprocessed original node.  
3. **Second pass – connect pointers**  
   - Reset `curr = head`.  
   - While `curr != null`:  
     - Set `map.get(curr).next = map.get(curr.next)`.  
     - Set `map.get(curr).random = map.get(curr.random)`.  
     - Advance `curr = curr.next`.  
   - Invariant: before each iteration, all clones of nodes up to (but not including) `curr` have their `next` and `random` fields correctly assigned; the map already contains entries for `curr.next` and `curr.random` (or `null`), so the assignments are O(1).  
4. **Return the cloned head** – `map.get(head)` yields the entry for the original head, which is now the head of the deep‑copied list.

## Dry Run  
Input list (value, random‑index): `[(1,null), (2,0), (3,1)]`

| Iter | `curr.val` | `map.get(curr).next.val` | `map.get(curr).random.val` | Note |
|------|------------|--------------------------|----------------------------|------|
| 1    | 1          | 2                        | null                       | After first iteration of second pass, clone of node 1 points to clone 2; random stays null. |
| 2    | 2          | 3                        | 1                          | Clone 2’s `next` set to clone 3, `random` set to clone 1 (original random index 0). |
| 3    | 3          | null                     | 2                          | Clone 3’s `next` is null (end of list), `random` set to clone 2 (original random index 1). |
| 4    | null       | –                        | –                          | Loop exits because `curr` becomes null. |

After the loop, `map.get(head)` is the clone of the original node 1, whose `next` and `random` chains exactly mirror the original list. Hence the returned list is a deep copy.

## Complexity  
- **Time:** O(n) – we traverse the list twice; the first loop creates n nodes, the second loop performs two constant‑time map lookups per node.  
- **Space:** O(n) – the hash map stores one entry for each of the n original nodes; the output list itself is not counted against the auxiliary space.

## Solution (Java)

```java
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
             if (head == null) {
            return null;
        }

        HashMap<Node, Node> map = new HashMap<>();

        // Create copies
        Node curr = head;

        while (curr != null) {
            map.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        // Connect next and random
        curr = head;

        while (curr != null) {
            map.get(curr).next = map.get(curr.next);
            map.get(curr).random = map.get(curr.random);

            curr = curr.next;
        }

        return map.get(head);
    }
}
```

---

**Runtime** 0 ms (beats 100.0%) · **Memory** 46.8 MB (beats 14.3%)

<sub>Synced by AILeetHub on 2026-09-05.</sub>
