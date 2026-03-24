# 183. Customers Who Never Order

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/customers-who-never-order/)

`Database`

## Intuition  
To find customers who never placed an order we need to keep every customer record and see whether a matching order exists. If no order matches, that customer should appear in the result.

## Approach  
1. Perform a **LEFT JOIN** from `Customers` to `Orders` on `Customers.id = Orders.customerId`.  
2. The join keeps all customers and attaches order data when available.  
3. Filter the joined rows where `Orders.id` is `NULL`. A `NULL` in the order column indicates that the left‑joined customer had no corresponding order row.  
4. Return the customer name as `Customers`.

This simple join‑and‑filter pattern directly yields the list of customers with zero orders.

## Complexity  
- **Time:** O(n + m) – each table is scanned once during the join.  
- **Space:** O(n) – the result set holds at most all customers, proportional to the number of rows in `Customers`.

## Solution (mysql)

```sql
# Write your MySQL query statement below
Select C.name as Customers
FROM Customers as C
LEFT JOIN Orders as O
ON C.id = O.customerId
WHERE O.id IS null
```

---

**Runtime** 517 ms · **Memory** 0.0B

<sub>Synced by AILeetHub on 2026-03-24.</sub>
