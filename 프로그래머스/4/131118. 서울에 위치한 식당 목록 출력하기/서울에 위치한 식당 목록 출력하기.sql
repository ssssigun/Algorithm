-- 코드를 입력하세요
SELECT a.rest_id, rest_name, food_type, favorites, address, score_avg as score
FROM (SELECT *
    FROM rest_info
    WHERE address LIKE '서울%') a JOIN (SELECT rest_id, ROUND(AVG(review_score), 2) as score_avg FROM rest_review GROUP BY rest_id) b
        ON a.rest_id = b.rest_id
ORDER BY score DESC, favorites DESC