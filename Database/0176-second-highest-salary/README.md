# 176. Second Highest Salary

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/second-highest-salary/)

`Database`

## Intuition  
The goal is to retrieve the second highest distinct salary from the `Employee` table.  
Because salaries can repeat, we first need a list of unique values.  
Once we have the distinct salaries, the natural ordering (descending) places the highest salary first, the second highest second, and so on.  
Thus, selecting the element at index 1 (the second position) after ordering yields the desired result.

## Approach  
1. **Distinct extraction** – `SELECT DISTINCT salary FROM Employee` removes duplicates.  
2. **Ordering** – `ORDER BY salary DESC` arranges the unique salaries from largest to smallest.  
3. **Offset selection** – `LIMIT 1 OFFSET 1` skips the first (highest) salary and returns the next one.  
4. The subquery’s result is aliased as `SecondHighestSalary`.  
If fewer than two distinct salaries exist, the subquery returns no rows, and the outer query yields `NULL`, matching the problem’s requirement.

## Complexity  
- **Time:** O(n log n) – sorting the distinct salaries dominates the cost.  
- **Space:** O(1) – aside from the database’s internal structures, the query uses constant auxiliary space.

## Solution (mysql)

```sql
# Write your MySQL query statement below
SELECT (
    SELECT DISTINCT salary 
    FROM Employee 
    ORDER BY salary DESC
    LIMIT 1
    OFFSET 1
) as SecondHighestSalary
```

---

**Runtime** 381 ms · **Memory** 0.0B

<sub>Synced by AILeetHub on 2026-08-20.</sub>
