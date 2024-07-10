-- 코드를 입력하세요
SELECT decode(b.start_date, '08', 8, '09', 9, b.start_date) as month, a.car_id, COUNT(*) as records
FROM (SELECT car_id
    FROM car_rental_company_rental_history
    WHERE start_date BETWEEN TO_DATE('2022-08-01','YYYY-MM-DD') AND TO_DATE('2022-10-31','YYYY-MM-DD')
    GROUP BY car_id
    HAVING COUNT(*) >= 5) a JOIN (SELECT car_id, TO_CHAR(start_date,'MM') as start_date
        FROM car_rental_company_rental_history
        WHERE start_date BETWEEN TO_DATE('2022-08-01','YYYY-MM-DD') AND TO_DATE('2022-10-31','YYYY-MM-DD'))         b ON a.car_id = b.car_id
GROUP BY a.car_id, b.start_date
ORDER BY month ASC, a.car_id DESC 