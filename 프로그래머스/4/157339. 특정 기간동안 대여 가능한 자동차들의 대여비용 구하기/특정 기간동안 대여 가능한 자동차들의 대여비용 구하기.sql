/*
    세단, SUV
    2022-11-01 ~ 2022-11-30 대여 가능
    30일간 대여 금익이 50만 이상 ~ 200만 미만
    자동차 아이디, 자동차 종류, 대여 금액
    대여 금액 내림차순, 자동차 종류 오름차순, 자동차 아이디 내림차순
*/
SELECT DISTINCT c.car_id, c.car_type, (30 * daily_fee * (100 - p.discount_rate) * 0.01) as fee
FROM car_rental_company_car c JOIN car_rental_company_rental_history h ON c.car_id = h.car_id
    JOIN (SELECT * FROM car_rental_company_discount_plan WHERE duration_type = '30일 이상') p 
        ON c.car_type = p.car_type
WHERE c.car_type IN ('세단', 'SUV') 
    AND c.car_id NOT IN (SELECT car_id FROM car_rental_company_rental_history 
                            WHERE TO_CHAR(start_date, 'YYYY-MM') <= '2022-11' 
                                AND TO_CHAR(end_date, 'YYYY-MM') >= '2022-11')
    AND ((30 * daily_fee * (100 - p.discount_rate) * 0.01) BETWEEN 500000 AND 1999999)
ORDER BY fee DESC, c.car_type ASC, c.car_id DESC