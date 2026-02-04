-- 코드를 작성해주세요
SELECT COUNT(*) as 'FISH_COUNT', MAX(IFNULL(length,10)) as 'MAX_LENGTH', fish_type as 'FISH_TYPE'
FROM fish_info
WHERE fish_type IN (SELECT fish_type FROM fish_info WHERE length >= 33)
GROUP BY fish_type
ORDER BY fish_type