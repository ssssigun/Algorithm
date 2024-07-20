-- 코드를 입력하세요
SELECT a.id, a.name, a.host_id
FROM places a JOIN (SELECT host_id FROM places GROUP BY host_id HAVING COUNT(*)>=2) b
    ON a.host_id = b.host_id
ORDER BY a.id ASC