# Write your MySQL query statement below
SELECT e.name as Employee FROM Employee AS e WHERE e.salary >  (SELECT m.salary FROM Employee as m WHERE e.managerID = m.id) 