# Write your MySQL query statement below
SELECT user_id, email
FROM Users
WHERE email REGEXP "^[A-Za-z0-9]+@[A-Za-z]+\\.com$"
ORDER BY user_id ASC