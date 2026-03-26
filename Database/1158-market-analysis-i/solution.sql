# Write your MySQL query statement below
SELECT U.user_id AS buyer_id, U.join_date, Count(O.order_id) AS orders_in_2019
FROM Users AS U
LEFT JOIN Orders AS O
ON U.user_id = O.buyer_id
AND YEAR(O.order_date) = 2019
GROUP BY U.user_id,U.join_date