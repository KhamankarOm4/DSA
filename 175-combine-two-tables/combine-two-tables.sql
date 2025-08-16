/* Write your PL/SQL query statement below */
SELECT Distinct a.lastName , a.firstName ,b.city ,b.state FROM person a LEFT JOIN address b ON a.personId = b.personId;