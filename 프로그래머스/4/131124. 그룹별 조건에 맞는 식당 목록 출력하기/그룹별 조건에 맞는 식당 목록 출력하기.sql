-- 코드를 입력하세요
SELECT m.member_name, r.review_text, TO_CHAR(r.review_date, 'YYYY-MM-DD') as review_date
FROM rest_review r JOIN member_profile m
    ON r.member_id = m.member_id
WHERE r.member_id IN (SELECT member_id
        FROM rest_review
        GROUP BY member_id
        HAVING COUNT(*) IN (SELECT max(COUNT(*)) FROM rest_review GROUP BY member_id))
ORDER BY review_date ASC, review_text ASC