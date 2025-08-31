/* Write your PL/SQL query statement below */
SELECT e.name , b.bonus from employee e LEFT JOIN  Bonus b ON b.empId=e.empId WHERE bonus<1000 or bonus IS NULL;