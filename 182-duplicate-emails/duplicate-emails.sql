/* Write your PL/SQL query statement below */
SELECT distinct e.email as Email from Person e join Person m on e.email=m.email where e.id<>m.id;