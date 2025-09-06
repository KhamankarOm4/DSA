/* Write your PL/SQL query statement below */
SELECT id, num
FROM (
    SELECT id, SUM(num) AS num
    FROM (
        SELECT requester_id AS id, COUNT(*) AS num
        FROM RequestAccepted
        GROUP BY requester_id
        UNION ALL
        SELECT accepter_id AS id, COUNT(*) AS num
        FROM RequestAccepted
        GROUP BY accepter_id
    )
    GROUP BY id
    ORDER BY num DESC, id ASC
)
WHERE ROWNUM = 1;
