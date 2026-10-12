CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  RETURN (
       With ranked as(Select salary , DENSE_RANK() over(order by salary desc) as rn from Employee) select distinct salary from ranked where rn=N

  );
END