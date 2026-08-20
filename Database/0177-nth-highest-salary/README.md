# 177. Nth Highest Salary

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/nth-highest-salary/)

`Database`

## Intuition
The goal is to return the *n*‑th distinct highest salary.  
A natural way to rank distinct values in SQL is to use a window function that assigns a rank to each salary in descending order.  
`DENSE_RANK()` gives the same rank to equal salaries and skips no numbers, so the first rank is the highest salary, the second rank the second distinct highest, and so on.

## Approach
1. **Rank the salaries** –  
   ```sql
   SELECT salary,
          DENSE_RANK() OVER (ORDER BY salary DESC) AS ranking
   FROM Employee
   ```
   This produces a result set where each row has its salary and the rank of that salary among all distinct salaries.

2. **Filter for the desired rank** –  
   Wrap the above query in a subquery and keep only the row whose `ranking` equals the input `N`.

3. **Return the value** –  
   The outer query selects `salary` from the filtered subquery and limits the result to one row.  
   If no row matches (i.e., fewer than `N` distinct salaries), the function returns `NULL`.

## Complexity
- **Time:** O(n log n) – the window function requires sorting the `n` rows by salary.  
- **Space:** O(n) – the intermediate result set holds one row per employee for the ranking calculation.

## Solution (mysql)

```sql
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  RETURN (
      # Write your MySQL query statement below.
    SELECT salary FROM (
        SELECT salary, DENSE_RANK() OVER(ORDER BY salary DESC) as ranking FROM Employee
    ) as t where ranking = N LIMIT 1
  );
END
```

---

**Runtime** 470 ms · **Memory** 0.0B

<sub>Synced by AILeetHub on 2026-08-20.</sub>
