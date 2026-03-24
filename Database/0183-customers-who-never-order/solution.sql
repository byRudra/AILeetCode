# Write your MySQL query statement below
Select C.name as Customers
FROM Customers as C
LEFT JOIN Orders as O
ON C.id = O.customerId
WHERE O.id IS null