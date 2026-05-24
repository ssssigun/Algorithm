-- 코드를 입력하세요
-- SELECT time as "HOUR", COUNT(time) as "COUNT"
-- FROM (SELECT TO_CHAR(datetime, 'HH24') as time FROM animal_outs)
-- GROUP BY time
-- ORDER BY time
SELECT h.hour as hour, COUNT(d.time) as count
FROM (SELECT LEVEL - 1 AS hour FROM DUAL CONNECT BY LEVEL <= 24) h 
LEFT JOIN(SELECT TO_CHAR(datetime, 'HH24') as time FROM animal_outs) d
ON h.hour = d.time
GROUP BY h.hour
ORDER BY h.hour;