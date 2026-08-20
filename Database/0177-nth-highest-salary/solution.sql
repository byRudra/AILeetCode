CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  RETURN (
      # Write your MySQL query statement below.
    SELECT salary FROM (
        SELECT salary, DENSE_RANK() OVER(ORDER BY salary DESC) as ranking FROM Employee
    ) as t where ranking = N LIMIT 1
  );
END