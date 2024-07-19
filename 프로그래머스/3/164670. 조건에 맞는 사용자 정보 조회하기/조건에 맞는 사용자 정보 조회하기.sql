-- 코드를 입력하세요
SELECT user_id, b.nickname, city || ' ' || street_address1 || ' ' || street_address2 전체주소,
    SUBSTR(tlno, 1,3) || '-' || SUBSTR(tlno, 4,4) || '-' || SUBSTR(tlno, 8,11) 전화번호
FROM (SELECT writer_id FROM used_goods_board Group BY writer_id HAVING count(*) >= 3) a 
    JOIN used_goods_user b ON a.writer_id = b.user_id
ORDER BY user_id DESC