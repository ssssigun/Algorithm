SELECT COUNT(*) as 'FISH_COUNT', MAX(IFNULL(length,10)) as 'MAX_LENGTH', fish_type as 'FISH_TYPE'
FROM fish_info
GROUP BY fish_type
HAVING AVG(IFNULL(length,10))>= 33
ORDER BY fish_type ASC