/* Write your PL/SQL query statement below */
SELECT round(sum(i1.tiv_2016),2) as tiv_2016 From insurance i1 where i1.tiv_2015 IN (
        SELECT tiv_2015
        FROM Insurance
        GROUP BY tiv_2015
        HAVING COUNT(*) > 1
    ) and (lat , lon) in(select lat , lon from insurance group by lat,lon having count(*) = 1);