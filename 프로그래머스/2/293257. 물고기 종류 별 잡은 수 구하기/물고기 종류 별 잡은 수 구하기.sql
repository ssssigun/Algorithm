-- Join과 group by 문제
SELECT COUNT(*) as "FISH_COUNT", n.fish_name as "FISH_NAME"
FROM fish_info i JOIN fish_name_info n
ON i.fish_type = n.fish_type
GROUP BY n.fish_name
ORDER BY FISH_COUNT DESC