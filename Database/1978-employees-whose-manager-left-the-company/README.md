# 1978. Employees Whose Manager Left the Company

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/employees-whose-manager-left-the-company/)

`Database`

## Approach

Accepted easy solution in mysql.
Relevant topics: Database.

## Complexity

- **Time:** _not analysed_
- **Space:** _not analysed_

## Solution (mysql)

```sql
SELECT e.employee_id
FROM Employees e
LEFT JOIN Employees m
ON e.manager_id = m.employee_id
WHERE e.salary < 30000
AND e.manager_id IS NOT NULL
AND m.employee_id IS NULL
ORDER BY e.employee_id;
```

---

**Runtime** 371 ms · **Memory** 0.0B

<sub>Synced by AILeetHub on 2026-04-27.</sub>
