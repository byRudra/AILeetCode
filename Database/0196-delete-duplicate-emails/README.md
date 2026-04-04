# 196. Delete Duplicate Emails

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/delete-duplicate-emails/)

`Database`

## Intuition  
The goal is to keep only the earliest occurrence of each email address.  
Because the `id` column is unique and monotonically increasing, the row with the smallest `id` for a given email is the one that must survive. All other rows with the same email are duplicates and should be removed.

## Approach  
The solution uses a self‑join on the `Person` table.  
```sql
DELETE p1
FROM Person p1, Person p2
WHERE p1.email = p2.email
  AND p1.id > p2.id;
```
For every pair of rows that share the same email, the join produces a record where `p1.id` is greater than `p2.id`.  
The `DELETE` clause then removes the `p1` row.  
Because the join is performed for all matching email pairs, every duplicate row that has a larger `id` than at least one other row with the same email is deleted.  
Only the row with the smallest `id` for each email remains, satisfying the requirement.

## Complexity  
- **Time:** O(n²) – the self‑join compares each pair of rows with the same email, which in the worst case can involve all rows.  
- **Space:** O(1) – the operation uses only constant extra storage aside from the temporary result of the join.

## Solution (mysql)

```sql
DELETE p1
FROM Person p1, Person p2
WHERE p1.email = p2.email
AND p1.id > p2.id;
```

---

**Runtime** 827 ms · **Memory** 0.0B

<sub>Synced by AILeetHub on 2026-04-04.</sub>
