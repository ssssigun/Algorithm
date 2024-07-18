-- 코드를 입력하세요
SELECT order_id, product_id, TO_CHAR(out_date, 'YYYY-MM-DD') out_date,
CASE WHEN TO_CHAR(out_date, 'YYYY-MM-DD') <= '2022-05-01' THEN '출고완료'
    WHEN out_date IS NULL THEN '출고미정'
    ELSE '출고대기' 
END as 출고여부
FROM food_order
ORDER BY order_id ASC