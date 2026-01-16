-- 코드를 작성해주세요
SELECT YEAR(YM) as "YEAR", ROUND(AVG(pm_val1),2) as "PM10", ROUND(AVG(pm_val2),2) as "PM2.5"
FROM air_pollution 
WHERE location2 = '수원'
GROUP BY YEAR(YM)
ORDER BY YEAR ASC