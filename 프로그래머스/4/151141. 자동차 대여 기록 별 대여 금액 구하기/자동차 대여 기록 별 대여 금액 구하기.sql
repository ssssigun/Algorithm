-- 코드를 입력하세요
SELECT h.history_id, (h.daily_fee * RENTAL_DAY) * (1 - NVL(p.discount_rate, 0) / 100) as fee
FROM 
(SELECT h.history_id, c.car_type, c.daily_fee, (h.end_date - h.start_date +1) as rental_day,
    CASE 
        WHEN h.end_date - h.start_date >= 90 THEN '90일 이상'
        WHEN h.end_date - h.start_date >= 30 THEN '30일 이상'
        WHEN h.end_date - h.start_date >= 7 THEN '7일 이상'
    END as DURATION_TYPE
FROM car_rental_company_rental_history h 
    JOIN car_rental_company_car c
    ON c.car_id = h.car_id
    WHERE c.car_type = '트럭'
) h 
    LEFT JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN p
    ON h.car_type = p.car_type AND h.DURATION_TYPE = p.DURATION_TYPE
ORDER BY fee DESC, h.history_id DESC