-- 코드를 입력하세요
SELECT flavor
FROM (SELECT f.flavor, f.total_order + j.total_order as total_order
        FROM first_half f JOIN (SELECT flavor, SUM(total_order) as total_order FROM july GROUP BY flavor) j
            ON f.flavor = j.flavor
        ORDER BY total_order DESC)
FETCH next 3 row only