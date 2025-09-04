/* Write your PL/SQL query statement below */
select player_id , TO_CHAR(MIN(event_date),'YYYY-MM-DD') as first_login FROM Activity GROUP BY player_id ORDER BY player_id ;