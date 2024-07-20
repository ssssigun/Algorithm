-- 코드를 입력하세요
SELECT DISTINCT car_id,
    CASE WHEN car_id IN (SELECT car_id FROM car_rental_company_rental_history
                            WHERE TO_CHAR(end_date, 'YYYY-MM-DD') >= '2022-10-16'
                                AND TO_CHAR(start_date, 'YYYY-MM-DD') <= '2022-10-16')
        THEN '대여중'
        ELSE '대여 가능' 
    END as availability
FROM car_rental_company_rental_history
ORDER BY car_id DESC