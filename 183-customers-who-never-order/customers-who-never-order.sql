/* Write your PL/SQL query statement below */
SELECT name as customers FROM Customers where  id not in (select customerID from Orders);