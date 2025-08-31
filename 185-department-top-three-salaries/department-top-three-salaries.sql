/* Write your PL/SQL query statement below */
SELECT Department , Employee , Salary
   FROM( 
        SELECT d.name as Department ,
        e.name as Employee , 
        e.salary as salary , 
        DENSE_RANK() OVER (
            PARTITION BY e.departmentId ORDER BY e.salary DESC) as rank_dtw 
        FROM Employee e JOIN Department d ON e.departmentId = d.id)ranked WHERE rank_dtw <= 3;