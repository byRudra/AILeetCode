# 1070. Product Sales Analysis III

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/product-sales-analysis-iii/)

`Database`

## Intuition  
The goal is to isolate, for each product, the sales that happened in its earliest year.  
If we know the minimum year per product, any row whose `(product_id, year)` pair matches that minimum belongs to the desired set.

## Approach  
1. **Find earliest years** – The subquery  
   ```sql
   SELECT product_id, MIN(year) AS first_year
   FROM Sales
   GROUP BY product_id
   ```  
   produces a list of `(product_id, first_year)` pairs.  
2. **Filter original rows** – The outer query selects all columns from `Sales` where the pair `(product_id, year)` exists in the result of the subquery.  
   ```sql
   SELECT product_id, year AS first_year, quantity, price
   FROM Sales
   WHERE (product_id, year) IN ( …subquery… )
   ```  
   This guarantees that only sales from the first year of each product are returned, preserving the original `quantity` and `price` values.

## Complexity  
- **Time:** O(n) – the subquery scans the table once to compute minima, and the outer query scans it again to filter rows.  
- **Space:** O(k) – the subquery stores one row per distinct `product_id` (k distinct products).

## Solution (mysql)

```sql
# Write your MySQL query statement below
SELECT product_id, year AS first_year, quantity, price
FROM Sales
WHERE (product_id, year) in (
    SELECT product_id, min(year)
    FROM Sales
    GROUP BY product_id
)
```

---

**Runtime** 682 ms · **Memory** 0.0B

<sub>Synced by AILeetHub on 2026-04-15.</sub>
